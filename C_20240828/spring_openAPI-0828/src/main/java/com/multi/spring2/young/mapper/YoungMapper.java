package com.multi.spring2.young.mapper;

import com.multi.spring2.young.domain.YoungVO;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface YoungMapper {
  //mapper의 id와 맞아야함.
  int insert(YoungVO youngVO);
}