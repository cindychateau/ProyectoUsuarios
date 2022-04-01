package com.codingdojo.cynthia.controladores;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
	
}
