package com.multi.spring2.people.service;

import com.multi.spring2.people.dao.PeopleDAO;
import com.multi.spring2.people.domain.PeopleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeopleService {

    private final PeopleDAO peopleDAO;

    @Autowired
    public PeopleService(PeopleDAO peopleDAO) {
        this.peopleDAO = peopleDAO;
        System.out.println("PeopleService created");
    }

    public String insert(PeopleVO peopleVO){
        String result = "영화인 삽입 실패";
        if(peopleDAO.insert(peopleVO) == 1){
            result = "영화인 삽입 성공";
        };
        return result;
    }

    public List<PeopleVO> all(){
        return peopleDAO.all();
    }
}