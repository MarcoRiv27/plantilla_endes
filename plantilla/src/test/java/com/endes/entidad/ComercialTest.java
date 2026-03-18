package com.endes.entidad;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ComercialTest {
	
	Comercial comercial;
	@BeforeEach
	void test() throws Exception{
		comercial = new Comercial("12345678A", "Marco", "Florencio", 500.0, 1000.0);
	}
	
	/**
	 * @param ventas Obtener las ventas.
	 */
	@Test
	void testGetVentas() {
        double resultadoEsperado = 1000.0;
        double resultadoActual = Double.valueOf(comercial.getVentas());
        assertEquals(resultadoEsperado, resultadoActual);
	}
	
	
	/**
	 * @param ventas Valor de ventas a establecer en el comercial.
	 */
	@Test
	void testSetVentas(double ventas) {
		comercial.setVentas(ventas);
		Double resultadoEsperado = Double.valueOf(ventas);
		Double resultadoActual = Double.valueOf(comercial.getVentas());
		assertEquals(resultadoEsperado, resultadoActual);
		
	}
	
	/**
	 * @param ventas Valor de ventas negativo a establecer en el comercial.
	 * @throws IllegalArgumentException Si se intenta establecer un valor de ventas negativo.
	 */
	@Test
	void testVentasNegativo() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> comercial.setVentas(-500.0));
		String mensajeEsperado = "Las ventas no pueden ser negativas";
		String mensajeActual = exception.getMessage();
		assertEquals(mensajeEsperado, mensajeActual);
	}
	
	/**
	 * Prueba que verifica que el método calcularExtra() devuelve el extra correcto
	 */
	@Test
	void textCalcularExtra() {
		double resultadoEsperado = 100.0;
		double resultadoActual = comercial.calcularExtra();
		assertEquals(resultadoEsperado, resultadoActual);
	}
	
	/**
	 * @param sueldo Obtener el sueldo total del comercial, incluyendo el bono por ventas.
	 */
	@Test
	void testGetSueldo() {
		double resultadoEsperado = 600.0;
		double resultadoActual = comercial.getSueldo();
		assertEquals(resultadoEsperado, resultadoActual);
	}
}
