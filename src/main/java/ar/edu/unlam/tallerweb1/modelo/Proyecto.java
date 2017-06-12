package ar.edu.unlam.tallerweb1.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Proyecto {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer Id;
	private String descripcion;
	private Integer horasEstimadas;
	private Integer horasReales;
	private Integer porcentajeAvance;
	
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
	
	/*
	public List<Proyecto> listaProyecto(){
		lsProyecto = null;
		
		Proyecto p1 = new Proyecto();
		p1.Id = 1;
		p1.descripcion = "Ejemplo nro 1";
		
		lsProyecto.add(p1);
		return lsProyecto;
	}
	*/

}
