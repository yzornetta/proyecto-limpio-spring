package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Proyecto;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Service("usuarioDao")
public class UsuarioDaoImpl implements UsuarioDao {

	@Inject
    private SessionFactory sessionFactory;

	@Override
	public Usuario consultarUsuario(Usuario usuario) {

		final Session session = sessionFactory.getCurrentSession();
		return (Usuario) session.createCriteria(Usuario.class)
				.add(Restrictions.eq("email", usuario.getEmail()))
				.add(Restrictions.eq("password", usuario.getPassword()))
				.uniqueResult();
				//Get
				//session.get("tabla",id); Busca de esta tabla este id y devolvelo
	}
	
	@Override
	public Usuario findUserByEmail(String email) {
		final Session session = sessionFactory.openSession();
		return (Usuario) session.createCriteria(Usuario.class)
				.add(Restrictions.eq("email", email))
				.uniqueResult();
	}

	@Override
	public void save(Usuario user) {
		
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(user);
	}
	
	@Override
	public List<Usuario> obtenerTodos() {
		List <Usuario> usuarios = sessionFactory.openSession().createCriteria(Usuario.class).list();
		return usuarios;
	}

}
