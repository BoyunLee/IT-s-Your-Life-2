package com.multi.spring2.city.service;

import com.multi.spring2.city.dao.CityDAO;
import com.multi.spring2.city.domain.CityVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

//구현부분
    private final CityDAO cityDAO;

    @Autowired
    public CityService(CityDAO cityDAO) {
        this.cityDAO = cityDAO;
        System.out.println("CityService created");
    }

    public String insert(CityVO cityVO) {
        String result = "게시판 글쓰기 실패";
        if(cityDAO.insert(cityVO) == 1) {
            result = "게시판 글 수정 성공";
        }
        return result;
    }

    public List<CityVO> all() {
        return cityDAO.all();
    }
}