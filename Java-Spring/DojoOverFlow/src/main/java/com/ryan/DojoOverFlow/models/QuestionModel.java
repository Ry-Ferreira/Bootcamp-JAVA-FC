package com.ryan.DojoOverFlow.models;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="questions")
public class QuestionModel {

	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	 
	 	@NotBlank
	    private String question;
	 	
	    @Column(updatable=false)
	    @DateTimeFormat(pattern = "yyyy-MM-dd")
	    private Date createdAt;
	    
	    @DateTimeFormat(pattern = "yyyy-MM-dd")
	    private Date updatedAt;
	    
	    @ManyToMany(fetch = FetchType.LAZY)
	    @JoinTable(
	            name = "tags_questions", 
	            joinColumns = @JoinColumn(name = "question_id"), 
	            inverseJoinColumns = @JoinColumn(name = "tag_id")
	    )
	    private List<TagModel> tags;
	    
	    @OneToMany(mappedBy="questions", fetch=FetchType.LAZY)
	    private List<AnswerModel> answers;
	    
	    //CONSTRUCTOR
	    public QuestionModel() {
	        
	    }

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getQuestion() {
			return question;
		}

		public void setQuestion(String question) {
			this.question = question;
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

		public List<TagModel> getTags() {
			return tags;
		}

		public void setTags(List<TagModel> tags) {
			this.tags = tags;
		}

		public List<AnswerModel> getAnswers() {
			return answers;
		}

		public void setAnswers(List<AnswerModel> answers) {
			this.answers = answers;
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
