package com.noures.SpringBootMvcSecurityJpa.repository;

import com.noures.SpringBootMvcSecurityJpa.domain.Dept;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeptRepository extends JpaRepository<Dept, Long> {


}
