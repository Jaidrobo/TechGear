public class Usuario {
    
    // -- Atributos-- // 

    private int id;
    private String nombre;
    private String correoElectronico;
    private String contraseña;

    // -- Constructor-- //
    
    public Usuario(int id, String nombre, String correoElectronico, String contraseña) {
        this.id = id;
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
        this.contraseña = contraseña;
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
