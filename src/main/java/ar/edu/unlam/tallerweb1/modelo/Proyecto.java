package ar.edu.unlam.tallerweb1.modelo;


import javax.servlet.http.HttpServletRequest;

import org.junit.runner.Request;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "proyecto")
public class Proyecto {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer Id;
	private String descripcion;
	private Integer horasEstimadas;
	private Integer horasReales;
	private Integer porcentajeAvance = 0;
	private Date fechaAlta = new Date();
	private String fechaFinalizacion;
	private Integer idUsuarioAlta;
			
			//request.getSession().setAttribute("Id",usuarioValidado.getId());
	
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Integer getHorasEstimadas() {
		return horasEstimadas;
	}
	public void setHorasEstimadas(Integer horasEstimadas) {
		this.horasEstimadas = horasEstimadas;
	}
	public Integer getPorcentajeAvance() {
		return porcentajeAvance;
	}
	public void setPorcentajeAvance(Integer porcentajeAvance) {
		this.porcentajeAvance = porcentajeAvance;
	}
	public Integer getHorasReales() {
		return horasReales;
	}
	public void setHorasReales(Integer horasReales) {
		this.horasReales = horasReales;
	}
	public Date getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = new Date();
	}
	public String getFechaFinalizacion() {
		return fechaFinalizacion;
	}
	public void setFechaFinalizacion(String fechaFinalizacion) {
		this.fechaFinalizacion = fechaFinalizacion;
	}
	public Integer getIdUsuarioAlta() {
		return idUsuarioAlta;
	}
	public void setIdUsuarioAlta(Integer idUsuarioAlta) {
		this.idUsuarioAlta = idUsuarioAlta;
	}

}
