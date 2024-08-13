package com.multi.spring3.member.service;

import com.multi.spring3.member.dao.MemberDAO;
import com.multi.spring3.member.domain.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    private final MemberDAO memberDAO;

    @Autowired
    public MemberService(MemberDAO memberDAO) {
        this.memberDAO = memberDAO;
        System.out.println("MemberService created");
    }

    public String insert(MemberVO memberVO){
        String result = "회원가입 실패";
        if(memberDAO.insert(memberVO) == 1){
            result = "회원가입 성공";
        };
        return result;
    }

    public String update(MemberVO memberVO){
        String result = "회원수정 실패";
        if(memberDAO.update(memberVO) != 0){
            result = "회원수정 성공";
        };
        return result;
    }

    public String delete(String id){
        String result = "회원탈퇴 실패";
        if(memberDAO.delete(id) != 0){
            result = "회원탈퇴 성공";
        };
        return result;
    }

    public MemberVO one(String id){
        return memberDAO.one(id);
    }

    public List<MemberVO> all(){
        return memberDAO.all();
    }

    public int login(MemberVO memberVO) {
        return memberDAO.login(memberVO);
    }

    public List<MemberVO> find(String word){
        return memberDAO.find(word);
    }
}