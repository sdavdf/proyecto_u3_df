package com.uce.edu.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.uce.edu.demo.ProyectoU3DfApplication;
import com.uce.edu.demo.cajero.repository.modelo.ContadorHabitaciones;
import com.uce.edu.demo.repository.modelo.Hotel;

@Repository
@Transactional
public class HotelRepositoryImpl implements IHotelRepository {

	private static Logger LOG = Logger.getLogger(HotelRepositoryImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Hotel buscarHotel(String tipo) {
		TypedQuery<Hotel> myQuery = this.entityManager
				.createQuery("SELECT h FROM Hotel h JOIN h.habitaciones ha WHERE ha.tipo= :datoTipo", Hotel.class);
		myQuery.setParameter("datoTipo", tipo);
		return myQuery.getSingleResult();
	}

	@Override
	public void insertar(Hotel h) {
		this.entityManager.persist(h);

	}

	@Override
	public Hotel buscar(Integer id) {

		return this.entityManager.find(Hotel.class, id);
	}

	@Override
	public ContadorHabitaciones contarHabitaciones(Integer id, String tipo) {
		// SELECT h.hote_direccion, ha.habi_tipo, COUNT(ha.habi_tipo) as "No
		// Habitaciones" FROM Hotel h INNER JOIN Habitacion ha GROUP BY ha.habi_tipo,
		// h.hote_id
		TypedQuery<ContadorHabitaciones> myQuery = this.entityManager.createQuery(
				"SELECT NEW com.uce.edu.demo.cajero.repository.modelo.ContadorHabitaciones(h.direccion, ha.tipo, COUNT(ha.tipo)) FROM Hotel h JOIN h.habitaciones ha WHERE h.id= :datoId AND ha.tipo= :datoTipo GROUP BY ha.tipo, h.id",
				ContadorHabitaciones.class);
		myQuery.setParameter("datoId", id);
		myQuery.setParameter("datoTipo", tipo);
		return myQuery.getSingleResult();
	}
	
	
	
	
	
	
	
	
	
	
	

	@Override
	public List<Hotel> buscarHotelInnerJoin(String tipoHabitacion) {
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery(
				"SELECT h FROM Hotel h JOIN h.habitaciones ha WHERE ha.tipo= :tipoHabitacion", Hotel.class);
		myQuery.setParameter("tipoHabitacion", tipoHabitacion);
		List<Hotel> hoteles = myQuery.getResultList();
		for (Hotel h : hoteles) {
			h.getHabitaciones().size();
		}
		return hoteles;
	}

	@Override
	public List<Hotel> buscarHotelInnerJoin2() {
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h FROM Hotel h JOIN h.habitaciones ha",
				Hotel.class);
		return myQuery.getResultList();
	}

	// LEFT JOIN ----------
	@Override
	public List<Hotel> buscarHotelOuterJoinLeft(String tipoHabitacion) {
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery(
				"SELECT h FROM Hotel h LEFT JOIN h.habitaciones ha WHERE ha.tipo= :tipoHabitacion", Hotel.class);
		myQuery.setParameter("tipoHabitacion", tipoHabitacion);
		return myQuery.getResultList();
	}

	@Override
	public List<Hotel> buscarHotelOuterJoinLeft2() {
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h FROM Hotel h LEFT JOIN h.habitaciones ha",
				Hotel.class);
		return myQuery.getResultList();
	}

	// RIGHT JOIN ----------
	@Override
	public List<Hotel> buscarHotelOuterJoinRight(String tipoHabitacion) {
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery(
				"SELECT h FROM Hotel h RIGHT JOIN h.habitaciones ha WHERE ha.tipo= :tipoHabitacion", Hotel.class);
		myQuery.setParameter("tipoHabitacion", tipoHabitacion);
		return myQuery.getResultList();
	}

	// WHERE
	@Override
	public List<Hotel> buscarHotelJoinWhere(String tipoHabitacion) {
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery(
				"SELECT h FROM Hotel h, Habitacion ha WHERE h.id= ha.hotel AND ha.tipo =:tipoHabitacion", Hotel.class);
		myQuery.setParameter("tipoHabitacion", tipoHabitacion);
		return myQuery.getResultList();
	}

	// FETCH
	@Override
	// @Transactional(value = TxType.MANDATORY)
	public List<Hotel> buscarHotelJoinFetch(String tipoHabitacion) {
		LOG.info("Funciona: " + org.springframework.transaction.support.TransactionSynchronizationManager
				.isActualTransactionActive());

		TypedQuery<Hotel> myQuery = this.entityManager.createQuery(
				"SELECT h FROM Hotel h JOIN FETCH h.habitaciones ha WHERE ha.tipo =:tipoHabitacion", Hotel.class);
		myQuery.setParameter("tipoHabitacion", tipoHabitacion);
		return myQuery.getResultList();
	}

//	private static Logger log = Logger.getLogger(ProyectoU3DfApplication.class);
//
//	@PersistenceContext
//	private EntityManager entityManager;
//
//	@Override
//	public List<Hotel> buscarHotelInnerJoin(String tipoHabitacion) {
//		// TODO Auto-generated method stub
//		TypedQuery<Hotel> myQuery = this.entityManager.createQuery(
//				"SELECT h FROM Hotel h JOIN h.habitaciones ha WHERE ha.tipo = :tipoHabitacion", Hotel.class);
//		myQuery.setParameter("tipoHabitacion", tipoHabitacion);
//		
//		List<Hotel> hoteles = myQuery.getResultList();
//		for(Hotel h: hoteles) {
//			h.getHabitaciones().size();
//		}
//		
//		return hoteles;
//	}
//	
//	
//	@Override
//	public List<Hotel> buscarHotelInnerJoin() {
//		// TODO Auto-generated method stub
//		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h FROM Hotel h JOIN h.habitaciones ha",
//				Hotel.class);
//		return myQuery.getResultList();
//	}
//
//	@Override
//	public List<Hotel> buscarHotelOuterJoinLeft(String tipoHabitacion) {
//		// TODO Auto-generated method stub
//		TypedQuery<Hotel> myQuery = this.entityManager.createQuery(
//				"SELECT h FROM Hotel h LEFT JOIN h.habitaciones ha WHERE ha.tipo = :tipoHabitacion", Hotel.class);
//		myQuery.setParameter("tipoHabitacion", tipoHabitacion);
//		return myQuery.getResultList();
//	}
//
//	@Override
//	public List<Hotel> buscarHotelOuterJoinLeft() {
//		// TODO Auto-generated method stub
//		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h FROM Hotel h LEFT JOIN h.habitaciones ha",
//				Hotel.class);
//		return myQuery.getResultList();
//	}
//
//	@Override
//	public List<Hotel> buscarHotelOuterJoinRight(String tipoHabitacion) {
//		// TODO Auto-generated method stub
//		TypedQuery<Hotel> myQuery = this.entityManager.createQuery(
//				"SELECT h FROM Hotel h RIGHT JOIN h.habitaciones ha WHERE ha.tipo = :tipoHabitacion", Hotel.class);
//		myQuery.setParameter("tipoHabitacion", tipoHabitacion);
//		return myQuery.getResultList();
//	}
//
//	@Override
//	public List<Hotel> buscarHotelJoinWhere(String tipoHabitacion) {
//		// TODO Auto-generated method stub
//		TypedQuery<Hotel> myQuery = this.entityManager.createQuery(
//				"SELECT h FROM Hotel h, Habitacion ha WHERE h = ha.hotel AND ha.tipo = :tipoHabitacion", Hotel.class);
//		myQuery.setParameter("tipoHabitacion", tipoHabitacion);
//		return myQuery.getResultList();
//	}
//
//	@Override
////	@Transactional(value = TxType.MANDATORY)
//	public List<Hotel> buscarHotelJoinFetch(String tipoHabitacion) {
//		// TODO Auto-generated method stub
//		log.info("Transacción activa Repository: "+ TransactionSynchronizationManager.isActualTransactionActive());
//		TypedQuery<Hotel> myQuery = this.entityManager.createQuery(
//				"SELECT h FROM Hotel h JOIN FETCH h.habitaciones ha WHERE ha.tipo = :tipoHabitacion", Hotel.class);
//		myQuery.setParameter("tipoHabitacion", tipoHabitacion);
//		return myQuery.getResultList();
//	}

}
