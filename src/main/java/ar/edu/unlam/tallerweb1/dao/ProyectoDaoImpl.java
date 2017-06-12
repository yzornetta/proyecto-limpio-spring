package ar.edu.unlam.tallerweb1.dao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Proyecto;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

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

	@Override
	public void save(Proyecto proyecto) {
		
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(proyecto);
	}

	@Override
	public Proyecto consultarProyectoPorID(Integer idProyecto) {
		final Session session = sessionFactory.openSession();
		return (Proyecto) session.createCriteria(Proyecto.class)
				.add(Restrictions.eq("id", idProyecto))
				.uniqueResult();
	}

	@Override
	public List<Proyecto> obtenerTodos() {
		List <Proyecto> proyectos = sessionFactory.openSession().createCriteria(Proyecto.class).list();
		return proyectos;
	}
}
