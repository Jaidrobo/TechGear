package pago;

public class PagoTarjeta implements ProcesoPago {

    private boolean forzarFallo;

    // CONSTRUCTOR REQUERIDO por PagoTarjetaTest.java
    /**
     * Constructor para simular pagos exitosos o fallidos en pruebas.
     * @param forzarFallo Si es true, la verificación fallará y lanzará la excepción.
     */
    public PagoTarjeta(boolean forzarFallo) {
        this.forzarFallo = forzarFallo;
    }

    // CONSTRUCTOR POR DEFECTO (opcional, pero buena práctica para uso real)
    public PagoTarjeta() {
        this.forzarFallo = false; // En producción, no fallará a menos que haya un error real.
    }

    @Override
    public void iniciarPago(double monto) {
        System.out.println(" Iniciando pago con tarjeta de crédito por un monto de $" + monto);
        System.out.println("Conectando con la pasarela de pago...");
    }

    @Override
    public boolean verificarPago() throws PagoFallidoException {
        // En un caso real, aquí se verificaría la respuesta del banco.
        if (this.forzarFallo) {
            System.out.println("Pago de prueba simulado como rechazado. ");
            throw new PagoFallidoException("El pago con tarjeta ha sido rechazado. ");
        }
        System.out.println("Verificando datos de la tarjeta... Verificación exitosa.");
        return true;
    }

    @Override
    public void confirmarPago() {
        System.out.println("Pago con tarjeta confirmado. Transacción completada.");
    }
}