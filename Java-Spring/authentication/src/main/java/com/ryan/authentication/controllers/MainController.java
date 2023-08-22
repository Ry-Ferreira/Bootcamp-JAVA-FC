package com.ryan.authentication.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ryan.authentication.models.LogReg;
import com.ryan.authentication.models.User;
import com.ryan.authentication.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class MainController {
	
	private final UserService userServ;
	public MainController(UserService uSer) {
		this.userServ = uSer;
	}
	
	@GetMapping("/")
	public String raiz(Model viewModel) {
		viewModel.addAttribute("user", new User());
		viewModel.addAttribute("login", new LogReg());
		
		return "loginreg.jsp";
	}
	
	@GetMapping("/dashboard")
	public String welcome(HttpSession sesion, Model viewModel) {
		
		Long userId = (Long) sesion.getAttribute("userId");
		if(userId == null) {
			return "redirect:/";
		}
		
		User usuario = userServ.findUserId(userId);
		viewModel.addAttribute("usuario", usuario);
		
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
				return "loginreg.jsp";
			}
			
			if(userServ.authenthicateUser(loginuser.getEmail(), loginuser.getPassword(), result)) {
				
				User usuarioSuccess = userServ.findEmail(loginuser.getEmail());
				sesion.setAttribute("userId", usuarioSuccess.getId());
				return "redirect:/dashboard";
			} else {
				viewModel.addAttribute("errorLog", "Por favor intenta de nuevo");
				viewModel.addAttribute("user", new User());
				return "loginreg.jsp";
			}
	}
}
