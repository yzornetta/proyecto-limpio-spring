package ar.edu.unlam.tallerweb1.modelo;


import javax.servlet.http.HttpServletRequest;

import org.junit.runner.Request;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "proyecto")
public class Proyecto {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer Id;
	private String descripcion;
	private Integer horasEstimadas;
	private Integer horasReales = 0;
	private Integer porcentajeAvance = 0;
	private Date fechaAlta = new Date();
	private String fechaFinalizacion;
	private Integer idUsuarioAlta;
	private String comentarios;
	private Set<Usuario> Usuario = new HashSet<Usuario>(0);
			
			//request.getSession().setAttribute("Id",usuarioValidado.getId());
	
	
	@Column(name = "Id", nullable = false)
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	@Column(name = "descripcion", nullable = false)
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@Column(name = "HorasEstimadas", nullable = false)
	public Integer getHorasEstimadas() {
		return horasEstimadas;
	}
	public void setHorasEstimadas(Integer horasEstimadas) {
		this.horasEstimadas = horasEstimadas;
	}
	
	@Column(name = "PorcentajeAvance", nullable = false)
	public Integer getPorcentajeAvance() {
		return porcentajeAvance;
	}
	public void setPorcentajeAvance(Integer porcentajeAvance) {
		this.porcentajeAvance = porcentajeAvance;
	}
	
	@Column(name = "HorasReales", nullable = false)
	public Integer getHorasReales() {
		return horasReales;
	}
	public void setHorasReales(Integer horasReales) {
		this.horasReales = horasReales;
	}
	
	@Column(name = "FechaAlta", nullable = false)
	public Date getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = new Date();
	}
	
	@Column(name = "FechaFinalizacion", nullable = false)
	public String getFechaFinalizacion() {
		return fechaFinalizacion;
	}
	public void setFechaFinalizacion(String fechaFinalizacion) {
		this.fechaFinalizacion = fechaFinalizacion;
	}
	
	@Column(name = "idUsuarioAlta", nullable = false)
	public Integer getIdUsuarioAlta() {
		return idUsuarioAlta;
	}
	public void setIdUsuarioAlta(Integer idUsuarioAlta) {
		this.idUsuarioAlta = idUsuarioAlta;
	}
	
	@Column(name = "Comentarios", nullable = false)
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "Usuario")
	public Set<Usuario> getUsuario() {
		return this.Usuario;
	}
	
	public void setInscripcion(Set<Usuario> Usuario) {
		this.Usuario = Usuario;
	}

}
