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
		altaUsuario.setViewName("usuario/altaUsuario");
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
		registracion.setViewName("usuario/registracionOk");
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
	
	
	
	
	/*Nuevo*/
	
	
	@RequestMapping(value="/modificarUsuario",  method = RequestMethod.GET)
	public ModelAndView vistaModificarUsuario(Model modelo) {
		ModelAndView modificarUsuario = new ModelAndView();
		modelo.addAttribute("classRegistrarse", new Usuario());
		modificarUsuario.setViewName("usuario/modificarUsuario");
		return modificarUsuario;
	}	
	
	
	@RequestMapping(value="/modificar",  method = RequestMethod.POST)
	public ModelAndView modificarUsuario(@ModelAttribute("usuario") Usuario usuario) {
		
		servicioLogin.modificarUsuario(usuario);
		ModelAndView modificar = new ModelAndView();
		modificar.addObject("nombre", usuario.getNombre());
		modificar.addObject("apellido", usuario.getApellido());
		modificar.addObject("email", usuario.getEmail());
		modificar.addObject("id", usuario.getId());
		modificar.setViewName("usuario/modificacionOK");
        return modificar;
	}
	
	
	@RequestMapping(value="/modificarPassword",  method = RequestMethod.GET)
	public ModelAndView vistaModificarPassword(Model modelo) {
		ModelAndView modificarPassword = new ModelAndView();
		modelo.addAttribute("classNuevaPass", new Usuario());
		modificarPassword.setViewName("usuario/modificarPassword");
		return modificarPassword;
	}	
	
	@RequestMapping(value="/nuevaPassword",  method = RequestMethod.POST)
	public ModelAndView modificarPassword(@ModelAttribute("classNuevaPass") Usuario usuario) {
		
		Usuario existeUsuario = servicioLogin.findUserById(usuario.getId());
		
		existeUsuario.setPassword(usuario.getPassword());
		
		servicioLogin.modificarUsuario(existeUsuario);
		
		return new ModelAndView("usuario/registracionOk");
		
	}
	

}
