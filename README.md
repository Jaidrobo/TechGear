
# TechGear "E-commerce"

Es un proyecto de comercio electrónico diseñado para la venta de productos tecnológicos. _"facilitando a los usuarios navegar por un catálogo de productos, agregarlos al carrito de compras, gestionar sus pedidos y realizar pagos de forma segura"_. 

_**El objetivo principal:**_ _es ofrecer una experiencia de compra fluida y eficiente, con una interfaz intuitiva y un backend robusto_.

En ese sentido, la propuesta del presente proyecto se centra en el diseño arquitectónico de **"TechGear"**, _una plataforma de que busca abordar los desafíos clave de este nicho, la compatibilidad y necesidad del cliente_.
## 🛠️ Tecnologías y Herramientas Utilizadas

El proyecto contempla un conjunto de tecnologías y herramientas que garantizan su funcionalidad, escalabilidad y seguridad.

**BackEnd:** 
- _Java (Lenguaje)_ 
- _JDK/JRE 24 (Máquina Virtual de Java)_
- _JUnit 5 (Jupiter) Framework de pruebas unitarias_
 

### _=== BackEnd ===_

## Clases
La implementación de las clases **“Producto, Usuario y CarritoDeCompra”** es clave para el correcto funcionamiento de la e-commerce, ya que encapsulan la información de los artículos, los compradores y la gestión de los productos seleccionados respectivamente, formando la base de la lógica de **"TechGear”**, mejorando la experiencia del cliente.

![Test de Producto](assets/Producto1.png)

![Test de Producto](assets/Producto2.png)

![Test de Usuario](assets/Usuario1.png)

![Test de Usuario](assets/Usuario2.png)

![Test de Carrito](assets/Carrito1.png)

![Test de Carrito](assets/Carrito2.png)


### _Extensión de Funcionalidades mediante Herencia_
Permite una gestión organizada, reutilización de código y una extensión flexible del sistema a medida que la e-commerce crece, optimizando la forma en que los “productos, clientes y el proceso de compra se manejan de forma estructurada y modular”.

![Ext de Producto](assets/Prod_Digital.png)

![Ext de Producto](assets/Prod_Fisico.png)

![Ext de Usuario](assets/Cliente1.png)

![Ext de Usuario](assets/Cliente2.png)

![Ext de Usuario](assets/Administrador.png)

_El administrador tendrá permisos especiales, como la capacidad de modificar productos directamente en el inventario._


## Aplicación de Polimorfismo y Sobrecarga
La implementación de polimorfismo y sobrecarga permite manejar diversas operaciones sobre productos y pedidos en la plataforma "TechGear”.

![Test de Producto](assets/MostrarDetalle.png)

_La sobreescritura de métodos permite que una clase hija proporcione una implementación específica para un método que ya está definido en su clase padre._

![Método Override](assets/Override1.png)

![Método Override](assets/Override2.png)


_Sobrecarga de Métodos agregarProducto () en la clase CarritoDeCompras._

![Test Sobrecarga](assets/Sobrecarga1.png)

#### _Implementación de Polimorfismo_ 

_Al procesar objetos de diferentes clases a través de una única interfaz. Dado a que ProductoFisico y ProductoDigital son Producto, se pueden tratar a todos por igual._

_En ese sentido se crea una Clase principal llamada **(Store.java)** que simula el funcionamiento de la e-commerce **"TechGear”**, La cual, instancian los objetos y se demuestra la interacción entre ellos, aplicando polimorfismo, herencia, sobrecarga y sobreescritura._

![Test Store](assets/Store1.png)

![Test Store](assets/Store2.png)


## Aplicación de Encapsulamiento y Abstracción
Permite ocultar la complejidad interna de un objeto (encapsulamiento) y presentar solo las características esenciales de manera simplificada (abstracción).

![Test Encapsulamiento](assets/Encapsu1.png)

![Test Encapsulamiento](assets/Encapsu2.png)

![Test Abstracción](assets/Abstraccion.png)


## Implementación de Interfaces y Clases Abstractas
Permiten definir qué deben hacer las clases (interfaces) o qué pueden heredar y completar las (clases abstractas), haciendo que el código sea más flexible y manejable.

![Test Clases Abstractas](assets/GestorInv.png)

![Test Clases Abstractas](assets/GestorFis.png)

![Test Clases Abstractas](assets/GestorDig.png)


#### _Interfaces_ 

![Test Interfaces](assets/Proc_Pagos.png)

![Test Interfaces](assets/Pagotarjeta.png)

![Test Interfaces](assets/PagoPayPal.png)



## Implementación de Patrones de Diseño Singleton, Factory, y Observer
Son herramientas fundamentales en el desarrollo de software que resuelven problemas comunes de forma reutilizable y organizada. El Singleton asegura que una clase solo tenga una instancia, el patrón Factory abstrae la creación de objetos, “permitiendo una generación flexible de instancias sin especificar la clase exacta”. 

![Test Patrones de Diseño](assets/Singleton.png)

![Test Patrones de Diseño](assets/Factory.png)


#### _Observer para notificaciones_

![Test Observer](assets/Observador.png)

![Test Observer](assets/Subjeto.png)

![Test Observer](assets/Estadopedido.png)

![Test Observer](assets/Email.png)

![Test Observer](assets/Inventario.png)


## Implementación de Manejo de Excepciones y Pruebas Unitarias
Facilitan la creación de software robusto, confiable y de calidad, permitiendo a los desarrolladores detectar y corregir errores de forma temprana, mejorar la experiencia del usuario al anticipar fallos inesperados y mantener la integridad del código a lo largo del tiempo. 

#### _Excepciones_

![Test Excepciones](assets/Except1.png)

![Test Excepciones](assets/Except2.png)


#### _Excepciones en la Lógica de Negocio (throw)_

![Test Excepciones logica](assets/ExcepLog1.png)

![Test Excepciones logica](assets/ExcepLog2.png)

![Test Excepciones logica](assets/Try1.png)

![Test Excepciones logica](assets/Try2.png)



### Prueba Unitarias (JUnit)
Las pruebas unitarias validan que cada "unidad" de código (cada método) funcione como se espera, tanto en casos de éxito como de error.

![Test Pruebas JUnit](assets/Test1.png)

![Test Pruebas JUnit](assets/Test2.png)

![Test Pruebas JUnit](assets/Test3.png)

![Test Pruebas JUnit](assets/Test4.png)



### _=== FrontEnd ===_

## Maqueta de Plataforma eCommerce - TechGear
Contiene la maqueta inicial de la página web para la plataforma de eCommerce **TechGear** donde el uso de tecnologías para web modernas como HTML5, CSS3 y Tailwind CSS permite crear una interfaz de usuario atractiva, interactiva y responsiva.

El proyecto contempla un conjunto de tecnologías y herramientas que garantizan su funcionalidad, escalabilidad y seguridad.

**FrontEnd:** HTML5, CSS3, Tailwind CSS,


### Estructura de Archivos
/
|-- index.html      # Archivo principal de la página
|-- css/
|   |-- styles.css  # Estilos personalizados
|-- js/
|   |-- script.js   # Lógica de JavaScript


## Capturas de Pantalla
A continuación, se muestran vistas previas de la página en diferentes dispositivos.

### Vista de Escritorio (Desktop)
_Captura de pantalla de la vista de escritorio._
![Vista de Escritorio](ruta/a/tu/imagen_desktop.png)

### Vista Móvil (Mobile)
_Captura de pantalla de la vista móvil._
![Vista Móvil](ruta/a/tu/imagen_mobile.png)