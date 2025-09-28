package visitor;
public interface Solicitud {
    void aceptar(SolicitudVisitor visitor);
}