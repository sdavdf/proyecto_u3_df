package com.uce.edu.demo.service.funcional;

import org.apache.log4j.Logger;

import com.uce.edu.demo.ProyectoU3DfApplication;

public class MainInterfacesFuncionales {

	private static Logger log = Logger.getLogger(ProyectoU3DfApplication.class);
	
	
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
	
	
	//CONSUMER
	//Clases
	IPersonaConsumer<String> consumerClase = new PersonaConsumerImpl();
	consumerClase.accept("Prueba Consumer");
	
	//Lambdas
	IPersonaConsumer<String> consumerLambda = cadena -> System.out.println(cadena);
	consumerLambda.accept("Prueba Consumer Lambda");
	
	
	// Metodos High Order
	
	metodosHO.consumirConsumer(valor -> System.out.println(valor), 2);
	
	//PREDICATE
	//Clases
	
	//Lambdas
	IPersonaPredicate<String> predicateLambda = cadena -> cadena.contains("Z");
	log.info("Supplier Lambdas: "+predicateLambda.evaluar("Edison"));
	

	// Metodos High Order
	boolean respuesta = metodosHO.consumirPredicate(cadena -> cadena.contains("Z"), "Zoila");
	log.info("HO Predicate" + respuesta);
	
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
