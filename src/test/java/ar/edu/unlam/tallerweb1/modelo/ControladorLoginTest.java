package ar.edu.unlam.tallerweb1.modelo;

import org.junit.Test;
import org.mockito.BDDMockito.Then;
import org.mockito.Mock;
import org.springframework.web.servlet.ModelAndView;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import javax.servlet.http.HttpServletRequest;

import ar.edu.unlam.tallerweb1.controladores.ControladorLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;

public class ControladorLoginTest {

	@Test
	public void consultarUsuarioExistente () {
		
		//Todas las instancias deben ser MOCK
		Usuario usuarioPrueba = mock(Usuario.class);
		ServicioLogin servicioLoginFake = mock(ServicioLogin.class);
		
		when(servicioLoginFake.consultarUsuario(usuarioPrueba)).thenReturn(usuarioPrueba);
		
		ControladorLogin controlador = new ControladorLogin();
		
		//Setearle al controlador el servicio mockeado
		controlador.setServicioLoginMock(servicioLoginFake);
		
		//HttpServletRequest request = null;
		ModelAndView modelAndView = controlador.validarLogin(usuarioPrueba, null);

		
		verify(usuarioPrueba, times(1)).getEmail();
		assertThat(modelAndView.getViewName()).isEqualTo("redirect:/home");
		
	}
	
	@Test
	public void consultarUsuarioInexistente () {
	
		//Todas las instancias deben ser MOCK
		Usuario usuarioPrueba = mock(Usuario.class);
		ServicioLogin servicioLoginFake = mock(ServicioLogin.class);
		
		when(servicioLoginFake.consultarUsuario(usuarioPrueba)).thenReturn(null);
		
		ControladorLogin controlador = new ControladorLogin();
		
		//Setearle al controlador el servicio mockeado
		controlador.setServicioLoginMock(servicioLoginFake);
		
		ModelAndView modelAndView = controlador.validarLogin(usuarioPrueba, null);
		
		verify(usuarioPrueba, times(0)).getEmail();
		assertThat(modelAndView.getModelMap().get("error")).isEqualTo("Usuario o clave incorrecta");
		assertThat(modelAndView.getViewName()).isEqualTo("login");
	}
	
}
