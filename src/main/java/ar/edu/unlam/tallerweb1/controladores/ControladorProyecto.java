package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;
import java.util.Random;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Persona;
import ar.edu.unlam.tallerweb1.modelo.Proyecto;
import ar.edu.unlam.tallerweb1.servicios.ServicioProyecto;

@Controller
public class ControladorProyecto {

	@Inject
	private ServicioProyecto servicioProyecto;
	private Random random = new Random();
	
	ArrayList<Proyecto> lista = new ArrayList<Proyecto>();
		
	@RequestMapping("proyecto/altaProyecto")
	public ModelAndView formulario(ArrayList<Proyecto>lista) {
		return new ModelAndView("proyecto/altaProyecto","command", new Proyecto());//devuelve vista formulario
	}
	
	@RequestMapping(value="proyecto/agregarProyecto", method = RequestMethod.GET)
	public ModelAndView agregarProyecto(Proyecto proyecto)
	{
		//ID aleatorio por ahora
		int nuevoID = random.nextInt((99999 - 1) + 1) + 1;
		proyecto.setId(nuevoID);
		lista.add(proyecto);
		return new ModelAndView("proyecto/exitoProyecto","command", lista);//devuelve vista exito
	}

	
	@RequestMapping(value="proyecto/listarProyecto")
	public ModelAndView IrAProyecto(@ModelAttribute Proyecto proyecto)
	{
		//Id seleccionado
		Integer idProyecto = proyecto.getId();
				
		//Servicio devuelve Objeto en base al id enviado
		//Cuando haya base la lista no va, porque se busca sobre la base directamente
		Proyecto proyectoElegido = servicioProyecto.consultarProyectoPorID(lista, idProyecto);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("proyecto/listarProyecto");
		modelAndView.addObject("proyecto", proyectoElegido);
		return modelAndView;
		
	}
}
