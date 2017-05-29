package ar.edu.unlam.tallerweb1.dao;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Proyecto;

@Service("proyectoDao")
public class ProyectoDaoImpl implements ProyectoDao {

	@Inject
    private SessionFactory sessionFactory;
	
	@Override
	public Proyecto consultarProyecto(Proyecto proyecto) {
		final Session session = sessionFactory.openSession();
		return (Proyecto) session.createCriteria(Proyecto.class)
				.add(Restrictions.eq("descripcion", proyecto.getDescripcion()))
				.uniqueResult();
	}

}
