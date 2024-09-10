package com.example.demo.service;

import com.example.demo.domain.Member;
import com.example.demo.dto.MemberRequestDto;
import com.example.demo.dto.MemberResponseDto;

import java.util.List;


public interface MemberService {
    void insert(MemberRequestDto memberRequestDto);                // 멤버 생성
    void delete(Long id);                      // 멤버 삭제
    List<MemberResponseDto> getAll();          // 멤버 전체 조회
    MemberResponseDto getById(Long id);        // 멤버 단건 조회
    MemberResponseDto updateMember(Long id, String name);   // 멤버 수정
}
