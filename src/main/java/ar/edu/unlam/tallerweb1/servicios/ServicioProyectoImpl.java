package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.ProyectoDao;
import ar.edu.unlam.tallerweb1.modelo.Proyecto;
import ar.edu.unlam.tallerweb1.modelo.Tarea;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.UsuarioProyecto;

@Service("servicioProyecto")
@Transactional
public class ServicioProyectoImpl implements ServicioProyecto {

	@Inject
	private ProyectoDao servicioProyectoDao;

	@Override
	public Proyecto consultarProyecto(Proyecto proyecto) {
		return servicioProyectoDao.consultarProyecto(proyecto);
	}

	@Override
	@Transactional
	public void grabarProyecto(Proyecto proyecto) {
		servicioProyectoDao.save(proyecto);
	}

	@Override
	@Transactional
	public void editarProyecto(Proyecto proyecto) {
		servicioProyectoDao.edit(proyecto);
	}		
	
	/*
	@Override
	public Proyecto consultarProyectoPorID(ArrayList<Proyecto> listaProyectos, Integer idProyecto) {
		Integer idActual;

		// TODO Esto lo debería hacer el DAO cuando exista algo en la base
		// El servicio solo va a ser el pasamano de los datos entre el DAO y el
		// controller
		Proyecto p = new Proyecto();
		
		for (Proyecto temp : listaProyectos) {
			idActual = temp.getId();
			if (idActual.equals(idActual)) {
				p = temp;
			}
		}

		return p;
	}*/
	
	@Override
	public Proyecto consultarProyectoPorID(Integer idProyecto) {

		return servicioProyectoDao.consultarProyectoPorID(idProyecto);
		
	}

	@Override
	public List<Proyecto> obtenerTodos() {
		return servicioProyectoDao.obtenerTodos();
	}

	@Override
	public void asignarUsuarioProyecto(UsuarioProyecto usuarioProyecto) {
		servicioProyectoDao.saveUsuarioProyecto(usuarioProyecto);
		
	}

	@Override
	public List<UsuarioProyecto> consultarUsuariosProyecto(Proyecto proyecto) {
		return servicioProyectoDao.consultarUsuariosProyecto(proyecto);

	}

	@Override
	public UsuarioProyecto consultarSiExisteProyectoUsuario(Proyecto proyecto, Usuario usuario) {
		return servicioProyectoDao.consultarSiExisteProyectoUsuario(proyecto, usuario);
	}

}
