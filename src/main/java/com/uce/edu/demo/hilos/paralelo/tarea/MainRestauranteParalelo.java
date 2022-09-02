package com.uce.edu.demo.hilos.paralelo.tarea;

import java.util.Arrays;

public class MainRestauranteParalelo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Repartidor repar1 = new Repartidor("Juan", Arrays.asList("Andrea, Angel"));
		Repartidor repar2 = new Repartidor("Andres", Arrays.asList("Andrea2, Angel2"));
		Repartidor repar3 = new Repartidor("Danilo", Arrays.asList("Andrea3, Angel3"));
		Repartidor repar4 = new Repartidor("María", Arrays.asList("Andrea4, Angel4"));
		Repartidor repar5 = new Repartidor("Alejandro", Arrays.asList("Andrea5, Angel5"));
		
		Restaurante gestorAtencion1 = new Restaurante(repar1);
		gestorAtencion1.start();
		
		Restaurante gestorAtencion2 = new Restaurante(repar2);
		gestorAtencion2.start();
		
		Restaurante gestorAtencion3 = new Restaurante(repar3);
		gestorAtencion3.start();
		
		Restaurante gestorAtencion4 = new Restaurante(repar4);
		gestorAtencion4.start();
		
		Restaurante gestorAtencion5 = new Restaurante(repar5);
		gestorAtencion5.start();
	}

}
