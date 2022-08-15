package com.uce.edu.demo.cajero.repository;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.cajero.repository.modelo.Factura;

@Repository
@Transactional
public class FacturaRepositoryImpl implements IFacturaRepository{

	@PersistenceContext
	private EntityManager entityManager;

	
	//CRUD----
	@Override
	public Factura consultar(Integer id) {
		return this.entityManager.find(Factura.class, id);
	}
	
	@Override
	public void create(Factura f) {
		this.entityManager.persist(f);
	}

	@Override
	public void update(Factura f) {
		this.entityManager.merge(f);
	}

	@Override
	public void delete(Integer id) {
		Factura f=this.consultar(id);
		this.entityManager.remove(f);
	}
	



	//---------
	//INNER JOIN
	@Override
	public List<Factura> buscarFacturaInnerJoin(BigDecimal precio) {
		TypedQuery<Factura> myQuery=this.entityManager.createQuery(
				"SELECT f FROM Factura f JOIN f.detalles d WHERE d.subtotal> :datoPrecio", 
				Factura.class);
		myQuery.setParameter("datoPrecio", precio);
		return myQuery.getResultList();
	}

	
	//OUTER JOIN LEFT
	@Override
	public List<Factura> buscarFacturaOuterJoinLeft(BigDecimal precio) {
		TypedQuery<Factura> myQuery=this.entityManager.createQuery(
				"SELECT f FROM Factura f LEFT JOIN f.detalles d WHERE d.subtotal> : datoPrecio ", 
				Factura.class);
		myQuery.setParameter("datoPrecio", precio);
		return myQuery.getResultList();
	}


	//OUTER JOIN RIGHT
	@Override
	public List<Factura> buscarFacturaOuterJoinRight(Integer cantidad) {
		TypedQuery<Factura> myQuery=this.entityManager.createQuery(
				"SELECT f FROM Factura f RIGHT JOIN f.detalles d WHERE d.cantidad> : datoCantidad ", 
				Factura.class);
		myQuery.setParameter("datoCantidad", cantidad);
		return myQuery.getResultList();
	}

	//WHERE JOIN 
	@Override
	public List<Factura> buscarFacturaJoinWhere(BigDecimal precio) {
		TypedQuery<Factura> myQuery=this.entityManager.createQuery(
				"SELECT f FROM Factura f, Detalle d WHERE f.id=d.factura AND d.subtotal> :datoPrecio",
				Factura.class);
		myQuery.setParameter("datoPrecio", precio);
		return myQuery.getResultList();
	}

	//FETCH JOIN
	@Override
	public List<Factura> buscarFacturaJoinFetch(BigDecimal precio) {
		TypedQuery<Factura> myQuery=this.entityManager.createQuery(
				"SELECT f FROM Factura f JOIN FETCH f.detalles d WHERE d.subtotal> :datoPrecio",
				Factura.class);
		myQuery.setParameter("datoPrecio", precio);
		return myQuery.getResultList();
	}
	
	
	
	
	
	
	
	
	
	
	
//	@Override
//	public List<Factura> buscarFacturaInnerJoin(Integer cantidadDetalle) {
//		// TODO Auto-generated method stub
//		TypedQuery<Factura> myQuery = this.entityManager.createQuery(
//				"SELECT f FROM Factura f JOIN f.detalles d WHERE d.cantidad = :cantidadDetalle", Factura.class);
//		myQuery.setParameter("cantidadDetalle", cantidadDetalle);
//		
//		
//		List<Factura> facturas = myQuery.getResultList();
//		for(Factura f: facturas) {
//			f.getDetalles().size();
//		}
//		
//		return facturas;
//	}
//
//	@Override
//	public List<Factura> buscarFacturaInnerJoin() {
//		// TODO Auto-generated method stub
//		TypedQuery<Factura> myQuery = this.entityManager.createQuery(
//				"SELECT f FROM Factura f JOIN f.detalles d", Factura.class);
//		return myQuery.getResultList();
//	}
//
//	@Override
//	public List<Factura> buscarFacturaOuterJoinLeft(Integer cantidadDetalle) {
//		// TODO Auto-generated method stub
//		TypedQuery<Factura> myQuery = this.entityManager.createQuery(
//				"SELECT f FROM Factura f LEFT JOIN f.detalles d WHERE d.cantidad = :cantidadDetalle", Factura.class);
//		myQuery.setParameter("cantidadDetalle", cantidadDetalle);
//		return myQuery.getResultList();
//	}
//
//	@Override
//	public List<Factura> buscarFacturaOuterJoinLeft() {
//		// TODO Auto-generated method stub
//		TypedQuery<Factura> myQuery = this.entityManager.createQuery(
//				"SELECT f FROM Factura f LEFT JOIN f.detalles d", Factura.class);
//		return myQuery.getResultList();
//	}
//
//	@Override
//	public List<Factura> buscarFacturaOuterJoinRight(Integer cantidadDetalle) {
//		// TODO Auto-generated method stub
//		TypedQuery<Factura> myQuery = this.entityManager.createQuery(
//				"SELECT f FROM Factura f RIGHT JOIN f.detalles d WHERE d.cantidad = :cantidadDetalle", Factura.class);
//		myQuery.setParameter("cantidadDetalle", cantidadDetalle);
//		return myQuery.getResultList();
//	}
//
//	@Override
//	public List<Factura> buscarFacturaJoinWhere(Integer cantidadDetalle) {
//		// TODO Auto-generated method stub
//		TypedQuery<Factura> myQuery = this.entityManager.createQuery(
//				"SELECT f FROM Factura f, DetalleFactura d WHERE f = d.factura AND d.cantidad = :cantidadDetalle", Factura.class);
//		myQuery.setParameter("cantidadDetalle", cantidadDetalle);
//		return myQuery.getResultList();
//	}
//
//	@Override
//	public List<Factura> buscarFacturaJoinFetch(Integer cantidadDetalle) {
//		// TODO Auto-generated method stub
//		TypedQuery<Factura> myQuery = this.entityManager.createQuery(
//				"SELECT f FROM Factura f JOIN FETCH f.detalles d WHERE d.cantidad = :cantidadDetalle", Factura.class);
//		myQuery.setParameter("cantidadDetalle", cantidadDetalle);
//		return myQuery.getResultList();
//	}

}
