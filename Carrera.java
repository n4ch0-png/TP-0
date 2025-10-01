import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Carrera {
    private String nombre;
    private List<Estudiante> estudiantes;

    public Carrera(String nombre) {
        setNombre(nombre);
        this.estudiantes = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la carrera no puede estar vacío.");
        }
        this.nombre = nombre.trim();
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void agregarEstudiante(Estudiante e) {
        if (e == null) {
            throw new IllegalArgumentException("El estudiante no puede ser nulo.");
        }
        this.estudiantes.add(e);
    }

    public void listarEstudiantes() {
        System.out.println("Estudiantes de la carrera: " + nombre);
        if (estudiantes.isEmpty()) {
            System.out.println("  (sin estudiantes)");
            return;
        }
        for (Estudiante e : estudiantes) {
            System.out.println("  - " + e);
        }
    }

    public Optional<Estudiante> buscarEstudiante(String nombre) {
        return estudiantes.stream()
                .filter(e -> e.getNombre().equalsIgnoreCase(nombre))
                .findFirst();
    }
}
