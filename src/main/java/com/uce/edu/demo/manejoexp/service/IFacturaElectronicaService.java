package com.uce.edu.demo.manejoexp.service;

import com.uce.edu.demo.manejoexp.repository.modelo.Factura;
import com.uce.edu.demo.manejoexp.repository.modelo.FacturaElectronica;

public interface IFacturaElectronicaService {

	
	public void insertar(FacturaElectronica facturaElectronica);
	
	public void crearFacturaSRI(Factura factura);

	public void actualizar(FacturaElectronica facturaElectronica);

	public void eliminar(Integer id);

	public FacturaElectronica buscar(Integer id);

	public FacturaElectronica buscarPorNumero(String numero);
}