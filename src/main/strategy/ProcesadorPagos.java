package strategy;
public class ProcesadorPagos {
    private MetodoPago MetodoPago;

    public void setMetodoPago(MetodoPago MetodoPago) {
        this.MetodoPago = MetodoPago;
    }

    public void procesarPago(double monto) {
        if (MetodoPago != null) {
            MetodoPago.pagar(monto);
        } else {
            System.out.println("Método de pago no seleccionado");
        }
    }
}
