package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.unlam.tallerweb1.dao.TareaDao;
import ar.edu.unlam.tallerweb1.modelo.Tarea;

public class ServicioTareaImpl implements ServicioTarea {
	
	@Inject
	private TareaDao servicioTareaDao;
	
	@Autowired
	TareaDao tareaDao;
	
	@Override
	public List<Tarea> listarTareas() {
		return tareaDao.listarTareas();
	}
	
	
	@Override
	public List<Tarea> obtenerTodosTarea() {
		return servicioTareaDao.obtenerTodosTarea();
	}


	@Override
	public void grabarTarea(Tarea tarea) {
		// TODO Auto-generated method stub
		
	}

}
