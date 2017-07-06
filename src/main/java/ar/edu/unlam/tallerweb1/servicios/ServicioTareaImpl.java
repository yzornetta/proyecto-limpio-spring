package ar.edu.unlam.tallerweb1.servicios;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.TareaDao;
import ar.edu.unlam.tallerweb1.modelo.Proyecto;
import ar.edu.unlam.tallerweb1.modelo.Tarea;

@Service("servicioTarea")
@Transactional
public class ServicioTareaImpl implements ServicioTarea {
	
	@Inject
	private TareaDao servicioTareaDao;
	
	
	//@Autowired
	//TareaDao tareaDao;
	
	@Override
	public Tarea consultarTarea(Tarea tarea) {
		return servicioTareaDao.consultarTarea(tarea);
	}

	@Override
	@Transactional
	public void grabarTarea(Tarea tarea) {
		
		switch (tarea.getEstado()) {
		 
        case "En proceso":
	        tarea.setEstadoOrdenar(1); 
	        break;
 
        case "No iniciada":
        	tarea.setEstadoOrdenar(2); 
	        break;

        case "Finalizada":
	        tarea.setEstadoOrdenar(3); 
	        break;
		}
		
		servicioTareaDao.save(tarea);
	}
	
	@Override
	@Transactional
	public void editarTarea(Tarea tarea) {
		
		switch (tarea.getEstado()) {
		 
        case "En proceso":
	        tarea.setEstadoOrdenar(1); 
	        tarea.setFechaFinalizacion(null);
	        break;
 
        case "No iniciada":
        	tarea.setEstadoOrdenar(2); 
        	tarea.setFechaFinalizacion(null);
	        break;

        case "Finalizada":
	        tarea.setEstadoOrdenar(3);
	        
	        SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd");
	        
	        tarea.setFechaFinalizacion(dt1.format(new Date()));
	        break;
		}		
		
		servicioTareaDao.edit(tarea);
	}	

	@Override
	public Tarea consultarTareaPorID(Integer idTarea) {
		return servicioTareaDao.consultarTareaPorID(idTarea);
	}
	
	@Override
	public List<Tarea> consultarTareaPorProyecto(Proyecto proyecto) {
		return servicioTareaDao.consultarTareaPorProyecto(proyecto);
	}
	

	@Override
	public List<Tarea> obtenerTodos() {
		return servicioTareaDao.obtenerTodas();
	}

	@Override
	public void eliminarTarea(Tarea tarea) {
		servicioTareaDao.eliminarTarea(tarea);
		
	}

}
