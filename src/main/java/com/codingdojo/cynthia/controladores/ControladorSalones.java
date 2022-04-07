package com.codingdojo.cynthia.controladores;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.cynthia.modelos.Salon;
import com.codingdojo.cynthia.servicios.ServicioUsuarios;

@Controller
public class ControladorSalones {
	
	private final ServicioUsuarios servicio;
	
	public ControladorSalones(ServicioUsuarios servicio) {
		this.servicio = servicio;
	}
	
	/*
	 * @RequestMapping(value="/salon/{id}", method=RequestMethod.GET)
	 * @RequestMapping("/salon/{id}")
	 * */
	@GetMapping("/salon/{id}")
	public String show_salon(@PathVariable("id") Long id, Model model) {
		Salon salon_clase = servicio.find_salon(id);
		model.addAttribute("salon", salon_clase);
		return "/salones/show.jsp";
	}
	
	@RequestMapping("/salones")
	public String salones(Model model) {
		List<Salon> salones = servicio.get_salones();
		model.addAttribute("salones", salones);
		
		return "/salones/index.jsp";
	}
	
	
}
