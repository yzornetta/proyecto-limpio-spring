package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.TareaDao;
import ar.edu.unlam.tallerweb1.modelo.Tarea;

@Service("servicioTarea")
@Transactional
public class ServicioTareaImpl implements ServicioTarea {
	
	@Inject
	private TareaDao servicioTareaDao;
	
	
	//@Autowired
	//TareaDao tareaDao;
	
	@Override
	public List<Tarea> listarTareas() {
		return servicioTareaDao.listarTareas();
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
