package test;

// Importaciones estáticas para usar los métodos de aserción directamente
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import producto.Producto;
import producto.ProductoFisico;
import inventario.InventarioInsuficienteException;
import negocio.CarritoDeCompras;

public class CarritoDeComprasTest {

    private CarritoDeCompras carrito;
    private Producto productoConStock;
    private Producto productoSinStock;

    @BeforeEach // Este método se ejecuta antes de CADA prueba
    void setUp() {
        carrito = new CarritoDeCompras();
        productoConStock = new ProductoFisico(1, "Test", "", 100.0, 5, 1.0, "");
        productoSinStock = new ProductoFisico(2, "Test Sin Stock", "", 50.0, 0, 1.0, "");
    }

    @Test // Prueba para el "camino feliz" (happy path)
    void testAgregarProductoYCalcularTotalCorrectamente() {
        try {
            carrito.agregarProducto(productoConStock);
            carrito.agregarProducto(productoConStock);
        } catch (InventarioInsuficienteException e) {
            fail("No debería lanzar una excepción si hay stock.");
        }
        
        assertEquals(2, carrito.getProductosSeleccionados().size(), "El carrito debería tener 2 productos.");
        assertEquals(200.0, carrito.getTotal(), "El total debería ser 200.0.");
        assertEquals(5, productoConStock.getStock(), "El stock del producto debería cambiar (Responsable GestorInvetario).");
    }

    @Test // Prueba para el escenario de error
    void testAgregarProductoSinStockDebeLanzarExcepcion() {
        // Verificamos que al ejecutar la acción, se lance la excepción esperada
        Exception exception = assertThrows(InventarioInsuficienteException.class, () -> {
            carrito.agregarProducto(productoSinStock);
        });

        String expectedMessage = "No hay Stock disponible para el producto:";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage), "El mensaje de la excepción no es el esperado.");
    }
}