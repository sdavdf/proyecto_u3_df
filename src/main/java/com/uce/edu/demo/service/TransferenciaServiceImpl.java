package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.ICuentaBancariaRepository;
import com.uce.edu.demo.repository.ITransferenciaRepository;
import com.uce.edu.demo.repository.modelo.CuentaBancaria;
import com.uce.edu.demo.repository.modelo.Transferencia;

@Service
public class TransferenciaServiceImpl implements ITransferenciaService {

	@Autowired
	private ICuentaBancariaRepository iCuentaBancariaRepository;
	
	@Autowired
	private ITransferenciaRepository iTransferenciaRepository;
	
	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void realizarTransferencia(String numeroCtaOrigen, String numeroCtaDestino, BigDecimal monto) {
		// TODO Auto-generated method stub

		CuentaBancaria ctaOrigen = this.iCuentaBancariaRepository.buscarPorNumero(numeroCtaOrigen);
		
		BigDecimal saldoOrigen= ctaOrigen.getSaldo();
		BigDecimal saldoFinal = saldoOrigen.subtract(monto);
		ctaOrigen.setSaldo(saldoFinal);
		this.iCuentaBancariaRepository.actualizar(ctaOrigen);
		
		CuentaBancaria ctaDestino = this.iCuentaBancariaRepository.buscarPorNumero(numeroCtaDestino);
		ctaDestino.setSaldo(ctaDestino.getSaldo().add(monto));
		this.iCuentaBancariaRepository.actualizar(ctaDestino);
				
		
		Transferencia trans = new Transferencia();
		trans.setFecha(LocalDateTime.now());
		trans.setMonto(null);
		trans.setCuentaOrigen(ctaOrigen);
		trans.setCuentaDestino(ctaDestino);
		this.iTransferenciaRepository.insertar(trans);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void realizarTransferenciaFachada(String numeroCtaOrigen, String numeroCtaDestino, BigDecimal monto) {
		// TODO Auto-generated method stub
		this.realizarTransferenciaFachada(numeroCtaOrigen, numeroCtaDestino, monto);
	}

}
