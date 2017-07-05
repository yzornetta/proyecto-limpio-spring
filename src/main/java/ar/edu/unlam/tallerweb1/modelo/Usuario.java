package ar.edu.unlam.tallerweb1.modelo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "usuario")
public class Usuario {
	
	
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer id;
	private String email;
	private String nombre;
	private String apellido;
	private String password;
	private String passwordConf;
	/*private Set<Proyecto> Proyecto = new HashSet<Proyecto>(0);*/
	
	@Id 
	@Column(name = "Id")
	public Integer getId() {
		return id;
	}	
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name = "password")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name = "passwordConf")
	public String getPasswordConf() {
		return passwordConf;
	}
	public void setPasswordConf(String passwordConf) {
		this.passwordConf = passwordConf;
	}
	
	@Column(name = "nombre")
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Column(name = "apellido")
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	/*
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "Proyecto")
	public Set<Proyecto> getProyecto() {
		return this.Proyecto;
	}
	
	public void setInscripcion(Set<Proyecto> Proyecto) {
		this.Proyecto = Proyecto;
	}
	*/		
	
}
