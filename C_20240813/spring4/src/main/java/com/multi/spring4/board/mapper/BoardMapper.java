package com.multi.spring4.board.mapper;

import com.multi.spring4.board.domain.BoardVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    int insert(BoardVO boardVO);
    int update(BoardVO boardVO);
    int delete(int no);
    BoardVO one(int no);
    List<BoardVO> all();
}
