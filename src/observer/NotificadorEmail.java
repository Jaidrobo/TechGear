package observer;

public class NotificadorEmail implements Observador {
    @Override
    public void actualizar(String evento, String detalles) {
        if (evento.equals("Cambio_Estado_Pedido")) {
            System.out.println(" -> Email enviado: " + detalles);
        }
    }
}