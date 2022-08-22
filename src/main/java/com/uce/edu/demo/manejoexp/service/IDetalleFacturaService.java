package com.uce.edu.demo.manejoexp.service;

import com.uce.edu.demo.manejoexp.repository.modelo.DetalleFactura;

public interface IDetalleFacturaService {
	
	public void insertar(DetalleFactura detalle);

	public void actualizar(DetalleFactura detalle);

	public void eliminar(Integer id);

	public DetalleFactura buscar(Integer id);

}
