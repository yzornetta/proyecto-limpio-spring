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
import ar.edu.unlam.tallerweb1.modelo.UsuarioProyecto;
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

	
	//////////////////////// INICIO ALTA DE TAREAS ////////////////////////
		
	//ARMA EL FORM DE ALTA DE TAREA
	@RequestMapping(value="tarea/altaTarea",  method = RequestMethod.GET)
	public ModelAndView altaTarea(Model modelo) {
		
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
	
	//////////////////////// FIN ALTA DE TAREAS ////////////////////////
	
	
	////////////////////////INICIO EDITAR TAREAS ////////////////////////
	
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
		
		//DEBUG
		System.out.println(tareaElegida.getFechaFinalizacion());	
		
		
		return modelAndView;
	}	
	
	//ACCION DEL BOTON GRABAR - EDITAR TAREA
	@RequestMapping(value="tarea/editarTarea",  method = RequestMethod.POST)
	public ModelAndView editarTarea(@ModelAttribute("tarea") Tarea tarea) {
					
		System.out.println(tarea.getFechaFinalizacion());
		
		//Guardo proyecto asignado
		tarea.setProyecto(servicioProyecto.consultarProyectoPorID(tarea.getProyectoId()));

		//Guardo usuario asignado
		tarea.setUsuario(servicioLogin.findUserById(tarea.getUsuarioId()));		

		servicioTarea.editarTarea(tarea);
		return new ModelAndView("redirect:/tarea/listarTareas");

	}	
	
	////////////////////////FIN EDITAR TAREAS ////////////////////////	
	
	////////////////////////INICIO LISTAR TAREAS ////////////////////////	
	
	//LISTAR TODAS LAS TAREAS
	@RequestMapping(value="tarea/listarTareas",  method = RequestMethod.GET)
	public ModelAndView listarTareas(HttpServletRequest request)
	{
		//listaTareas = servicioTarea.obtenerTodos();
		Usuario usuario = servicioLogin.findUserById((Integer) request.getSession().getAttribute("Id"));

		listaTareas = servicioTarea.consultarTareaPorUsuarioAsignado(usuario);		
		
		return new ModelAndView("tarea/listarTareas","command", listaTareas);
	}
	
	//LISTAR TAREAS FILTRADAS POR PROYECTO
	@RequestMapping("tarea/listarTareasPorProyecto")
	public ModelAndView listarTareasPorProyecto(@RequestParam(value="idProyecto") Integer idProyecto){
		
		Proyecto proyecto = servicioProyecto.consultarProyectoPorID(idProyecto);
		listaTareas = servicioTarea.consultarTareaPorProyecto(proyecto);
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("tarea/listarTareasPorProyecto");
		modelAndView.addObject("command", listaTareas);
		modelAndView.addObject("idProyecto", idProyecto);
		
		return modelAndView;
	}	

	////////////////////////FIN LISTAR TAREAS ////////////////////////	

	
	//ALTA DE TAREA PROYECTO ESPECIFICO
	@RequestMapping(value="tarea/altaTareaProyecto",  method = RequestMethod.GET)
	public ModelAndView altaTareaProyecto(@RequestParam(value="idProyecto") Integer idProyecto, Model modelo) {
		
		modelo.addAttribute("tarea", new Tarea());		
		
		Proyecto ProyectoSeleccionado = servicioProyecto.consultarProyectoPorID(idProyecto);

		modelo.addAttribute("ProyectoSeleccionado", ProyectoSeleccionado);		
		
		
		//listaUsuarios = servicioLogin.obtenerTodos();
		//modelo.addAttribute("usuarios", listaUsuarios);
		
		
		List<UsuarioProyecto> listaUsuariosProyecto;
		listaUsuariosProyecto =  servicioProyecto.consultarUsuariosProyecto(ProyectoSeleccionado);
		modelo.addAttribute("listaUsuariosProyecto", listaUsuariosProyecto);		
		
		
		return new ModelAndView("tarea/altaTareaProyecto");
	}	

	//ACCION DEL BOTON GRABAR - ALTA DE TAREA PROYECTO
	@RequestMapping(value="tarea/agregarTareaProyecto",  method = RequestMethod.POST)
	public ModelAndView altaTareaProyecto(@ModelAttribute("tarea") Tarea tarea) {

		//Guardo proyecto asignado
		tarea.setProyecto(servicioProyecto.consultarProyectoPorID(tarea.getProyectoId()));

		//Guardo usuario asignado
		tarea.setUsuario(servicioLogin.findUserById(tarea.getUsuarioId()));
			
		servicioTarea.grabarTarea(tarea);
		
		Integer idProyecto = tarea.getProyectoId();
		
		return new ModelAndView("redirect:/tarea/listarTareasPorProyecto?idProyecto="+idProyecto);

	}
		
	////////////////////////INICIO EDITAR TAREAS PROYECTO ////////////////////////
	
	//ARMA EL FORM DE EDIT DE TAREA
	@RequestMapping(value="tarea/editarTareaProyecto")
	public ModelAndView editarTareaProyecto(@RequestParam("id") Integer idTarea) {
		
		Tarea tareaElegida = servicioTarea.consultarTareaPorID(idTarea);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("tarea/editarTareaProyecto");
		modelAndView.addObject("tarea", tareaElegida);
		
		Proyecto ProyectoSeleccionado = servicioProyecto.consultarProyectoPorID(tareaElegida.getProyectoId());

		modelAndView.addObject("ProyectoSeleccionado", ProyectoSeleccionado);

		//listaProyectos = servicioProyecto.obtenerTodos();		
		//modelAndView.addObject("proyectos", listaProyectos);
		
		//listaUsuarios = servicioLogin.obtenerTodos();
		//modelAndView.addObject("usuarios", listaUsuarios);	
		
		List<UsuarioProyecto> listaUsuariosProyecto;
		listaUsuariosProyecto =  servicioProyecto.consultarUsuariosProyecto(ProyectoSeleccionado);
		modelAndView.addObject("listaUsuariosProyecto", listaUsuariosProyecto);		
		
		return modelAndView;
	}	
	
	//ACCION DEL BOTON GRABAR - EDITAR TAREA
	@RequestMapping(value="tarea/editarTareaProyecto",  method = RequestMethod.POST)
	public ModelAndView editarTareaProyecto(@ModelAttribute("tarea") Tarea tarea) {
						
		//Guardo proyecto asignado
		tarea.setProyecto(servicioProyecto.consultarProyectoPorID(tarea.getProyectoId()));

		//Guardo usuario asignado
		tarea.setUsuario(servicioLogin.findUserById(tarea.getUsuarioId()));		

		servicioTarea.editarTarea(tarea);
		return new ModelAndView("redirect:/tarea/listarTareasPorProyecto?idProyecto=" + tarea.getProyectoId());

	}	
	
	////////////////////////FIN EDITAR TAREAS PROYECTO ////////////////////////	
	
	////////////////////////CAMBIAR ESTADO DE TAREAS ////////////////////////
	@RequestMapping("tarea/cambiarEstadoAdelante")
	public ModelAndView cambiarEstadoAdelante(@RequestParam(value="idTarea") Integer idTarea){
		
		Tarea tarea = servicioTarea.consultarTareaPorID(idTarea);
		
		String estado = tarea.getEstado();
		
		if (estado.equals("No iniciada")) {
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
		
		if (estado.equals("Finalizada")) {
			tarea.setEstado("En proceso");
		}
		else {
			tarea.setEstado("No iniciada");
		}
		
		servicioTarea.editarTarea(tarea);
		return new ModelAndView("redirect:/tarea/listarTareas");
	}
	
	////////////////////////CAMBIAR ESTADO DE TAREAS POR PROYECTO ////////////////////////
	@RequestMapping("tarea/cambiarEstadoAdelanteProyecto")
	public ModelAndView cambiarEstadoAdelanteProyecto(@RequestParam(value="idTarea") Integer idTarea){
		
		Tarea tarea = servicioTarea.consultarTareaPorID(idTarea);
		
		String estado = tarea.getEstado();
		
		if (estado.equals("No iniciada")) {
			tarea.setEstado("En proceso");
		}
		else {
			tarea.setEstado("Finalizada");
		}	
		
		servicioTarea.editarTarea(tarea);
		return new ModelAndView("redirect:/tarea/listarTareasPorProyecto?idProyecto=" + tarea.getProyectoId());
	}	
	
	//Cambia estado de tarea hacia atrás
	@RequestMapping("tarea/cambiarEstadoAtrasProyecto")
	public ModelAndView cambiarEstadoAtrasProyecto(@RequestParam(value="idTarea") Integer idTarea){
		
		Tarea tarea = servicioTarea.consultarTareaPorID(idTarea);
		
		String estado = tarea.getEstado();
		
		if (estado.equals("Finalizada")) {
			tarea.setEstado("En proceso");
		}
		else {
			tarea.setEstado("No iniciada");
		}
		
		servicioTarea.editarTarea(tarea);
		return new ModelAndView("redirect:/tarea/listarTareasPorProyecto?idProyecto=" + tarea.getProyectoId());
	}


	//ELIMINAR TAREA
	@RequestMapping("tarea/eliminarTarea")
	public ModelAndView eliminarTarea(@RequestParam(value="id") Integer idTarea){
		
		Tarea tarea = servicioTarea.consultarTareaPorID(idTarea);		
		
		servicioTarea.eliminarTarea(tarea);
		
		return new ModelAndView("redirect:/tarea/listarTareas");
	}	

	//ELIMINAR TAREA PROYECTO
	@RequestMapping("tarea/eliminarTareaProyecto")
	public ModelAndView eliminarTareaProyecto(@RequestParam(value="id") Integer idTarea){
		
		Tarea tarea = servicioTarea.consultarTareaPorID(idTarea);		
		
		servicioTarea.eliminarTarea(tarea);
		
		return new ModelAndView("redirect:/tarea/listarTareasPorProyecto?idProyecto=" + tarea.getProyectoId());
	}	
}
