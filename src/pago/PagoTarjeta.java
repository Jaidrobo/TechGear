package pago;

public class PagoTarjeta implements ProcesoPago {

    // Este campo permite simular un fallo en las pruebas.
    private boolean simularFallo = false;

    /**
     * Constructor para el uso normal en producción.
     */
    public PagoTarjeta() {}

    /**
     * Constructor para pruebas. Permite inyectar el estado de fallo.
     * @param simularFallo Si es true, el método verificarPago fallará.
     */

    public PagoTarjeta(boolean simularFallo) {
        this.simularFallo = simularFallo;
    }

    @Override
    public void iniciarPago(double monto) {
        System.out.println(" Iniciando pago con tarjeta de crédito por un monto de $" + monto);
        System.out.println("Conectando con la pasarela de pago...");
    }

    @Override
    public boolean verificarPago() throws PagoFallidoException {
        // En un caso real, aquí se verificaría la respuesta del banco.
        if (this.simularFallo) {
            throw new PagoFallidoException("El banco ha rechazado la transacción (simulado). ");
        }
       
        System.out.println("Verificando datos de la tarjeta...Verificación exitosa. ");
        return true;
    }   

    @Override
    public void confirmarPago() {
        System.out.println("Pago con tarjeta confirmado. Transacción completada.");
    }
}