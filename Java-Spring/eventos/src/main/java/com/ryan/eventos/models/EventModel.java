package com.ryan.eventos.models;

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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="events")
public class EventModel {

		@Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
	    private Long id;
	   
	    
	    @NotBlank(message="Por favor ingresa un nombre")
	    @Size(min=3, max=30, message="Formato de nombre incorrecto")
	    private String name;
	    
	    @Future(message="ingresa una fecha posterior")
	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    @NotNull(message="Por favor ingresa un fecha")
	    private Date date;

	    @NotBlank(message="Por favor ingresa una ubicacion")
	    @Size(min=2, max=30, message="Formato de ubicacion incorrecto")
	    private String location;
	    
	    @NotBlank(message="Por favor selecciona un estado")
	    private String state;
	    

	    
	    @Column(updatable=false)
	    private Date createdAt;
	    private Date updatedAt;
	    
	    //RELACION 1:N HACIA USUARIO
	    @ManyToOne(fetch=FetchType.LAZY)
	    @JoinColumn(name="user_id")
	    private User organizador;
	    
	    
	    //RELACIONA n:m EVENTOS A USUARIOS
	    @ManyToMany(fetch=FetchType.LAZY)
	    @JoinTable(name="asists", 
	    joinColumns = @JoinColumn(name="event_id"),
	    inverseJoinColumns = @JoinColumn(name="user_id"))
	    private List<User> asist;
	    
	    
	    //RELACION n:n HACIA MENSAJES
	    @OneToMany(mappedBy="event", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	    private List<MessageModel> messages;
	    
	    public EventModel() {
	    }
	    
	    
	    
	    public List<MessageModel> getMessages() {
			return messages;
		}



		public void setMessages(List<MessageModel> messages) {
			this.messages = messages;
		}



		public List<User> getAsist() {
			return asist;
		}



		public void setAsist(List<User> asist) {
			this.asist = asist;
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



		public Date getDate() {
			return date;
		}



		public void setDate(Date date) {
			this.date = date;
		}



		public String getLocation() {
			return location;
		}



		public void setLocation(String location) {
			this.location = location;
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



		public User getOrganizador() {
			return organizador;
		}



		public void setOrganizador(User organizador) {
			this.organizador = organizador;
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
