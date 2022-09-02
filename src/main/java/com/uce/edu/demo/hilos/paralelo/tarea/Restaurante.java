package com.uce.edu.demo.hilos.paralelo.tarea;

import java.util.concurrent.TimeUnit;

public class Restaurante extends Thread{

	private Repartidor repartidor;

	public Restaurante(Repartidor repartidor) {
		this.repartidor = repartidor;
	}

	public void run() {
		this.iniciarSesion(this.repartidor);
	}
	
	private void iniciarSesion(Repartidor repartidor) {
		
		long tiempoInicial = System.currentTimeMillis();
		
		System.out.println("Nombre del hilo: " + Thread.currentThread().getName());
		System.out.println("Escogiendo repartidor: "+repartidor.getNombre());

		for(String cliente: repartidor.getClientes()) {
			this.entregarPedidoCliente(cliente);
		}
		long tiempoFinal = System.currentTimeMillis();
		long tiempoTranscurrido=(tiempoFinal-tiempoInicial)/1000;
		
		System.out.println("\nTermino: "+repartidor.getNombre() + " en " + tiempoTranscurrido + " seg");
	}
	
	private void entregarPedidoCliente(String cliente) {
		System.out.println("Atendiendo a: " + cliente);
		//Demorar el metodo 10 seg
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
