package ar.edu.unlam.tallerweb1.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Tarea;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Service("tareaDao")
public class TareaDaoImpl implements TareaDao {
	
	@Inject
    private SessionFactory sessionFactory;
	
	@Override
	public Tarea consultarTarea(Tarea tarea) {
		final Session session = sessionFactory.openSession();
		return (Tarea) session.createCriteria(Tarea.class)
				.add(Restrictions.eq("descripcion", tarea.getDescripcion()))
				.uniqueResult();
	}

	@Override
	public void save(Tarea tarea) {
		
		Session session = this.sessionFactory.getCurrentSession();
			
		session.persist(tarea);
	}
	
	@Override
	public void edit(Tarea tarea) {
		
		Session session = this.sessionFactory.getCurrentSession();
		//session.flush();

		session.update(tarea);
	}

	@Override
	public Tarea consultarTareaPorID(Integer idTarea) {
		final Session session = sessionFactory.openSession();
		return (Tarea) session.createCriteria(Tarea.class)
				.add(Restrictions.eq("id", idTarea))
				.uniqueResult();
	}

	@Override
	public List<Tarea> obtenerTodas() {
		List <Tarea> Tareas = sessionFactory.openSession().createCriteria(Tarea.class).list();
		return Tareas;
	}
	

}