package strategy;

public class ProcesadorPagos {
    private MetodoPago MetodoPago;

    public void setMetodoPago(MetodoPago MetodoPago) {
        this.metodoPago = metodoPago;
    }

    public void procesarPago(double monto) {
        if (metodoPago != null) {
            metodoPago.pagar(monto);
        } else {
            System.out.println("Método de pago no seleccionado");
        }
    }
}
