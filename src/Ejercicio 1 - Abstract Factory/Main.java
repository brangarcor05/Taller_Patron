public class Main {
    public static void main(String[] args) {
        MateriaFactory factory = new MateriaFactory();

        Materia calculo = factory.crearMateria("Cálculo I", 2, "Lunes 8-10am");
        Materia filosofia = factory.crearMateria("Filosofía", 1, "Martes 10-12am");

        Estudiante e1 = new Estudiante(1, "Ana");
        Estudiante e2 = new Estudiante(2, "Carlos");
        Estudiante e3 = new Estudiante(3, "Laura");

        // colocamos inscripciones de ejemplo
        e1.inscribirseEnMateria(calculo);
        e2.inscribirseEnMateria(calculo);
        e3.inscribirseEnMateria(calculo); // sin cupos

        e1.inscribirseEnMateria(filosofia);
        e2.inscribirseEnMateria(filosofia); // sin cupos


    for (Materia m : factory.getMaterias()) {
    m.mostrarInscritos();
    System.out.println("Cupos restantes: " + m.getCuposDisponibles());
    }

        System.out.println("\nResumen de inscripciones:");
        for (Materia m : factory.getMaterias()) {
            System.out.println("Materia: " + m.getNombre() + 
                               " | Cupos disponibles: " + m.getCuposDisponibles() + 
                               " | Estudiantes inscritos: " + m.getInscritos().size());
        }
    }
}
