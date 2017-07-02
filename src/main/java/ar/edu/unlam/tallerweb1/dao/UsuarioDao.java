package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface UsuarioDao {
	
	Usuario consultarUsuario (Usuario usuario);
	
    void save(Usuario user);
	
	Usuario findUserByEmail(String email);

	List<Usuario> obtenerTodos();
	
	Usuario modificarUsuario(Usuario usuario);
	
	Usuario findUserById(int id);
}
