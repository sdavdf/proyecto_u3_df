package com.uce.edu.demo.cajero.service;

import java.math.BigDecimal;
import java.util.List;

import com.uce.edu.demo.cajero.repository.modelo.Factura;

public interface IFacturaService {

	// CRUD
	public Factura consultar(Integer id);

	public void create(Factura f);

	public void update(Factura f);

	public void delete(Integer id);

	// Cree estos dos para calcular el precio y el numero de alimentos
	public BigDecimal calcularPrecio(Integer id);

	public int cantidad(Integer id);

	// Inner Join
	public List<Factura> buscarFacturaInnerJoin(BigDecimal precio);

	// Inner Outer Join Left
	public List<Factura> buscarFacturaOuterJoinLeft(BigDecimal precio);

	// Inner Outer Join Right
	public List<Factura> buscarFacturaOuterJoinRight(Integer cantidad);

	// Where Join
	public List<Factura> buscarFacturaJoinWhere(BigDecimal precio);

	// Fetch Join
	public List<Factura> buscarFacturaJoinFetch(BigDecimal precio);

	
	
	
	
	
//	public List<Factura> buscarFacturaInnerJoin(Integer cantidadDetalle);
//
//	public List<Factura> buscarFacturaInnerJoin();
//
//	public List<Factura> buscarFacturaOuterJoinLeft(Integer cantidadDetalle);
//
//	public List<Factura> buscarFacturaOuterJoinLeft();
//
//	public List<Factura> buscarFacturaOuterJoinRight(Integer cantidadDetalle);
//
//	public List<Factura> buscarFacturaJoinWhere(Integer cantidadDetalle);
//
//	public List<Factura> buscarFacturaJoinFetch(Integer cantidadDetalle);

}
