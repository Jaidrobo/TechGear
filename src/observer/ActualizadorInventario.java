package observer;

public class ActualizadorInventario implements Observador {
    @Override
    public void actualizar(String evento, String detalles) {
        if (evento.equals("Cambio_Estado_Pedido") && detalles.contains("Enviado")) {
            System.out.println(" -> Inventario: Descontando stock del pedido.");
        }
    }
}