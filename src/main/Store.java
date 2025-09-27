package main;
import java.util.ArrayList;
import java.util.List;

import negocio.CarritoDeCompras;
import producto.Producto;
import producto.ProductoDigital;
import producto.ProductoFisico;
import usuario.Administrador;
import usuario.Cliente;

/**
 * Clase principal que simula el funcionamiento de la e-commerce.
 * En esta se instancian los objetos y se demuestra la interacción entre ellos,
 * aplicando polimorfismo, herencia, sobrecarga y sobrescritura.
 */
public class Store {
    public static void main(String[] args) {

        // Configuración inicial: Creación de Inventario y Usuarios.
        System.out.println("Sistema de Store Iniciado 🚀");

        // Creación del Inventario con diferente tipos de productos
        ProductoFisico discoSsd = new ProductoFisico(201, "Disco SSD Externo", "Portable E30 2TB", 45.50, 50, 0.42, "9x8x4 cm");
        ProductoDigital ebook = new ProductoDigital(301, "Guía de Programación Java", "Ebook completo para principiantes", 9.99, 0, "PDF", 15.5);
        ProductoFisico teclado = new ProductoFisico(202, "Teclado Mecanico", "RGB con switches azules", 75, 30, 0.8, "45x15x4 cm");

        List<Producto> inventario = new ArrayList<>();
        inventario.add(discoSsd);
        inventario.add(ebook);
        inventario.add(teclado);

        // Creación de usuarios
        Cliente cliente = new Cliente(1001, "Lyzdaiana", "lyz@hotmail.com", "pass123", "Calle Galdar 11");
        Administrador administrador = new Administrador(1, "Jose", "jidrobo@hotmail.com", "Admi567", "Total");
       
        // POLIMORFISMO Y SOBRESCRITURA 
        // El método mostrarInventarioCompleto trata a todos como 'Producto' (polimorfismo),
        // El método 'mostrarDetalle' específico de cada subclase (sobrescritura).
        mostrarInventarioCompleto(inventario);

        // Simulación de compra de un cliente
        System.out.println("\n --- Inicio del Proceo de Compra de para " + cliente.getNombre() + " ---");
        CarritoDeCompras carritoDeLyzdaiana = new CarritoDeCompras();
        
        // Demostración de Sobrecarga de Métodos 
        carritoDeLyzdaiana.agregarProducto(discoSsd); // Añadir por objeto (la original)
        carritoDeLyzdaiana.agregarProducto(301, inventario); // Añadir por ID, buscando en el inventario
        carritoDeLyzdaiana.agregarProducto(teclado, 2); // Añadir por objeto y cantidad 

        // Muestra el resultado final del carrito
        System.out.println("\n Resumen del carrito antes de finalizar la compra: ");
        carritoDeLyzdaiana.mostrarCarrito();

        // El cliente "finaliza" la compra y se añade a su historial
        cliente.agregarCompraAlHistorial(carritoDeLyzdaiana);
        cliente.mostrarHistorialDeCompra();

        // Simulación de una acción de usuario administrador
        System.out.println("\n--- Acciones del Administrador " + administrador.getNombre() + " ---");
        administrador.cambiarPrecioProducto(discoSsd, 38.99); // El adminastrador pone el disco SSD en oferta
        administrador.reponerStock(teclado, 10); // El adminastrador repone stock

        System.out.println("\n--- Estado del Inventario Tras las Acciones del Administrador ---");
        mostrarInventarioCompleto(inventario);
    }
    /**
     * Método polimórfico procesa una lista de productos.
     * @param inventario Una lista que puede contener cualquier tipo de Producto.
     */
    public static void mostrarInventarioCompleto(List<Producto> inventario) {
        System.out.println("\n =================================");
        System.out.println("--- Estado Actual del Inventario ---");
        System.out.println("\n =================================");
        for (Producto producto : inventario) {
            producto.mostrarDetalle(); // ¡Polimorfismo: se llama el método correcto!
            System.out.println("--------------------------------");
        }
    }
    /**
     * Método para probar los conceptos de Abstracción y Encapsulamiento con Validación.
     */
    public static void demostrarAbstraccionYValidacion(Cliente cliente, Producto producto) {
        System.out.println("--- Generación de Abstración ---");
        // La siguiente línea daría un error de compilación, lo cual es correcto,
        // porque 'Producto' es una clase abstracta y no puede ser instanciada.
        // Producto productoGenerico = new Producto(0, "Genérico", "", 0, 0);
        System.out.println(" Verificando: No se pueden crear instancias de 'Producto' directamente.");

        System.out.println("\n--- Demostrando Encapsulamiento con Validación ---");
        // Intentar relacionar un precio negativo a un producto
        System.out.println("Precio original del producto: $" + producto.getPrecio());
        producto.setPrecio(-5.00); // Esto debería fallar y mostrar un error gracias a la validación en el setter.
        System.out.println("Precio del producto después del intento de cambio inválido: $" + producto.getPrecio());
        
        // Intentar relacionar un email inválido a un cliente
        System.out.println("\nEmail original del cliente: " + cliente.getCorreoElectronico());
        cliente.setCorreoElectronico("usuario-sin-arroba"); // Esto también debería fallar.
        System.out.println("Email del cliente después del intento de cambio inválido: " + cliente.getCorreoElectronico());
    }
}
