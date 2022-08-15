package com.uce.edu.demo.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "transferencia")
public class Transferencia {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tran_id_seq")
	@SequenceGenerator(name = "tran_id_seq", sequenceName = "tran_id_seq", allocationSize = 1)
	@Column(name = "tran_id")
	private Integer id;

	@Column(name = "tran_fecha")
	private LocalDateTime fecha;

	@Column(name = "tran_monto")
	private BigDecimal monto;

	@Column(name = "tran_origen")
	private Integer ctaOrigen;

	@Column(name = "tran_destino")
	private Integer ctaDestino;

	@ManyToOne
	@JoinColumn(name = "tran_cta_origen")
	private CuentaBancaria cuentaOrigen;

	@ManyToOne
	@JoinColumn(name = "tran_cta_destino")
	private CuentaBancaria cuentaDestino;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public Integer getCtaOrigen() {
		return ctaOrigen;
	}

	public void setCtaOrigen(Integer ctaOrigen) {
		this.ctaOrigen = ctaOrigen;
	}

	public Integer getCtaDestino() {
		return ctaDestino;
	}

	public void setCtaDestino(Integer ctaDestino) {
		this.ctaDestino = ctaDestino;
	}

	public CuentaBancaria getCuentaOrigen() {
		return cuentaOrigen;
	}

	public void setCuentaOrigen(CuentaBancaria cuentaOrigen) {
		this.cuentaOrigen = cuentaOrigen;
	}

	public CuentaBancaria getCuentaDestino() {
		return cuentaDestino;
	}

	public void setCuentaDestino(CuentaBancaria cuentaDestino) {
		this.cuentaDestino = cuentaDestino;
	}

	

}
