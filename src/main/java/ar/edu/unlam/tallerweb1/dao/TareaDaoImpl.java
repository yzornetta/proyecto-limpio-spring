package ar.edu.unlam.tallerweb1.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;


import ar.edu.unlam.tallerweb1.modelo.Tarea;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Service("TareaDao")
public class TareaDaoImpl implements TareaDao {
	
	@Inject
    private SessionFactory sessionFactory;
	
	@Override
	public Tarea consultarTarea(Tarea tarea) {
		final Session session = sessionFactory.openSession();
		return (Tarea) session.createCriteria(Tarea.class)
				.add(Restrictions.eq("descripcion", Tarea.getDescripcion()))
				.uniqueResult();
	}

	@Override
	public void save(Tarea Tarea) {
		
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(Tarea);
	}

	@Override
	public Tarea consultarTareaPorID(Integer idTarea) {
		final Session session = sessionFactory.openSession();
		return (Tarea) session.createCriteria(Tarea.class)
				.add(Restrictions.eq("id", idTarea))
				.uniqueResult();
	}

	@Override
	public List<Tarea> obtenerTodosTarea() {
		List <Tarea> proyectos = sessionFactory.openSession().createCriteria(Tarea.class).list();
		return proyectos;
	}

	@Override
	public List<Tarea> listarTareas() {
		// TODO Auto-generated method stub
		return null;
	}
	

}