package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.UsuarioDao;
import ar.edu.unlam.tallerweb1.modelo.Proyecto;
import ar.edu.unlam.tallerweb1.modelo.Usuario;


@Service("servicioLogin")
@Transactional
public class ServicioLoginImpl implements ServicioLogin {

	@Inject
	private UsuarioDao servicioLoginDao;

	@Override
	public Usuario consultarUsuario (Usuario usuario) {
		return servicioLoginDao.consultarUsuario(usuario);
	}
	
	@Override
	@Transactional
	public void grabarUsuario(Usuario user) {
		
		servicioLoginDao.save(user);
		
	}

	@Override
	public Usuario findUserByEmail(String email) {
		return servicioLoginDao.findUserByEmail(email);
	}

	@Override
	public List<Usuario> obtenerTodos() {
		return servicioLoginDao.obtenerTodos();
	}

	@Override
	public Usuario modificarUsuario(Usuario usuario) {
		return servicioLoginDao.modificarUsuario(usuario);
	}

	@Override
	public Usuario findUserById(int id) {
	
		return servicioLoginDao.findUserById(id);
	}

	
	
}
