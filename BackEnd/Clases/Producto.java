package Clases;
// Representa un producto en el inventario de la ecommerce
// Añadimos la palabra clave "abstract" a la declaración de la clase
public abstract class Producto{

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
        // Validación: Asegurar que el precio no sea negativo.
        if (precio >= 0){ 
           this.precio = precio;
        } else {
            // Informamos del error en vez de asignar un valor invalido.
            System.out.println("Error: El precio no puede ser negativo. Se mantiene el valor anterior de $" + this.precio);
        }
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        // Validación: Aseguramos que el stock no sea negativo.
        if (stock >= 0){
            this.stock = stock;
        } else {
            System.out.println("Error: El stock no puede ser un valor negativo. Se mantiene el valor del stock anterior de " + this.stock);
        }
    }

    // Método Abstracto
    /**
     * Muestra los detalles completos y específicos del producto.
     * Obliga a todas las clases hijas (como ProductoFisico y ProductoDigital) a definir su propia forma de mostrar los detalles.
     */

    public abstract void mostrarDetalle();
   
}

   
//_______________________________________________________________//
   
    // Métodos a ser sobreescrito
    /**
    * Muestra los detalles básicos y comunes a todos los productos.
    * Este método está diseñado para ser sobrescrito por las clases hijas.
    */

    /** public void mostrarDetalle() {
        System.out.println("Detalle del prodcuto: ");
        System.out.println(" ID: " + getId());  
        System.out.println("Nombre: " + getNombre());
        System.out.println("Descripción: " + getDescripcion());
        System.out.printf("Precio: $%.2f%n", getPrecio()); // Usamos printf para formatear el precio
        System.out.println("Stock: " + getStock());
    } */


 