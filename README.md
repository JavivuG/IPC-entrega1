# IPC Entrega 1: gestor de libros con Swing

Aplicación de escritorio en Java Swing para dar de alta, editar y borrar referencias de libros desde una única ventana.

Asignatura **Interacción Persona-Computadora**, primera entrega, 2.º curso, 2.º cuatrimestre, curso 2022-2023. Grado en Ingeniería Informática, Universidad de Valladolid.

## Qué hace

- Formulario con título, ISBN, descripción, estado (`Malo`, `Regular` o `Bueno`), precio (unidades y decimales con dos `JSpinner`) y la casilla "leído".
- Lista (`JList`) con los libros guardados. Al seleccionar uno se puede editar o borrar.
- Valida los datos antes de guardar: el título debe tener entre 1 y 20 caracteres y el ISBN entre 1 y 13, sin ISBN repetidos. Además, no deja cambiar el ISBN de un libro existente.
- Muestra mensajes de éxito y de error en la propia ventana.
- Atajos de teclado: `Supr` borra el libro seleccionado en la lista y `Esc` quita la selección. Con el foco en Editar o Borrar, las teclas `1`-`9` seleccionan el libro de esa posición. `Enter` marca o desmarca la casilla "leído".

## Tecnologías

- Java 11
- Swing, con la apariencia Nimbus, y formularios del editor visual de NetBeans (`.form`)
- Proyecto NetBeans con Ant (`build.xml`, `nbproject/`)

## Lo que aprendí / Aspectos técnicos destacados

- **Separación Modelo-Vista-Controlador**: `Modelo` guarda la lista de `ReferenciaLibro`, `Vista` es el `JFrame` y `Controlador` concentra la lógica de los eventos (`procesarEventoGuardar`, `procesarEventoEditar`, `procesarEventoBorrar`).
- **Un único botón para guardar**: si hay un libro seleccionado, el botón lo actualiza y, si no, lo añade. La identidad del libro es el ISBN (`equals`).
- **Precio a partir de dos enteros**: `getPrecio()` combina las unidades y los decimales en un `double`.
- **Usabilidad**: el tamaño mínimo de la ventana es fijo (600x350) para que el diseño no se rompa al redimensionarla, y hay atajos de teclado y mensajes de retroalimentación.
- Código documentado con Javadoc.

## Estructura del repositorio

```text
IPC-entrega1/
├── build.xml  manifest.mf  nbproject/   # Proyecto NetBeans/Ant
└── src/com/entrega1/
    ├── main/Main.java                   # Arranque y look and feel
    ├── modelo/Modelo.java  ReferenciaLibro.java
    └── vista/Vista.java  Vista.form  Controlador.java
```

## Requisitos

- JDK 11 o superior.
- Opcional: NetBeans o Apache Ant para usar `build.xml`.

## Cómo compilar y ejecutar

Abre la carpeta como proyecto en NetBeans y ejecútalo, o usa Ant:

```sh
ant run
```

Sin IDE ni Ant, con el JDK:

```sh
javac --release 11 -d build/classes $(find src -name '*.java')
java -cp build/classes com.entrega1.main.Main
```

La compilación con `javac` está comprobada con OpenJDK 17. `ant run` y el arranque de la interfaz gráfica no se han probado.

## Autoría

Proyecto en grupo. Autores de los commits: `Javier` y `jagarci` (la misma persona, Javier García González) y `hquea`.

---

Parte de [UVa-Projects](https://github.com/JavivuG/UVa-Projects).
