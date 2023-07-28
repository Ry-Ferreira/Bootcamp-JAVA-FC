package com.ryan.NinjaGold.Controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;


@Controller
public class MainControllers {
	
	
	@GetMapping("/gold")
	public String raiz(HttpSession sesion, Model modelo) {
		modelo.addAttribute("gold", sesion.getAttribute("gold"));
		modelo.addAttribute("resultados", sesion.getAttribute("resultados"));
		modelo.addAttribute("randomBoolean", sesion.getAttribute("randomBoolean"));
		return "index.jsp";
	}
	
	@PostMapping("/gold")
	public String enviarOro(HttpSession sesion, @RequestParam(value="lugar") String lugar) {
	
		//VARIABLES INICIO
		int oro = 0;
		ArrayList<String> resultados = new ArrayList<String>();
		SimpleDateFormat formatoFecha = new SimpleDateFormat("MMM; D Y h:mm a");
		
		Random random = new Random();
		boolean randomBoolean = random.nextBoolean();
	
		// INICIAR LA CLAVE GOLD
		if(sesion.getAttribute("gold") == null) {
			sesion.setAttribute("gold", oro);
			sesion.setAttribute("resultados", resultados);
		} else {
			oro = (int) sesion.getAttribute("gold");
			resultados = (ArrayList<String>) sesion.getAttribute("resultados");
			
		}
		
		//SECCION DE INCREMENTO/DECREMENTO DE ORO "FARM"
		if(lugar.equals("farm") && randomBoolean) {
			int cantidad = new Random().nextInt(11)+10;
			oro += cantidad;
			resultados.add(0,"Entraste a Farm y aumentas " + cantidad + " de oro " + formatoFecha.format(new Date()) );
			sesion.setAttribute("gold", oro);
			sesion.setAttribute("resultados", resultados);
			return "redirect:/gold";
		} 
		
		else if (lugar.equals("farm") && !randomBoolean){
			int cantidad = new Random().nextInt(11)+10;
			oro -= cantidad;
			resultados.add(0,"Entraste a Farm y pierdes " + cantidad + " de oro " + formatoFecha.format(new Date()) );
			sesion.setAttribute("gold", oro);
			sesion.setAttribute("resultados", resultados);
			return "redirect:/gold";
		}
		
		//SECCION DE INCREMENTO/DECREMENTO DE ORO "CAVE"
		if(lugar.equals("cave") && randomBoolean) {
			int cantidad = new Random().nextInt(6)+5;
			oro += cantidad;
			resultados.add(0,"Entraste a Cave y aumentas " + cantidad + " de oro " + formatoFecha.format(new Date()) );
			sesion.setAttribute("gold", oro);
			sesion.setAttribute("resultados", resultados);
			return "redirect:/gold";
		} 
		
		else if (lugar.equals("cave") && !randomBoolean){
			int cantidad = new Random().nextInt(6)+5;
			oro -= cantidad;
			resultados.add(0,"Entraste a Cave y pierdes " + cantidad + " de oro " + formatoFecha.format(new Date()) );
			sesion.setAttribute("gold", oro);
			sesion.setAttribute("resultados", resultados);
			return "redirect:/gold";
		}
		
		
		//SECCION DE INCREMENTO/DECREMENTO DE ORO "HOUSE"
		if(lugar.equals("house") && randomBoolean) {
			int cantidad = new Random().nextInt(3)+2;
			oro += cantidad;
			resultados.add(0,"Entraste a House y aumentas " + cantidad + " de oro " + formatoFecha.format(new Date()) );
			sesion.setAttribute("gold", oro);
			sesion.setAttribute("resultados", resultados);
			return "redirect:/gold";
		} 
		
		else if (lugar.equals("house") && !randomBoolean){
			int cantidad = new Random().nextInt(3)+2;
			oro -= cantidad;
			resultados.add(0,"Entraste a House y pierdes " + cantidad + " de oro " + formatoFecha.format(new Date()) );
			sesion.setAttribute("gold", oro);
			sesion.setAttribute("resultados", resultados);
			return "redirect:/gold";
		}
		
		
		//SECCION DE INCREMENTO/DECREMENTO DE ORO "CASINO"
		if(lugar.equals("casino") && randomBoolean) {
			int cantidad = new Random().nextInt(51);
			oro += cantidad;
			resultados.add(0,"Entraste a Casino y aumentas " + cantidad + " de oro " + formatoFecha.format(new Date()) );
			sesion.setAttribute("gold", oro);
			sesion.setAttribute("resultados", resultados);
			return "redirect:/gold";
		} 
		
		else if (lugar.equals("casino") && !randomBoolean){
			int cantidad = new Random().nextInt(51);
			oro -= cantidad;
			resultados.add(0,"Entraste a Casino y pierdes " + cantidad + " de oro " + formatoFecha.format(new Date()) );
			sesion.setAttribute("gold", oro);
			sesion.setAttribute("resultados", resultados);
			return "redirect:/gold";
		}
		
		//SECCION DE INCREMENTE/DECREMENTO DE ORO "CAVE"
		//if(lugar.equals("cave")) {
		//	int cantidad = new Random().nextInt(6)+5;
		//	oro += cantidad;
		//	resultados.add(0, "Entraste a farm y aumentas " + cantidad + " oro " + formatoFecha.format(new Date()) );
		//	sesion.setAttribute("gold", oro);
		//	sesion.setAttribute("resultados", resultados);
		//	return "redirect:/gold";
		//}
		
		
		
		
		return "redirect:/gold";
	}
}
