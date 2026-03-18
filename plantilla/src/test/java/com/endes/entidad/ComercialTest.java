package com.endes.entidad;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ComercialTest {
	
	Comercial comercial;
	@Test
	void test() throws Exception{
		comercial = new Comercial("12345678A", "Marco", "Florencio", 500.0, 1000.0);
	}
	
	@Test
	void testGetVentas() {
        double resultadoEsperado = 1000.0;
        double resultadoActual = Double.valueOf(comercial.getVentas());
        assertEquals(resultadoEsperado, resultadoActual);
	}
	
	void testSetVentas(double ventas) {
		comercial.setVentas(ventas);
		Double resultadoEsperado = Double.valueOf(ventas);
		Double resultadoActual = Double.valueOf(comercial.getVentas());
		assertEquals(resultadoEsperado, resultadoActual);
		
	}
	
	void testVentasNegativo() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> comercial.setVentas(-500.0));
		String mensajeEsperado = "Las ventas no pueden ser negativas";
		String mensajeActual = exception.getMessage();
		assertEquals(mensajeEsperado, mensajeActual);
	}
	
	void textCalcularExtra() {
		double resultadoEsperado = 100.0;
		double resultadoActual = comercial.calcularExtra();
		assertEquals(resultadoEsperado, resultadoActual);
	}
	
	void testGetSueldo() {
		double resultadoEsperado = 600.0;
		double resultadoActual = comercial.getSueldo();
		assertEquals(resultadoEsperado, resultadoActual);
	}
}
