package producto;

/**
 * Representa un producto digital que se puede descargar.
 * Hereda de la clase Producto.
 */
public class ProductoDigital extends Producto {
    
    // Atributos Especificos.
    private String formatoArchivo;
    private double tamañoMB;

    // Constructor 
    /** 
    * Inicializar un ProductoDigital.
    * Para productos digitales, el stock se puede considerar infinito.
    */
    public ProductoDigital(int id, String nombre, String descripcion, double precio, int stock, String formatoArchivo,
            double tamañoMB) {
        // Llamamos al constructor padre para un producto digital, el stock puede ser un valor alto para simular
        super(id, nombre, descripcion, precio, Integer.MAX_VALUE);

        // Inicializamos los atributos propios de esta clase.
        this.formatoArchivo = formatoArchivo;
        this.tamañoMB = tamañoMB;
    }

     // Métodos Getters y Setters Especificos

    public String getFormatoArchivo() {
        return formatoArchivo;
    }

    public void setFormatoArchivo(String formatoArchivo) {
        this.formatoArchivo = formatoArchivo;
    }

    public double getTamañoMB() {
        return tamañoMB;
    }

    public void setTamañoMB(double tamañoMB) {
        this.tamañoMB = tamañoMB;
    }
    

    @Override // Anotación que indica al compilador que estamos sobrescribiendo un método
    public void mostrarDetalle() {
        System.out.println("\n--- Detalle del Producto Digital ---"); // Encabezado específico
        System.out.println("ID: " + getId()); // Usa los getters del padre
        System.out.println("Nombre: " + getNombre());
        System.out.println("Descripción: " + getDescripcion());
        System.out.printf("Precio: $%.2f%n", getPrecio());
        System.out.println("Stock: Disponible (Ilimitado)"); // O getStock(), pero el valor es MAX_VALUE

        System.out.println("Tipo: Producto Digital");
        System.out.println("Formato: " + getFormatoArchivo());
        System.out.println("Tamaño: " + getTamañoMB() + " MB");
    }
    
}
