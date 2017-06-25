package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface ServicioLogin {

	Usuario consultarUsuario(Usuario usuario);
	
	void grabarUsuario(Usuario user);
	
	Usuario findUserByEmail(String email);

	List<Usuario> obtenerTodos();
	
}
