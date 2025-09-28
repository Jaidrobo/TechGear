package pago;

public class PagoFallidoException extends Exception {
    public PagoFallidoException(String mensaje) {
        super(mensaje);
    }
}
