package strategy;

public class pagotarjeta implements metodopago {
    @Override
    public void pagar(double monto) {
        System.out.println("Pagando $" + monto + " con tarjeta de crédito");
    }
}
