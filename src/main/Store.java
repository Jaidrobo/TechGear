package main;

import producto.Producto;
import usuario.Cliente;
import negocio.CarritoDeCompras;
import inventario.GestorInventario;
import inventario.GestorInventarioFisico;
import inventario.InventarioInsuficienteException;
import pago.PagoFallidoException;
import pago.PagoTarjeta;
import pago.ProcesoPago;
import factory.FabricaEntidades;
import observer.ActualizadorInventario;
import observer.EstadoPedido;
import observer.NotificadorEmail;
import observer.Observador;
import singleton.ConfiguracionSistema;


 // --- Clase principal que simula el funcionamiento de la E-commerce ---
 /** En esta se instancian se demuestra la interacción de todas las clases y la aplicación de
 * principios de POO y patrones de diseño (Singleton, Factory, Observer), incluyendo un manejo de excepciones robusto.
 */
public class Store {
    public static void main(String[] args) {
        System.out.println("=======================================");
        System.out.println("Iniciado Simulación de la E-commerce 🚀");
        System.out.println("=======================================");

        // 1.PATRÓN SINGLETON: Cargar configuración del sistema ---
        System.out.println("--- Obteniendo configuración del sistema (Singleton)---");
        ConfiguracionSistema config = ConfiguracionSistema.getInstance();
        config.mostrarConfiguracion();
        System.out.println("\n Singleton verificado.\n");

        // 2.PATRÓN FACTORY: Crear entidades del sistema ---
        System.out.println("--- Creando entidades con una Fábrica (Factory)---");
        FabricaEntidades fabrica = new FabricaEntidades();

        Cliente cliente = (Cliente) fabrica.crearUsuario("CLIENTE", 1001, "Lyzdaiana", "lyz@email.com", "pass123", "Calle Galdar 11");
        Producto laptop = fabrica.crearProducto("FISICO", 201, "Laptop Pro X", "16GB RAM, 512GB SSD", 1250.00, 5, 1.8, "35x25x2 cm");
        Producto antivirus = fabrica.crearProducto("DIGITAL", 301, "Software Antivirus Pro", "Licencia de 1 año", 49.99, 100, "EXE", 250.0);
        Producto monitorSinStock = fabrica.crearProducto("FISICO", 202, "Monitor UltraWide 29\"", "Panel IPS, 75Hz", 300.50, 0, 4.5, "70x40x10 cm");

        System.out.println("Entidades creadas. \n");

        // 3.GESTIÓN DE INVENTARIO ---
        System.out.println("--- Cargando productos en el inventario ---");
        GestorInventario inventario = new GestorInventarioFisico();
        inventario.añadirProducto(laptop);
        inventario.añadirProducto(monitorSinStock);
        inventario.listarProducto();
        System.out.println("\n Inventario inicializado.\n");

        // 4.SIMULACIÓN DE COMPRA CON MANEJO DE EXCEPCIONES ---
        System.out.println(" El cliente '" + cliente.getNombre() + "' inicia una compra. ");
        CarritoDeCompras carrito = new CarritoDeCompras();
        
        try {
            System.out.println("\n Intentando agregar Laptop (con stock)...");
            carrito.agregarProducto(laptop);
            System.out.println("Intentando agregar Antivirus (con stock)...");
            carrito.agregarProducto(antivirus);
            System.out.println("Intentando agregar Monitor (sin stock)...");
            carrito.agregarProducto(monitorSinStock); // Esto lanzará la excepción
        } catch (InventarioInsuficienteException e) {
            System.out.println(" Atención CLIENTE: " + e.getMessage());
            System.out.println("Continuamos con los productos que sí están disponibles.");
        }
        
        System.out.println("\n--- Contenido Final del Carrito ---");
        carrito.mostrarCarrito();
        System.out.println("\n Cliente ha llenado su carrito.\n");

        
        // 5. PROCESO DE PAGO Y PATRÓN OBSERVER ---
        System.out.println("--- El cliente procede al pago (Observer y Excepciones) ---");
        double totalAPagar = carrito.getTotal();
        ProcesoPago metodoDePago = new PagoTarjeta(); // El cliente elige pagar con tarjeta

        // Se crea el Sujeto (pedido) y los Observadores
        EstadoPedido pedido = new EstadoPedido(90210);
        Observador notificadorEmail = new NotificadorEmail();
        Observador actualizadorStock = new ActualizadorInventario();
        
        // Se suscribe los observadores al pedido
        pedido.registrarObservador(notificadorEmail);
        pedido.registrarObservador(actualizadorStock);

        try {
            pedido.setEstado("Pago iniciado");
            ejecutarProcesoDePago(metodoDePago, totalAPagar);
            
            // Si el pago es exitoso, actualizamos el estado y notificamos
            pedido.setEstado("Pagado y procesando");
            
            cliente.agregarCompraAlHistorial(carrito); // Guardamos la compra
            pedido.setEstado("Enviado");
            
        } catch (PagoFallidoException e) {
            System.out.println(" ERROR DE PAGO: " + e.getMessage());
            pedido.setEstado("Pago fallido");
        }

        System.out.println("\n Proceso de pago finalizado.\n");

        System.out.println("================================");
        System.out.println(" --- SIMULACIÓN FINALIZADA --- ");
        System.out.println("================================");
    }

    /**
     * Método polimórfico que ejecuta el flujo de pago.
     * Lanza PagoFallidoException si la verificación falla.
     */
    public static void ejecutarProcesoDePago(ProcesoPago metodoDePago, double monto) throws PagoFallidoException {
        metodoDePago.iniciarPago(monto);
        // La excepción se lanza dentro de verificarPago si falla
        if (metodoDePago.verificarPago()) {
            metodoDePago.confirmarPago();
        }
    }
}

