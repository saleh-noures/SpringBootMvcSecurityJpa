package com.noures.SpringBootMvcSecurityJpa.repository;

import com.noures.SpringBootMvcSecurityJpa.domain.Emp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmpRepository extends JpaRepository<Emp, Long> {

    @Query("SELECT e FROM Emp e order by e.name asc")
    List<Emp> findAllOrderByName();

}
