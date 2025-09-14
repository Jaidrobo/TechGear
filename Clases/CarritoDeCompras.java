
import java.util.ArrayList; //-- esta clase se utliza para importar listas dinamicas --//
import java.util.List;  //-- corresponde a la interfaz List --//

public class CarritoDeCompras {

    // -- Atributos -- //

    private List<Producto> productosSeleccionados;
    private double total;

    // -- Constructor -- //

    public CarritoDeCompras() {
        this.productosSeleccionados = new ArrayList<>();
        this.total = 0.0;
    }

   // -- Métodos de Gestión -- //

    public void agregarProducto(Producto producto) {
        if (producto != null && producto.getStock()> 0) {
            this.productosSeleccionados.add(producto);
            producto.setStock(producto.getStock() -1);
            System.out.println("Ok` " + producto.getNombre() + " `ha sido añadido al carrito.`");
            calcularTotal();

        } else { 
            System.out.println("No se puede añadir el producto. Stock no disponible o producto nulo.");
        }
    }

    public void removerProducto(Producto producto) {
        if (producto != null && this.productosSeleccionados.contains(producto)) {
            this.productosSeleccionados.remove(producto);
            producto.setStock(producto.getStock() + 1);
            System.out.println("delete`" + producto.getNombre() + "`ha sido removido del carrito.");
            calcularTotal();

        } else {
            System.out.println("El producto no se encuentra en el carrito");  
        }
    }

    private void calcularTotal() {
        this.total = 0.0; 
        for (Producto p : this.productosSeleccionados) {
            this.total += p.getPrecio();
        }
    }

    // -- Métodos Getters --//

    public double getTotal() {
        return total();
    }

    public void mostrarCarrito() {
        System.out.println("\n--- Resumen del Carrito ---");
        if (productosSeleccionados.isEmpty()) {
            System.out.println("El carrito está vacio. ");
        } else {
            for (Producto p: productosSeleccionados) {
                System.out.println("_ " + p.getNombre() + "\t | Precio: $" + p.getPrecio());
            }
        }

        System.out.println("--------------------------------------");
        System.out.printf("TOTAL A PAGAR: $%.2f%n", this.total);
        System.out.println("-------------------------------------\n");

    }

}
