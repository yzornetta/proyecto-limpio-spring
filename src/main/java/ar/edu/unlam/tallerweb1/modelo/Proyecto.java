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
	
	
	@Id 
	@Column(name = "Id")
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	@Column(name = "descripcion")
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@Column(name = "horasEstimadas")
	public Integer getHorasEstimadas() {
		return horasEstimadas;
	}
	public void setHorasEstimadas(Integer horasEstimadas) {
		this.horasEstimadas = horasEstimadas;
	}
	
	@Column(name = "porcentajeAvance")
	public Integer getPorcentajeAvance() {
		return porcentajeAvance;
	}
	public void setPorcentajeAvance(Integer porcentajeAvance) {
		this.porcentajeAvance = porcentajeAvance;
	}
	
	@Column(name = "horasReales")
	public Integer getHorasReales() {
		return horasReales;
	}
	public void setHorasReales(Integer horasReales) {
		this.horasReales = horasReales;
	}
	
	@Column(name = "fechaAlta")
	public Date getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = new Date();
	}
	
	@Column(name = "fechaFinalizacion")
	public String getFechaFinalizacion() {
		return fechaFinalizacion;
	}
	public void setFechaFinalizacion(String fechaFinalizacion) {
		this.fechaFinalizacion = fechaFinalizacion;
	}
	
	@Column(name = "idUsuarioAlta")
	public Integer getIdUsuarioAlta() {
		return idUsuarioAlta;
	}
	public void setIdUsuarioAlta(Integer idUsuarioAlta) {
		this.idUsuarioAlta = idUsuarioAlta;
	}
	
	@Column(name = "comentarios")
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	
	/*Definicion de la relacion Mucho a Muchos con tabla Proyectos*/
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "proyecto")
	public Set<Usuario> getUsuario() {
		return this.Usuario;
	}
	
	public void setInscripcion(Set<Usuario> Usuario) {
		this.Usuario = Usuario;
	}

}
