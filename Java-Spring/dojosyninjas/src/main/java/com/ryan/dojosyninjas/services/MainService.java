package com.ryan.dojosyninjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ryan.dojosyninjas.models.DojoModel;
import com.ryan.dojosyninjas.models.NinjaModel;
import com.ryan.dojosyninjas.repositories.DojoRepo;
import com.ryan.dojosyninjas.repositories.NinjaRepo;

@Service
public class MainService {
	
	//INYECCION DE DEPENDENCIAS
	private final DojoRepo dojoRepo;
	private final NinjaRepo ninjaRepo;
	
	public MainService(DojoRepo dojoR, NinjaRepo ninjaR) {
		this.dojoRepo = dojoR;
		this.ninjaRepo = ninjaR;
	}
	
	//CREAR DOJO
	public DojoModel createDojo(DojoModel dojo) {
		return dojoRepo.save(dojo);
	}
	
	//CREAR NINJA
	public NinjaModel createNinja(NinjaModel ninja) {
		return ninjaRepo.save(ninja);
	}
	 
	//METODO LEER DOJOS
	public List<DojoModel> todosDojos() {
		return dojoRepo.findAll();
	}
	
	//METODO LEER NINJAS
	public List<NinjaModel> todosNinjas(){
		return ninjaRepo.findAll();
	}
	
	public DojoModel unDojo(Long id) {
		return dojoRepo.findById(id).orElse(null);
	}
}
