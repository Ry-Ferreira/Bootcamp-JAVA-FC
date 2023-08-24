package com.ryan.eventos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ryan.eventos.models.EventModel;
import com.ryan.eventos.models.States;
import com.ryan.eventos.models.User;
import com.ryan.eventos.services.EventService;
import com.ryan.eventos.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class EventController {

	private final EventService eventServ;
	private final UserService userServ;
	public EventController(EventService eSer, UserService uSer) {
		this.eventServ = eSer;
		this.userServ = uSer;
	}
	
	
	@PostMapping("/new/event")
	public String createEvent(@Valid @ModelAttribute("event") EventModel evento, 
			BindingResult result,
			HttpSession sesion,
			Model viewModel) {
		
		//VALIDAR SI LA SESION DEL USUARIO ESTA ACTIVA
		Long userId = (Long) sesion.getAttribute("userId");
		if(userId == null) {
			return "redirect:/";
		}
		
		if(result.hasErrors()) {
			User usuario = userServ.findUserId(userId);
			viewModel.addAttribute("usuario", usuario);
			viewModel.addAttribute("states", States.allStates);
			viewModel.addAttribute("sameEventState", eventServ.sameEventState(usuario.getState()));
			viewModel.addAttribute("otherEvent", eventServ.otherEventState(usuario.getState()));
			return "dashboard.jsp";
		}
		
		eventServ.createEvent(evento);
		
		return "redirect:/events";
	}
	
	//EDITAR EVENTO
	@GetMapping("/events/{idEvent}/edit")
	public String editForm(@PathVariable("idEvent") Long idEvent, 
			HttpSession sesion, 
			Model viewModel) {
		//VALIDAR SI EL USUARIO SIGUE ACITVO
		Long userId = (Long) sesion.getAttribute("userId");
		if(userId == null) {
			return "redirect:/";
		}
		
		EventModel anEvent = eventServ.eventById(idEvent);
		//VALIDAR SI ENCUENTRA EVENTO POR ID
		if(anEvent == null) {
			return "redirect:/";
		}
		
		User usuario = userServ.findUserId(userId);
		viewModel.addAttribute("usuario", usuario);
		viewModel.addAttribute("states", States.allStates);
		viewModel.addAttribute("editEvent", anEvent);
		
		
		return "edit.jsp";
	}
	
	//EDITAR EVENTO PUT
	@PutMapping("/events/{id}/edit")
	public String edit(@Valid @ModelAttribute("editEvent") EventModel evento,
			BindingResult result, @PathVariable("id") Long idEvent, 
			HttpSession sesion, Model viewModel) {
		
		//VALIDAR SI EL USUARIO SIGUE ACITVO
		Long userId = (Long) sesion.getAttribute("userId");
		if(userId == null) {
			return "redirect:/";
		}
		EventModel anEvent = eventServ.eventById(idEvent);
		User usuario = userServ.findUserId(userId);
		
		if(result.hasErrors()) {
			
			viewModel.addAttribute("usuario", usuario);
			viewModel.addAttribute("states", States.allStates);
			viewModel.addAttribute("evento", anEvent);
			return "edit.jsp";
		}
		
		eventServ.editEvent(evento);
		
		return "redirect:/events";
	}
	
	
	
	@DeleteMapping("/events/{id}")
	public String delete(@PathVariable("id") Long id) {	
		eventServ.deleteEvent(id);	
		return "redirect:/events";
	}
	
	
	//UNIRSE-CANCELAR AL EVENTO
	
	@GetMapping("/events/{idEvent}/{idUser}/{option}")
	public String eventAction(@PathVariable("idEvent") Long idEvent,
			@PathVariable("idUser") Long idUser,
			@PathVariable("option") String option, 
			HttpSession sesion) {
		
		//VALIDAR SI EL USUARIO SIGUE ACITVO
			Long userId = (Long) sesion.getAttribute("userId");
			if(userId == null) {
				return "redirect:/";
			}
			
			EventModel anEvent = eventServ.eventById(idEvent);
			User usuario = userServ.findUserId(userId);
			boolean joinCancel = (option.equals("unirse"));
			
			eventServ.joinCancelAsist(anEvent, usuario, joinCancel);
			
			return "redirect:/events";
	}
	
	
	//PLANTILLA SHOW INFO
	
	@GetMapping("/events/{idEvent}")
	public String showEvent(@PathVariable("idEvent") Long idEvent, Model viewModel, HttpSession sesion) {
		
		Long userId = (Long) sesion.getAttribute("userId");
		if(userId == null) {
			return "redirect:/";
		}
		
		User usuario = userServ.findUserId(userId);
		EventModel anEvent = eventServ.eventById(idEvent);
				
		viewModel.addAttribute("event", eventServ.eventById(idEvent));
		viewModel.addAttribute("usuario", usuario);
		
		return "show.jsp";
	}
	
	//METODO PARA MENSAJES A EVENTOS
	@PostMapping("/events/{idEvent}/comentario")
	public String addComment(@PathVariable("idEvent") Long idEvent,
			@RequestParam("comment") String comment, HttpSession sesion,
			RedirectAttributes error) {
		
		//VALIDAR SI EL USUARIO SIGUE ACITVO
		Long userId = (Long) sesion.getAttribute("userId");
		if(userId == null) {
			return "redirect:/";
		}
		
		if(comment.equals("")) {
			error.addFlashAttribute("error", "Por favor no envies mensajes vacios");
			return "redirect:/events";
		}
		
		EventModel anEvent = eventServ.eventById(idEvent);
		User usuario = userServ.findUserId(userId);
		
		eventServ.addComment(usuario, anEvent, comment);
		
		return "redirect:/events/"+idEvent;
	}
	
	
	
}
