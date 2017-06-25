package ar.edu.unlam.tallerweb1.modelo;

public class Tragamonedas {
	
	//Mal implementado, es acoplado
	//Con esto no puedo probar pasarle el valor que yo quiero7
	//Para eso agrego el Constructor
	//private Tambor t1 = new Tambor();
	//private Tambor t2 = new Tambor();
	//private Tambor t3 = new Tambor();
	
	private Tambor t1;
	private Tambor t2;
	private Tambor t3;

	public Tragamonedas(Tambor t1, Tambor t2, Tambor t3) {
		this.t1 = t1;
		this.t2 = t2;
		this.t3 = t3;
	}

	
	public void activar() {
		t1.girar();
		t2.girar();
		t3.girar();
	}
	
	public Boolean entregaPremio() {
		
		return t1.getPosition() == t2.getPosition() &&
			t2.getPosition() == t3.getPosition();
	}
		
}
