package com.uce.edu.demo.colegio.service.funcional;

@FunctionalInterface
public interface IAlumnoConsumer<T>  {

	public void accept(T arg1);

}
