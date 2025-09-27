package strategy;

public class PagoTarjeta implements metodopago {
    @Override
    public void pagar(double monto) {
        System.out.println("Pagando $" + monto + " con tarjeta de crédito");
    }
}
