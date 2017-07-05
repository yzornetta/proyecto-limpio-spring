package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Column;

public class UsuarioProyecto {

	private Integer Id;
	private Integer idEmpleado;
	private Integer idProyecto;
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	
	@Column(name = "IdEmpleado", nullable = false)
	public Integer getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(Integer idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	
	@Column(name = "IdProyecto", nullable = false)
	public Integer getIdProyecto() {
		return idProyecto;
	}
	public void setIdProyecto(Integer idProyecto) {
		this.idProyecto = idProyecto;
	}
}
