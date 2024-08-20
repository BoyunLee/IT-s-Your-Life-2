package com.multi.spring2.aop.service;

import com.multi.spring2.aop.domain.BoardVO;
import com.multi.spring2.aop.domain.MemberVO;
import org.springframework.transaction.annotation.Transactional;

public interface TransactionInterface {

    public int tran(BoardVO boardVO, MemberVO memberVO) throws Exception;
}

