package ar.edu.unlam.tallerweb1.modelo;

import org.junit.Test;
import org.mockito.BDDMockito.Then;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.*;

public class TamborTest {
	
	//HACER LOS IMPORTS
	//import org.junit.Test;
	//import static org.assertj.core.api.Assertions.*;
	
	//CORRER EL TEST
	//Clic derecho sobre el proyecto, Run As --> JUnit Test
	@Test
	public void girarTest() {
		Tambor t = new Tambor();
		t.girar();		
		assertThat(t.getPosition()).isBetween(1, 8);		
	}
	
	
	//FAKE OBJECTS: Fake, Stub, Mocks	
		
	//STUBS: Forzar comportamientos
	//t2Fake fake no tiene un Obj tambor, lo que guarda es un falso tambor
	
	/*
	Tambor t1Fake = mock(Tambor.class); //Tambor.class es un Stab
	Tambor t2Fake = mock(Tambor.class); //Tambor.class es un Stab
	Tambor t3Fake = mock(Tambor.class); //Tambor.class es un Stab
	
	when(t1Fake.getPosition())Then Return(4);
	when(t2Fake.getPosition())Then Return(5);
	when(t3Fake.getPosition())Then Return(6);
	*/
	//MOCKS: Para validar si ocurrió algo
	

}
