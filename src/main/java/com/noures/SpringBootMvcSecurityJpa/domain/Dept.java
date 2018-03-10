package com.noures.SpringBootMvcSecurityJpa.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
@Entity
@Table(name = "DEPT", uniqueConstraints = @UniqueConstraint(columnNames = "deptName"))
public class Dept implements java.io.Serializable {

    @Id
    @GeneratedValue
	private Long deptId;
    
    @NotNull
	private String deptName;
    
	private String location;
	// mappedBy indicates that Dept is the inverse of the relationship and EMP is the owner
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "dept") // with out mappedBy delete emp will not work!
	@JsonIgnore
	private List<Emp> emps = new ArrayList<Emp>(0);

	public Dept() {
	}

	public Dept(Long deptId) {
		this.deptId = deptId;
	}

	public Dept(Long deptId, String dname, String location, List<Emp> emps) {
		this.deptId = deptId;
		this.deptName = dname;
		this.location = location;
		this.emps = emps;
	}

	public Long getDeptId() {
		return this.deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return this.deptName;
	}

	public void setDeptName(String dname) {
		this.deptName = dname;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<Emp> getEmps() {
		return this.emps;
	}

	public void setEmps(List<Emp> emps) {
		this.emps = emps;
	}

}
