package com.noures.SpringBootMvcSecurityJpa.controller.company;

import com.noures.SpringBootMvcSecurityJpa.domain.Emp;
import com.noures.SpringBootMvcSecurityJpa.exception.EmployeeNotFoundException;
import com.noures.SpringBootMvcSecurityJpa.repository.DeptRepository;
import com.noures.SpringBootMvcSecurityJpa.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/emps")
public class EmpRestController {

    @Autowired
    EmpRepository empRepository;

    @Autowired
    DeptRepository deptRepository;

    //  http://localhost:8080/SpringBootMvcSecurityJpaApplication/rest/emps
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public List<Emp> listAllEmps() {
        List<Emp> list = empRepository.findAllOrderByName();
        return list;
    }

    //  http://localhost:8080/SpringBootMvcSecurityJpaApplication/rest/emps/101
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public Emp getEmpById(@PathVariable("id") Long id) throws EmployeeNotFoundException {
        Emp emp = empRepository.findOne(id);
        if (emp == null) {
            throw new EmployeeNotFoundException(id);
        }
        return emp;
    }

    //  http://localhost:8080/SpringBootMvcSecurityJpaApplication/rest/emps/101
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteEmpById(@PathVariable("id") Long id) {
        empRepository.delete(id);

    }

}
