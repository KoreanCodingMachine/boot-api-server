package com.example.demo.controller;

import com.example.demo.domain.Member;
import com.example.demo.dto.MemberRequestDto;
import com.example.demo.service.MemberService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MemberController {
    @Autowired
    private MemberService memberService;

    @GetMapping("/api/members")
    public Member getMember() {
        // object 리턴시 자동으로 json형태로 형변환

        Member member = new Member();
        member.setName("kjh");
        member.setPassword("1234");
        return member;
    }

    @GetMapping("/hello")
    public String sayHello() {
        // String type도 리턴 가능
        return "hello";
    }

    @GetMapping("/customResponse")
    public ResponseEntity<Member> customResponse() {
//        ResponseEntity: ResponseEntity는 HTTP 상태 코드, 헤더 및 본문을 모두 제어할 수 있는
//        유연한 방법을 제공합니다. 응답의 상태 코드와 헤더를 설정할 수 있습니다.
        Member member = new Member();
        member.setName("사일러스");
        member.setPassword("1234");

        return ResponseEntity.status(HttpStatus.OK)
                .header("Custom-Header", "value")
                .body(member);
    }


    @PostMapping("/api/members")
    public Member postMember(@RequestBody @Valid MemberRequestDto memberRequestDto) {
        Member member = new Member();
        member.setName(memberRequestDto.getName());
        member.setPassword(memberRequestDto.getPassword());
        member.setAge(memberRequestDto.getAge());
        member.setNickname(memberRequestDto.getNickname());

        memberService.insert(member);

        return member;
    }

}
