
public class ValidacionVisitor implements SolicitudVisitor {
    @Override
    public void validar(SolicitudCertificado s) {
        System.out.println("Validando certificado de tipo: " + s.getTipo());
        if (s.getPrecio() <= 0) {
            System.out.println("Error: El precio debe ser mayor que cero.");
        } else {
            System.out.println(" Certificado válido. Entrega: " + s.getEntrega());
        }
    }

    @Override
    public void validar(SolicitudCitaConsejero s) {
        System.out.println("Validando cita con consejero. Motivo: " + s.getMotivo());
        if (s.getDia() == null || s.getDia().isEmpty()) {
            System.out.println("Error: El día no puede estar vacío.");
        } else {
            System.out.println("Cita agendada en modalidad: " + s.getModalidad() + " para el día " + s.getDia());
        }
    }
}
