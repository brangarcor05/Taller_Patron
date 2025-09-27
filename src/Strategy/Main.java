package strategy;

public class Main {
    public static void main(String[] args) {
        ProcesadorPagos procesador = new ProcesadorPagos();
        
        procesador.setMetodoPago(new PagoTarjeta());
        procesador.procesarPago(1500000);
        
        procesador.setMetodoPago(new PagoTransferencia());
        procesador.procesarPago(800000);
    }
}
