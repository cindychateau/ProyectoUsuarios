package com.codingdojo.cynthia.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.cynthia.modelos.Direccion;
import com.codingdojo.cynthia.modelos.Salon;
import com.codingdojo.cynthia.modelos.Usuario;
import com.codingdojo.cynthia.repositorios.RepositorioDirecciones;
import com.codingdojo.cynthia.repositorios.RepositorioSalones;
import com.codingdojo.cynthia.repositorios.RepositorioUsuarios;

@Service
public class ServicioUsuarios {
	
	//Depende del repositorio
	private final RepositorioUsuarios repositorio;
	private final RepositorioDirecciones repositorio_dir;
	private final RepositorioSalones repositorio_sal;
	
	public ServicioUsuarios(RepositorioUsuarios repositorio, 
							RepositorioDirecciones repositorio_dir,
							RepositorioSalones repositorio_sal) {
		this.repositorio = repositorio;
		this.repositorio_dir = repositorio_dir;
		this.repositorio_sal = repositorio_sal;
	}
	
	public List<Usuario> get_all() {
		return repositorio.findAll();
	}
	
	public Usuario find_user(Long id) {
		Optional<Usuario> optionalUser = repositorio.findById(id);
		if(optionalUser.isPresent()) {
			return optionalUser.get();
		} else {
			return null;
		}
	}
	
	public Usuario save_user(Usuario nuevoUsuario) {
		return repositorio.save(nuevoUsuario);
	}
	
	public void delete_user(Long id) {
		repositorio.deleteById(id);
	}
	
	public Usuario check_email_password(String email, String password) {
		List<Usuario> usuarioEncontrado = repositorio.findByEmailAndPassword(email, password);
		if(usuarioEncontrado.isEmpty()) {
			return null;
		} else {
			return usuarioEncontrado.get(0);
		}
	}
	
	public List<Usuario> get_users_no_address(){
		return repositorio.findByDireccionIdIsNull();
	}
	
	public Direccion save_direccion(Direccion nuevaDireccion) {
		return repositorio_dir.save(nuevaDireccion);
	}
	
	public List<Salon> get_salones(){
		return repositorio_sal.findAll();
	}
	
	public Salon find_salon(Long id) {
		Optional<Salon> optionalSalon = repositorio_sal.findById(id);
		if(optionalSalon.isPresent()) {
			return optionalSalon.get();
		} else {
			return null;
		}
	}
	
}
