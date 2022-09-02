package com.uce.edu.demo.colegio.service.funcional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.apache.log4j.Logger;

import com.uce.edu.demo.ProyectoU3DfApplication;

public class MainStream {

	private static Logger log = Logger.getLogger(ProyectoU3DfApplication.class);
	
	public static void imprimir(String lista) {
		log.info("Impresión: " + lista);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// SUPPLIER
		log.info("JAVA Supplier");
		Stream<Integer> numeros = Stream.generate(() -> 2).limit(4);
		numeros.forEach(cadena -> System.out.println(cadena));

		// CONSUMER
		log.info("\nJAVA Consumer");
		List<String> listaEstudiantes = Arrays.asList("Ana", "Cristian", "Sofia", "Stefany");
		listaEstudiantes.forEach(nombre -> System.out.println(nombre));

		
		// PREDICATE
		log.info("\nJAVA Predicate");
		Stream<String> nuevaLista = listaEstudiantes.stream().filter(nombre -> nombre.contains("i"));
		nuevaLista.forEach(x -> System.out.println(x));
		
		
		// FUNCTION
		log.info("\nJAVA Function");
		List<Integer> listaNumeros = Arrays.asList(3,4,6,7,8);
		Stream<String> listaCambiada = listaNumeros.stream().map(numeroLista -> {
			Integer valor = numeroLista * 2;
			String cadena = "num: "+valor.toString();
			return cadena;
		});
		listaCambiada.forEach(valor -> imprimir(valor));
		
	}

}
