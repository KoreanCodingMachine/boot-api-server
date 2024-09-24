package com.example.demo.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer age;
    private String name;
    private String password;
    private String nickname;


    @ManyToOne
    @JoinColumn (name = "team_id")
    private Team team;

    @OneToMany(mappedBy = "member")
    private List<MemberBrand> memberBrands = new ArrayList<>();
}

