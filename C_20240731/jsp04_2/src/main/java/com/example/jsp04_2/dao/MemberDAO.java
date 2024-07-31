package com.example.jsp04_2.dao;

import com.example.jsp04_2.vo.MemberVO;
import java.util.HashMap;
import java.util.Map;
public class MemberDAO {
    private Map<String, MemberVO> members = new HashMap<>();

    public void insertMember(MemberVO member) {
        System.out.println("dao insert member >> " + member);
        members.put(member.getId(), member);
    }
    public void deleteMember(String id) {
        System.out.println("dao delete id >> " + id);
        members.remove(id);
    }
}
