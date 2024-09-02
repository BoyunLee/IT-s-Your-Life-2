package com.multi.spring2.young.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class YoungVO {
    private String bizId;
    private String polyBizSjnm;
    private String plcyTpNm;
    private String cnsgNmor;
    private String rqutProcCn;
}