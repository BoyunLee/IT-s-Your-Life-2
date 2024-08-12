package com.multi.spring2.board.domain;

import lombok.Data;

@Data
public class BoardVO {

    private int no;
    private String title;
    private String content;
    private String writer;

    /*
    use shop2;
    CREATE TABLE `board` (
      `no` int NOT NULL AUTO_INCREMENT,
      `title` varchar(45) NOT NULL,
      `content` varchar(45) NOT NULL,
      `writer` varchar(45) NOT NULL,
      PRIMARY KEY (`no`)
    )
    */
}
