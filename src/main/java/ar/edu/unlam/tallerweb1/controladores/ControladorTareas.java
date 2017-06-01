package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Tarea;

@Controller
public class ControladorTareas {
ArrayList<Tarea> lista = new ArrayList<Tarea>();
	

@RequestMapping("/listarTareas")
public ModelAndView listarTareas(ArrayList<Tarea>lista) {
return new ModelAndView("listarTareas","command", new Tarea());
}





}
