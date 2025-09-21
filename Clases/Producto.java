package Clases;
// Representa un producto en el inventario de la ecommerce

public class Producto{

    // Atributos
    // Se declaran como `private` para encapsular los datos.

    private int id;
    private String nombre;
    private String descripcion;
    private double precio;
    private int stock;

    // Constructor

    /**
     * Para inicializar un nuevo objeto Producto con todos sus atributos.
     * @param id Identificador único del producto.
     * @param nombre EL nombre del producto.
     * @param descripcion Breve descripción del producto.
     * @param precio El precio de venta del producto.
     * @param stock Cantidad de unidades disponibles en inventario.
     */

    public Producto (int id, String nombre, String descripcion, double precio, int stock) {
        this. id = id;
        this. nombre = nombre;
        this. descripcion = descripcion;
        this. precio = precio;
        this. stock = stock;
    }

    // Métodos GETTERS y SETTERS (Propiedades)
    // Permiten acceder y modificar los atributos privados de forma controlada.

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if (precio >= 0){ 
           this.precio = precio;
        }
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if (stock >= 0){
            this.stock = stock;
        }
    }

    // Métodos a ser sobreescrito
    /**
    * Muestra los detalles básicos y comunes a todos los productos.
    * Este método está diseñado para ser sobrescrito por las clases hijas.
    */

    public void mostrarDetalle() {
        System.out.println("Detalle del prodcuto: ");
        System.out.println(" ID: " + getId());  
        System.out.println("Nombre: " + getNombre());
        System.out.println("Descripción: " + getDescripcion());
        System.out.printf("Precio: $%.2f%n", getPrecio()); // Usamos printf para formatear el precio
        System.out.println("Stock: " + getStock());
    }

}   