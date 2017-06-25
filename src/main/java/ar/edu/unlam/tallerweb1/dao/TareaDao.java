package ar.edu.unlam.tallerweb1.dao;

import java.util.List;


import ar.edu.unlam.tallerweb1.modelo.Tarea;


public interface TareaDao {
	
	public List<Tarea> listarTareas();	
	
	List<Tarea> obtenerTodosTarea();

	Tarea consultarTarea(Tarea tarea);

	void save(Tarea Tarea);

	Tarea consultarTareaPorID(Integer idTarea);

}
