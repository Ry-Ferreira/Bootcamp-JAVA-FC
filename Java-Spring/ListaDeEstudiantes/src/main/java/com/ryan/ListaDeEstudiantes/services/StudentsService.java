package com.ryan.ListaDeEstudiantes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryan.ListaDeEstudiantes.models.StudentsModel;
import com.ryan.ListaDeEstudiantes.repositories.StudentsRepositorie;

@Service
public class StudentsService {
	
	@Autowired
	private StudentsRepositorie studentRepo;
	
	public StudentsModel createStudent(StudentsModel student) {
		return studentRepo.save(student);
	}
	
	public List<StudentsModel> allStudents(){
		return studentRepo.findAll();
	}
	
	public StudentsModel findById(Long id){
		Optional<StudentsModel> student = studentRepo.findById(id);
		
		if(student.isPresent()) {
			return student.get();
		}
		
		return null;
	}
}
