package com.ryan.licencias.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryan.licencias.models.Licencia;
import com.ryan.licencias.models.Persona;
import com.ryan.licencias.repositories.LicenciaRepo;
import com.ryan.licencias.repositories.PersonaRepo;

@Service
public class MainService {
	
	//INYECCIONES DE DEPENDENCIAS
	@Autowired
	private LicenciaRepo licenciaRepo;
	
	@Autowired
	private PersonaRepo personaRepo;
	
	//SERVICE PERSONA
	public Persona crearPersona(Persona persona) {
		return personaRepo.save(persona);
	}
	
	public List<Persona> allPerson(){
		return personaRepo.findAll();
	}
	
	//SERVICE LICENCIA
	public Licencia crearLicencia(Licencia licencia) {
		licencia.setNumber(this.generarNumLic());
		return licenciaRepo.save(licencia);
	}
	
	
	public List<Persona> personasSinLic(){
		return personaRepo.findNoLic();
	}
	
	
	//METODO PARA GENERAR NUMERO DE LICENCIA
	public int generarNumLic() {
		Licencia lic = licenciaRepo.findTopByOrderByNumberDesc();
		if(lic == null) {
			return 1;
		} 
		
		int numeroMayorLicencia = lic.getNumber();
		numeroMayorLicencia++;
		return numeroMayorLicencia;
	}
	
	
}
