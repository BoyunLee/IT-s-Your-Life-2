package com.multi.spring4.board.dao;

import com.multi.spring4.board.domain.BoardVO;
import com.multi.spring4.board.mapper.BoardMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class BoardDAO {
    private final SqlSessionTemplate sqlSessionTemplate;

    @Autowired
    public BoardDAO(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    public int insert(BoardVO boardVO) {
        return sqlSessionTemplate.getMapper(BoardMapper.class).insert(boardVO);
    }

    public int update(BoardVO boardVO) {
        return sqlSessionTemplate.getMapper(BoardMapper.class).update(boardVO);
    }

    public int delete(int no) {
        return sqlSessionTemplate.getMapper(BoardMapper.class).delete(no);
    }

    public BoardVO one(int no) {
        return sqlSessionTemplate.getMapper(BoardMapper.class).one(no);
    }

    public List<BoardVO> all() {
        return sqlSessionTemplate.getMapper(BoardMapper.class).all();
    }


    /*
        use shop2;
        CREATE TABLE `board` (
          `no` int NOT NULL AUTO_INCREMENT,
          `title` varchar(45) NOT NULL,
          `content` varchar(45) NOT NULL,
          `writer` varchar(45) NOT NULL,
          PRIMARY KEY (`no`)
        ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

        desc board;
     */
}
