package com.multi.spring3.member.dao;

import com.multi.spring3.member.domain.MemberVO;
import com.multi.spring3.member.mapper.MemberMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class MemberDAO {

    private final SqlSessionTemplate sqlSessionTemplate;

    @Autowired
    public MemberDAO(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    public int insert(MemberVO memberVO) {
        return sqlSessionTemplate.getMapper(MemberMapper.class).insert(memberVO);
    }

    public MemberVO one(String id) {
        return sqlSessionTemplate.getMapper(MemberMapper.class).one(id);
    }

    public int update(MemberVO memberVO) {
        return sqlSessionTemplate.getMapper(MemberMapper.class).update(memberVO);
    }

    public int delete(String id) {
        return sqlSessionTemplate.getMapper(MemberMapper.class).delete(id);
    }

    public List<MemberVO> all() {
        return sqlSessionTemplate.getMapper(MemberMapper.class).all();
    }

    public int login(MemberVO memberVO) {
        return sqlSessionTemplate.getMapper(MemberMapper.class).login(memberVO);
    }

    public List<MemberVO> find(String word) {
        return sqlSessionTemplate.getMapper(MemberMapper.class).find(word);
    }

    /*
        use shop2;
        CREATE TABLE `member` (
          `id` varchar(45) NOT NULL,
          `pw` varchar(45) NOT NULL,
          `name` varchar(45) DEFAULT NULL,
          `tel` varchar(45) DEFAULT NULL,
          PRIMARY KEY (`id`)
        ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='회원관리용 테이블';

        desc member;
     */

}

