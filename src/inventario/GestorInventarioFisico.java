package inventario;

import producto.Producto;
import producto.ProductoFisico;

public class GestorInventarioFisico extends GestorInventario {

    public GestorInventarioFisico() {
        super();
    }

    @Override
    public void añadirProducto(Producto producto) {
        if (producto instanceof ProductoFisico) {
            this.productos.add(producto);
            System.out.println(" Producto físico '" + producto.getNombre() + "' añadido al almacén.");
        } else {
            System.out.println(" Error: Solo se pueden añadir productos físicos a este inventario.");
        }
    }

    @Override
    public void eliminarProducto(int productoId) {
        // Lógica para encontrar y eliminar el producto por ID
        boolean removido = productos.removeIf(p -> p.getId() == productoId);
        if (removido) {
           System.out.println(" Producto con ID " + productoId + " eliminado del almacén.");
        } else {
           System.out.println("Error: Producto con ID " + productoId + "no encontrado en el almacén. ");
        }
    }    

    @Override
    public void actualizarProducto(int productoId, int cantidad) {
        for (Producto p : productos) {
            if (p.getId() == productoId) {
                p.setStock(p.getStock() + cantidad);
                System.out.println(" Stock del producto '" + p.getNombre() + "' actualizado a " + p.getStock() + ".");
                return;
            }
        }
        System.out.println(" Error: Producto con ID " + productoId + "no encontrado en el inventario fisíco. ");
    }
}