package com.multi.spring2.people.dao;

import com.multi.spring2.people.domain.PeopleVO;
import com.multi.spring2.people.mapper.PeopleMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PeopleDAO {

    private SqlSessionTemplate sqlSessionTemplate;

    public PeopleDAO() {
        System.out.println("PeopleDAO created");
    }

    @Autowired
    public PeopleDAO(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    // 등록
    public int insert(PeopleVO peopleVO) {
        int result = sqlSessionTemplate.getMapper(PeopleMapper.class).insert(peopleVO);
        return result;
    }

    // 조회
    public List<PeopleVO> all() {
        return sqlSessionTemplate.getMapper(PeopleMapper.class).all();
    }
}

