package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;

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

	@Override
	public Proyecto consultarProyectoPorID(ArrayList<Proyecto> listaProyectos, Integer idProyecto) {
		Integer idActual;		

		//TODO Esto lo deber�a hacer el DAO cuando exista algo en la base
		//El servicio solo va a ser el pasamano de los datos entre el DAO y el controller
		Proyecto p = new Proyecto();		
		p.setId(idProyecto);		

		for (Proyecto temp : listaProyectos) {
			idActual = temp.getId();
			if (idActual.equals(idActual))	{
				//p.setId(temp.getId());
				p.setDescripcion(temp.getDescripcion());
			}
		}
		
		return p;
	}

}
