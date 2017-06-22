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
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Persona;
import ar.edu.unlam.tallerweb1.modelo.Proyecto;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioProyecto;

@Controller
public class ControladorProyecto {

	@Inject
	private ServicioProyecto servicioProyecto;
	private Random random = new Random();
	private List<Proyecto> listaProyectos;
		
	//ARMA EL FORM DE ALTA DE PROYECTO
	@RequestMapping(value="proyecto/altaProyecto",  method = RequestMethod.GET)
	public ModelAndView vistaRegistrar(Model modelo) {
		ModelAndView altaProyecto = new ModelAndView();
		modelo.addAttribute("classAltaProyecto", new Proyecto());
		altaProyecto.setViewName("proyecto/altaProyecto");
		return altaProyecto;
	}
	

	//ACCION DEL BOTON GRABAR - ALTA DE PROYECTO
	@RequestMapping(value="proyecto/agregarProyecto",  method = RequestMethod.POST)
	public ModelAndView agregarProyecto(@ModelAttribute("proyecto") Proyecto proyecto) {
		servicioProyecto.grabarProyecto(proyecto);
		return new ModelAndView("redirect:/proyecto/listarProyectos");

		//return new ModelAndView("listarProyectos");
	}	

	//LISTAR TODOS LOS PROYECTOS
	@RequestMapping(value="proyecto/listarProyectos",  method = RequestMethod.GET)
	public ModelAndView listarProyectos()
	{
		listaProyectos = servicioProyecto.obtenerTodos();
		return new ModelAndView("proyecto/listarProyectos","command", listaProyectos);//devuelve vista exito
	}
	
	//LISTAR TODOS LOS PROYECTOS
	/*@RequestMapping(value="proyecto",  method = RequestMethod.GET)
	public ModelAndView proyectos()
	{
		listaProyectos = servicioProyecto.obtenerTodos();
		return new ModelAndView("proyecto/listarProyectos","command", listaProyectos);//devuelve vista exito
	}
	*/
	
	//VER DETALLE DE PROYECTO
	@RequestMapping(value="proyecto/listarProyecto")
	//public ModelAndView IrAProyecto(@ModelAttribute Proyecto proyecto)
	public ModelAndView IrAProyecto(@RequestParam("id") Integer idProyecto)
	{
		//Id seleccionado
		//Integer idProyecto = proyecto.getId();
				
		//Servicio devuelve Objeto en base al id enviado
		//Cuando haya base la lista no va, porque se busca sobre la base directamente
		Proyecto proyectoElegido = servicioProyecto.consultarProyectoPorID(idProyecto);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("proyecto/listarProyecto");
		modelAndView.addObject("proyecto", proyectoElegido);
		return modelAndView;
		
	}
}
