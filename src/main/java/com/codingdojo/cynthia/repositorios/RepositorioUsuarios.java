package com.codingdojo.cynthia.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.cynthia.modelos.Usuario;

@Repository
public interface RepositorioUsuarios extends CrudRepository<Usuario, Long>{
	
	List<Usuario> findAll(); //SELECT * FROM users
	List<Usuario> findByEmail(String email); //SELECT * FROM users WHERE email = '<EMAIL>'
	List<Usuario> findById(long id); //SELECT * FROM users WHERE id = <ID>
	
	//INSERT into users(first_name, last_name, password, email) VALUES (Datos de objeto Usuario)
	Usuario save(Usuario nuevoUsuario);
	
	void deleteById(Long id);
	
}
