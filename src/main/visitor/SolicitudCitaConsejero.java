package visitor;
public class SolicitudCitaConsejero implements Solicitud {
    private String motivo;
    private String dia;
    private String modalidad;

    public SolicitudCitaConsejero(String motivo, String dia, String modalidad) {
        // Validar que el motivo no sea nulo ni vacío
        if (motivo == null || motivo.trim().isEmpty()) {
            throw new IllegalArgumentException("El motivo de la cita no puede estar vacío");
        }
        
        // Validar que el día no sea nulo ni vacío
        if (dia == null || dia.trim().isEmpty()) {
            throw new IllegalArgumentException("El día de la cita no puede estar vacío");
        }
        
        this.motivo = motivo.trim();
        this.dia = dia.trim();
        this.modalidad = (modalidad != null) ? modalidad.trim() : "Presencial"; // Valor por defecto
    }
    public String getMotivo() {
         return motivo; 
        }
    public String getDia() { 
        return dia; 
    }
    public String getModalidad() { 
        return modalidad; 
    }

    @Override
    public void aceptar(SolicitudVisitor visitor) {
        visitor.validar(this);
    }
}
