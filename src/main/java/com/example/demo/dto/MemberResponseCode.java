package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MemberResponseCode implements ResponseCode{
    MEMBER_CREATED_OK(20001, "멤버 생성 성공")
    ,MEMBER_DELETED_OK(20002, "멤버 삭제 성공")
    ,MEMBER_UPDATED_OK(20003, "멤버 수정 성공")
    ,MEMBER_NOT_FOUND(40001,"멤버 조회 실패")
    ,MEMBER_ADD_BRAND_OK(20001,"멤버 브랜드 생성 성공")
    ;

    private Integer statusCode;
    private String message;
}
