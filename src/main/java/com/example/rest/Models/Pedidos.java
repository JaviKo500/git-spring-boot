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
@Table(name = "pedidos")

public class Pedidos implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ped_id",unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "platos")
	private Integer ped_id;
	@Column(name = "ped_fecha")
	private String ped_fecha;
	@Column(name = "ped_costo_final")
	private Double ped_costo_final;
	@Column(name = "ped_estado")
	private String ped_estado;
	@Column(name = "ped_est_cocinado")
	private String ped_est_cocinado;
	@Column(name = "ped_direccion")
	private String ped_direccion;
	@Column(name = "ped_des_dir")
	private String ped_des_dir;
	@Column(name = "ped_num_movil")
	private String ped_num_movil;
	
	@ManyToOne
	@JoinColumn(name="per_id_fk")
	private Personas per_id_fk;

	

	public Integer getPed_id() {
		return ped_id;
	}

	public void setPed_id(Integer ped_id) {
		this.ped_id = ped_id;
	}

	public String getPed_fecha() {
		return ped_fecha;
	}

	public void setPed_fecha(String ped_fecha) {
		this.ped_fecha = ped_fecha;
	}

	public Double getPed_costo_final() {
		return ped_costo_final;
	}

	public void setPed_costo_final(Double ped_costo_final) {
		this.ped_costo_final = ped_costo_final;
	}

	public String getPed_estado() {
		return ped_estado;
	}

	public void setPed_estado(String ped_estado) {
		this.ped_estado = ped_estado;
	}

	public Personas getPer_id_fk() {
		return per_id_fk;
	}

	public void setPer_id_fk(Personas per_id_fk) {
		this.per_id_fk = per_id_fk;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getPed_direccion() {
		return ped_direccion;
	}

	public void setPed_direccion(String ped_direccion) {
		this.ped_direccion = ped_direccion;
	}

	public String getPed_des_dir() {
		return ped_des_dir;
	}

	public void setPed_des_dir(String ped_des_dir) {
		this.ped_des_dir = ped_des_dir;
	}

	public String getPed_num_movil() {
		return ped_num_movil;
	}

	public void setPed_num_movil(String ped_num_movil) {
		this.ped_num_movil = ped_num_movil;
	}

	public String getPed_est_cocinado() {
		return ped_est_cocinado;
	}

	public void setPed_est_cocinado(String ped_est_cocinado) {
		this.ped_est_cocinado = ped_est_cocinado;
	}
	
	
	
	



}
