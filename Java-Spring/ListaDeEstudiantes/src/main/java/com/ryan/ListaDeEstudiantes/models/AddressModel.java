package com.ryan.ListaDeEstudiantes.models;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="address")
public class AddressModel {

	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	 
	 	@NotBlank
	    private String address;
	 	
	 	@NotBlank
	    private String city;
	 	
	 	@NotBlank
	    private String state;
	 	
	 	@Column(updatable=false)
	    private Date createdAt;
	    private Date updatedAt;
	    
	    @OneToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "students_id")
		private StudentsModel students;
	    
	    public AddressModel() {
	    }

	    public AddressModel(String address, String city, String state, StudentsModel student) {
	    	this.address = address;
	    	this.city = city;
	    	this.state = state;
	    	this.students = student;
	    }
	    
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public Date getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}

		public Date getUpdatedAt() {
			return updatedAt;
		}

		public void setUpdatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
		}

	    
		public StudentsModel getStudents() {
			return students;
		}

		public void setStudents(StudentsModel students) {
			this.students = students;
		}

		@PrePersist
		protected void createdAt() {
			this.createdAt = new Date();
		}
	    
		@PreUpdate
		protected void updatedAt() {
			this.updatedAt = new Date();
		}
	    
}
