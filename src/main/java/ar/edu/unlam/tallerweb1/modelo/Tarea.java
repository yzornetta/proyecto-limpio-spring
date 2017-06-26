package ar.edu.unlam.tallerweb1.modelo;

public class Tarea {
	
	private Long Id;
	//Esto sera fk a empleados y será integer
	private String nombreTarea;
	private String comentarios;
	private String usuarioAsignado;
	private String estado;	
	//Esto sera fk a proyectos y será integer
	//private String nombreProyecto;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getnombreTarea() {
		return nombreTarea;
	}

	public void setnombreTarea(String nombreTarea) {
		this.nombreTarea = nombreTarea;
	}
	
	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getusuarioAsignado() {
		return usuarioAsignado;
	}

	public void setusuarioAsignado(String usuarioAsignado) {
		this.usuarioAsignado = usuarioAsignado;
	}

	//public String getNombreProyecto() {
		//return nombreProyecto;
	//}

	//public void setNombreProyecto(String nombreProyecto) {
		//this.nombreProyecto = nombreProyecto;
	//}

	//public static Object getDescripcion() {
		// TODO Auto-generated method stub
		//return null;
	}
	


