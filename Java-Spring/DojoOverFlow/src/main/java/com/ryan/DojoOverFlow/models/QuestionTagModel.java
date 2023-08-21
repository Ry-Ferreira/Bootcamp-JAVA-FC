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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;


@Entity
@Table(name="tags_questions")
public class QuestionTagModel {
	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	
	 	
	 	@Column(updatable = false)
	    @DateTimeFormat(pattern = "yyyy-MM-dd")
	    private Date createdAt;
	    @DateTimeFormat(pattern = "yyyy-MM-dd")
	    private Date updatedAt;
	 	
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name="question_id")
	    private QuestionModel question;
	    
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name="tag_id")
	    private TagModel tag;
	    
	    public QuestionTagModel() {
	        
	    }

	    
		public QuestionModel getQuestion() {
			return question;
		}

		public void setQuestion(QuestionModel questions) {
			this.question = questions;
		}

		public TagModel getTag() {
			return tag;
		}

		public void setTag(TagModel tags) {
			this.tag = tags;
		}


		public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
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
	    
		@PrePersist
	    protected void onCreate(){
	        this.createdAt = new Date();
	    }
	    @PreUpdate
	    protected void onUpdate(){
	        this.updatedAt = new Date();
	    }
	    
}
