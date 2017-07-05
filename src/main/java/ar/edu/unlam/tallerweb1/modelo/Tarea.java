package ar.edu.unlam.tallerweb1.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name = "tarea")
public class Tarea {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer Id;
	//Esto sera fk a empleados y será integer
	private String descripcion;
	private String usuarioAsignado;
	private String estado;
	private Integer porcentajeAvance = 0;
	private Integer horasEstimadas;
	private Integer horasReales = 0;
	private String comentarios;
	//Esto sera fk a proyectos y será IdProyecto integer
	private String descripcionProyecto;
	private Date fechaAlta = new Date();
	private String fechaFinalizacion;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario") //Nombre de la columna en la tabla Tarea
	private Usuario usuario;
	
	private Integer usuarioId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "proyecto") //Nombre de la columna en la tabla Tarea
	private Proyecto proyecto;	
	private Integer proyectoId;
	
	
	@Column(name = "Id", nullable = false)
	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	@Column(name = "Estado", nullable = false)
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Column(name = "HorasEstimadas", nullable = false)
	public Integer getHorasEstimadas() {
		return horasEstimadas;
	}

	public void setHorasEstimadas(Integer horasEstimadas) {
		this.horasEstimadas = horasEstimadas;
	}

	@Column(name = "HorasReales", nullable = false)
	public Integer getHorasReales() {
		return horasReales;
	}

	public void setHorasReales(Integer horasReales) {
		this.horasReales = horasReales;
	}

	@Column(name = "Comentarios", nullable = false)
	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	@Column(name = "Descripcion", nullable = false)
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Column(name = "DescripcionProyecto", nullable = false)
	public String getDescripcionProyecto() {
		return descripcionProyecto;
	}

	public void setDescripcionProyecto(String descripcionProyecto) {
		this.descripcionProyecto = descripcionProyecto;
	}

	@Column(name = "FechaFinalizacion", nullable = false)
	public String getFechaFinalizacion() {
		return fechaFinalizacion;
	}

	public void setFechaFinalizacion(String fechaFinalizacion) {
		this.fechaFinalizacion = fechaFinalizacion;
	}

	@Column(name = "FechaAlta", nullable = false)
	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	@Column(name = "UsuarioAsignado", nullable = false)
	public String getUsuarioAsignado() {
		return usuarioAsignado;
	}

	public void setUsuarioAsignado(String usuarioAsignado) {
		this.usuarioAsignado = usuarioAsignado;
	}

	@Column(name = "PorcentajeAvance", nullable = false)
	public Integer getPorcentajeAvance() {
		return porcentajeAvance;
	}

	public void setPorcentajeAvance(Integer porcentajeAvance) {
		this.porcentajeAvance = porcentajeAvance;
	}

	@Column(name = "Usuario", nullable = false)
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Column(name = "Proyecto", nullable = false)
	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	@Column(name = "ProyectoId", nullable = false)
	public Integer getProyectoId() {
		return proyectoId;
	}

	public void setProyectoId(Integer proyectoId) {
		this.proyectoId = proyectoId;
	}

	@Column(name = "UsuarioId", nullable = false)
	public Integer getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}


	

}
