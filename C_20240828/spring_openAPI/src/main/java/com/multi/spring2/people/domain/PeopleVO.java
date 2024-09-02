package com.multi.spring2.people.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PeopleVO {
    private String peopleCd;     // 영화인 코드
    private String peopleNm;     // 영화인명
    private String peopleNmEn;   // 영화인명(영문)
    private String repRoleNm;    // 분야
    private String filmoNames;   // 필모리스트
}

