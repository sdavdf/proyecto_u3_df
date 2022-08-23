package com.uce.edu.demo.service.funcional;

import org.apache.log4j.Logger;

import com.uce.edu.demo.ProyectoU3DfApplication;

public class MainInterfacesFuncionales {

	private static Logger log = Logger.getLogger(ProyectoU3DfApplication.class);
	
	
	public static void main(String[] args) {
	
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
	
	
	//CONSUMER
	//Clases
	IPersonaConsumer<String> consumerClase = new PersonaConsumerImpl();
	consumerClase.accept("Prueba Consumer");
	
	//Lambdas
	IPersonaConsumer<String> consumerLambda = cadena -> System.out.println(cadena);
	consumerLambda.accept("Prueba Consumer Lambda");
	
	
	//PREDICATE
	//Clases
	
	//Lambdas
	
	//FUNCTION
	//Clases
	
	//Lambdas
	
	//UNARY OPERATOR(FUNCTION)
	//Clases
	
	//Lambdas
}

}
