package com.uce.edu.demo.repository;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Hotel;

public interface IHotelRepository {

	public List<Hotel> buscarHotelInnerJoin(String tipoHabitacion);
	
	public List<Hotel> buscarHotelInnerJoin();
	
	public List<Hotel> buscarHotelOuterJoinLeft(String tipoHabitacion);
	
	public List<Hotel> buscarHotelOuterJoinLeft();

	public List<Hotel> buscarHotelOuterJoinRight(String tipoHabitacion);
	
	public List<Hotel> buscarHotelJoinWhere(String tipoHabitacion);
	
	public List<Hotel> buscarHotelJoinFetch(String tipoHabitacion);
}
