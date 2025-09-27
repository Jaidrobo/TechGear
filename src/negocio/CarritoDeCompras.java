package negocio;

import java.util.ArrayList; // esta clase se utliza para importar listas dinamicas.
import java.util.List;  // corresponde a la interfaz List.

import producto.Producto;

// Representa el carrito de compras de un usuario.
public class CarritoDeCompras {

    // Atributos.
    private List<Producto> productosSeleccionados;
    private double total;

    // Constructor.
    // Para inicializar el carrito de compras vacío.

    public CarritoDeCompras() {
        this.productosSeleccionados = new ArrayList<>(); // Inicializa la lista como un ArrayList vacío.
        this.total = 0.0; // El total inicial es cero.
    }

   // Métodos de Gestión del Carrito
   /** 
    * Añade un producto al carrito y actualiza el total.
    * @param producto EL objeto producto que se va añadir.
    */

    public void agregarProducto(Producto producto) {
        if (producto != null && producto.getStock()> 0) {
            this.productosSeleccionados.add(producto);
            producto.setStock(producto.getStock() - 1);
            System.out.println("Ok` " + producto.getNombre() + " `ha sido añadido al carrito.`");
            calcularTotal();
        } else { 
            System.out.println("No se puede añadir el producto. Stock no disponible o producto nulo.");
        }
    }

    /**
    * Remueve un producto del carrito y actualiza el total.
    * @param producto El objeto Producto que se va a remover.
    */
    public void removerProducto(Producto producto) {
        if (producto != null && this.productosSeleccionados.contains(producto)) {
            this.productosSeleccionados.remove(producto);
            producto.setStock(producto.getStock() + 1);
            System.out.println("Delete`" + producto.getNombre() + "`ha sido removido del carrito.");
            calcularTotal();
        } else {
            System.out.println("El producto no se encuentra en el carrito");  
        }
    }
    /**
     * Calcula el costo total de todos los productos en el carrito.
     * Este método es 'private' porque solo necesita ser llamado desde dentro de la clase.
     */
    private void calcularTotal() {
        this.total = 0.0; // Resetea el total para empezar el cálculo desde cero.
        for (Producto p : this.productosSeleccionados) {
            this.total += p.getPrecio(); // Suma el precio de cada producto
        }
    }

    // Métodos Getters.
    // No se crea el setters para 'productos' o 'total' para que solo se puedan modificar
    // a través de los métodos 'agregar' y 'remover'.

    /**
     * Devuelve el total actual del carrito.
     * @return El costo total de los productos.
     */

    public double getTotal() {
        return total;
    }

    /**
     * Muestra un resumen de los productos en el carrito y el total.
     */

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
        System.out.println("------------------------------------\n");

    }

    // Versiones del método.
    // El método agregarProducto(Producto producto) se mantiene.
    /**
    * SOBRECARGA 1: Añade una cantidad específica de un mismo producto.
    * @param producto El producto a añadir.
    * @param cantidad El número de unidades a añadir.
    */

    public void agregarProducto(Producto producto, int cantidad) {
        System.out.println("Intentando agregar " + cantidad + "unidades de `" + producto.getNombre() + "`...`");
        for (int i = 0; i < cantidad; i++){
            // Se reutiliza el método original para la lógica de añadir una cantidad
            agregarProducto(producto);
        }
    }

    /**
    * SOBRECARGA 2: Busca un producto por su ID en un inventario y lo añade.
    * @param productoId El ID del producto a buscar.
    * @param inventario Generalmente, una lista de todos los productos disponibles en la tienda.
    */

    public void agregarProducto(int productoId, List<Producto> inventario) {
        Producto productoEncontrado = null;
        for (Producto p : inventario) {
            if (p.getId() == productoId) {
                productoEncontrado = p;
                break; // Salir del bucle una vez encontrado
            }
        }
        if (productoEncontrado != null) {
            // Si lo encontramos, reutilzamos el metodo original para añadirlo
            agregarProducto(productoEncontrado);
        } else {
            System.out.println("No se encontró ningún producto con el ID:  " + productoId);
        }
    }

}

