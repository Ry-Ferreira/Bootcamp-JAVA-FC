package com.ryan.lenguajes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ryan.lenguajes.models.LanguagesModel;
import com.ryan.lenguajes.repositories.LanguageRepo;

@Service
public class LanguageService {

	@Autowired
	private LanguageRepo languageRepo;
	
	
	//CREAR LENGUAJE
	public LanguagesModel createLanguage(LanguagesModel language) {
		return languageRepo.save(language);
	}
	
	//BUSCA TODOS LOS LENGUAJE
	public List<LanguagesModel> allLanguages(){
		return languageRepo.findAll();
	}
	
	//BUSCAR LENGUAJE POR ID
	
	public LanguagesModel findLanguage(Long id) {
		Optional<LanguagesModel> optionalSong = languageRepo.findById(id);
		if(optionalSong.isPresent()) {
			return optionalSong.get();
		}else {
			return null;
		}
	}
	
	
	//ACTUALIZAR LIRBO
    public LanguagesModel updateLanguage(LanguagesModel language) {
    	LanguagesModel temporal = findLanguage(language.getId());
    	temporal.setName(language.getName());
    	temporal.setCreatorName(language.getCreatorName());
    	temporal.setVersion(language.getVersion());
    	return languageRepo.save(temporal);
    }
	
    
	//ELIMINAR LENGUAJE
	public void deleteLanguage(LanguagesModel language) {
		languageRepo.delete(language);
	}
}
