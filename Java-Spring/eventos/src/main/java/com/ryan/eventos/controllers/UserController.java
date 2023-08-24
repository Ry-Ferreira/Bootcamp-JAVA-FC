package com.ryan.eventos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ryan.eventos.models.EventModel;
import com.ryan.eventos.models.LogReg;
import com.ryan.eventos.models.States;
import com.ryan.eventos.models.User;
import com.ryan.eventos.services.EventService;
import com.ryan.eventos.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {
	
	private final UserService userServ;
	private final EventService eventServ;
	public UserController(UserService uSer, EventService eSer) {
		this.userServ = uSer;
		this.eventServ = eSer;
	}
	
	@GetMapping("/")
	public String raiz(Model viewModel) {
		viewModel.addAttribute("user", new User());
		viewModel.addAttribute("login", new LogReg());
		viewModel.addAttribute("states", States.allStates);
		return "loginreg.jsp";
	}
	
	@GetMapping("/events")
	public String welcome(@ModelAttribute("event") EventModel evento, BindingResult result,HttpSession sesion, Model viewModel) {
		
		Long userId = (Long) sesion.getAttribute("userId");
		if(userId == null) {
			return "redirect:/";
		}
		
		User usuario = userServ.findUserId(userId);
		viewModel.addAttribute("usuario", usuario);
		viewModel.addAttribute("states", States.allStates);
		viewModel.addAttribute("sameEventState", eventServ.sameEventState(usuario.getState()));
		viewModel.addAttribute("otherEvent", eventServ.otherEventState(usuario.getState()));
		
		
		return "dashboard.jsp";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession sesion) {
		sesion.setAttribute("userId", null);
		return "redirect:/";
	}
	
	@PostMapping("/registration")
	public String register(@Valid @ModelAttribute("user") User usuario,
			BindingResult result, Model viewModel) {
			
			if(result.hasErrors()) {
				viewModel.addAttribute("login", new LogReg());
				viewModel.addAttribute("states", States.allStates);
				return "loginreg.jsp";
			}
			
			User registerSuccess = userServ.registerUser(usuario, result); 
			viewModel.addAttribute("login", new LogReg());
			
			if(registerSuccess != null) {
				viewModel.addAttribute("registro", "Registrado correctamente!, Ya puedes logearte!");
				
			}

		return "loginreg.jsp";
	}
	
	
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("login") LogReg loginuser,
			BindingResult result, Model viewModel, HttpSession sesion) {
			
			if(result.hasErrors()) {
				viewModel.addAttribute("user", new User());
				viewModel.addAttribute("states", States.allStates);
				return "loginreg.jsp";
			}
			
			if(userServ.authenthicateUser(loginuser.getEmail(), loginuser.getPassword(), result)) {
				
				User usuarioSuccess = userServ.findEmail(loginuser.getEmail());
				sesion.setAttribute("userId", usuarioSuccess.getId());
				return "redirect:/events";
			} else {
				viewModel.addAttribute("errorLog", "Por favor intenta de nuevo");
				viewModel.addAttribute("user", new User());
				return "loginreg.jsp";
			}
	}
}