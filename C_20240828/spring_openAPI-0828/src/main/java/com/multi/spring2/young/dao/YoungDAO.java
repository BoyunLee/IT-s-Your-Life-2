package com.multi.spring2.young.dao;

import com.multi.spring2.young.domain.YoungVO;
import com.multi.spring2.young.mapper.YoungMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class YoungDAO {

    private SqlSessionTemplate my;

    public YoungDAO() {
        System.out.println("YoungDAO created");
    }

    @Autowired
    public YoungDAO(SqlSessionTemplate my) {
        this.my = my;
    }


    public int insert(YoungVO youngVO) {
        return my.getMapper(YoungMapper.class).insert(youngVO);
    }

}

