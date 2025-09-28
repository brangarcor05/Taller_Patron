package abstractfactory;
import java.util.ArrayList;
import java.util.List;

public class Materia {
    private String nombre;
    private int cuposTotales;
    private int cuposDisponibles;
    private String horario;
    private List<EstudianteUnificado> inscritos;

    public Materia(String nombre, int cuposTotales, String horario) {
        this.nombre = nombre;
        this.cuposTotales = cuposTotales;
        this.cuposDisponibles = cuposTotales;
        this.horario = horario;
        this.inscritos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCuposTotales() {
        return cuposTotales;
    }

    public void setCuposTotales(int cuposTotales) {
        this.cuposTotales = cuposTotales;
    }

    public int getCuposDisponibles() {
        return cuposDisponibles;
    }

    public void setCuposDisponibles(int cuposDisponibles) {
        this.cuposDisponibles = cuposDisponibles;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public List<EstudianteUnificado> getInscritos() {
        return inscritos;
    }


    public boolean hayCupos() {
        return cuposDisponibles > 0;
    }

    public boolean inscribirEstudiante(EstudianteUnificado e) {
        if (hayCupos() && !inscritos.contains(e)) {
            inscritos.add(e);
            cuposDisponibles--;
            System.out.println(e.getNombre() + " se inscribió en " + nombre);
            return true;
        }
        System.out.println("No hay cupos disponibles en " + nombre + " para " + e.getNombre());
        return false;
    }
    


    public void mostrarInscritos() {
    System.out.println("Materia: " + nombre);
    if (inscritos.isEmpty()) {
        System.out.println("  No hay estudiantes inscritos.");
    } else {
        System.out.println("  Estudiantes inscritos:");
        for (EstudianteUnificado e : inscritos) {
            System.out.println("   - " + e.getNombre());
        }
    }
}


}

