package com.alvaro.empleados.model;



import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table(name="trabajos")
public class Trabajo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "trabajo_id")
	private int id;
	@Column(name = "nref")
	private String nref;
	
	
	
	@DateTimeFormat(pattern="dd/MM/yyyy") 
	@Column(name = "fTrabajo")
	private Date fTrabajo;

	@Column(name = "lugar")
	private String lugar;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "clientes_trabajos", joinColumns = {
			@JoinColumn(name = "cliente_id") },
			inverseJoinColumns = { @JoinColumn(name = "trabajo_id"
					) })
	private Set<Cliente> clientes = new HashSet<Cliente>();             
	            
	
	
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNref() {
		return nref;
	}
	public void setNref(String cif) {
		this.nref = cif;
	}
	public String getLugar() {
		return lugar;
	}
	public void setLugar(String direccion) {
		this.lugar = direccion;
	}
	public Date getfTrabajo() {
		return fTrabajo;
	}
	public void setfTrabajo(Date fTrabajo) {
		this.fTrabajo = fTrabajo;
	}

	
	  public Set<Cliente> getClientes() {
	        return clientes;
	    }
	public void setClientes(Set<Cliente> clientes) {
		this.clientes = clientes;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clientes == null) ? 0 : clientes.hashCode());
		result = prime * result + ((fTrabajo == null) ? 0 : fTrabajo.hashCode());
		result = prime * result + id;
		result = prime * result + ((lugar == null) ? 0 : lugar.hashCode());
		result = prime * result + ((nref == null) ? 0 : nref.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trabajo other = (Trabajo) obj;
		if (clientes == null) {
			if (other.clientes != null)
				return false;
		} else if (!clientes.equals(other.clientes))
			return false;
		if (fTrabajo == null) {
			if (other.fTrabajo != null)
				return false;
		} else if (!fTrabajo.equals(other.fTrabajo))
			return false;
		if (id != other.id)
			return false;
		if (lugar == null) {
			if (other.lugar != null)
				return false;
		} else if (!lugar.equals(other.lugar))
			return false;
		if (nref == null) {
			if (other.nref != null)
				return false;
		} else if (!nref.equals(other.nref))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Trabajo [id=" + id + ", nref=" + nref + ", fTrabajo=" + fTrabajo + ", lugar=" + lugar + ", clientes="
				+ clientes + "]";
	}
	
	 
}
