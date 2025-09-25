package Clases;

public class PagoPaypal implements ProcesoPago {
    private String emailUsuario;

    @Override
    public void iniciarPago(double monto) {
        System.out.println("Iniciando pago con PayPal por un monto de $" + monto);
        // Lógica para obtener el email del usuario
        this.emailUsuario = "usuario@email.com";
        System.out.println("Redirigiendo al usuario a la página de login de PayPal...");
    }

    @Override
    public boolean verificarPago() {
        System.out.println("Verificando autenticación del usuario '" + emailUsuario + "' en PayPal... Verificación exitosa.");
        return true;
    }

    @Override
    public void confirmarPago() {
        System.out.println("Pago con PayPal confirmado. Transacción completada.");
    }
}
