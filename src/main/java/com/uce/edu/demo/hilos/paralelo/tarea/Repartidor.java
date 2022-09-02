package com.uce.edu.demo.hilos.paralelo.tarea;

import java.util.List;

public class Repartidor {

	private String nombre;
	private List<String> clientes;

	public Repartidor(String nombre, List<String> clientes) {
		super();
		this.nombre = nombre;
		this.clientes = clientes;
	}

	// SET y GET
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<String> getClientes() {
		return clientes;
	}

	public void setClientes(List<String> clientes) {
		this.clientes = clientes;
	}

}
