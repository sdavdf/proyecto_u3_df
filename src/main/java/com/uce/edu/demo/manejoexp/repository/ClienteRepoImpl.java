package com.uce.edu.demo.manejoexp.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.manejoexp.repository.modelo.Cliente;

@Repository
@Transactional
public class ClienteRepoImpl implements IClienteRepo {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertar(Cliente cliente) {
		this.entityManager.persist(cliente);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void actualizar(Cliente cliente) {
		this.entityManager.merge(cliente);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void eliminar(Integer id) {
		this.entityManager.remove(this.buscar(id));
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Cliente buscar(Integer id) {
		return this.entityManager.find(Cliente.class, id);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Cliente buscarPorCedula(String cedula) {
		TypedQuery<Cliente> myQuery = this.entityManager
				.createQuery("Select c FROM Cliente c WHERE c.cedula = :datocedula", Cliente.class);
		myQuery.setParameter("datocedula", cedula);
		return myQuery.getSingleResult();
	}

}
