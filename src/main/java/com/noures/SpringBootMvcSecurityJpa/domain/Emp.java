package com.noures.SpringBootMvcSecurityJpa.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "Emp")
public class Emp implements java.io.Serializable {

    @Id
    @GeneratedValue
	private Long empId;
    
	private String name;
	
	private Date hiredate;
	
	private Long salary;
	
	private Character gender;
	
	private Long country;
	
	private String photo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DEPT_ID")
	@JsonIgnore
	private Dept dept;
	
	@Version
	private Long version;
	

	public Emp() {
	}

	public Emp(Long empId) {
		this.empId = empId;
	}

	public Emp(Long empId, Dept dept, String name, Date hiredate,
			Long salary, Character gender, Long country,
			String photo) {
		this.empId = empId;
		this.dept = dept;
		this.name = name;
		this.hiredate = hiredate;
		this.salary = salary;
		this.gender = gender;
		this.country = country;
		this.photo = photo;
	}

	public Long getEmpId() {
		return this.empId;
	}

	public void setEmpId(Long empId) {
		this.empId =  empId;
	}

	public Long getVersion() {
		return this.version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public Dept getDept() {
		return this.dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getHiredate() {
		return this.hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	public Long getSalary() {
		return this.salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

	public Character getGender() {
		return this.gender;
	}

	public void setGender(Character gender) {
		this.gender = gender;
	}

	public Long getCountry() {
		return this.country;
	}

	public void setCountry(Long country) {
		this.country = country;
	}

	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

}
