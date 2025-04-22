package com.portfolio.dto;

import java.util.List;

public class StudentDTO {
	 	private String name;
	    private String email;
	    private String usn;
	    private String branch;
	    private Integer year;
	    private PortfolioCreateDTO portfolio;
	    private List<TeacherDTO> teachers;
	    
	    public StudentDTO() {
	    	
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

		public PortfolioCreateDTO getPortfolio() {
			return portfolio;
		}

		public void setPortfolio(PortfolioCreateDTO portfolio) {
			this.portfolio = portfolio;
		}

		public List<TeacherDTO> getTeachers() {
			return teachers;
		}

		public void setTeachers(List<TeacherDTO> teachers) {
			this.teachers = teachers;
		}
	    
	    
}
