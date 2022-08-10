package com.uce.edu.demo.cajero.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.uce.edu.demo.ProyectoU3DfApplication;
import com.uce.edu.demo.cajero.repository.IFacturaRepository;
import com.uce.edu.demo.cajero.repository.modelo.Factura;

@Service
public class FacturaServiceImpl implements IFacturaService{
	
	private static Logger log = Logger.getLogger(ProyectoU3DfApplication.class);
	
	@Autowired
	private IFacturaRepository facturaRepository;

	@Override
	public List<Factura> buscarFacturaInnerJoin(Integer cantidadDetalle) {
		// TODO Auto-generated method stub
		return this.facturaRepository.buscarFacturaInnerJoin(cantidadDetalle);
	}

	@Override
	public List<Factura> buscarFacturaInnerJoin() {
		// TODO Auto-generated method stub
		return this.facturaRepository.buscarFacturaInnerJoin();
	}

	@Override
	public List<Factura> buscarFacturaOuterJoinLeft(Integer cantidadDetalle) {
		// TODO Auto-generated method stub
		return this.facturaRepository.buscarFacturaOuterJoinLeft(cantidadDetalle);
	}

	@Override
	public List<Factura> buscarFacturaOuterJoinLeft() {
		// TODO Auto-generated method stub
		return this.facturaRepository.buscarFacturaOuterJoinLeft();
	}

	@Override
	public List<Factura> buscarFacturaOuterJoinRight(Integer cantidadDetalle) {
		// TODO Auto-generated method stub
		return this.facturaRepository.buscarFacturaOuterJoinRight(cantidadDetalle);
	}

	@Override
	public List<Factura> buscarFacturaJoinWhere(Integer cantidadDetalle) {
		// TODO Auto-generated method stub
		return this.facturaRepository.buscarFacturaJoinWhere(cantidadDetalle);
	}

	@Override
	public List<Factura> buscarFacturaJoinFetch(Integer cantidadDetalle) {
		// TODO Auto-generated method stub
		log.info("Transacción activa Repository: "+ TransactionSynchronizationManager.isActualTransactionActive());
		return this.facturaRepository.buscarFacturaJoinFetch(cantidadDetalle);
	}

}
