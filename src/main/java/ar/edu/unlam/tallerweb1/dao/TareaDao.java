package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Proyecto;
import ar.edu.unlam.tallerweb1.modelo.Tarea;
import ar.edu.unlam.tallerweb1.modelo.Usuario;


public interface TareaDao {

	Tarea consultarTarea(Tarea tarea);

	void save(Tarea tarea);

	Tarea consultarTareaPorID(Integer idTarea);

	List<Tarea> obtenerTodas();

	void edit(Tarea tarea);

	List<Tarea> consultarTareaPorProyecto(Proyecto proyecto);

	void eliminarTarea(Tarea tarea);

	List<Tarea> consultarTareaPorUsuarioAsignado(Usuario usuario);
	

}
