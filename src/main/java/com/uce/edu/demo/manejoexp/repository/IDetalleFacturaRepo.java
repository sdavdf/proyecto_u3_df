package com.uce.edu.demo.manejoexp.repository;

import com.uce.edu.demo.manejoexp.repository.modelo.DetalleFactura;

public interface IDetalleFacturaRepo {
	
	public void insertar(DetalleFactura detalle);

	public void actualizar(DetalleFactura detalle);

	public void eliminar(Integer id);

	public DetalleFactura buscar(Integer id);

}
