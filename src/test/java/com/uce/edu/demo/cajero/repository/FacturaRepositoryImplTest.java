package com.uce.edu.demo.cajero.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.uce.edu.demo.cajero.repository.modelo.Factura;

@SpringBootTest
class FacturaRepositoryImplTest {

	@Autowired
	private IFacturaRepository facturaRepository;

	@Test
	void testCompararNumero() {
		Factura f = new Factura();
		f.setId(2);
		f.setNumero("1020");
		f.setFecha(LocalDateTime.of(2022, 7, 21, 0, 0));
		f.setTotal(new BigDecimal(7.6));

		Factura f2 = this.facturaRepository.consultar(2);
		assertEquals(f.getNumero(), f2.getNumero());

	}

}