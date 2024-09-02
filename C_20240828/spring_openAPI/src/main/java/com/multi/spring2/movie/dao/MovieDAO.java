package com.multi.spring2.movie.dao;

import com.multi.spring2.movie.domain.MovieVO;
import com.multi.spring2.movie.mapper.MovieMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieDAO {

    private SqlSessionTemplate sqlSessionTemplate;

    public MovieDAO() {
        System.out.println("MemberDAO created");
    }

    @Autowired
    public MovieDAO(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    // 등록
    public int insert(MovieVO vo) {
        int result = sqlSessionTemplate.getMapper(MovieMapper.class).insert(vo);
        return result;
    }

    // 조회
    public List<MovieVO> all() {
        return sqlSessionTemplate.getMapper(MovieMapper.class).all();
    }
}

