package com.uce.edu.demo.cajero.service;

import java.math.BigDecimal;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.ProyectoU3DfApplication;
import com.uce.edu.demo.cajero.repository.IFacturaRepository;
import com.uce.edu.demo.cajero.repository.modelo.Detalle;
import com.uce.edu.demo.cajero.repository.modelo.Factura;

@Service
public class FacturaServiceImpl implements IFacturaService {

	private static Logger log = Logger.getLogger(ProyectoU3DfApplication.class);

	@Autowired
	private IFacturaRepository facturaRepository;

	// CRUD
	@Override
	public Factura consultar(Integer id) {
		return this.facturaRepository.consultar(id);
	}

	@Override
	public void create(Factura f) {
		this.facturaRepository.create(f);
	}

	@Override
	public void update(Factura f) {
		this.facturaRepository.update(f);
	}

	@Override
	public void delete(Integer id) {
		this.facturaRepository.delete(id);
	}


	@Override
	public BigDecimal calcularPrecio(Integer id) {
		Factura f = this.facturaRepository.consultar(id);
		List<Detalle> productos = f.getDetalles();
		BigDecimal valorFactura = new BigDecimal(0);

		for (Detalle p : productos) {
			BigDecimal cantidad = new BigDecimal(p.getCantidad());
			BigDecimal totalProducto = p.getPrecio().multiply(cantidad);
			valorFactura = valorFactura.add(totalProducto);
//			valorFactura = valorFactura.multiply(new BigDecimal(112));
//			valorFactura = valorFactura.divide(new BigDecimal(100));
		}

		return valorFactura;

	}

	@Override
	public int cantidad(Integer id) {
		Factura f = this.facturaRepository.consultar(id);
		List<Detalle> productos = f.getDetalles();
		int canasta = 0;

		for (Detalle p : productos) {
			canasta = canasta + p.getCantidad();
		}

		return canasta;
	}
	// -----------------------------------------------------------

	// -------------
	// INNER JOIN
	@Override
	public List<Factura> buscarFacturaInnerJoin(BigDecimal precio) {
		return this.facturaRepository.buscarFacturaInnerJoin(precio);
	}

	// OUTER LEFT JOIN
	@Override
	public List<Factura> buscarFacturaOuterJoinLeft(BigDecimal precio) {
		return this.facturaRepository.buscarFacturaOuterJoinLeft(precio);
	}

	// OUTER RIGHT JOIN
	@Override
	public List<Factura> buscarFacturaOuterJoinRight(Integer cantidad) {
		return this.facturaRepository.buscarFacturaOuterJoinRight(cantidad);
	}

	// WHERE JOIN
	@Override
	public List<Factura> buscarFacturaJoinWhere(BigDecimal precio) {
		return this.facturaRepository.buscarFacturaJoinWhere(precio);
	}

	// FETCH JOIN
	@Override
	public List<Factura> buscarFacturaJoinFetch(BigDecimal precio) {
		return this.facturaRepository.buscarFacturaJoinFetch(precio);
	}

//	@Autowired
//	private IFacturaRepository facturaRepository;
//
//	@Override
//	public List<Factura> buscarFacturaInnerJoin(Integer cantidadDetalle) {
//		// TODO Auto-generated method stub
//		return this.facturaRepository.buscarFacturaInnerJoin(cantidadDetalle);
//	}
//
//	@Override
//	public List<Factura> buscarFacturaInnerJoin() {
//		// TODO Auto-generated method stub
//		return this.facturaRepository.buscarFacturaInnerJoin();
//	}
//
//	@Override
//	public List<Factura> buscarFacturaOuterJoinLeft(Integer cantidadDetalle) {
//		// TODO Auto-generated method stub
//		return this.facturaRepository.buscarFacturaOuterJoinLeft(cantidadDetalle);
//	}
//
//	@Override
//	public List<Factura> buscarFacturaOuterJoinLeft() {
//		// TODO Auto-generated method stub
//		return this.facturaRepository.buscarFacturaOuterJoinLeft();
//	}
//
//	@Override
//	public List<Factura> buscarFacturaOuterJoinRight(Integer cantidadDetalle) {
//		// TODO Auto-generated method stub
//		return this.facturaRepository.buscarFacturaOuterJoinRight(cantidadDetalle);
//	}
//
//	@Override
//	public List<Factura> buscarFacturaJoinWhere(Integer cantidadDetalle) {
//		// TODO Auto-generated method stub
//		return this.facturaRepository.buscarFacturaJoinWhere(cantidadDetalle);
//	}
//
//	@Override
//	public List<Factura> buscarFacturaJoinFetch(Integer cantidadDetalle) {
//		// TODO Auto-generated method stub
//		log.info("Transacción activa Repository: "+ TransactionSynchronizationManager.isActualTransactionActive());
//		return this.facturaRepository.buscarFacturaJoinFetch(cantidadDetalle);
//	}

}
