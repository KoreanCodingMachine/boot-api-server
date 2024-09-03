package com.example.demo.service;

import com.example.demo.domain.Member;
import com.example.demo.dto.MemberResponseDTO;

import java.util.List;


public interface MemberService {
    void insert(Member member);                // 멤버 생성
    void delete(Long id);                      // 멤버 삭제
    List<MemberResponseDTO> getAll();          // 멤버 전체 조회
    MemberResponseDTO getById(Long id);        // 멤버 단건 조회
    void updateMember(Long id, String name);   // 멤버 수정
}
