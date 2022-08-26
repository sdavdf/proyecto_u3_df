package com.uce.edu.demo.colegio.service.funcional;

public class AlumnoConsumer implements IAlumnoConsumer<String>{

	@Override
	public void accept(String arg1) {
		// TODO Auto-generated method stub
		System.out.println(arg1);
	}
}
