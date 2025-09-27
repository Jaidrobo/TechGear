package inventario;

import java.util.ArrayList;
import java.util.List;

import producto.Producto;

public abstract class GestorInventario {
    // `protected` para que las clases hijas puedan acceder directamente a la lista.
    protected List<Producto> productos;

    public GestorInventario() {
        this.productos = new ArrayList<>();
    }

    // --- Métodos Abstractos ---
    // Las clases hijas implementan los métodos.
    public abstract void añadirProducto (Producto producto);
    public abstract void eliminarProducto (int productoId);
    public abstract void actualizarProducto (int productoId, int cantidad);

    // --- Métodos Concreto ---
    // Este método será heredado y funcionará igual para todos los gestores.
    public void listarProducto() {
        System.out.println("--- listado de Productos en Inventario ---");
        if (productos.isEmpty()) {
            System.out.println("El invetario está vacio. ");
            return;
        }
        for (Producto p :productos) {
            System.out.println("ID: " + p.getId() + " | Nombre: " + p.getNombre() + " | Stock: " + p.getStock());
        }
    }
}

