package singleton;

// --- Implementación del patrón Singleton --- 
public class ConfiguracionSistema {
    // Instancia de la clase (privada y estática)
    private static final ConfiguracionSistema instancia = new ConfiguracionSistema();

    // Atributos de configuración
    private String urlBaseDatos;
    private String temaUI;
    private int maximoConexiones;

    // El constructor es PRIVADO para evitar que se creen instancias desde fuera.
    private ConfiguracionSistema() {
        // Se inicializan los valores por defecto (en un caso real, se leerían de un archivo)
        this.urlBaseDatos = "jdbc:mysql://localhost:3306/ecommerce";
        this.temaUI = "Oscuro";
        this.maximoConexiones = 100;
        System.out.println("Instancia de ConfiguracionSistema creada.");
    }

    // Método público y estático para obtener la única instancia
    public static ConfiguracionSistema getInstance() {
        return instancia;
    }

    // Métodos para acceder a la configuración
    public void mostrarConfiguracion() {
        System.out.println("--- Configuración del Sistema ---");
        System.out.println("URL Base de Datos: " + urlBaseDatos);
        System.out.println("Tema UI: " + temaUI);
        System.out.println("Máximo de Conexiones: " + maximoConexiones);
    }

    // Getters y Setters si se necesita modificar la configuración en tiempo de ejecución
}