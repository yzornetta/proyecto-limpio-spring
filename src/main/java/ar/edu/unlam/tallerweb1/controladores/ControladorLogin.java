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
public class ControladorLogin {

	@Inject
	private ServicioLogin servicioLogin;
	
	@RequestMapping("/login")
	public ModelAndView irALogin() {

		ModelMap modelo = new ModelMap();
		Usuario usuario = new Usuario();
		modelo.put("usuario", usuario);
		return new ModelAndView("login", modelo);
	}

	@RequestMapping(path = "/validar-login", method = RequestMethod.POST)
	public ModelAndView validarLogin(@ModelAttribute("usuario") Usuario usuario) {
		ModelMap model = new ModelMap();

		if (servicioLogin.consultarUsuario(usuario) != null) {
			return new ModelAndView("redirect:/home");
		} else {
			model.put("error", "Usuario o clave incorrecta");
		}
		return new ModelAndView("login", model);
	}
	
	@RequestMapping(path = "/home", method = RequestMethod.GET)
	public ModelAndView irAHome() {
		return new ModelAndView("home");
	}
	
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ModelAndView inicio() {
		return new ModelAndView("redirect:/login");
	}
	
	
/*mapping de creacion de usuario*/
	
	
	@RequestMapping(value = "/nuevoUsuario", method = RequestMethod.GET)
	public String create(Model model) {
		 model.addAttribute("altaUsuario", new Usuario());
		return "/altaUsuario";
	}
	
	
	@RequestMapping(value = "/alta", method = RequestMethod.POST)
	public String save(@ModelAttribute("usuario") Usuario user, BindingResult bindingResult){
	
		Usuario existeUsuario = servicioLogin.findUserByEmail(user.getEmail());
		
		if(existeUsuario != null){
			bindingResult.rejectValue("email","error.user","el usuario ya esta dado de alta");
		}
		else
		{
			servicioLogin.save(user);
		}
		
		
		return "redirect:/login";
		
	}
	
	
}
