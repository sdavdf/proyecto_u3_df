package com.uce.edu.demo.hilos.paralelo;

import java.util.Arrays;

import com.uce.edu.demo.hilos.tradicional.Cajero;
import com.uce.edu.demo.hilos.tradicional.PCCajero;

public class MainParalelo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		long tiempoInicial = System.currentTimeMillis();

		System.out.println("Nombre Hilo procesar: " + Thread.currentThread().getName());
		CajeroParalelo cajero1 = new CajeroParalelo("Edison", Arrays.asList("Pepito"));
		CajeroParalelo cajero2 = new CajeroParalelo("Stiven", Arrays.asList("Pepito2"));
		CajeroParalelo cajero3 = new CajeroParalelo("Paul", Arrays.asList("Pepito3"));

		CajeroParalelo cajero4 = new CajeroParalelo("Edison", Arrays.asList("Juan"));
		CajeroParalelo cajero5 = new CajeroParalelo("Stiven", Arrays.asList("Juan2"));
		CajeroParalelo cajero6 = new CajeroParalelo("Paul", Arrays.asList("Juan3"));

		// Edison
		PCCajeroParalelo gestorAtencion = new PCCajeroParalelo(cajero1);
		gestorAtencion.start();

		// Stiven
		PCCajeroParalelo gestorAtencion2 = new PCCajeroParalelo(cajero2);
		gestorAtencion2.start();

		// Paul
		PCCajeroParalelo gestorAtencion3 = new PCCajeroParalelo(cajero3);
		gestorAtencion3.start();

		// Edison
		PCCajeroParalelo gestorAtencion4 = new PCCajeroParalelo(cajero1);
		gestorAtencion4.start();

		// Stiven
		PCCajeroParalelo gestorAtencion5 = new PCCajeroParalelo(cajero2);
		gestorAtencion5.start();

		// Paul
		PCCajeroParalelo gestorAtencion6 = new PCCajeroParalelo(cajero3);
		gestorAtencion6.start();

		long tiempoFinal = System.currentTimeMillis();

		long tiempoTranscurrido = (tiempoFinal - tiempoInicial) / 1000;
		System.out.println(tiempoTranscurrido + "seg");
	}

}
