package org.scoula.member.mapper;

import org.scoula.member.dto.ChangePasswordDTO;
import org.scoula.security.account.domain.AuthVO;
import org.scoula.security.account.domain.MemberVO;

import java.util.List;

public interface MemberMapper {
    MemberVO findByUsername(String username);

    List<MemberVO> getList();

    MemberVO get(String username);

    int update(MemberVO member);

    int insert(MemberVO member);

    int updatePassword(ChangePasswordDTO changePasswordDTO);

    int delete(String username);

    int insertAuth(AuthVO auth);

    int deleteAuth(AuthVO auth);
}
