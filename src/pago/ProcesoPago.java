package pago;

/**
 * Interfaz que define el contrato para cualquier método de pago.
 * Todas las clases que implementen esta interfaz deben proporcionar lógica para estos tres métodos.
 */
public interface ProcesoPago {
    // Los métodos en una interfaz son públicos y abstractos por defecto.
    void iniciarPago(double monto);
    boolean verificarPago();
    void confirmarPago();
}

