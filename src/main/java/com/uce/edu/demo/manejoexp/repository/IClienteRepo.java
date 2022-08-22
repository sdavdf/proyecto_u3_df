package com.uce.edu.demo.manejoexp.repository;

import com.uce.edu.demo.manejoexp.repository.modelo.Cliente;

public interface IClienteRepo {
	
	public void insertar(Cliente cliente);

	public void actualizar(Cliente cliente);

	public void eliminar(Integer id);

	public Cliente buscar(Integer id);

	public Cliente buscarPorCedula(String cedula);

}
