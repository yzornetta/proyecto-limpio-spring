package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.unlam.tallerweb1.dao.TareaDao;
import ar.edu.unlam.tallerweb1.modelo.Tarea;

public class ServicioTareaImpl implements ServicioTarea {
	
	@Autowired
	TareaDao tareaDao;
	
	@Override
	public List<Tarea> listarTareas() {
		return tareaDao.listarTareas();
	}
	

}
