package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Tarea;
import ar.edu.unlam.tallerweb1.servicios.ServicioTarea;

@Controller
public class ControladorTareas {
ArrayList<Tarea> lista = new ArrayList<Tarea>();

@Inject
private ServicioTarea ServicioTarea;
private Random random = new Random();
private List<Tarea> listarTareas;
	

//ARMA EL FORM DE ALTA DE TAREA
	@RequestMapping(value="Tareas/altaTarea",  method = RequestMethod.GET)
	public ModelAndView vistaRegistrarTarea(Model modelo) {
		ModelAndView altaTarea = new ModelAndView();
		modelo.addAttribute("classAltaTarea", new Tarea());
		altaTarea.setViewName("Tareas/altaTarea");
		return altaTarea;
	}

	//ACCION DEL BOTON GRABAR - ALTA TAREA
		@RequestMapping(value="Tareas/agregarTarea",  method = RequestMethod.POST)
		public ModelAndView agregarTareas(@ModelAttribute("Tarea") Tarea tarea) {
			ServicioTarea.grabarTarea(tarea);
			return new ModelAndView("redirect:/Tareas/listarTareas");

		}	

		//LISTAR TAREAS
		@RequestMapping(value="Tareas/listarTareas",  method = RequestMethod.GET)
		public ModelAndView listarTareas()
		{
			listarTareas = ServicioTarea.obtenerTodosTarea();
			return new ModelAndView("Tareas/listarTareas","command", listarTareas);//devuelve vista exito
		}
		
		
		
		

}
