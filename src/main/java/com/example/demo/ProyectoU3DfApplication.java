package com.example.demo;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Hotel;
import com.example.demo.service.IHotelService;

@SpringBootApplication
public class ProyectoU3DfApplication implements CommandLineRunner {
	
	private static Logger log = Logger.getLogger(ProyectoU3DfApplication.class);

	@Autowired
	private IHotelService hotelService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3DfApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		
		log.info("INNER JOIN");
		List<Hotel> listaHoteles = this.hotelService.buscarHotelInnerJoin("Familiar");
		for(Hotel h : listaHoteles) {
			log.info("Hotel: "+ h.getNombre()+"   "+h.getDireccion());
		}
		
		List<Hotel> listaHoteles2 = this.hotelService.buscarHotelInnerJoin();
		for(Hotel h : listaHoteles2) {
			log.info("Hotel: "+ h.getNombre()+"   "+h.getDireccion());
		}
		
		// LEFT
		log.info("LEFT JOIN");
		List<Hotel> listaHotelesLeft = this.hotelService.buscarHotelOuterJoinLeft("Familiar");
		for(Hotel h : listaHotelesLeft) {
			log.info("Hotel: "+ h.getNombre()+"   "+h.getDireccion());
		}
		
		log.info("LEFT JOIN");
		List<Hotel> listaHotelesLeft2 = this.hotelService.buscarHotelOuterJoinLeft();
		for(Hotel h : listaHotelesLeft2) {
			log.info("Hotel: "+ h.getNombre()+"   "+h.getDireccion());
		}
		
		// RIGHT
		log.info("RIGHT JOIN");
		List<Hotel> listaHotelesRight = this.hotelService.buscarHotelOuterJoinRight("Familiar");
		for(Hotel h : listaHotelesRight) {
			log.info("Hotel: "+ h.getNombre()+"   "+h.getDireccion());
		}
	}

}
