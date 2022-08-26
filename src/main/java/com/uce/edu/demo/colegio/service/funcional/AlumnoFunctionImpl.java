package com.uce.edu.demo.colegio.service.funcional;

public class AlumnoFunctionImpl<String> implements IAlumnoFunction<String, Integer> {

	@Override
	public String aplicar(Integer arg1) {
		// TODO Auto-generated method stub
		String valor =  (String) arg1.toString();
		
		return valor;
	}
}
