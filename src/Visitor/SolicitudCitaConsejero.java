public class SolicitudCitaConsejero implements Solicitud {
    private String motivo;
    private String dia;
    private String modalidad;

    public SolicitudCitaConsejero(String motivo, String dia, String modalidad) {
        this.motivo = motivo;
        this.dia = dia;
        this.modalidad = modalidad;
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


