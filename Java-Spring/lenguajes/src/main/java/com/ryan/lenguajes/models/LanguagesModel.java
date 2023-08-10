package com.ryan.lenguajes.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="languages")
public class LanguagesModel {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotBlank(message="Por favor agrega un lenguaje")
    private String name;
	
	@NotBlank(message="Por favor agrega una version")
    private String version;
	
	@NotBlank(message="Por favor agrega el nombre del creador")
    private String creatorName;
	
	@Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    //CONSTRUCTOR PARA BEANS
    
    public LanguagesModel() {
    	
    }
    
    public LanguagesModel(String name, String version, String creatorName) {
        this.name = name;
        this.version = version;
        this.creatorName = creatorName;
    }
    
    //CONSTRUCTOR POR ID PARA EDIT
    public LanguagesModel(Long id, String name, String version, String creatorName) {
    	this.id = id;
        this.name = name;
        this.version = version;
        this.creatorName = creatorName;
    }
    
    
    //GETTERS AND SETTERS
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
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getCreatorName() {
		return creatorName;
	}
	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
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
	protected void createdAt() {
		this.createdAt = new Date();
	}
    
	@PreUpdate
	protected void updatedAt() {
		this.updatedAt = new Date();
	}
    
}
