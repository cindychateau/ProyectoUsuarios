package com.codingdojo.cynthia.controladores;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.cynthia.modelos.Usuario;

@Controller
public class ControladorUsuariosPlantilla {
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping(value="/muestraUsuario", method=RequestMethod.GET)
	public String muestraUsuario(Model model) {
		
		Usuario user1 = new Usuario("Cynthia", "Castillo", 1);
		Usuario user2 = new Usuario("Valeria", "Romero", 2);
		
		model.addAttribute("titulo", "Usuarios");
		
		ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
		
		listaUsuarios.add(user1);
		listaUsuarios.add(user2);
		
		model.addAttribute("listaUsuarios", listaUsuarios);
		
		HashMap<String, String> paises = new HashMap<String, String>();
		
		paises.put("Mexico", "CDMX");
		paises.put("Estados Unidos", "Washington DC");
		paises.put("El Salvador", "San Salvador");
		
		model.addAttribute("paises", paises);
		
		return "usuarios.jsp";
		
	}
	
	@RequestMapping(value="/registro", method=RequestMethod.GET)
	public String registro() {
		return "registro.jsp";
	}
	
	@RequestMapping(value="/registraUsuario", method=RequestMethod.POST)
	public String registraUsuario(@RequestParam(value="nombre") String nombre,
								  @RequestParam(value="email") String email,
								  HttpSession session /*Se agrega para iniciar sesión*/,
								  RedirectAttributes flash /*Se agregan mensajes flash para validar*/) {
		
		System.out.println(nombre);
		System.out.println(email);
		
		ArrayList<String> mensajes = new ArrayList<String>();
		boolean isValid = true;
		
		if(nombre.equals("")) {
			mensajes.add("Por favor proporciona tu nombre");
			isValid = false;
		}
		
		if(email.equals("")) {
			mensajes.add("Por favor proporciona tu email");
			isValid = false;
		}
		
		if(!isValid) {
			flash.addFlashAttribute("error_registro", mensajes);
			return "redirect:/registro";
		}
		
		session.setAttribute("nombre_sesion", nombre);
		
		return "redirect:/dashboard";
	}
	
	@RequestMapping(value="/dashboard", method=RequestMethod.GET)
	public String dashboard() {
		return "dashboard.jsp";
	}
	
	
}
