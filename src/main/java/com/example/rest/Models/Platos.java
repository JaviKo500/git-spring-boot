package com.example.rest.Models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "platos")

public class Platos implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "pla_id",unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "platos")
	private Integer pla_id;
	@Column(name = "pla_nom")
	private String pla_nom;
	@Column(name = "pla_des")
	private String pla_des;
	@Column(name = "pla_precio")
	private Double pla_precio;
	
	@OneToOne
	@JoinColumn(name = "cat_id_fk")
	private Categorias cat_id_fk;

	

	public Integer getPla_id() {
		return pla_id;
	}

	public void setPla_id(Integer pla_id) {
		this.pla_id = pla_id;
	}

	public String getPla_nom() {
		return pla_nom;
	}

	public void setPla_nom(String pla_nom) {
		this.pla_nom = pla_nom;
	}

	public String getPla_des() {
		return pla_des;
	}

	public void setPla_des(String pla_des) {
		this.pla_des = pla_des;
	}

	public Double getPla_precio() {
		return pla_precio;
	}

	public void setPla_precio(Double pla_precio) {
		this.pla_precio = pla_precio;
	}

	public Categorias getCat_id_fk() {
		return cat_id_fk;
	}

	public void setCat_id_fk(Categorias cat_id_fk) {
		this.cat_id_fk = cat_id_fk;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}
