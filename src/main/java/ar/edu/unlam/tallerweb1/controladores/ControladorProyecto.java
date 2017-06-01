package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	ArrayList<Proyecto> lista = new ArrayList<Proyecto>();
	
	@RequestMapping("proyecto/altaProyecto")
	public ModelAndView formulario(ArrayList<Proyecto>lista) {
		return new ModelAndView("proyecto/altaProyecto","command", new Proyecto());//devuelve vista formulario
	}
	
	@RequestMapping(value="proyecto/agregarProyecto", method = RequestMethod.GET)
	public ModelAndView agregarProyecto(Proyecto proyecto)
	{
		lista.add(proyecto);
		return new ModelAndView("proyecto/exitoProyecto","command",lista);//devuelve vista exito
	}
	
	@RequestMapping(value="proyecto/listarProyecto")
	public ModelAndView IrAProyecto(@ModelAttribute Proyecto proyecto)
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("proyecto/listarProyecto");
		modelAndView.addObject("proyecto", proyecto);
		return modelAndView;
	}

}
