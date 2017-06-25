package ar.edu.unlam.tallerweb1.modelo;

public class Tarea {
	
	private Long Id;
	//Esto sera fk a empleados y será integer
	private String usuarioAsignado;
	private String estado;
	private Integer porcentajeAvance;
	private Integer horasEstimadas;
	private Integer horasReales;
	private String comentarios;
	//Esto sera fk a proyectos y será integer
	private String nombreProyecto;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getUsuariosignado() {
		return usuarioAsignado;
	}

	public void setUsuarioAsignado(String usuarioAsignado) {
		this.usuarioAsignado = usuarioAsignado;
	}

	public Integer getAvance() {
		return porcentajeAvance;
	}

	public void setPorcentajeAvance(Integer porcentajeAvance) {
		this.porcentajeAvance = porcentajeAvance;
	}

	public Integer getHorasEstimadas() {
		return horasEstimadas;
	}

	public void setHorasEstimadas(Integer horasEstimadas) {
		this.horasEstimadas = horasEstimadas;
	}

	public Integer getHorasReales() {
		return horasReales;
	}

	public void setHorasReales(Integer horasReales) {
		this.horasReales = horasReales;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public String getNombreProyecto() {
		return nombreProyecto;
	}

	public void setNombreProyecto(String nombreProyecto) {
		this.nombreProyecto = nombreProyecto;
	}

	public static Object getDescripcion() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
