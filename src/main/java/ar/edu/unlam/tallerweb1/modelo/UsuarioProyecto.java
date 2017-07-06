package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuario_proyecto")
public class UsuarioProyecto {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 	
	private Integer Id;
	private Integer usuarioId;
	private Integer proyectoId;
	
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public Integer getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}
	public Integer getProyectoId() {
		return proyectoId;
	}
	public void setProyectoId(Integer proyectoId) {
		this.proyectoId = proyectoId;
	}
}
