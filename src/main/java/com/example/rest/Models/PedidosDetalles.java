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
@Table(name = "pedidos_detalles")

public class PedidosDetalles implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "pdt_id",unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "pedidosDetalles")
	private Integer pdt_id;
	@Column(name = "pdt_cantidad")
	private Integer pdt_cantidad;
	@Column(name = "pdt_total")
	private Double pdt_total;
	@Column(name = "pdt_pre_uni")
	private Double pdt_pre_uni;
	@Column(name = "pdt_estado")
	private String pdt_estado;
	@Column(name = "pdt_est_cocinado")
	private String pdt_est_cocinado;
	
	
	@ManyToOne
	@JoinColumn(name="per_id_fk" )
	private Personas per_id_fk;
	
	@ManyToOne
	@JoinColumn(name="pla_id_fk")
	private Platos pla_id_fk;

	

	public Integer getPdt_id() {
		return pdt_id;
	}

	public void setPdt_id(Integer pdt_id) {
		this.pdt_id = pdt_id;
	}

	public Integer getPdt_cantidad() {
		return pdt_cantidad;
	}

	public void setPdt_cantidad(Integer pdt_cantidad) {
		this.pdt_cantidad = pdt_cantidad;
	}

	public Double getPdt_total() {
		return pdt_total;
	}

	public void setPdt_total(Double pdt_total) {
		this.pdt_total = pdt_total;
	}
	
	public String getPdt_estado() {
		return pdt_estado;
	}

	public void setPdt_estado(String pdt_estado) {
		this.pdt_estado = pdt_estado;
	}

	public Personas getPer_id_fk() {
		return per_id_fk;
	}

	public void setPer_id_fk(Personas per_id_fk) {
		this.per_id_fk = per_id_fk;
	}

	public Platos getPla_id_fk() {
		return pla_id_fk;
	}

	public void setPla_id_fk(Platos pla_id_fk) {
		this.pla_id_fk = pla_id_fk;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Double getPdt_pre_uni() {
		return pdt_pre_uni;
	}

	public void setPdt_pre_uni(Double pdt_pre_uni) {
		this.pdt_pre_uni = pdt_pre_uni;
	}

	public String getPdt_est_cocinado() {
		return pdt_est_cocinado;
	}

	public void setPdt_est_cocinado(String pdt_est_cocinado) {
		this.pdt_est_cocinado = pdt_est_cocinado;
	}
	
	
	
	
	

}
