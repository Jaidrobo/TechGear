package inventario;

public class InventarioInsuficienteException extends Exception {
    public InventarioInsuficienteException(String mensaje) {
        super(mensaje); // Llama al constructor de la clase padre 'Exception'
    }
}
