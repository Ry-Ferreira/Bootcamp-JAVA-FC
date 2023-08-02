package com.ryan.bookAPI.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.ryan.bookAPI.models.BookModel;
import com.ryan.bookAPI.services.BookService;

import jakarta.validation.Valid;

@Controller
public class BookController {
//	    private final BookService bookService;
//	    
//	    public BooksController(BookService bookService) {
//	        this.bookService = bookService;
//	    }
	
	@Autowired
	private BookService bookservice;
	
	
	
		//TODOS LOS LIBROS
	    @GetMapping("/books")
	    public String index(Model model) {
	        List<BookModel> books = bookservice.allBooks();
	        model.addAttribute("books", books);
	        return "/books/index.jsp";
	    }
	    
	    @GetMapping("/books/new")
	    public String formBook(@ModelAttribute("libro") BookModel book) {
	    	
	    	return "/books/formBook.jsp";
	    }
	    
	    @PostMapping("/books")
	    public String newBook(@Valid @ModelAttribute("libro") BookModel book, BindingResult result) {
	        if(result.hasErrors()) {
	        	return "/books/formBook.jsp";
	        } else {
	        	bookservice.createBook(book);
	        	return "redirect:/books";
	        }
	    }
	    
	    
	    //EDITAR LIBRO
	    
	    @GetMapping("/books/{id}/edit")
	    public String edit(@PathVariable("id") Long id, Model model) {
	        BookModel book = bookservice.findBook(id);
	        model.addAttribute("libro", book);
	        return "/books/edit.jsp";
	    }
	    
	    //EDITAR LIBRO
	    @PutMapping("/books/{id}")
	    public String update(@Valid @ModelAttribute("libro") BookModel book, BindingResult result) {
	        if (result.hasErrors()) {
	            return "/books/edit.jsp";
	        } else {
	            bookservice.updateBook(book);
	            return "redirect:/books";
	        }
	    }
	    
	    
	    //BORRAR LIBRO
	    @DeleteMapping("/books/{id}")
	    public String destroy(@PathVariable("id") Long id) {
	    	bookservice.delete(id);
	    	return "redirect:/books";
	    }
	   // @PostMapping(value="/books")
	   // public String create(@Valid @ModelAttribute("book") BookModel book, BindingResult result) {
	   //     if (result.hasErrors()) {
	   //        return "/books/new.jsp";
	   //     } else {
	   //         bookservice.createBook(book);
	   //         return "redirect:/books";
	   //    }
	   // }
	    
	    
	    
	}
