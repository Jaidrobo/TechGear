public class Producto{

    // -- Atributos-- // 

    private int id;
    private String nombre;
    private String descripcion;
    private double precio;
    private int stock;

    // -- Constructor-- //

    public Producto (int id, String nombre, String descripcion, double precio, int stock) {
        this. id = id;
        this. nombre = nombre;
        this. descripcion = descripcion;
        this. precio = precio;
        this. stock = stock;
    }

    // -- Métodos GETTERS y SETTERS (Propiedades) -- //

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


}