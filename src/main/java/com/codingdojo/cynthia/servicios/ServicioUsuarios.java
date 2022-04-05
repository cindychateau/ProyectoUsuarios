package com.codingdojo.cynthia.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.cynthia.modelos.Usuario;
import com.codingdojo.cynthia.repositorios.RepositorioUsuarios;

@Service
public class ServicioUsuarios {
	
	//Depende del repositorio
	private final RepositorioUsuarios repositorio;
	
	public ServicioUsuarios(RepositorioUsuarios repositorio) {
		this.repositorio = repositorio;
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
	
}
