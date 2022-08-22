package com.uce.edu.demo.manejoexp.service;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.manejoexp.repository.IClienteRepo;
import com.uce.edu.demo.manejoexp.repository.modelo.Cliente;

@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private IClienteRepo iClienteRepository;

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void insertar(Cliente cliente) {
		this.iClienteRepository.insertar(cliente);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void actualizar(Cliente cliente) {
		this.iClienteRepository.actualizar(cliente);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void eliminar(Integer id) {
		this.iClienteRepository.eliminar(id);
	}

	@Override
	public Cliente buscar(Integer id) {
		return this.iClienteRepository.buscar(id);
	}

	@Override
	public Cliente buscarPorCedula(String cedula) {
		return this.iClienteRepository.buscarPorCedula(cedula);
	}

}