package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Proyecto;
import ar.edu.unlam.tallerweb1.servicios.ServicioProyecto;

@Controller
public class ControladorProyecto {

	@Inject
	private ServicioProyecto servicioProyecto;
	
	@RequestMapping("proyecto/altaProyecto")
	public ModelAndView irAProyectoAlta() {

		ModelMap modelo = new ModelMap();
		Proyecto proyecto = new Proyecto();
		modelo.put("proyecto", proyecto);
		return new ModelAndView("proyecto/altaProyecto", modelo);
	}

	@RequestMapping(path = "proyecto/guardar-proyecto", method = RequestMethod.POST)
	public ModelAndView guardarProyecto(@ModelAttribute("proyecto") Proyecto proyecto) {
		ModelMap modelo = new ModelMap();
		modelo.put("proyecto", proyecto);
		return new ModelAndView("proyecto/listarProyecto", modelo);
		//modelo.put("descripcion", proyecto.getDescripcion());
		//return new ModelAndView("proyecto/altaProyecto", modelo);
	}
		
}
