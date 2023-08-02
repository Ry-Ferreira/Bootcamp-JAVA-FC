package com.ryan.bookAPI.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ryan.bookAPI.models.BookModel;
import com.ryan.bookAPI.services.BookService;

@RestController
public class BookApiController {
	
	//INYECCION DE DEPENDENCIAS
	 // private final bookservice bookservice;
	  //  public BooksApi(bookservice bookservice){
	  //      this.bookservice = bookservice;
	  //  }
	    
	    @Autowired
	    private BookService bookservice;
	    
	    //OBTENER TODOS LOS LIBROS
	    @GetMapping("/api/books")
	    public List<BookModel> index() {
	        return bookservice.allBooks();
	    }
	    
	    //CREAR UN LIBRO
	    @PostMapping(value="/api/books")
	    public BookModel create(
	    		@RequestParam(value="title") String title, 
	    		@RequestParam(value="description") String desc, 
	    		@RequestParam(value="language") String lang, 
	    		@RequestParam(value="pages") Integer numOfPages) {
	    	
	        BookModel book = new BookModel(title, desc, lang, numOfPages);
	        return bookservice.createBook(book);
	        
	    }
	    
	    //MOSTRAR INFORMACION DE UN LIBRO ESPECIFICO
	    @GetMapping("/api/books/{id}")
	    public BookModel show(@PathVariable("id") Long id) {
	        BookModel book = bookservice.findBook(id);
	        return book;
	    }
	
	    
	    //ACTUALIZAR INFORMACION DE UN LIBRO
	    @PutMapping("/api/books/{id}")
	    public BookModel update(
	    		@PathVariable("id")Long id, 
	    		@RequestParam(value="title") String title, 
	    		@RequestParam(value="description") String desc, 
	    		@RequestParam(value="language") String lang, 
	    		@RequestParam(value="pages") Integer numOfPages) {
	    	
	    	BookModel book = new BookModel(id, title, desc, lang, numOfPages);
	    	//return bookservice.updateBook(book);
	    	return bookservice.updateBook(id, title, desc, lang, numOfPages);
	    }
	    
	    //BORRAR REGISTRO
	    
	    @DeleteMapping("/api/books/{id}")
	    public void deleteRegister(@PathVariable("id")Long id) {
	    	bookservice.delete(id);
	    }
}
