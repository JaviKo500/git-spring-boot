package com.example.rest.Models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "perfiles")
public class Perfiles implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "pfl_id",unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "perfiles")
	private Integer pfl_id;
	@Column(name = "pfl_nom")
	private String pfl_nom;
	@Column(name = "pfl_des")
	private String pfl_des;
	@Column(name = "pfl_estado")
	private String pfl_estado;
	
	public Integer getPfl_id() {
		return pfl_id;
	}
	public void setPfl_id(Integer pfl_id) {
		this.pfl_id = pfl_id;
	}
	public String getPfl_nom() {
		return pfl_nom;
	}
	public void setPfl_nom(String pfl_nom) {
		this.pfl_nom = pfl_nom;
	}
	public String getPfl_des() {
		return pfl_des;
	}
	public void setPfl_des(String pfl_des) {
		this.pfl_des = pfl_des;
	}
	
	public String getPfl_estado() {
		return pfl_estado;
	}
	public void setPfl_estado(String pfl_estado) {
		this.pfl_estado = pfl_estado;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
