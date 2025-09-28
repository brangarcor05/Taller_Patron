import java.util.ArrayList;
import java.util.List;

public class Estudiante {
    private String nombre;
    private String id;
    private List<Solicitud> solicitudes = new ArrayList<>();

    public Estudiante(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
    }

    public void agregarSolicitud(Solicitud s) {
        solicitudes.add(s);
    }

    public void procesarSolicitudes(SolicitudVisitor visitor) {
        for (Solicitud s : solicitudes) {
            s.aceptar(visitor);
        }
    }
}
