package com.jnshu.common.pojo;

import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SmsInfo implements Serializable {

    private String id;
    private String content;
    private String outId;
    private String phoneNum;

    private Integer resCode;
    private String resMsg;
}
