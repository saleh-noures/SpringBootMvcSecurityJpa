package com.noures.SpringBootMvcSecurityJpa.controller.company;


import com.noures.SpringBootMvcSecurityJpa.domain.Dept;
import com.noures.SpringBootMvcSecurityJpa.domain.Emp;
import com.noures.SpringBootMvcSecurityJpa.exception.DepartmentNotFoundException;
import com.noures.SpringBootMvcSecurityJpa.repository.DeptRepository;
import com.noures.SpringBootMvcSecurityJpa.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/depts")
public class DeptRestController {

    @Autowired
    DeptRepository deptRepository;

    @Autowired
    EmpRepository empRepository;

    //  http://localhost:8080/SpringBootMvcSecurityJpaApplication/rest/depts/
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseStatus(value = HttpStatus.OK) // optional
    public List<Dept> listAllDepts() {
        List<Dept> list = deptRepository.findAll();
        return list;
    }


    //  http://localhost:8080/SpringBootMvcSecurityJpaApplication/rest/depts/1
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public Dept getDeptById(@PathVariable("id") Long id) throws DepartmentNotFoundException {
        Dept dept = deptRepository.findOne(id);
        if (dept == null) {
            throw new DepartmentNotFoundException(id);
        }
        return dept;
    }

    // http://localhost:8080/SpringBootMvcSecurityJpaApplication/rest/depts/1/emps
    @RequestMapping(value = "/{id}/emps", method = RequestMethod.GET, produces = "application/json")
    public List<Emp> listEmpsByDept(@PathVariable("id") Long deptId) {
        Dept dept = deptRepository.findOne(deptId);
        if (dept == null) {
            throw new DepartmentNotFoundException(deptId);
        }
        List<Emp> emps = dept.getEmps();
        return emps;
    }

    // verb= POST http://localhost:8080/SpringBootMvcSecurityJpaApplication/rest/depts/1/emps
    @RequestMapping(value = "/{id}/emps", method = RequestMethod.POST, produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void AddEmpToDept(@PathVariable("id") Long deptId, @RequestBody Emp emp) {
        Dept dept = deptRepository.findOne(deptId);

        emp.setDept(dept);
        dept.getEmps().add(emp);

        empRepository.save(emp);
        deptRepository.save(dept);

/* ResponseEntity is a wrapper for a response and, optionally, HTTP headers and a status code.
 The code below will return "201 Created" Heep status and the "Location" header for the resource
 after insertion: http://localhost:8080/SpringMvcJpaJBoss/rest/depts/1/emps/1

 URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(emp.getEmpId()).toUri();

        return ResponseEntity.created(location).build();
 */

    }

}
