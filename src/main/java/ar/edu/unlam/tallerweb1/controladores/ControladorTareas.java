package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.inject.Inject;
import javax.persistence.Convert;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Persona;
import ar.edu.unlam.tallerweb1.modelo.Proyecto;
import ar.edu.unlam.tallerweb1.modelo.Tarea;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioProyecto;
import ar.edu.unlam.tallerweb1.servicios.ServicioTarea;

@Controller
@SessionAttributes("usuarioLogueado")
public class ControladorTareas {

	@Inject
	private ServicioTarea servicioTarea;
	
	@Inject
	private ServicioLogin servicioLogin;	

	@Inject
	private ServicioProyecto servicioProyecto;	

	private List<Tarea> listaTareas;
	private List<Usuario> listaUsuarios;
	private List<Proyecto> listaProyectos;

		
	//ARMA EL FORM DE ALTA DE TAREA
	@RequestMapping(value="tarea/altaTarea",  method = RequestMethod.GET)
	public ModelAndView vistaRegistrar(Model modelo) {
		
		modelo.addAttribute("tarea", new Tarea());		
		
		listaProyectos = servicioProyecto.obtenerTodos();		
		modelo.addAttribute("proyectos", listaProyectos);
		
		listaUsuarios = servicioLogin.obtenerTodos();
		modelo.addAttribute("usuarios", listaUsuarios);
		
		return new ModelAndView("tarea/altaTarea");
	}
		
	
	//ACCION DEL BOTON GRABAR - ALTA DE TAREA
	@RequestMapping(value="tarea/agregarTarea",  method = RequestMethod.POST)
	public ModelAndView agregarTarea(@ModelAttribute("tarea") Tarea tarea) {

		//Guardo proyecto asignado
		tarea.setProyecto(servicioProyecto.consultarProyectoPorID(tarea.getProyectoId()));

		//Guardo usuario asignado
		tarea.setUsuario(servicioLogin.findUserById(tarea.getUsuarioId()));
			
		servicioTarea.grabarTarea(tarea);
		return new ModelAndView("redirect:/tarea/listarTareas");

	}	

	
	//ARMA EL FORM DE EDIT DE TAREA
	@RequestMapping(value="tarea/editarTarea")
	public ModelAndView editarTarea(@RequestParam("id") Integer idTarea) {
		
		Tarea tareaElegida = servicioTarea.consultarTareaPorID(idTarea);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("tarea/editarTarea");
		modelAndView.addObject("tarea", tareaElegida);
		
		
		listaProyectos = servicioProyecto.obtenerTodos();		
		modelAndView.addObject("proyectos", listaProyectos);
		
		listaUsuarios = servicioLogin.obtenerTodos();
		modelAndView.addObject("usuarios", listaUsuarios);		
		
		return modelAndView;
	}	
	
	//ACCION DEL BOTON GRABAR - EDITAR TAREA
	@RequestMapping(value="tarea/editarTarea",  method = RequestMethod.POST)
	public ModelAndView editarTarea(@ModelAttribute("tarea") Tarea tarea) {
		
		
		//Guardo proyecto asignado
		tarea.setProyecto(servicioProyecto.consultarProyectoPorID(tarea.getProyectoId()));

		//Guardo usuario asignado
		tarea.setUsuario(servicioLogin.findUserById(tarea.getUsuarioId()));
		
		servicioTarea.editarTarea(tarea);
		return new ModelAndView("redirect:/tarea/listarTareas");

		//return new ModelAndView("listarTareas");
	}	
	
	//LISTAR TODAS LAS TAREAS
	@RequestMapping(value="tarea/listarTareas",  method = RequestMethod.GET)
	public ModelAndView listarTareas()
	{
		listaTareas = servicioTarea.obtenerTodos();
				
		return new ModelAndView("tarea/listarTareas","command", listaTareas);
	}
	
	//Tareas de un proyecto especifico
	@RequestMapping("tarea/listarTareasPorProyecto")
	public ModelAndView listarTareasPorProyecto(@RequestParam(value="idProyecto") Integer idProyecto){
		
		Proyecto proyecto = servicioProyecto.consultarProyectoPorID(idProyecto);
		listaTareas = servicioTarea.consultarTareaPorProyecto(proyecto);
		return new ModelAndView("tarea/listarTareas","command", listaTareas);
	}	
	
	//VER DETALLE DE LA TAREA
	@RequestMapping(value="tarea/listarTarea")
	//public ModelAndView IrATarea(@ModelAttribute Tarea tarea)
	public ModelAndView IrATarea(@RequestParam("id") Integer idTarea)
	{
		Tarea tareaElegida = servicioTarea.consultarTareaPorID(idTarea);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("tarea/listarTarea");
		modelAndView.addObject("tarea", tareaElegida);
		return modelAndView;
	}
	
	//Cambia estado de tarea hacia adelante
	//Tareas de un proyecto especifico
	@RequestMapping("tarea/cambiarEstadoAdelante")
	public ModelAndView cambiarEstadoAdelante(@RequestParam(value="idTarea") Integer idTarea){
		
		Tarea tarea = servicioTarea.consultarTareaPorID(idTarea);
		
		String estado = tarea.getEstado();
		
		if (estado == "No iniciada") {
			tarea.setEstado("En proceso");
		}
		else {
			tarea.setEstado("Finalizada");
		}
		
		servicioTarea.editarTarea(tarea);
		return new ModelAndView("redirect:/tarea/listarTareas");
	}	
	
	//Cambia estado de tarea hacia atrás
	@RequestMapping("tarea/cambiarEstadoAtras")
	public ModelAndView cambiarEstadoAtras(@RequestParam(value="idTarea") Integer idTarea){
		
		Tarea tarea = servicioTarea.consultarTareaPorID(idTarea);
		
		String estado = tarea.getEstado();
		
		if (estado == "Finalizada") {
			tarea.setEstado("En proceso");
		}
		else {
			tarea.setEstado("No iniciada");
		}
		
		servicioTarea.editarTarea(tarea);
		return new ModelAndView("redirect:/tarea/listarTareas");
	}
	
	
}
