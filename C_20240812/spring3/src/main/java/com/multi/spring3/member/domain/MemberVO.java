package com.multi.spring3.member.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberVO {

    private String id;
    private String pw;
    private String name;
    private String tel;

    /*
        use shop2;
        CREATE TABLE `member` (
          `id` varchar(45) NOT NULL,
          `pw` varchar(45) NOT NULL,
          `name` varchar(45) DEFAULT NULL,
          `tel` varchar(45) DEFAULT NULL,
           PRIMARY KEY (`id`)
        );

        desc member;
     */
}
