# Informe Trabajo Práctico - POO en Java

--Panelo Ignacio--

---

## 1. Aplicación del Encapsulamiento

El encapsulamiento se aplicó declarando todos los atributos de las clases como **privados** (`private`) y proporcionando métodos públicos **getter** y **setter** para acceder y modificar estos atributos.

### Implementación:

**Clase Estudiante:**
```java
private String nombre;
private String apellido;
private int edad;
private String carrera;
private double promedio;
private ArrayList<Materia> materias;

// Métodos de acceso
public String getNombre() { return nombre; }
public void setNombre(String nombre) { this.nombre = nombre; }
Clase Materia:
javaprivate String nombre;
private String codigo;
private int creditos;
private double calificacion;
Clase Carrera:
javaprivate String nombre;
private String direccion;
private ArrayList<Estudiante> estudiantes;
Beneficios obtenidos:

Protección de datos contra acceso no autorizado
Control total sobre cómo se modifican los atributos
Posibilidad de agregar validaciones en los setters
Mayor facilidad de mantenimiento del código


2. Implementación de Relaciones entre Clases
Se implementaron dos tipos de relaciones:
Relación 1: Estudiante → Materia (Composición 1 a N)
Un estudiante tiene varias materias.
javapublic class Estudiante {
    private ArrayList<Materia> materias;
    
    public Estudiante() {
        this.materias = new ArrayList<>();
    }
    
    public void agregarMateria(Materia materia) {
        if (materia != null) {
            materias.add(materia);
        }
    }
    
    public double calcularPromedio() {
        if (materias.isEmpty()) {
            return 0.0;
        }
        double suma = 0;
        for (Materia materia : materias) {
            suma += materia.getCalificacion();
        }
        this.promedio = suma / materias.size();
        return this.promedio;
    }
}
Características:

Un estudiante puede tener múltiples materias
El método agregarMateria() permite asociar materias al estudiante
El método calcularPromedio() recorre todas las materias y calcula el promedio de sus calificaciones

Relación 2: Carrera → Estudiante (Agregación 1 a N)
Una carrera contiene varios estudiantes.
javapublic class Carrera {
    private ArrayList<Estudiante> estudiantes;
    
    public Carrera(String nombre, String direccion) {
        this.estudiantes = new ArrayList<>();
    }
    
    public void agregarEstudiante(Estudiante estudiante) {
        if (estudiante != null) {
            estudiantes.add(estudiante);
        }
    }
    
    public void listarEstudiantes() {
        for (Estudiante estudiante : estudiantes) {
            System.out.println(estudiante.getNombre() + " " + 
                             estudiante.getApellido() + 
                             " | Promedio: " + estudiante.getPromedio());
        }
    }
    
    public Estudiante buscarEstudiante(String nombre) {
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getNombre().equalsIgnoreCase(nombre)) {
                return estudiante;
            }
        }
        return null;
    }
}
Características:

Una carrera gestiona múltiples estudiantes
Métodos para agregar, listar y buscar estudiantes
La relación permite organizar estudiantes por carrera

Diagrama de relaciones:
Carrera (1) ──────> (N) Estudiante (1) ──────> (N) Materia

3. Validaciones en los Métodos Setter
Se implementaron tres validaciones críticas en la clase Estudiante:
Validación 1: Nombre y Apellido no vacíos
javapublic void setNombre(String nombre) {
    if (nombre == null || nombre.trim().isEmpty()) {
        System.out.println("Error: El nombre no puede estar vacío");
        return;
    }
    this.nombre = nombre;
}

public void setApellido(String apellido) {
    if (apellido == null || apellido.trim().isEmpty()) {
        System.out.println("Error: El apellido no puede estar vacío");
        return;
    }
    this.apellido = apellido;
}
Justificación: Todo estudiante debe tener una identificación válida con nombre y apellido.
Validación 2: Edad mayor a 16 años
javapublic void setEdad(int edad) {
    if (edad <= 16) {
        System.out.println("Error: La edad debe ser mayor a 16 años");
        return;
    }
    this.edad = edad;
}
Justificación: Requisito institucional que establece que los estudiantes universitarios deben tener más de 16 años.
Validación 3: Promedio entre 0 y 10
javapublic void setPromedio(double promedio) {
    if (promedio < 0 || promedio > 10) {
        System.out.println("Error: El promedio debe estar entre 0 y 10");
        return;
    }
    this.promedio = promedio;
}
Justificación: El sistema de calificación utiliza una escala de 0 a 10, por lo que no se permiten valores fuera de este rango.
Comportamiento de las Validaciones
Cuando se detecta un valor inválido:

Se muestra un mensaje de error descriptivo en consola
El atributo no se modifica (mantiene su valor anterior o permanece sin inicializar)
El programa continúa su ejecución sin interrupciones

Esto garantiza la integridad de los datos y evita que se almacenen valores incorrectos en los objetos.

Conclusión
Este trabajo práctico implementó exitosamente los principios fundamentales de la POO:

Encapsulamiento: Todos los atributos privados con acceso controlado
Relaciones entre clases: Composición y agregación para modelar el dominio
Validación de datos: Garantizando la integridad mediante reglas de negocio

El resultado es un sistema robusto, mantenible y que respeta las mejores prácticas de Java.