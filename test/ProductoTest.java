package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import producto.Producto;
import producto.ProductoFisico;

public class ProductoTest {

    @Test
    void testSetPrecioValido() {
        // Arrange: Preparamos el escenario
        Producto producto = new ProductoFisico(1, "Test", "", 100.0, 10, 1.0, "");
        
        // Act: Ejecutamos la acción a probar
        producto.setPrecio(150.75);
        
        // Assert: Verificamos el resultado
        assertEquals(150.75, producto.getPrecio(), "El precio debería actualizarse a un valor válido.");
    }

    @Test
    void testSetPrecioNegativoNoDebeCambiarElValor() {
        // Arrange
        Producto producto = new ProductoFisico(1, "Test", "", 100.0, 10, 1.0, "");
        
        // Act
        producto.setPrecio(-50.0);
        
        // Assert
        assertEquals(100.0, producto.getPrecio(), "El precio no debería cambiar si el nuevo valor es negativo.");
    }
}