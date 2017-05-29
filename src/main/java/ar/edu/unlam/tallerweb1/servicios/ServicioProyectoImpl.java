package ar.edu.unlam.tallerweb1.servicios;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.ProyectoDao;
import ar.edu.unlam.tallerweb1.modelo.Proyecto;;


@Service("servicioProyecto")
@Transactional
public class ServicioProyectoImpl implements ServicioProyecto {

	@Inject
	private ProyectoDao servicioProyectoDao;

	@Override
	public Proyecto consultarProyecto(Proyecto proyecto) {
		return servicioProyectoDao.consultarProyecto(proyecto) ;
	}

}
