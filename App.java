public class App {
    public static void main(String[] args) {
        Carrera ing = new Carrera("Ingeniería en Sistemas");

        Estudiante e1 = new Estudiante();
        try {
            e1.setNombre("María");
            e1.setApellido("Gómez");
            e1.setEdad(20);
            e1.setCarrera(ing.getNombre());
        } catch (IllegalArgumentException ex) {
            System.err.println("Error al crear e1: " + ex.getMessage());
        }
        // Agregar materias
        Materia m1 = new Materia("Programación I", "PROG101", 4, 8.5);
        Materia m2 = new Materia("Matemáticas Discretas", "MATD102", 3, 7.5);
        e1.agregarMateria(m1);
        e1.agregarMateria(m2);

        
        Estudiante e2 = null;
        try {
            e2 = new Estudiante("Juan", "Pérez", 22, ing.getNombre(), 0.0);
            e2.agregarMateria(new Materia("Algoritmos", "ALG201", 4, 9.0));
            e2.agregarMateria(new Materia("Estructuras de Datos", "EDA202", 4, 8.0));
        } catch (IllegalArgumentException ex) {
            System.err.println("Error al crear e2: " + ex.getMessage());
        }

        Estudiante e3 = new Estudiante("Luisa", "Fernández", 19, ing.getNombre(), 0.0);
        e3.agregarMateria(new Materia("Bases de Datos", "BD301", 3, 6.5));
        e3.agregarMateria(new Materia("Sistemas Operativos", "SO302", 4, 7.0));

        // Agregar estudiantes a la carrera
        ing.agregarEstudiante(e1);
        ing.agregarEstudiante(e2);
        ing.agregarEstudiante(e3);

        System.out.println("Promedios calculados:");
        for (Estudiante e : ing.getEstudiantes()) {
            System.out.printf(" - %s %s: %.2f\n", e.getNombre(), e.getApellido(), e.calcularPromedio());
        }

        System.out.println();

        // Listar todos los estudiantes de la carrera
        ing.listarEstudiantes();

        System.out.println();

        String buscar = "Juan";
        System.out.println("Buscando estudiante con nombre: " + buscar);
        ing.buscarEstudiante(buscar).ifPresentOrElse(
                est -> System.out.println("  Encontrado: " + est),
                () -> System.out.println("  No se encontró al estudiante.")
        );
    }
}