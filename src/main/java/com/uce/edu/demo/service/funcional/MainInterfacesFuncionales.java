package com.uce.edu.demo.service.funcional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.apache.log4j.Logger;

import com.uce.edu.demo.ProyectoU3DfApplication;

public class MainInterfacesFuncionales {

	private static Logger log = Logger.getLogger(ProyectoU3DfApplication.class);

	public static void imprimir(String cadena) {
		log.info("Impresión: " + cadena);
	}
	
	
	public static void main(String[] args) {
		
		ConsumoMetodosHighOrder metodosHO = new ConsumoMetodosHighOrder();
	
	//SUPPLIER
	//Clases
	IPersonaSupplier<String> supplier = new PersonaSupplierImpl();
	log.info("Supplier Clase: " + supplier.getNombre());
	
	IPersonaSupplier<String> supplierTE = new PersonaSupplierImpl();
	log.info("Supplier Clase: " + supplierTE.getNombre());
	
	//Lambdas
	IPersonaSupplier<String> supplierLambda = () -> "Edison2";
	log.info("Supplier Lambdas: " + supplierLambda.getNombre());
	
	IPersonaSupplier<String> supplierLambdaTE = () -> "Daniel TE2";
	log.info("Supplier Lambdas: " + supplierLambdaTE.getNombre());
	
	// Metodo High Order
		String valorHO = metodosHO.consumirSupplier(() -> "hola mundo");
		log.info("HO Supplier: "+valorHO);
		
		String valorHO1 = metodosHO.consumirSupplier(() -> {
			String valorConsultado = "1274398598";
				return valorConsultado;}
		);
		log.info("HO Supplier: "+valorHO1);
	
	// JAVA
	log.info("JAVA Supplier");	
	Stream<String> test = Stream.generate(() -> "Edison 3").limit(2);
	test.forEach(cadena -> System.out.println(cadena));
		
	
	//CONSUMER
	//Clases
	IPersonaConsumer<String> consumerClase = new PersonaConsumerImpl();
	consumerClase.accept("Prueba Consumer");
	
	//Lambdas
	IPersonaConsumer<String> consumerLambda = cadena -> System.out.println(cadena);
	consumerLambda.accept("Prueba Consumer Lambda");
	
	
	// Metodos High Order
	
	metodosHO.consumirConsumer(valor -> System.out.println(valor), 2);
	
	// JAVA
	log.info("JAVA Consumer");
	List<Integer> listaNumeros = Arrays.asList(1,2,3,4,5);
	listaNumeros.forEach(numero -> System.out.println(numero));
	
	//PREDICATE
	//Clases
	
	//Lambdas
	IPersonaPredicate<String> predicateLambda = cadena -> cadena.contains("Z");
	log.info("Supplier Lambdas: "+predicateLambda.evaluar("Edison"));
	

	// Metodos High Order
	boolean respuesta = metodosHO.consumirPredicate(cadena -> cadena.contains("Z"), "Zoila");
	log.info("HO Predicate" + respuesta);
	
	//JAVA
	log.info("JAVA Predicate");
	Stream<Integer> nuevaLista = listaNumeros.stream().filter(numero -> numero >= 3);
	nuevaLista.forEach(numero -> System.out.println(numero));
	
	//FUNCTION
	//Clases
	
	//Lambdas
	IPersonaFunction<Integer, String> funtionLambda = cadena -> {
		Integer valor = Integer.parseInt(cadena);
		Integer valorFinal = valor-2;
		return valorFinal;
	};
	log.info("Function Lambdas: "+funtionLambda.aplicar("7"));
	
	// Metodos High Order
	String valorFinalHO = metodosHO.consumirFunction(valor -> {
		String retorn = valor.toString() + "A";
		return retorn;
	}, 1);
	log.info("HO Function: "+valorFinalHO);
	
	//JAVA
	log.info("JAVA Function");
	//Conversiones/cast Empleado -> EmpleadoDTO (Ligero)
	Stream<String> listaCambiada = listaNumeros.stream().map(numeroLista -> {
		Integer valor = numeroLista + 1;
		String cadena = "num: "+valor.toString();
		return cadena;
	});
	listaCambiada.forEach(valor -> imprimir(valor));
	
//	List<String> lista1 = new ArrayList<>();
//	Map<String,String> mpa1 = new HashMap<String, String>();
	
	//UNARY OPERATOR(FUNCTION)
	//Clases
	
	//Lambdas
	IPersonaUnaryOperator<String> unaryLambda = cade -> {
		String valorFinal = cade.concat("subfijo");
		return valorFinal;
	};
	log.info("Unary Lambdas: "+ unaryLambda.apply("Daniel"));
	
	
}

}
