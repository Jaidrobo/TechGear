package Clases;
import java.util.ArrayList; // esta clase se utliza para importar listas dinamicas
import java.util.List;  // corresponde a la interfaz List 

/**
 * Representa a un cliente del ecommerce, que es un tipo de Usuario.
 * Incluye historial de compras y dirección de envío.
 */

public class Cliente extends Usuario {

    // Atributos específicos.
    private String direccionEnvio;
    private List<CarritoDeCompras> historialDeCompras;

    // Constructor.
    public Cliente(int id, String nombre, String correoElectronico, String contraseña, String direccionEnvio) {
        // Llamamos al constructor de la clase padre (Usuario)
        super(id, nombre, correoElectronico, contraseña);

        // Inicializamos los atributos propios.
        this.direccionEnvio = direccionEnvio;
        this.historialDeCompras = new ArrayList<>(); // Inicializa la lista vacía
    }

    // Métodos específicos.
    /**
     * Añade un carrito (que representa una compra finalizada) al historial del cliente.
     * @param carrito La compra finalizada al registrar.
     */

    public void agregarCompraAlHistorial(CarritoDeCompras carrito) {
        if (carrito != null && carrito.getTotal() > 0) {
            this.historialDeCompras.add(carrito);
            System.out.println("Compra registrada en el historial de " + getNombre() + ". ");
        }
    }

    public void mostrarHistorialDeCompra(){
        System.out.println("\n--- Historial de compra de " + getNombre().toUpperCase()+ "---" );
        if (historialDeCompras.isEmpty()) {
            System.out.println(" Este cliente aún no tiene compras registradas.");
        } else {
            int numeroCompra = 1;
            for (CarritoDeCompras compra : historialDeCompras){
                System.out.println("\n--- Compra #" + numeroCompra + "---");
                compra.mostrarCarrito();
                numeroCompra ++;
            } 
        }
        System.out.println("--------------------------------------");
    }

    // Getter y Setter Especificos.

    public String getDireccionEnvio() {
        return direccionEnvio;
    }

    public void setDireccionEnvio(String direccionEnvio) {
        this.direccionEnvio = direccionEnvio;
    }
    
        
}

    
    



    

