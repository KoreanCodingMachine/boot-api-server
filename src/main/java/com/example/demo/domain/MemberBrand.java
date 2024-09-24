package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class MemberBrand {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer count;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;
}
