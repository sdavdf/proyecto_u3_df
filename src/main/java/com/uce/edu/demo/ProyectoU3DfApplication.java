package com.uce.edu.demo;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.cajero.service.IFacturaService;
import com.uce.edu.demo.repository.modelo.Habitacion;
import com.uce.edu.demo.repository.modelo.Hotel;
import com.uce.edu.demo.service.IHotelService;

@SpringBootApplication
public class ProyectoU3DfApplication implements CommandLineRunner {

	private static Logger log = Logger.getLogger(ProyectoU3DfApplication.class);

	@Autowired
	private IHotelService hotelService;

	@Autowired
	private IFacturaService facturaService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3DfApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		log.info("RELACIONAMIENTO JOIN");
		List<Hotel> listaHoteles = this.hotelService.buscarHotelJoinWhere("Individual");
		for(Hotel h : listaHoteles) {
			log.info("Hotel: "+ h.getNombre()+"   "+h.getDireccion());
		}
		
		
		log.info("INNER JOIN EAGER/LAZY");
		List<Hotel> listaHoteles2 = this.hotelService.buscarHotelInnerJoin("Individual");
		for(Hotel h : listaHoteles2) {
			log.info("Hotel2: "+ h.getNombre()+"   "+h.getDireccion());
			for(Habitacion ha : h.getHabitaciones()) {
				log.info("Hotel2Habitaciones:" + ha);
			}
			
		}
		
		log.info("JOIN FETCH");
		List<Hotel> listaHoteles3 = this.hotelService.buscarHotelJoinFetch("Individual");
		for(Hotel h : listaHoteles3) {
			log.info("Hotel3: "+ h.getNombre()+"   "+h.getDireccion());
			for(Habitacion ha : h.getHabitaciones()) {
				log.info("Hotel3Habitaciones:" + ha);
			}
			
		}
		
		
//		log.info("INNER JOIN");
//		List<Hotel> listaHoteles = this.hotelService.buscarHotelInnerJoin("Familiar");
//		for(Hotel h : listaHoteles) {
//			log.info("Hotel: "+ h.getNombre()+"   "+h.getDireccion());
//		}
//		
//		List<Hotel> listaHoteles2 = this.hotelService.buscarHotelInnerJoin();
//		for(Hotel h : listaHoteles2) {
//			log.info("Hotel: "+ h.getNombre()+"   "+h.getDireccion());
//		}
//		
//		// LEFT
//		log.info("LEFT JOIN");
//		List<Hotel> listaHotelesLeft = this.hotelService.buscarHotelOuterJoinLeft("Familiar");
//		for(Hotel h : listaHotelesLeft) {
//			log.info("Hotel: "+ h.getNombre()+"   "+h.getDireccion());
//		}
//		
//		log.info("LEFT JOIN");
//		List<Hotel> listaHotelesLeft2 = this.hotelService.buscarHotelOuterJoinLeft();
//		for(Hotel h : listaHotelesLeft2) {
//			log.info("Hotel: "+ h.getNombre()+"   "+h.getDireccion());
//		}
//		
//		// RIGHT
//		log.info("RIGHT JOIN");
//		List<Hotel> listaHotelesRight = this.hotelService.buscarHotelOuterJoinRight("Familiar");
//		for(Hotel h : listaHotelesRight) {
//			log.info("Hotel: "+ h.getNombre()+"   "+h.getDireccion());
//		}

		////////////////////////////////////////////////////////////////////////////////////////////
//
//		log.info("INNER JOIN");
//		List<Factura> listaFacturas = this.facturaService.buscarFacturaInnerJoin(10);
//		for (Factura f : listaFacturas) {
//			log.info("Factura: " + f.getNumero() + "   " + f.getFecha());
//		}
//
//		log.info("INNER JOIN");
//		List<Factura> listaFacturas2 = this.facturaService.buscarFacturaInnerJoin();
//		for (Factura f : listaFacturas2) {
//			log.info("Factura: " + f.getNumero() + "   " + f.getFecha());
//		}
//
//		// LEFT
//		log.info("LEFT JOIN");
//		List<Factura> listaFacturasLeft = this.facturaService.buscarFacturaOuterJoinLeft(10);
//		for (Factura f : listaFacturasLeft) {
//			log.info("Factura: " + f.getNumero() + "   " + f.getFecha());
//		}
//
//		log.info("LEFT JOIN");
//		List<Factura> listaFacturasLeft2 = this.facturaService.buscarFacturaOuterJoinLeft();
//		for (Factura f : listaFacturasLeft2) {
//			log.info("Factura: " + f.getNumero() + "   " + f.getFecha());
//		}
//
//		// RIGHT
//		log.info("RIGHT JOIN");
//		List<Factura> listaFacturasRight = this.facturaService.buscarFacturaOuterJoinRight(10);
//		for (Factura f : listaFacturasRight) {
//			log.info("Factura: " + f.getNumero() + "   " + f.getFecha());
//		}

	}

}
