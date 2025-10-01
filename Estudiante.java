import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Estudiante {
    private String nombre;
    private String apellido;
    private int edad;
    private String carrera;
    private double promedio; // 0 - 10
    private List<Materia> materias;

    
    public Estudiante() {
        this.nombre = "";
        this.apellido = "";
        this.edad = 17;
        this.carrera = "";
        this.promedio = 0.0;
        this.materias = new ArrayList<>();
    }

    
    public Estudiante(String nombre, String apellido, int edad, String carrera, double promedio) {
        setNombre(nombre);
        setApellido(apellido);
        setEdad(edad);
        setCarrera(carrera);
        setPromedio(promedio);
        this.materias = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        this.nombre = nombre.trim();
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        if (apellido == null || apellido.trim().isEmpty()) {
            throw new IllegalArgumentException("El apellido no puede estar vacío.");
        }
        this.apellido = apellido.trim();
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad <= 16) {
            throw new IllegalArgumentException("La edad debe ser mayor a 16 años.");
        }
        this.edad = edad;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        if (carrera == null) carrera = "";
        this.carrera = carrera.trim();
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        if (promedio < 0.0 || promedio > 10.0) {
            throw new IllegalArgumentException("El promedio debe estar entre 0 y 10.");
        }
        this.promedio = promedio;
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    
    public void agregarMateria(Materia materia) {
        if (materia == null) {
            throw new IllegalArgumentException("La materia no puede ser nula.");
        }
        this.materias.add(materia);
        actualizarPromedioDesdeMaterias();
    }

    public double calcularPromedio() {
        if (materias.isEmpty()) return 0.0;
        double suma = 0.0;

         int creditosSuma = 0;
        for (Materia m : materias) {
            suma += m.getCalificacion() * Math.max(1, m.getCreditos());
            creditosSuma += Math.max(1, m.getCreditos());
        }
        double promedioCalculado = (creditosSuma == 0) ? 0.0 : suma / creditosSuma;
        this.promedio = Math.round(promedioCalculado * 100.0) / 100.0; // redondear 2 decimales
        return this.promedio;
    }

    private void actualizarPromedioDesdeMaterias() {
        calcularPromedio();
    }

    public Optional<Materia> buscarMateriaPorCodigo(String codigo) {
        return materias.stream().filter(m -> m.getCodigo().equalsIgnoreCase(codigo)).findFirst();
    }

    
    public String toString() {
        return String.format("%s %s - Edad: %d - Carrera: %s - Promedio: %.2f", nombre, apellido, edad, carrera, promedio);
    }
}
