package com.multi.spring2.member.dao;

import com.multi.spring2.member.domain.MemberVO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MemberDAO_ds {

    private List<MemberVO> memberVOList = new ArrayList<>();
    private List<String> idList = new ArrayList<>();

    public MemberDAO_ds() {
        System.out.println("MemberDAO created.");
        memberVOList.add(new MemberVO("apple", "1234", "apple", "011"));
        memberVOList.add(new MemberVO("ice", "1234", "ice", "012"));
        memberVOList.add(new MemberVO("sky", "1234", "sky", "013"));
        // idListD에 id를 추가하는 코드
        for (MemberVO member : memberVOList) {
            idList.add(member.getId());
        }
    }

    public int insert(MemberVO memberVO) {
        int result = 0;
        if (!idList.contains(memberVO.getId())){
            memberVOList.add(memberVO);
            result = 1;
        }
        return result;
    }

    public int update(MemberVO memberVO) {
        int result = 0;
        int index = idList.indexOf(memberVO.getId());
        if (index >= 0){
            memberVO.setPw(memberVOList.get(index).getPw());
            memberVO.setName(memberVOList.get(index).getName());
            memberVOList.set(index, memberVO);
            result = 1;
        }
        return result;
    }

    public int delete(String id) {
        int result = 0;
        int index = idList.indexOf(id);
        if (index >= 0){
            memberVOList.remove(index);
            result = 1;
        }
        return result;
    }


    public MemberVO one(String id){
       MemberVO memberVO = null;
        //db검색 부분으로 변경 예정
       boolean result = idList.contains(id);

        if (result == true) {
            memberVO = new MemberVO();
            memberVO.setId("apple");
            memberVO.setPw("1234");
            memberVO.setName("apple");
            memberVO.setTel("011");
        }
        return memberVO;
    }

    public List<MemberVO> all(){
        List<MemberVO> all = new ArrayList<>();
        if (memberVOList.size() > 0) {
          return all = memberVOList;
        }
        return all;
    }
    /*
        use shop2;
        create table member (
            id varchar(45),
            pw varchar(45),
            name varchar(45),
            tel varchar(45)
        );

        desc member;
     */
}
