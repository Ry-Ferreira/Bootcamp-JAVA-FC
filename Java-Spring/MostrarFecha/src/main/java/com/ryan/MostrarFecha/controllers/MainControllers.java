package com.ryan.MostrarFecha.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainControllers {
	
	@GetMapping("/")
	public String home() {
		return "index.jsp";
	}
	
	@GetMapping("/date")
	public String date(Model modelo) {
		
		SimpleDateFormat fecha = new SimpleDateFormat("EEEE,MMM d, yyy");
		Date date = new Date();
		
		modelo.addAttribute("fecha", fecha.format(date));
		return "date.jsp";
	}
	
	@GetMapping("/time")
	public String time(Model modelo) {
		
		SimpleDateFormat tiempo = new SimpleDateFormat("h:mm a");
		Date date = new Date();
		
		modelo.addAttribute("tiempo", tiempo.format(date));
		return "time.jsp";
	}
	
}
