package com.multi.spring2.movie.service;

import com.multi.spring2.movie.dao.MovieDAO;
import com.multi.spring2.movie.domain.MovieVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieDAO movieDAO;

    @Autowired
    public MovieService(MovieDAO movieDAO) {
        this.movieDAO = movieDAO;
        System.out.println("MovieService created");
    }

    public String insert(MovieVO movieVO){
        String result = "영화 삽입 실패";
        if(movieDAO.insert(movieVO) == 1){
            result = "영화 삽입 성공";
        };
        return result;
    }

    public List<MovieVO> all(){
        return movieDAO.all();
    }
}