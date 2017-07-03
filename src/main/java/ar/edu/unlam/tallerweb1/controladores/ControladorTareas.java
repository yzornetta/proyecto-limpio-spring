package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.inject.Inject;
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

		
	//ARMA EL FORM DE ALTA DE TAREA
	@RequestMapping(value="tarea/altaTarea",  method = RequestMethod.GET)
	public ModelAndView vistaRegistrar(Model modelo) {
		//ModelAndView altaTarea = new ModelAndView();
		modelo.addAttribute("tarea", new Tarea());	
		
		//listaUsuarios = servicioLogin.obtenerTodos();		
		return new ModelAndView("tarea/altaTarea");
	}
	

	//ARMA EL FORM DE EDIT DE TAREA
	@RequestMapping(value="tarea/editarTarea")
	public ModelAndView editarTarea(@RequestParam("id") Integer idTarea) {
		
		Tarea tareaElegida = servicioTarea.consultarTareaPorID(idTarea);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("tarea/editarTarea");
		modelAndView.addObject("tarea", tareaElegida);
		
		return modelAndView;
	}
		
	
	//ACCION DEL BOTON GRABAR - ALTA DE TAREA
	@RequestMapping(value="tarea/agregarTarea",  method = RequestMethod.POST)
	public ModelAndView agregarTarea(@ModelAttribute("tarea") Tarea tarea) {
		
		//Prueba
		
		Usuario u = new Usuario();
		u.setEmail("elias@gmail.com");
		u.setPassword("pass");
		
		tarea.setUsuario(servicioLogin.consultarUsuario(u));
		
		Proyecto p = new Proyecto();
		p = servicioProyecto.consultarProyectoPorID(8);
		tarea.setProyecto(p);
		//Prueba
		
		
		servicioTarea.grabarTarea(tarea);
		return new ModelAndView("redirect:/tarea/listarTareas");

		//return new ModelAndView("listarTareas");
	}	

	
	//ACCION DEL BOTON GRABAR - EDITAR TAREA
	@RequestMapping(value="tarea/editarTarea",  method = RequestMethod.POST)
	public ModelAndView editarTarea(@ModelAttribute("tarea") Tarea tarea) {
		servicioTarea.editarTarea(tarea);
		return new ModelAndView("redirect:/tarea/listarTareas");

		//return new ModelAndView("listarTareas");
	}	
	
	//LISTAR TODOS LOS PROYECTOS
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
		//Id seleccionado
		//Integer idTarea = tarea.getId();
				
		//Servicio devuelve Objeto en base al id enviado
		//Cuando haya base la lista no va, porque se busca sobre la base directamente
		Tarea tareaElegida = servicioTarea.consultarTareaPorID(idTarea);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("tarea/listarTarea");
		modelAndView.addObject("tarea", tareaElegida);
		return modelAndView;
		
	}
}
