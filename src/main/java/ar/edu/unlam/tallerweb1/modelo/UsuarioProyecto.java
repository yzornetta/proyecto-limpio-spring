package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usuario_proyecto")
public class UsuarioProyecto {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 	
	private Integer Id;
	
	private Integer usuarioId;
	private Integer proyectoId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario") //Nombre de la columna en la tabla Tarea	
	private Usuario usuario;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "proyecto") //Nombre de la columna en la tabla Tarea		
	private Proyecto proyecto;	

	
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
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Proyecto getProyecto() {
		return proyecto;
	}
	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}
}
