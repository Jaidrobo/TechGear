package Clases;

public class Usuario {
    
    // Atributos

    private int id;
    protected String nombre;
    protected String correoElectronico;
    protected String contraseña;

    // Constructor
     /**
     * Para inicializar un nuevo objeto Usuario.
     * @param id Identificador único del producto.
     * @param nombre EL nombre del producto.
     * @param correoElectronico La dirección de email del usuario.
     * @param contraseña La contraseña para acceder al sistema.
     */
    
    
    public Usuario(int id, String nombre, String correoElectronico, String contraseña) {
        this.id = id;
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
        this.contraseña = contraseña;
    }

    // Métodos GETTERS y SETTERS (Propiedades)
    // Permiten gestionar los atributos de la clase.

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

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    
}
