package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import pago.PagoTarjeta;
import pago.ProcesoPago;
import pago.PagoFallidoException;

/**
 * Pruebas unitarias para la clase PagoTarjeta.
 */
public class PagoTarjetaTest {

    @Test
    void testVerificarPagoExitosoDebeDevolverTrue() {
        // Arrange: El escenario para un pago exitoso.
        // El nuevo constructor para que NO falle.
        ProcesoPago pagoExitoso = new PagoTarjeta(false);

        // Act & Assert: Ejecutamos y verificamos.
        // El bloque assertDoesNotThrow verifica que no se lance ninguna excepción.
        assertDoesNotThrow(() -> {
            boolean resultado = pagoExitoso.verificarPago();
            assertTrue(resultado, "El pago exitoso debería devolver true.");
        }, "Un pago válido no debería lanzar una excepción.");
    }

    @Test
    void testVerificarPagoFallidoDebeLanzarPagoFallidoExcepcion() {
        // Arrange: Preparamos el escenario para un pago fallido.
        // Forzamos el fallo inyectando 'true' en el constructor.
        ProcesoPago pagoFallido = new PagoTarjeta(true);

        // Act & Assert: Verificamos que se lance la excepción correcta.
        PagoFallidoException exception = assertThrows(
            PagoFallidoException.class,
            () -> pagoFallido.verificarPago(), // La acción que debe fallar
            "Se esperaba que verificarPago lanzara PagoFallidoException."
        );

        // Opcional: Verificar que el mensaje de la excepción es el esperado.
        assertTrue(exception.getMessage().contains("rechazado"), "El mensaje de la excepción es incorrecto.");
    }
}