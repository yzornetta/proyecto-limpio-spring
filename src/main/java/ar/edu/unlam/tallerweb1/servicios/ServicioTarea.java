package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Tarea;

public interface ServicioTarea {
	
	public List<Tarea> listarTareas();
	
	List<Tarea> obtenerTodosTarea();

	public void grabarTarea(Tarea tarea);
		

}
