package com.uce.edu.demo.colegio.service.funcional;

public class AlumnoPredicateImpl implements IAlumnoPredicate<String>{

	@Override
	public boolean evaluar(String arg1) {
		// TODO Auto-generated method stub
		if(arg1.equalsIgnoreCase("a")) {
			System.out.println("Verficando");
			return true;
		}else {
			System.out.println("Verficando");
			return false;
		}
		
		
	}
}
