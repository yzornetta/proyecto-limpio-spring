package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Proyecto;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.UsuarioProyecto;


public interface ServicioProyecto {

	Proyecto consultarProyecto(Proyecto proyecto);

	void grabarProyecto(Proyecto proyecto);

	Proyecto consultarProyectoPorID(Integer idProyecto);

	List<Proyecto> obtenerTodos();

	void editarProyecto(Proyecto proyecto);

	void asignarUsuarioProyecto(UsuarioProyecto usuarioProyecto);
	
	List<UsuarioProyecto> consultarUsuariosProyecto(Proyecto proyecto);

	UsuarioProyecto consultarSiExisteProyectoUsuario(Proyecto proyecto, Usuario usuario);

	UsuarioProyecto consultarUsuariosProyectoPorId(Integer idUsuarioProyecto);

	void eliminarUsuarioProyecto(UsuarioProyecto usuarioProyecto);

	List<UsuarioProyecto> obtenerTodosPorUsuario(Usuario usuario);
	
}
