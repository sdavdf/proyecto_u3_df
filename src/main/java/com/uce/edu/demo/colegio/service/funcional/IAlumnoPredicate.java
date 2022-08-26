package com.uce.edu.demo.colegio.service.funcional;

@FunctionalInterface
public interface IAlumnoPredicate<T> {
	public boolean evaluar(T arg1);
}
