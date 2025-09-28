import java.util.Date;
public class Main {
    public static void main(String[] args) {
        Estudiante e = new Estudiante("Juan Pérez", "12345");

        e.agregarSolicitud(new SolicitudCertificado("Notas", 50.0, new Date()));
        e.agregarSolicitud(new SolicitudCitaConsejero("Orientación académica", "Lunes", "Presencial"));

        SolicitudVisitor validador = new ValidacionVisitor();
        e.procesarSolicitudes(validador);
    }
}
