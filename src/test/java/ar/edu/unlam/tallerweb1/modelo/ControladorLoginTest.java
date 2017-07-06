package ar.edu.unlam.tallerweb1.modelo;

import org.junit.Test;
import org.mockito.BDDMockito.Then;
import org.mockito.Mock;
import org.springframework.web.servlet.ModelAndView;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import ar.edu.unlam.tallerweb1.controladores.ControladorLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;

public class ControladorLoginTest {

	@Test
	public void testLoguearseConUsuarioYPassCorrectosDeberiaIrALaVistaIndex() {
		HttpServletRequest requestMock = mock(HttpServletRequest.class);
		when(requestMock.getSession()).thenReturn(mock(HttpSession.class));
		
		Usuario usuario = new Usuario();
		usuario.setEmail("test1@hotmail.com");
		usuario.setNombre("Luis");
		usuario.setApellido("Lopes");
		usuario.setPassword("111");		
		
		ServicioLogin servicioMock = mock(ServicioLogin.class);
		when (servicioMock.consultarUsuario(usuario));
		ControladorLogin controladorLogin = new ControladorLogin();
		controladorLogin.setValidarUsuarioMock(servicioMock);

		ModelAndView mav = controladorLogin.validarLogin(usuario, requestMock);
		assertThat(mav.getViewName()).isEqualTo("redirect:/");
	}
}
	
