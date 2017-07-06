package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Proyecto;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;

@Controller
public class ControladorLogin {

	@Inject
	private ServicioLogin servicioLogin;
	
	private List<Usuario> listaUsuarios;

	
	@RequestMapping("/login")
	public ModelAndView irALogin() {

		ModelMap modelo = new ModelMap();
		Usuario usuario = new Usuario();
		modelo.put("usuario", usuario);
		return new ModelAndView("login", modelo);
	}
	
	@RequestMapping(path = "/validar-login", method = RequestMethod.POST)
	public ModelAndView validarLogin(@ModelAttribute("usuario") Usuario usuario, HttpServletRequest request) {
		ModelMap model = new ModelMap();
		Usuario usuarioValidado = servicioLogin.consultarUsuario(usuario);
		
		if (usuarioValidado != null) {
			request.getSession().setAttribute("email",usuarioValidado.getEmail());
			request.getSession().setAttribute("nombre",usuarioValidado.getNombre());
			request.getSession().setAttribute("apellido",usuarioValidado.getApellido());
			request.getSession().setAttribute("password",usuarioValidado.getPassword());
			request.getSession().setAttribute("Id",usuarioValidado.getId());
			model.put("UsuarioLogueado", usuario);
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
	
	@RequestMapping(value = "/exit",  method = RequestMethod.GET)
	public ModelAndView vistaLogout (HttpServletRequest request) {
		if(request.getSession() != null) {
			request.getSession().invalidate();
		}
		return new ModelAndView("redirect:/");
	}
	
	//LISTAR TODOS LOS USUARIOS
	@RequestMapping(value="usuario/listarUsuarios",  method = RequestMethod.GET)
	public ModelAndView listarProyectos()
	{
		listaUsuarios = servicioLogin.obtenerTodos();
		return new ModelAndView("usuario/listarUsuarios","command", listaUsuarios);//devuelve vista exito
	}

	public void setValidarUsuarioMock(ServicioLogin servicioMock) {
		// TODO Auto-generated method stub
		
	}
	
}
