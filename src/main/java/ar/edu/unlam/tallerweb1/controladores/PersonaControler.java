package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import antlr.collections.List;
import ar.edu.unlam.tallerweb1.modelo.Persona;

@Controller
public class PersonaControler {
	
	public String nombres = "juan"; 
	
	@RequestMapping("/mostrar/nombre")
	public ModelAndView saludoInicial(@RequestParam("nombre")String nombre){
		String mensaje = "hola, " + nombre;
		
		ModelMap model = new ModelMap();
		
		model.put("mensajeMostrar", mensaje);
		
		return new ModelAndView("vistaAInvocar", model);
		
	}
		
		@RequestMapping("/mostrar/{nombre2}")
		public ModelAndView saludoInicial2(@PathVariable(value="nombre2") String nombre2){
			String mensaje = "hola, " + nombre2;
			
			ModelMap model = new ModelMap();
			
			model.put("mensajeMostrar", mensaje);
			
			return new ModelAndView("vistaAInvocar", model);	
		}
		
		@RequestMapping("/mostrar2/{celdas}")
		public ModelAndView saludoInicial3(@PathVariable(value="celdas") int celdas){
			
			ModelMap model = new ModelMap();
			/*int i = 0;
			
			ArrayList<String> lista = new ArrayList<String>();
						
			for(i = 0; i < celdas; i++)
			{
				lista.add(nombres);
			}
	*/
			model.put("mensajeMostrar", celdas);
			
			return new ModelAndView("vistaAInvocar", model);
		
		}
		
		
}
