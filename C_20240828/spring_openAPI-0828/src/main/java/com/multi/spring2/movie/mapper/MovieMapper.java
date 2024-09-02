package com.multi.spring2.movie.mapper;

import com.multi.spring2.movie.domain.MovieVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface MovieMapper {
  //mapper의 id와 맞아야함.
  int insert(MovieVO movieVO); //<insert id="insert" ~~>
  List<MovieVO> all();
}