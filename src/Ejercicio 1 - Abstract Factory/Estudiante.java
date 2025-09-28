import java.util.ArrayList;
import java.util.List;

public class Estudiante {
    private int id;
    private String nombre;
    private List<Materia> materiasInscritas;

    public Estudiante(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.materiasInscritas = new ArrayList<>();
    }

    // Getters y Setters
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


    public boolean inscribirseEnMateria(Materia m) {
        if (m.inscribirEstudiante(this)) {
            materiasInscritas.add(m);
            return true;
        }
        return false;
    }
}
