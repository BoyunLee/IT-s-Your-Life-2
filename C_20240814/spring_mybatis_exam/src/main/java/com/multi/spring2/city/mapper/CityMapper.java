package com.multi.spring2.city.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.multi.spring2.city.domain.*;
import java.util.List;


@Mapper
public interface CityMapper {
  //mapper의 id와 맞아야함.
  int insert(CityVO cityVO); //<insert id="insert" ~~>
  List<CityVO> all();

}