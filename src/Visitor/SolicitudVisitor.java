public interface SolicitudVisitor {
    void validar(SolicitudCertificado s);
    void validar(SolicitudCitaConsejero s);
}
