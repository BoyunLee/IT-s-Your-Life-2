package com.multi.spring2.young.service;

import com.multi.spring2.young.dao.YoungDAO;
import com.multi.spring2.young.domain.YoungVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YoungService {

    private final YoungDAO youngDAO;

    @Autowired
    public YoungService(YoungDAO youngDAO) {
        this.youngDAO = youngDAO;
        System.out.println("YoungService created");
    }

    public void insert() {
        YoungParser parser = new YoungParser();
        List<YoungVO> list = parser.parse();
        int index = 1;
        for (YoungVO youngVO : list) {
            youngDAO.insert(youngVO);
            System.out.println(index + ">> ");
            index++;
        }
    }
}