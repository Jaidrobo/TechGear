package Clases;

public class GestorInventarioDigital extends GestorInventario {

    public GestorInventarioDigital () {
        super();
    }

    @Override
    public void añadirProducto(Producto producto) {
        if (producto instanceof ProductoDigital) {
            this.productos.add(producto);
            System.out.println(" Producto digital '" + producto.getNombre() + "' añadido al servidor.");
        } else {
            System.out.println("Error: Solo se pueden añadir productos digitales a este inventario.");
        }
    }

    @Override
    public void eliminarProducto(int productoId) {
        productos.removeIf(p -> p.getId() == productoId);
        System.out.println(" Producto digital con ID " + productoId + " eliminado del servidor.");
    }

    @Override
    public void actualizarProducto(int productoId, int cantidad) {
        // Para productos digitales, el stock es "infinito", así que este método no tiene un efecto real.
        System.out.println(" El stock de productos digitales es ilimitado y no necesita ser actualizado.");
    }
}


