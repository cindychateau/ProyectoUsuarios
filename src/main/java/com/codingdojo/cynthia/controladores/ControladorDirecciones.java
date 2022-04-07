package com.codingdojo.cynthia.controladores;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.cynthia.modelos.Direccion;
import com.codingdojo.cynthia.modelos.Usuario;
import com.codingdojo.cynthia.servicios.ServicioUsuarios;

@Controller
@RequestMapping("/direcciones")
public class ControladorDirecciones {
	
	private final ServicioUsuarios servicio;
	
	public ControladorDirecciones(ServicioUsuarios servicio) {
		this.servicio = servicio;
	}
	
	@RequestMapping("/new")
	public String new_direccion(@ModelAttribute("direccion") Direccion direccion, Model model) {
		List<Usuario> sindireccion = servicio.get_users_no_address();
		
		model.addAttribute("usuarios_sindireccion", sindireccion);
		
		return "/direcciones/new.jsp";
		
	}
	
	@PostMapping("/create")
	public String create_direccion(@Valid @ModelAttribute("direccion") Direccion direccion, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			List<Usuario> sindireccion = servicio.get_users_no_address();
			
			model.addAttribute("usuarios_sindireccion", sindireccion);
			
			return "/direcciones/new.jsp";
		} else {
			servicio.save_direccion(direccion);
			return "redirect:/dashboard";
		}
		
	}
	
	
}
