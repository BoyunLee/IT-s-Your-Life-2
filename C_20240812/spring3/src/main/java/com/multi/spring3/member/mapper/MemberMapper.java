package com.multi.spring3.member.mapper;

import com.multi.spring3.member.domain.MemberVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface MemberMapper {
  //mapper의 id와 맞아야함.
  int insert(MemberVO memberVO); //<insert id="insert" ~~>
  int update(MemberVO memberVO);
  int delete(String id);
  MemberVO one(String id); // <select id="one" ~~>
  List<MemberVO> all();
  int login(MemberVO memberVO);

  List<MemberVO> find(String word);
}