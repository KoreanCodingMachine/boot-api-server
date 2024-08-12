package com.example.demo.controller;

import com.example.demo.domain.Member;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {
    @GetMapping("/api/member")
    public Member getMember() {
        Member member = new Member();
        member.setName("kjh");
        member.setPassword("1234");
        return member;
    }
}
