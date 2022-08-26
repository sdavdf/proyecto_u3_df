package com.uce.edu.demo.colegio.service.funcional;

@FunctionalInterface
public interface IAlumnoSupplier<T> {
	public T getNombre();
}
