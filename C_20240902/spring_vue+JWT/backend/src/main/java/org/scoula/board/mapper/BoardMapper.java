package org.scoula.board.mapper;

import org.scoula.board.domain.BoardAttachmentVO;
import org.scoula.board.domain.BoardVO;
import org.scoula.common.pagination.PageRequest;

import java.util.List;

public interface BoardMapper {
    int getTotalCount();

    List<BoardVO> getPage(PageRequest pageRequest);

    List<BoardVO> getList();

    BoardVO get(Long no);

    void create(BoardVO board);

    int update(BoardVO board);

    int delete(Long no);

    void createAttachment(BoardAttachmentVO attach);

    List<BoardAttachmentVO> getAttachmentList(Long bno);

    BoardAttachmentVO getAttachment(Long no);

    int deleteAttachment(Long no);

}
