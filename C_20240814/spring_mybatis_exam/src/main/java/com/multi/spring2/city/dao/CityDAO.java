package com.multi.spring2.city.dao;

import com.multi.spring2.city.domain.CityVO;
import com.multi.spring2.city.mapper.CityMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class CityDAO {
    private final SqlSessionTemplate sqlSessionTemplate;

    @Autowired
    public CityDAO(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

//구현부분
    // 도시 데이터를 데이터베이스에 삽입
    public int insert(CityVO cityVO) {
        return sqlSessionTemplate.getMapper(CityMapper.class).insert(cityVO);
    }

    // 모든 도시 데이터를 데이터베이스에서 조회
    public List<CityVO> all() {
        return sqlSessionTemplate.getMapper(CityMapper.class).all();
    }
}

