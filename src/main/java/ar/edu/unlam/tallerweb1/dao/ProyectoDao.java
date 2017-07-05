package ar.edu.unlam.tallerweb1.dao;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Proyecto;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface ProyectoDao {
	
	Proyecto consultarProyecto (Proyecto proyecto);

	void save(Proyecto proyecto);

	Proyecto consultarProyectoPorID(Integer idProyecto);

	List<Proyecto> obtenerTodos();

	void edit(Proyecto proyecto);
}

