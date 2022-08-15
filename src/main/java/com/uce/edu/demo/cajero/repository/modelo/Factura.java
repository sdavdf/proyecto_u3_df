package com.uce.edu.demo.cajero.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="factura")
public class Factura {
	
	@Id
	@Column(name="fact_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator ="fact_id_seq" )
	@SequenceGenerator(name="fact_id_seq", sequenceName = "fact_id_seq", allocationSize =1 )
	private Integer id;
	
	@Column(name="fact_fecha")
	private LocalDateTime fecha;
	
	@Column(name="fact_numero")
	private String numero;
	
	@Column(name="fact_total")
	private BigDecimal total;

	@OneToMany(mappedBy="factura", fetch = FetchType.EAGER)
	private List<Detalle> detalles;


	//SET y GET
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

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public List<Detalle> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<Detalle> detalles) {
		this.detalles = detalles;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	
	

}
