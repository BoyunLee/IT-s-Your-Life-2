package com.multi.jsp04.dao;

import com.multi.jsp04.vo.MemberVO;
import java.util.HashMap;
import java.util.Map;

public class MemberDAO {
    private Map<String, MemberVO> members = new HashMap<>();

    public void insertMember(MemberVO member) {
        members.put(member.getId(), member);
    }

    public void deleteMember(String id) {
        members.remove(id);
    }
}
