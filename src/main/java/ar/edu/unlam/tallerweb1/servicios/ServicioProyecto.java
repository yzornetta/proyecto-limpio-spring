package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;

import ar.edu.unlam.tallerweb1.modelo.Proyecto;


public interface ServicioProyecto {

	Proyecto consultarProyecto(Proyecto proyecto);

	Proyecto consultarProyectoPorID(ArrayList<Proyecto> lista, Integer proyectoId);
}
