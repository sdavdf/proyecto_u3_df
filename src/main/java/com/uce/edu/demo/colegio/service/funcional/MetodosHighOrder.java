package com.uce.edu.demo.colegio.service.funcional;

public class MetodosHighOrder {

	public String consumirSupplier(IAlumnoSupplier<String> funcion) {

		return funcion.getNombre() + " Se proceso el dato";
	}

	public void consumirConsumer(IAlumnoConsumer<Integer> funcion, Integer valor) {
		funcion.accept(valor);

	}

	public boolean consumirPredicate(IAlumnoPredicate<String> funcion, String valor) {
		return funcion.evaluar(valor);
	}

	public String consumirFunction(IAlumnoFunction<String, Integer> funcion, Integer valor) {
		return funcion.aplicar(valor) + " Se proceso el dato";
	}

}
