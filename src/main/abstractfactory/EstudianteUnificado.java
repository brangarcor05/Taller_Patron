package abstractfactory;
import java.util.ArrayList;
import java.util.List;
import visitor.Solicitud;
import visitor.SolicitudVisitor;

public class EstudianteUnificado {
    private int id;
    private String nombre;
    
    // Para Factory Pattern (inscripción en materias)
    private List<Materia> materiasInscritas;
    
    // Para Visitor Pattern (solicitudes)
    private List<Solicitud> solicitudes;

    public EstudianteUnificado(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.materiasInscritas = new ArrayList<>();
        this.solicitudes = new ArrayList<>();
    }

    // === MÉTODOS PARA FACTORY PATTERN ===
    
    public boolean inscribirseEnMateria(Materia m) {
        if (m.inscribirEstudiante(this)) {
            materiasInscritas.add(m);
            return true;
        }
        return false;
    }
    
    public void mostrarMateriasInscritas() {
        System.out.println("=== Materias inscritas de " + nombre + " ===");
        if (materiasInscritas.isEmpty()) {
            System.out.println("  No tiene materias inscritas.");
        } else {
            for (Materia materia : materiasInscritas) {
                System.out.println("  - " + materia.getNombre() + " (" + materia.getHorario() + ")");
            }
        }
    }

    // === MÉTODOS PARA VISITOR PATTERN ===
    
    public void agregarSolicitud(Solicitud s) {
        solicitudes.add(s);
    }

    public void procesarSolicitudes(SolicitudVisitor visitor) {
        System.out.println("Procesando solicitudes de: " + nombre);
        for (Solicitud s : solicitudes) {
            s.aceptar(visitor);
        }
    }
    
    public void mostrarSolicitudes() {
        System.out.println("=== Solicitudes de " + nombre + " ===");
        if (solicitudes.isEmpty()) {
            System.out.println("  No tiene solicitudes pendientes.");
        } else {
            System.out.println("  Total de solicitudes: " + solicitudes.size());
        }
    }

    // === GETTERS Y SETTERS ===
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Materia> getMateriasInscritas() {
        return materiasInscritas;
    }

    public List<Solicitud> getSolicitudes() {
        return solicitudes;
    }
}