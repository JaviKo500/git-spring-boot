package com.example.rest.Models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categorias")

public class Categorias implements Serializable{
	
	private static final long serialVersionUID= 1L;
	
	@Id
	@Column(name = "cat_id",unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "platos")
	private Integer cat_id;
	@Column(name = "cat_nom")
	private String cat_nom;
	@Column(name = "cat_des")
	private String cat_des;
	
	
	
	
	public Integer getCat_id() {
		return cat_id;
	}
	public void setCat_id(Integer cat_id) {
		this.cat_id = cat_id;
	}
	public String getCat_nom() {
		return cat_nom;
	}
	public void setCat_nom(String cat_nom) {
		this.cat_nom = cat_nom;
	}
	public String getCat_des() {
		return cat_des;
	}
	public void setCat_des(String cat_des) {
		this.cat_des = cat_des;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
