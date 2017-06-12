package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Proyecto;


public interface ServicioProyecto {

	Proyecto consultarProyecto(Proyecto proyecto);

	void grabarProyecto(Proyecto proyecto);

	Proyecto consultarProyectoPorID(Integer idProyecto);

	List<Proyecto> obtenerTodos();
}
