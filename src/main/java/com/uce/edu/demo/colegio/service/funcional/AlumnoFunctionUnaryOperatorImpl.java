package com.uce.edu.demo.colegio.service.funcional;

public class AlumnoFunctionUnaryOperatorImpl implements IAlumnoFunctionUnaryOperator<String>{

	@Override
	public String aplicar(String arg1) {
		// TODO Auto-generated method stub
		String cadenaFinal= arg1.concat(" Prueba completada");
		
		return cadenaFinal;
	}
}
