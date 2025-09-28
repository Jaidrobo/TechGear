package pago;

public class PagoTarjeta implements ProcesoPago {

    @Override
    public void iniciarPago(double monto) {
        System.out.println(" Iniciando pago con tarjeta de crédito por un monto de $" + monto);
        System.out.println("Conectando con la pasarela de pago...");
    }

    @Override
    public boolean verificarPago() {
        // En un caso real, aquí se verificaría la respuesta del banco.
        System.out.println("Verificando datos de la tarjeta... Verificación exitosa.");
        return true;
    }

    @Override
    public void confirmarPago() {
        System.out.println("Pago con tarjeta confirmado. Transacción completada.");
    }
}