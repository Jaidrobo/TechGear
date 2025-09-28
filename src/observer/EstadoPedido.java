package observer;

import java.util.ArrayList;
import java.util.List;

public class EstadoPedido implements Sujeto {
    private List<Observador> observadores = new ArrayList<>();
    private int idPedido;
    private String estadoActual;

    public EstadoPedido(int idPedido) {
        this.idPedido = idPedido;
        this.estadoActual = "Creado";
    }

    public void setEstado(String nuevoEstado) {
        this.estadoActual = nuevoEstado;
        System.out.println("\n Cambio de Estado: El pedido #" + idPedido + " ahora está '" + estadoActual + "'. Notificando...");
        notificarObservadores("Cambio_Estado_Pedido", "El nuevo estado es: " + estadoActual);
    }

    @Override
    public void registrarObservador(Observador o) { observadores.add(o); }
    @Override
    public void removerObservador(Observador o) { observadores.remove(o); }
    @Override
    public void notificarObservadores(String evento, String detalles) {
        for (Observador o : observadores) {
            o.actualizar(evento, detalles);
        }
    }
}   