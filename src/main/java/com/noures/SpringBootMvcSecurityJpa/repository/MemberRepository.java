package com.noures.SpringBootMvcSecurityJpa.repository;

import com.noures.SpringBootMvcSecurityJpa.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    public Member findByEmail(String email);

    @Query("SELECT m FROM Member m order by m.name asc")
    public List<Member> findAllOrderByName();

}
