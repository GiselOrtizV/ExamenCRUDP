package com.crud.ExamenCRUD.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="productos")
public class Producto implements Serializable {
	
	private static final long serialVersionUID = 2683450128708405020L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@Column(length=100)
	private String descripcion;
	private double precio;
	private int catidad;
	//private double compra;
	
	
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getCatidad() {
		return catidad;
	}
	public void setCatidad(int catidad) {
		this.catidad = catidad;
	}
	//public double getCompra() {
		//return compra;
	//}
	//public void setCompra(double compra) {
		//this.compra = compra;
	//}
	
	

}
