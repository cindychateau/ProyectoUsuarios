package com.codingdojo.cynthia.controladores;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class ControladorUsuarios {
	
	public static String usuarios[] = {"Kenny", "Jhomar", "Vale", "Fabian"};

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String despliegaHome() {
		String respuesta = "<ul>";
		
		for(int i=0; i<usuarios.length;i++) {
			respuesta += "<li>"+usuarios[i]+"</li>";
		}
		
		respuesta += "</ul>";
		
		return respuesta;
	}
	
	@RequestMapping(value="/hello/{nombre}/{apellido}", method=RequestMethod.GET)
	public String helloNombre(@PathVariable("nombre") String name,
							  @PathVariable("apellido") String lastname) {
		return "<h1>Hello "+name+" "+lastname+"!</h1>";
	}
	
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public String helloNombreParam(@RequestParam(value="nombre") String name, 
								   @RequestParam(value="apellido") String lastname) {
		return "<h1>Hola "+name+" "+lastname+"!</h1>";
	}
	
	@RequestMapping(value="/clase/{tema}", method=RequestMethod.GET)
	public String clase(@PathVariable("tema") String tema) {
		return "<h2>Bienvenidos a la clase de "+tema+"</h2>";
	}
	
	
	
}
