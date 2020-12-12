package com.example.rest.Models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "personas")

public class Personas implements Serializable{
	
	private static final long serialVersionUID= 1L;
	
	@Id
	@Column(name = "per_id",unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "personas")
	private Integer per_id;
	@Column(name = "per_ced")
	private String per_ced;
	@Column(name = "per_nom")
	private String per_nom;
	@Column(name = "per_mail")
	private String per_mail;
	@Column(name = "per_usu")
	private String per_usu;
	@Column(name = "per_pass")
	private String per_pass;
	@Column(name = "per_estado")
	private String per_estado;
	@Column(name = "per_dir")
	private String per_dir;
	
	@ManyToOne
	@JoinColumn(name = "pfl_id_fk")
	private Perfiles pfl_id_fk;
	
	

	public Integer getPer_id() {
		return per_id;
	}

	public void setPer_id(Integer per_id) {
		this.per_id = per_id;
	}

	public String getPer_ced() {
		return per_ced;
	}

	public void setPer_ced(String per_ced) {
		this.per_ced = per_ced;
	}

	public String getPer_nom() {
		return per_nom;
	}

	public void setPer_nom(String per_nom) {
		this.per_nom = per_nom;
	}

	public String getPer_mail() {
		return per_mail;
	}

	public void setPer_mail(String per_mail) {
		this.per_mail = per_mail;
	}

	public String getPer_usu() {
		return per_usu;
	}

	public void setPer_usu(String per_usu) {
		this.per_usu = per_usu;
	}

	public String getPer_pass() {
		return per_pass;
	}

	public void setPer_pass(String per_pass) {
		this.per_pass = per_pass;
	}

	public String getPer_estado() {
		return per_estado;
	}

	public void setPer_estado(String per_estado) {
		this.per_estado = per_estado;
	}
	
	public String getPer_dir() {
		return per_dir;
	}

	public void setPer_dir(String per_dir) {
		this.per_dir = per_dir;
	}

	public Perfiles getPfl_id_fk() {
		return pfl_id_fk;
	}

	public void setPfl_id_fk(Perfiles pfl_id_fk) {
		this.pfl_id_fk = pfl_id_fk;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}
