package com.portfolio.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String usn;
    private String branch;
    private Integer year;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private Portfolio portfolio;

    @ManyToMany
    @JoinTable(
        name = "student_teacher",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "teacher_id")
    )
    private List<Teacher> teachers;
    
    

	public Student(Long id, String name, String email, String usn, String branch, Integer year, Portfolio portfolio,
			List<Teacher> teachers) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.usn = usn;
		this.branch = branch;
		this.year = year;
		this.portfolio = portfolio;
		this.teachers = teachers;
	}
	
	public Student() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsn() {
		return usn;
	}

	public void setUsn(String usn) {
		this.usn = usn;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Portfolio getPortfolio() {
		return portfolio;
	}

	public void setPortfolio(Portfolio portfolio) {
		this.portfolio = portfolio;
	}

	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}
    
}
