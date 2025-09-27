package factory;

import producto.Producto;
import producto.ProductoDigital;
import producto.ProductoFisico;
import usuario.Administrador;
import usuario.Cliente;
import usuario.Usuario;

// --- Implementación del patrón Factory ---
public class FabricaEntidades {

    public Producto crearProducto(String tipo, int id, String nombre, String desc, double precio, int stock, Object... args) {
        switch (tipo.toUpperCase()) {
            case "FISICO":
                // Los args para físico son: peso (double), dimensiones (String)
                return new ProductoFisico(id, nombre, desc, precio, stock, (double) args[0], (String) args[1]);
            case "DIGITAL":
                // Los args para digital son: formato (String), tamañoMB (double)
                return new ProductoDigital(id, nombre, desc, precio, stock, (String) args[0], (double) args[1]);
            default:
                throw new IllegalArgumentException("Tipo de producto desconocido: " + tipo);
        }
    }

    public Usuario crearUsuario(String tipo, int id, String nombre, String email, String pass, Object... args) {
        switch (tipo.toUpperCase()) {
            case "CLIENTE":
                // El arg para cliente es: direccion (String)
                return new Cliente(id, nombre, email, pass, (String) args[0]);
            case "ADMIN":
                // El arg para admin es: nivelAcceso (String)
                return new Administrador(id, nombre, email, pass, (String) args[0]);
            default:
                throw new IllegalArgumentException("Tipo de usuario desconocido: " + tipo);
        }
    }
}
