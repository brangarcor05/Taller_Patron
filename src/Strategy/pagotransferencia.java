package strategy;

public class pagotransferencia implements MetodoPago {
    @Override
    public void pagar(double monto) {
        System.out.println("Pagando $" + monto + " por transferencia bancaria");
    }
}
