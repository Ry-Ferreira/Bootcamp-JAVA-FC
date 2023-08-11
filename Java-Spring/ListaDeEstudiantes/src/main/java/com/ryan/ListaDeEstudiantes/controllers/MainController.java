package com.ryan.ListaDeEstudiantes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ryan.ListaDeEstudiantes.models.AddressModel;
import com.ryan.ListaDeEstudiantes.models.StudentsModel;
import com.ryan.ListaDeEstudiantes.services.ContactService;
import com.ryan.ListaDeEstudiantes.services.StudentsService;

@Controller
public class MainController {
	
	
	@Autowired
	private StudentsService studentService;
	@Autowired
	private ContactService contactService;
	
	//REDIRECCIONAMIENTO DE RUTA RAIZ
	@GetMapping("/")
	public String root() {
		return "redirect:/students";
	}
	
	
	//VISTA PARA STUDENTS
	@GetMapping("/students")
	public String index(Model viewModel) {
		List<StudentsModel> students = studentService.allStudents();
		viewModel.addAttribute("students", students);
		return "index.jsp";
	}
	
	//VISTA CREAR
	@GetMapping("/students/new")
	public String formStudent(Model viewModel) {
		return "new.jsp";
	}
	
	//CREAR ESTUDIANTE
	@PostMapping("/students/new")
	public String newStudent(
		@RequestParam(name="firstName") String name, 
		@RequestParam(name="lastName") String lastname,
		@RequestParam(name="age") int age){
		
		StudentsModel newStudent = new StudentsModel(name, lastname, age);
		studentService.createStudent(newStudent);
		return "redirect:/";
	}
	
	//VISTA DE CONTACTO
	@GetMapping("/contact/new")
	public String contact(Model viewModel) {
		//List<StudentsModel> students = studentService.allStudents();
		viewModel.addAttribute("students", studentService.allStudents());
		return "contact.jsp";
	}
	
	//AGREGAR INFORMACION DE CONTACTO
	
	@PostMapping("/contact/new")
	public String addContact( 
		@RequestParam(name="student") Long student_id,	
		@RequestParam(name="address") String address,
		@RequestParam(name="city") String city,
		@RequestParam(name="state") String state){
		
		StudentsModel studentById = studentService.findById(student_id);
		AddressModel contact = new AddressModel(address, city, state, studentById);
		contactService.createContact(contact);
		
		
		return "redirect:/";
	}

}
