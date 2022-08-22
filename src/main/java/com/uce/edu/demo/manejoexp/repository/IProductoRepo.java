package com.uce.edu.demo.manejoexp.repository;

import com.uce.edu.demo.manejoexp.repository.modelo.Producto;

public interface IProductoRepo {

	public void insertar(Producto producto);

	public void actualizar(Producto producto);

	public void eliminar(Integer id);

	public Producto buscar(Integer id);

	public Producto buscarPorCodigoBarras(String codigoBarras);
	
	
}
