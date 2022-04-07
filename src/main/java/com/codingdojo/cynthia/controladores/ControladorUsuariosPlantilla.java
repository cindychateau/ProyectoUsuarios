package com.codingdojo.cynthia.controladores;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.cynthia.modelos.Salon;
import com.codingdojo.cynthia.modelos.Usuario;
import com.codingdojo.cynthia.servicios.ServicioUsuarios;

@Controller
public class ControladorUsuariosPlantilla {
	
	private final ServicioUsuarios servicio;
	
	public ControladorUsuariosPlantilla(ServicioUsuarios servicio) {
		this.servicio = servicio;
	}
	
	@RequestMapping(value="/dashboard", method=RequestMethod.GET)
	public String dashboard(Model model) {
		
		List<Usuario> usuarios = servicio.get_all();
		
		model.addAttribute("usuarios", usuarios);
		
		return "dashboard.jsp";
	}
	
	@RequestMapping(value="/new", method=RequestMethod.GET)
	public String register(@ModelAttribute("usuario") Usuario usuario, Model model) {
		
		List<Salon> lista_salones = servicio.get_salones();
		
		model.addAttribute("salones", lista_salones);
		
		return "registro.jsp";
	}
	
	@PostMapping("/create")
	//@RequestMapping(value="/new", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("usuario") Usuario usuario,
						 BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			
			List<Salon> lista_salones = servicio.get_salones();
			
			model.addAttribute("salones", lista_salones);
			
			return "registro.jsp";
		} else {
			
			System.out.println(usuario.getFirst_name());
			servicio.save_user(usuario);
			return "redirect:/dashboard";
		}
		
	}
	
	@DeleteMapping("/delete/{id}")
	//@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
	public String eliminaUsuario(@PathVariable("id") Long id) {
		servicio.delete_user(id);
		return "redirect:/dashboard";
	}
	
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping(value="/muestraUsuario", method=RequestMethod.GET)
	public String muestraUsuario(Model model) {
		
		/*Usuario user1 = new Usuario("Cynthia", "Castillo", 1);
		Usuario user2 = new Usuario("Valeria", "Romero", 2);*/
		
		model.addAttribute("titulo", "Usuarios");
		
		//ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
		
		/*listaUsuarios.add(user1);
		listaUsuarios.add(user2);*/
		
		//model.addAttribute("listaUsuarios", listaUsuarios);
		
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
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login() {
		return "login.jsp";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@RequestParam(value="email") String email,
						@RequestParam(value="password") String password,
						HttpSession session,
						RedirectAttributes flash) {
		
		List<String> mensajes_error = new ArrayList<String>();
		boolean isValid = true;
		
		if(email.equals("")) {
			mensajes_error.add("Ingrese su correo");
			isValid = false;
		}
		
		if(password.equals("")) {
			mensajes_error.add("Ingrese su password");
			isValid = false;
		}
		
		if(isValid) {
			Usuario usuarioEncontrado = servicio.check_email_password(email, password);
			if(usuarioEncontrado == null) {
				mensajes_error.add("Credenciales incorrectas");
				flash.addFlashAttribute("error_login", mensajes_error);
				return "redirect:/login";
				
			}else {
				session.setAttribute("nombre", usuarioEncontrado.getFirst_name());
				return "redirect:/dashboard";
			}
		} else {
			flash.addFlashAttribute("error_login", mensajes_error);
			return "redirect:/login";
		}
		
	}
	
	/*
	 * @RequestMapping(value="/show/{id}", method=RequestMethod.GET)
	 * @RequestMapping("/show/{id}")
	 * */
	@GetMapping("/show/{id_url}")
	public String show(@PathVariable("id_url") Long id, Model model) {
		Usuario usuario_show = servicio.find_user(id);
		model.addAttribute("usuario", usuario_show);
		return "show.jsp";
	}
	
	
}
