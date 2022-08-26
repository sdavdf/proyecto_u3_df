package com.uce.edu.demo.colegio.service.funcional;

import org.apache.log4j.Logger;

import com.uce.edu.demo.ProyectoU3DfApplication;

public class MainInterfacesFuncionales {

	private static Logger log = Logger.getLogger(ProyectoU3DfApplication.class);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MetodosHighOrder metodosHO = new MetodosHighOrder();

		// SUPPLIER
		// Clases

		IAlumnoSupplier<String> supplierClase = new AlumnoSupplierImpl();
		log.info("Supplier Clase Tarea: " + supplierClase.getNombre());

		// Lambdas

		IAlumnoSupplier<String> supplierLambdas = () -> "Stalyn David";
		log.info("Supplier Lambda Tarea: " + supplierLambdas.getNombre());

		// Metodos High Order
		String valorHO = metodosHO.consumirSupplier(() -> "Probando Lambas");
		log.info("High Order Supplier Tarea" + valorHO);

		String valorHO1 = metodosHO.consumirSupplier(() -> {
			String valorConsultado = "34";
			String valorFinal = valorConsultado.concat("concatenando...");
			return valorFinal;
		});
		log.info("High Order Supplier Tarea" + valorHO1);

		// CONSUMER
		// Clases

		IAlumnoConsumer<String> consumerClase = new AlumnoConsumer();
		consumerClase.accept("Consumer para la tarea");

		// Lambdas

		IAlumnoConsumer<String> consumerLamba = cadena -> System.out.println(cadena);
		consumerLamba.accept("Consumer para la tarea con Lambdas");

		// Metodos High Order
		metodosHO.consumirConsumer(valor -> System.out.println(valor), 23);

		// PREDICATE
		// Clases
		IAlumnoPredicate<String> predicateClase = new AlumnoPredicateImpl();
		boolean valorImprimir = predicateClase.evaluar("Stalyn");
		log.info("predicate Clase Tarea: " + valorImprimir);
		
		// Lambdas

		IAlumnoPredicate<String> predicateLamba = cadena -> cadena.contains("A");
		log.info("predicate Lamba Tarea: " + predicateLamba.evaluar("Stalyn"));

		// Metodos High Order
		boolean respuesta = metodosHO.consumirPredicate(cadena -> cadena.contains("X"), "Madelein");
		log.info("High Order predicate " + respuesta);
		
		// FUNCTION
		// Clases
		
		IAlumnoFunction<String, Integer> functionPredicate = new AlumnoFunctionImpl<>();
		String funcionImprimir = functionPredicate.aplicar(4);
		log.info("Function clase: el numero es: " + funcionImprimir);

		// Lambdas

		IAlumnoFunction<Integer, String> functionLambda = cadena -> {
			Integer valor = Integer.parseInt(cadena);
			Integer valorFinal = valor - 2;
			if (valorFinal < 23) {
				log.info("Function: Si cumple con la condicion");
				return valorFinal;
			} else {
				log.info("Function: No cumple con la condicion");
				return valorFinal + 30;
			}

		};

		log.info("Function Lamba: " + functionLambda.aplicar("9"));

		// Metodos High Order
		
		String valorFinalHO = metodosHO.consumirFunction(valor -> {
			String retorno = valor.toString() + "Ingresando datos en Function";
			return retorno;
		}, 1);
		log.info("High Order Function " + valorFinalHO);

		// UNARY OPERATOR
		
		// Clases
		
		IAlumnoFunctionUnaryOperator<String> functionUnaryOperator = new AlumnoFunctionUnaryOperatorImpl();
		String ValorPrueba = functionUnaryOperator.aplicar("Probando Unary Operator");
		log.info(ValorPrueba);

		// Lambdas

		IAlumnoFunctionUnaryOperator<String> unaryLambda = cadena -> {
			String valorFinal = cadena.concat("Pruebas de los lambdas");
			return valorFinal;
		};
		log.info("Unary Lamba: " + unaryLambda.aplicar("Stalyn"));

		// Metodos High Order
		String valorFinalHO1 = metodosHO.consumirFunction(valor -> {
			String retorno = valor.toString() + "Ingresando para Unary Operator";
			return retorno;
		}, 1);
		log.info("High Order function " + valorFinalHO1);

	}

}
