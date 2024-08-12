package com.multi.win01.domain;

import lombok.Data;

@Data
public class FinanceVO {
    private int financeId; //금융 상품 id
    private String title; //금융 상품 제목
    private String content; //금융 상품 설명
    private int amount; //금융 상품 금액
    private String field; //금융 상품 종류
}
