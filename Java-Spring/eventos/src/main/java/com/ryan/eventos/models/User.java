package com.ryan.eventos.models;

import java.util.Date;
import java.util.List;

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
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
	
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
   
    
    @NotBlank(message="Por favor ingresa un nombre")
    @Size(min=3, max=30, message="Formato de nombre incorrecto")
    private String name;
    
    @NotBlank(message="Por favor ingresa un apellido")
    @Size(min=3, max=30, message="Formato de apellido incorrecto")
    private String lastName;
    
    @NotBlank(message="Por favor ingresa un correo electrónico")
    @Email(message="El ingreso no es el correcto")
    private String email;
    
    @NotBlank(message="Por favor ingresa una ubicacion")
    @Size(min=2, max=30, message="Formato de ubicacion incorrecto")
    private String location;
    
    @NotBlank(message="Por favor selecciona un estado")
    private String state;
    
    @NotBlank(message="por favor, ingresa el password")
    @Size(min=8, max=64, message="La password debe contener mínimo 8 caracteres")
    private String password;
    
    @Transient
    @NotBlank(message="por favor confirmar la password")
    @Size(min=8, max=64, message="Ambas contraseñas deben coincidir")
    private String passwordConfirmation;
    
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    //RELACION 1:N hacia eventos
    @OneToMany(mappedBy="organizador", fetch=FetchType.LAZY)
    private List<EventModel> eventosOrganizados;
    
    
    //RELACION n:m DE USUARIOS A EVENTOS
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="asists", 
    joinColumns = @JoinColumn(name="user_id"),
    inverseJoinColumns = @JoinColumn(name="event_id"))
    private List<EventModel> eventAsist;
  
    @OneToMany(mappedBy="author", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<MessageModel> messages;
    
    
    public User() {
    }
    
    
    // otros getters y setters.
    
    
 
    public Long getId() {
		return id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
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


	public void setId(Long id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}


	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
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