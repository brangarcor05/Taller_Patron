import java.util.Date;

public class SolicitudCertificado implements Solicitud {
    private String tipo;
    private double precio;
    private Date entrega;

    public SolicitudCertificado(String tipo, double precio, Date entrega) {
        this.tipo = tipo;
        this.precio = precio;
        this.entrega = entrega;
    }

    public String getTipo() { 
        return tipo; 
    }
    public double getPrecio() { 
        return precio; 
    }
    public Date getEntrega() {
         return entrega; 
    }

    @Override
    public void aceptar(SolicitudVisitor visitor) {
        visitor.validar(this);
    }
}
