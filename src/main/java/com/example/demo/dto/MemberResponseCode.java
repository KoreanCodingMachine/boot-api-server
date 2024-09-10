package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MemberResponseCode implements ResponseCode{
    MEMBER_CREATED_OK(20001, "멤버 조회 성공"),
    MEMBER_NOT_FOUND(40001,"멤버 조회 실패")
    ;

    private Integer statusCode;
    private String message;
}
