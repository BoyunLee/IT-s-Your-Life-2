package com.multi.spring2.aop.service;

import com.multi.spring2.aop.dao.AOPDAO;
import com.multi.spring2.aop.domain.BoardVO;
import com.multi.spring2.aop.domain.MemberVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class TransactionService implements TransactionInterface {

    AOPDAO aopDAO;

    @Autowired
    public TransactionService(AOPDAO aopDAO) {
        this.aopDAO = aopDAO;
    }

    @Override
    @Transactional
    public int tran(BoardVO boardVO, MemberVO memberVO){

        int result = 1;

        // 1. 회원가입 처리
        int memberResult = aopDAO.insertMember(memberVO);


        // 2. 게시글 작성 처리
        int boardResult = aopDAO.insertBoard(boardVO);

        if (memberResult != 1 || boardResult != 1) {
            throw new RuntimeException("error..rolling back.........");
        }
        return result;
    }
}
