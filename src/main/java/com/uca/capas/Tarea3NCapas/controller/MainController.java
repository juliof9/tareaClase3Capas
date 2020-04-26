package com.uca.capas.Tarea3NCapas.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	@RequestMapping("/ingresar")
	public String index() {
		return "views/index";
	}
	
	@RequestMapping("/datos1")
	public ModelAndView datos1(HttpServletRequest request) {
		
		List<String> lista = new ArrayList<>();
		
		ModelAndView mav = new ModelAndView();
		String nombres = request.getParameter("nombres");
		String apellidos = request.getParameter("apellidos");
		String fechaN = request.getParameter("fechaNacimiento");
		String lugarN = request.getParameter("lugarNacimiento");
		String lugarprocedencia = request.getParameter("procedencia");
		String telfijo = request.getParameter("telfijo");
		String telmovil = request.getParameter("telMovil");
		
		if(nombres.length()>25)
			lista.add("El campo nombres no puede ser mayor a 25 caracteres");
		if(apellidos.length()>25)
			lista.add("El campo apellidos no puede ser mayor a 25 caracteres");
		if(lugarN.length()>25)
			lista.add("El campo lugar de nacimiento no puede ser mayor a 25 caracteres");
		if(lugarprocedencia.length()>100)
			lista.add("El campo lugar de procedencia no puede ser mayor a 100 caracteres");
		if(telfijo.length()!=8)
			lista.add("El numero de telefono fijo tiene que ser de 8 digitos");
		if(telmovil.length()!=8)
			lista.add("El numero de celular tiene que ser de 8 digitos");
		if(lista == null || lista.isEmpty())
			lista.add("Alumno ingresado con exito");
		
		mav.addObject("nombres",nombres);
		mav.addObject("apellidos", apellidos);
		mav.addObject("fechaNacimiento", fechaN);
		mav.addObject("lugarNacimiento", lugarN);
		mav.addObject("procedencia", lugarprocedencia);
		mav.addObject("telfijo", telfijo);
		mav.addObject("telMovil", telmovil);
		mav.addObject("Errores",lista);
		mav.setViewName("views/resultado");			
		
		return mav;
	}

}
