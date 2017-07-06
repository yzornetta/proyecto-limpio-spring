package ar.edu.unlam.tallerweb1.modelo;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.dao.UsuarioDao;

public class UsuarioPersistenciaTest extends SpringTest{
	
@Inject private UsuarioDao usudao;
@Test @Transactional @Rollback(true)
public void guardarUsuTest(){
	
	Usuario usu = new Usuario();
	usu.setEmail("test1@hotmail.com");
	usu.setNombre("Luis");
	usu.setApellido("Lopes");
	usu.setPassword("111");
	
	usudao.save(usu);
	
	Usuario buscado = sessionFactory.getCurrentSession().get(Usuario.class, usu.getId());
	Assert.assertTrue("correcto", buscado.getApellido().equals("Lopes"));
	
	
}

}
