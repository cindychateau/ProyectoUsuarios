package com.codingdojo.cynthia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController //Para mostrar las URLS
public class ProyectoUsuariosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoUsuariosApplication.class, args);
	}
	
	/*@RequestMapping("/")
	public String despliegaHome() {
		return "Hola desde spring!";
	}*/

}
