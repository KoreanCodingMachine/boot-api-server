package com.example.demo.controller;

import com.example.demo.domain.Member;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {
    @Autowired
    private MemberService memberService;

    @GetMapping("/api/member")
    public Member getMember() {
        Member member = new Member();
        member.setName("kjh");
        member.setPassword("1234");
        return member;
    }

    @PostMapping("/api/member")
    public Member postMember() {
        Member member = new Member();
        member.setName("kjh");
        member.setPassword("1234");

        memberService.insert(member);

        return member;
    }
}
