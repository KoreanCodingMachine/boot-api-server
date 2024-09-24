package com.example.demo.repository;

import com.example.demo.domain.MemberBrand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberBrandRepository extends JpaRepository<MemberBrand, Long> {
}
