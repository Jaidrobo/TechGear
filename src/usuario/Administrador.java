package usuario;

import producto.Producto;
import producto.ProductoFisico;

/**
 * Representa a un administrador del sistema, un tipo de Usuario con permisos especiales.
 */

public class Administrador extends Usuario {
    
    // Atributo específico 
    private String nivelDeAcceso; // Acceso "Total, Inventario y Precio"

    // Constructor 
    public Administrador(int id, String nombre, String correoElectronico, String contraseña, String nivelDeAcceso) {
        super(id, nombre, correoElectronico, contraseña);
        this.nivelDeAcceso = nivelDeAcceso;
    }

    // Métodos especificos de gestión
    /**
     * Permite al administrador cambiar el precio de cualquier producto.
     * @param producto El producto a modificar.
     * @param nuevoPrecio El nuevo precio a establecer.
     */
     public void cambiarPrecioProducto(Producto producto, double nuevoPrecio) {
        System.out.println("🔑 Acción de Admin: Cambiando precio de '" + producto.getNombre() + "'.");
        System.out.println("Precio anterior: $" + producto.getPrecio());
        producto.setPrecio(nuevoPrecio);
        System.out.println("Nuevo precio: $" + producto.getPrecio());
    }

    /**
     * Permite al administrador añadir stock a un producto físico.
     * @param producto El producto físico a reponer.
     * @param cantidad La cantidad de stock a añadir.
     */
    public void reponerStock(ProductoFisico producto, int cantidad) {
        System.out.println("🔑 Acción de Admin: Reponiendo stock de '" + producto.getNombre() + "'.");
        System.out.println("Stock anterior: " + producto.getStock());
        producto.setStock(producto.getStock() + cantidad);
        System.out.println("Stock actual: " + producto.getStock());
    }

    // Getter y Setter Específico
    public String getNivelDeAcceso() {
        return nivelDeAcceso;
    }
}

