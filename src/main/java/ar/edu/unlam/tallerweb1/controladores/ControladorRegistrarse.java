package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;

@Controller
public class ControladorRegistrarse {
	
	@Inject
	private ServicioLogin servicioLogin;
	

/*mapping de creacion de usuario*/
	
	/*ANTERIOR	
	@RequestMapping(value = "/nuevoUsuario", method = RequestMethod.GET)
	public String create(Model model) {
		 model.addAttribute("altaUsuario", new Usuario());
		return "/altaUsuario";
	}
	*/
	
	@RequestMapping(value="/nuevoUsuario",  method = RequestMethod.GET)
	public ModelAndView vistaRegistrar(Model modelo) {
		ModelAndView altaUsuario = new ModelAndView();
		modelo.addAttribute("classRegistrarse", new Usuario());
		altaUsuario.setViewName("altaUsuario");
		return altaUsuario;
	}
	
	
	@RequestMapping(value="/registracion",  method = RequestMethod.POST)
	public ModelAndView guardarUsuario(@ModelAttribute("usuario") Usuario usuario) {
		servicioLogin.grabarUsuario(usuario);
		ModelAndView registracion = new ModelAndView();
		registracion.addObject("nombre", usuario.getNombre());
		registracion.addObject("apellido", usuario.getApellido());
		registracion.addObject("email", usuario.getEmail());
		registracion.addObject("password", usuario.getPassword());
		registracion.setViewName("registracionOk");
        return registracion;
	}
	
	@RequestMapping(value = "/alta", method = RequestMethod.POST)
	public String save(@ModelAttribute("usuario") Usuario user, BindingResult bindingResult){
	
		Usuario existeUsuario = servicioLogin.findUserByEmail(user.getEmail());
		
		if(existeUsuario != null){
			bindingResult.rejectValue("email","error.user","el usuario ya esta dado de alta");
		}
		else
		{
			servicioLogin.grabarUsuario(user);
		}
		
		
		return "redirect:/login";
		
	}

}
