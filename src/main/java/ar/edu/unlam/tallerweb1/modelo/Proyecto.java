package ar.edu.unlam.tallerweb1.modelo;

public class Proyecto {

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
}
