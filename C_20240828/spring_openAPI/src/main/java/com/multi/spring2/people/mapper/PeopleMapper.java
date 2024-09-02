package com.multi.spring2.people.mapper;

import com.multi.spring2.people.domain.PeopleVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface PeopleMapper {
  //mapper의 id와 맞아야함.
  int insert(PeopleVO peopleVO); //<insert id="insert" ~~>
  List<PeopleVO> all();
}