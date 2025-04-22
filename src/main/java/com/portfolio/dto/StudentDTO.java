package com.portfolio.dto;



public class StudentDTO {
		private Long id;
	 	private String name;
	    private String email;
	    private String usn;
	    private String branch;
	    private Integer year;
	    
	    public StudentDTO() {
	    	
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

	    
	    
}
