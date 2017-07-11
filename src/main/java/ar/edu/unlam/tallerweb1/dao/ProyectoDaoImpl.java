package ar.edu.unlam.tallerweb1.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Proyecto;
import ar.edu.unlam.tallerweb1.modelo.Tarea;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.UsuarioProyecto;

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
		
		//Date date = new Date();
		//proyecto.setFechaAlta(date);
		
		session.persist(proyecto);
	}
	
	@Override
	public void edit(Proyecto proyecto) {
		
		Session session = this.sessionFactory.getCurrentSession();
		//session.flush();

		session.update(proyecto);
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

	@Override
	public void saveUsuarioProyecto(UsuarioProyecto usuarioProyecto) {
		Session session = this.sessionFactory.getCurrentSession();		
		session.persist(usuarioProyecto);
	}

	@Override
	public List<UsuarioProyecto> consultarUsuariosProyecto(Proyecto proyecto) {
		final Session session = sessionFactory.openSession();
		List<UsuarioProyecto> listaUsuarioProyecto;
		listaUsuarioProyecto = session.createCriteria(UsuarioProyecto.class)
				.add(Restrictions.eq("proyecto", proyecto)).list();
		
		return listaUsuarioProyecto;
	}

	@Override
	public UsuarioProyecto consultarSiExisteProyectoUsuario(Proyecto proyecto, Usuario usuario) {
		final Session session = sessionFactory.openSession();
		return (UsuarioProyecto) session.createCriteria(UsuarioProyecto.class)
				.add(Restrictions.eq("proyecto", proyecto))
				.add(Restrictions.eq("usuario", usuario))				
				.uniqueResult();
	}


	@Override
	public UsuarioProyecto consultarUsuariosProyectoPorId(Integer idUsuarioProyecto) {
		Session session = this.sessionFactory.getCurrentSession();
		return (UsuarioProyecto) session.createCriteria(UsuarioProyecto.class)
				.add(Restrictions.eq("id", idUsuarioProyecto))
				.uniqueResult();	
	}

	@Override
	public void eliminarUsuarioProyecto(UsuarioProyecto usuarioProyecto) {
		Session session = this.sessionFactory.getCurrentSession();

		session.delete(usuarioProyecto);		
	}

	@Override
	public List<UsuarioProyecto> obtenerTodosPorUsuario(Usuario usuario) {
		final Session session = sessionFactory.openSession();
		List<UsuarioProyecto> listaUsuarioProyecto;
		
		listaUsuarioProyecto = session.createCriteria(UsuarioProyecto.class)
				.add(Restrictions.eq("usuario", usuario)).list();
		
		return listaUsuarioProyecto;
	}
}
