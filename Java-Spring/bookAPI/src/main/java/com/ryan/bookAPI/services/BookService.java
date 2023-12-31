package com.ryan.bookAPI.services;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryan.bookAPI.models.BookModel;
import com.ryan.bookAPI.repositories.BookRepo;

import jakarta.validation.Valid;


@Service
public class BookService {
	
	
	//Agregando el book al repositorio como una dependencia
   // private final bookrepo bookrepo;
    
   // public BookService(bookrepo bookrepo) {
   //     this.bookRepo = bookrepo;
   // }
    
    @Autowired
    private BookRepo bookrepo;
    
    //Devolviendo todos los libros.
    public List<BookModel> allBooks() {
        return bookrepo.findAll();
    }
    //Creando un libro.
    public BookModel createBook(BookModel b) {
        return bookrepo.save(b);
    }
    //Obteniendo la información de un libro
    public BookModel findBook(Long id) {
        Optional<BookModel> optionalBook = bookrepo.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    
    //ACTUALIZAR LIRBO
    public BookModel updateBook(BookModel libro) {
    	BookModel temporal = findBook(libro.getId());
    	temporal.setDescription(libro.getDescription());
    	temporal.setLanguage(libro.getLanguage());
    	temporal.setNumberOfPages(libro.getNumberOfPages());
    	temporal.setTitle(libro.getTitle());
    	return bookrepo.save(temporal);
    }
    
    
    //ACTUALIZAR INFORMACION
    public BookModel updateBook(
    		Long id, 
    		String title, 
    		String desc, 
    		String lang, 
    		Integer numOfPages) {
    	BookModel temporal = bookrepo.findById(id).orElse(null);
    	
    	if(temporal != null ) {
    		temporal.setDescription(desc);
    		temporal.setLanguage(lang);
    		temporal.setNumberOfPages(numOfPages);
    		temporal.setTitle(title);
    		
    		bookrepo.save(temporal);
    		return temporal;
    	} else {
    		return temporal;
    	}    	
    }
    
    //BORRAR REGISTRO
    public void delete(Long id) {
    	bookrepo.deleteById(id);
    }
}
