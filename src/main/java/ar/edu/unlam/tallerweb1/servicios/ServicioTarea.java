package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Proyecto;
import ar.edu.unlam.tallerweb1.modelo.Tarea;

public interface ServicioTarea {

	Tarea consultarTarea(Tarea tarea);

	void grabarTarea(Tarea tarea);

	Tarea consultarTareaPorID(Integer idTarea);

	List<Tarea> obtenerTodos();

	void editarTarea(Tarea tarea);

	List<Tarea> consultarTareaPorProyecto(Proyecto proyecto);
	
}
