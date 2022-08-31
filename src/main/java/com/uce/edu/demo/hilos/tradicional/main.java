package com.uce.edu.demo.hilos.tradicional;

import java.util.Arrays;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long tiempoInicial = System.currentTimeMillis();
		
		System.out.println("Nombre Hilo procesar: " + Thread.currentThread().getName());
		Cajero cajero1 = new Cajero("Edison",Arrays.asList("Pepito", "Juan", "Daniela", "Kevin"));
		Cajero cajero2 = new Cajero("Stiven",Arrays.asList("Pepito2", "Juan2", "Daniela2"));
		Cajero cajero3 = new Cajero("Paul",Arrays.asList("Pepito3", "Juan3"));
		
		// Edison
		PCCajero gestorAtencion = new PCCajero();
		gestorAtencion.procesar(cajero1);
		
		// Stiven
		PCCajero gestorAtencion2 = new PCCajero();
		gestorAtencion2.procesar(cajero2);
		
		// Paul
		PCCajero gestorAtencion3 = new PCCajero();
		gestorAtencion3.procesar(cajero3);
		
		long tiempoFinal = System.currentTimeMillis();
		
		long tiempoTranscurrido=(tiempoFinal-tiempoInicial)/1000;
		System.out.println(tiempoTranscurrido + "seg");
	}

}
