package org.scoula.board.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.scoula.board.domain.BoardAttachmentVO;
import org.scoula.board.domain.BoardVO;
import org.scoula.board.dto.BoardDTO;
import org.scoula.board.mapper.BoardMapper;
import org.scoula.common.pagination.Page;
import org.scoula.common.pagination.PageRequest;
import org.scoula.common.util.UploadFiles;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Log4j
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private final static String BASE_DIR = "c:/upload/board";

    private final BoardMapper mapper;

    @Override
    public Page<BoardDTO> getPage(PageRequest pageRequest) {
        List<BoardVO> boards = mapper.getPage(pageRequest);
        int totalCount = mapper.getTotalCount();
        return Page.of(pageRequest, totalCount,
                boards.stream().map(BoardDTO::of).toList());

    }

    @Override
    public List<BoardDTO> getList() {
        log.info("getList..........");
        return mapper.getList().stream()
                .map(BoardDTO::of)
                .toList();

    }

    @Override
    public BoardDTO get(Long no) {
        log.info("get......" + no);
        BoardDTO board = BoardDTO.of(mapper.get(no));

        log.info("========================" + board);
        return Optional.ofNullable(board)
                .orElseThrow(NoSuchElementException::new);
    }

    @Transactional // 2개 이상의 insert 문이 실행될 수 있으므로 트랜잭션 처리 필요
    @Override
    public BoardDTO create(BoardDTO board) {
        log.info("create......" + board);

        BoardVO boardVO= board.toVo();
        mapper.create(boardVO);

        // 파일 업로드 처리
        List<MultipartFile> files = board.getFiles();
        if(files != null && !files.isEmpty()) {
            upload(boardVO.getNo(), files);
        }
        return get(boardVO.getNo());
    }

    private void upload(Long bno, List<MultipartFile> files) {
        for(MultipartFile part: files) {
            if(part.isEmpty()) continue;
            try {
                String uploadPath = UploadFiles.upload(BASE_DIR, part);
                BoardAttachmentVO attach = BoardAttachmentVO.from(part, bno, uploadPath);
                mapper.createAttachment(attach);
            } catch (IOException e) {
                throw new RuntimeException(e);
                //log.error(e.getMessage());
            }
        }
    }

    @Override
    public BoardDTO update(BoardDTO board) {
        log.info("update...... " + board);
        BoardVO boardVO = board.toVo();
        log.info("update...... " + boardVO);

        mapper.update(boardVO);

        // 파일 업로드 처리
        List<MultipartFile> files = board.getFiles();
        if(files != null && !files.isEmpty()) {
            upload(board.getNo(), files);
        }

        return get(board.getNo());
    }

    @Override
    public BoardDTO delete(Long no) {
        log.info("delete...." + no);
        BoardDTO board = get(no);

        mapper.delete(no);
        return board;
    }

    @Override
    public BoardAttachmentVO getAttachment(Long no) {
        return mapper.getAttachment(no);
    }

    @Override
    public boolean deleteAttachment(Long no) {
        return mapper.deleteAttachment(no) == 1;
    }

}
