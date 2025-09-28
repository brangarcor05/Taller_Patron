package abstractfactory;
import java.util.ArrayList;
import java.util.List;

public class MateriaFactory {
    private List<Materia> materias;

    public MateriaFactory() {
        this.materias = new ArrayList<>();
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public Materia crearMateria(String nombre, int cuposTotales, String horario) {
        Materia m = new Materia(nombre, cuposTotales, horario);
        materias.add(m);
        return m;
    }
}
