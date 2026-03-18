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
	 * Prueba que verifica que el método getVentas() devuelve el valor correcto de ventas.
	 */
	@Test
	void testGetVentas() {
        double resultadoEsperado = 1000.0;
        double resultadoActual = Double.valueOf(comercial.getVentas());
        assertEquals(resultadoEsperado, resultadoActual);
	}
	
	/**
	 * Prueba que verifica que el método setVentas() actualiza correctamente el
	 * valor de ventas. Se prueba con un valor positivo y se verifica que se
	 * actualice correctamente.
	 */
	@Test
	void testSetVentas(double ventas) {
		comercial.setVentas(ventas);
		Double resultadoEsperado = Double.valueOf(ventas);
		Double resultadoActual = Double.valueOf(comercial.getVentas());
		assertEquals(resultadoEsperado, resultadoActual);
		
	}
	
	/**
	 * Prueba que verifica que el método setVentas() lanza una excepción
	 * IllegalArgumentException cuando se intenta establecer un valor negativo para
	 * las ventas. Se verifica que el mensaje de la excepción sea el esperado.
	 */
	@Test
	void testVentasNegativo() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> comercial.setVentas(-500.0));
		String mensajeEsperado = "Las ventas no pueden ser negativas";
		String mensajeActual = exception.getMessage();
		assertEquals(mensajeEsperado, mensajeActual);
	}
	
	/**
	 * Prueba que verifica que el método calcularExtra() devuelve el valor correcto
	 * del extra basado en las ventas. Se calcula el extra como el 10% de las ventas
	 * y se verifica que el resultado sea el esperado.
	 */
	@Test
	void textCalcularExtra() {
		double resultadoEsperado = 100.0;
		double resultadoActual = comercial.calcularExtra();
		assertEquals(resultadoEsperado, resultadoActual);
	}
	
	/**
	 * Prueba que verifica que el método getSueldo() devuelve el sueldo total
	 * correcto para el comercial. El sueldo total se calcula como el sueldo base
	 * más el extra basado en las ventas. Se verifica que el resultado sea el
	 * esperado.
	 */
	@Test
	void testGetSueldo() {
		double resultadoEsperado = 600.0;
		double resultadoActual = comercial.getSueldo();
		assertEquals(resultadoEsperado, resultadoActual);
	}
}
