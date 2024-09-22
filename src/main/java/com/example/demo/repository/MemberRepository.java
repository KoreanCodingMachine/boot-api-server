package com.example.demo.repository;

import com.example.demo.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
    @Query("select m from Member m join fetch m.team")
    List<Member> findAllMembersWithTeam();
}
