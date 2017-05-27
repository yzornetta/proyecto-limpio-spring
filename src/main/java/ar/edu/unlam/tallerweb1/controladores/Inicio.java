package ar.edu.unlam.tallerweb1.controladores;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unlam.tallerweb1.modelo.Persona;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Controller
public class Inicio {
ArrayList<Persona> lista = new ArrayList<Persona>();
	
@RequestMapping("/formulario")
public ModelAndView formulario(ArrayList<Persona>lista) {
return new ModelAndView("formulario","command", new Persona());//devuelve vista formulario
}

@RequestMapping(value="/agregar", method = RequestMethod.GET)
//public ModelAndView agregar(Persona per, ModelMap model)
public ModelAndView agregar(Persona per)
{
//Persona persona1= new Persona("pedro");
//lista.add(persona1);
lista.add(per);
return new ModelAndView("exito","command",lista);//devuelve vista exito
}

@RequestMapping(value="/index", method = RequestMethod.GET)
public ModelAndView index(Persona per)
{
return new ModelAndView("ListaVacia","command",lista);//devuelve vista ListaVacia
}

@RequestMapping(value="/IrAProyecto", method = RequestMethod.GET)
public ModelAndView IrAProyecto(Persona per, ModelMap model)//model es para poder mostrar los datos en otra pagina. 
{
	//ModelMap modelo = new ModelMap();
	//Persona usuario = new Persona();
	//usuario = per;
	model.put("persona.nombre", per);
	return new ModelAndView("IrAProyecto",model);
	


	}




}

	
