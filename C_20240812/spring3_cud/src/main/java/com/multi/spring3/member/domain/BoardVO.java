package com.multi.spring3.member.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardVO {

    private int no;
    private String title;
    private String content;
    private String writer;

    /*
        CREATE TABLE `board` (
        `no` int NOT NULL,
        `title` varchar(45) NOT NULL,
        `content` varchar(45) NOT NULL,
        `writer` varchar(45) NOT NULL,
         PRIMARY KEY (`no`)
        )
    */
}
