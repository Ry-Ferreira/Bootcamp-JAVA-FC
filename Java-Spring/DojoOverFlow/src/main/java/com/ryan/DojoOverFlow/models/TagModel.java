package com.ryan.DojoOverFlow.models;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="tags")
public class TagModel {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
 
		@NotBlank
		private String subject;
		
		@Column(updatable=false)
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		private Date createdAt;
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		private Date updatedAt;
	
		
	 	@ManyToMany(fetch = FetchType.LAZY)
	    @JoinTable(
	            name = "tags_questions", 
	            joinColumns = @JoinColumn(name = "tag_id"), 
	            inverseJoinColumns = @JoinColumn(name = "question_id")
	    )
	    private List<QuestionModel> questions;
	 	
	 	
	 	public TagModel() {
	 		
	 	}

	 	//GETTERS AND SETTERS
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getSubject() {
			return subject;
		}

		public void setSubject(String subject) {
			this.subject = subject;
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

		public List<QuestionModel> getQuestions() {
			return questions;
		}

		public void setQuestions(List<QuestionModel> questions) {
			this.questions = questions;
		}
	 	
		@PrePersist
		protected void createAt() {
			this.createdAt = new Date();
		}
		
		@PreUpdate
		protected void updateAt() {
			this.updatedAt = new Date();
		}
}