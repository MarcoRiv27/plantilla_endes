package com.endes.entidad;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
/**
 * Pruebas unitarias para la clase Plantilla.
 */
class PlantillaTest {
    private Plantilla plantilla;

    @BeforeEach
    //@DisplayName("Inicialización de la plantilla de empleados")
    void setUp() {
        plantilla = new Plantilla();
    }

    /**
     * Prueba que verifica que no se puedan contratar empleados con el mismo DNI.
     * @test ContratarEmpleado_Duplicado() Verifica que se lance una excepción al intentar contratar un empleado con un DNI ya existente en la plantilla.
     * @throws IllegalArgumentException Si se intenta contratar un empleado con un DNI duplicado.
     * 
     */

    @Test
    //("No permite contratar empleados con el mismo DNI")
    void testContratarEmpleado_Duplicado() {
        Empleado tecnico1 = new Tecnico("11111111H", "Alejandro", "Fernández", 1000.0, 1);
        Empleado tecnico2 = new Tecnico("11111111H", "Carlos", "Pérez", 1200.0, 2); // Mismo DNI que el primero
        
        // Se permite el primer contrato
        assertDoesNotThrow(() -> plantilla.contratarEmpleado(tecnico1));

        // Intentar contratar otro empleado con el mismo DNI debería lanzar una excepción
        Exception ex = assertThrows(IllegalArgumentException.class, () -> plantilla.contratarEmpleado(tecnico2));

        // Verificar el mensaje de la excepción
        assertEquals("El empleado con DNI 11111111H ya está contratado", ex.getMessage());
    }
    /**
     * @test ContratarEmpleado_Exitoso() Verifica que se pueda contratar un empleado correctamente y que se refleje en la plantilla.
     */
    @Test
    void textContrartarEmpleado() {
		Empleado tecnico1 = new Tecnico("11111111H", "Alejandro", "Fernández", 1000.5, 1);
		plantilla.contratarEmpleado(tecnico1);
		int resultadoesperado = 1;
		int resultado = plantilla.getEmpleadosPorNombre("Alejandro").size();
		assertEquals(resultadoesperado, resultado);
    }
    
    /**
     *@test GetEmpleadosPorNombre() Verifica que el método getEmpleadosPorNombre() devuelva la lista correcta de empleados que coincidan con el filtro de nombre o apellido.
     */
    @Test
    void textGetEmpleadosPorNombre() {
    	Empleado tecnico1 = new Tecnico("11111111H", "Alejandro", "Fernández", 1000.5, 1);
    	plantilla.contratarEmpleado(tecnico1);
    	String resultadoesperado = "Alejandro";
    	String resultado = plantilla.getEmpleadosPorNombre("Alejandro").get(0).getNombre();
    	assertEquals(resultadoesperado, resultado);
    }
}