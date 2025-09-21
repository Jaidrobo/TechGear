package Clases;
/**
 * Representa un producto físico que tiene `peso` y `dimensiones`.
 * Hereda de la clase Producto.
 */

public class ProductoFisico extends Producto {

    // Atributos Específicos

    private double pesoKg;
    private String dimensiones; // "15x10x5 cm"

    // Constructor
    // Constructor para inicializar un ProductoFisico.

    public ProductoFisico(int id, String nombre, String descripcion, double precio, int stock, double pesoKg,
            String dimensiones) {
        // Llama al constructor de la clase padre (Producto)
        super(id, nombre, descripcion, precio, stock); 

        // Inicializamos los atributos propios de esta clase
        this.pesoKg = pesoKg;
        this.dimensiones = dimensiones; 
    }

    // Métodos Getters y Setters Especificos
    
    public double getPesoKg() {
        return pesoKg;
    }

    public void setPesoKg(double pesoKg) {
        this.pesoKg = pesoKg;
    }

    public String getDimensiones() {
        return dimensiones;
    }

    public void setDimensiones(String dimensiones) {
        this.dimensiones = dimensiones;
    }
    
    @Override // Anotación que indica al compilador que estamos sobrescribiendo un método
    public void mostrarDetalle() {
         super.mostrarDetalle(); // Llama al método original de la clase padre (Producto)
         System.out.println("Tipo: Producto Físico");
         System.out.println("Peso: " + getPesoKg() + " kg");
         System.out.println("Dimensiones: " + getDimensiones());
    }
}
