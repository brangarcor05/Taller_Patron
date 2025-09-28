package main;

// Import de todos los paquetes
import abstractfactory.*;
import visitor.*;
import strategy.*;
import java.util.Date;

public class MainGeneral {
    public static void main(String[] args) {
        System.out.println(" ===== SISTEMA UNIVERSITARIO INTEGRADO ===== \n");
        
        // Crear estudiantes unificados (mismos para ambos patrones)
        EstudianteUnificado ana = new EstudianteUnificado(1, "Ana García");
        EstudianteUnificado carlos = new EstudianteUnificado(2, "Carlos López");
        EstudianteUnificado laura = new EstudianteUnificado(3, "Laura Martínez");
        
        // ===== 1. PATRÓN FACTORY - GESTIÓN DE MATERIAS =====
        System.out.println("1. PATRÓN ABSTRACT FACTORY - INSCRIPCIÓN DE MATERIAS");
        System.out.println("======================================================");
        
        MateriaFactory factory = new MateriaFactory();
        Materia calculo = factory.crearMateria("Cálculo I", 2, "Lunes 8-10am");
        Materia filosofia = factory.crearMateria("Filosofía", 1, "Martes 10-12am");
        Materia programacion = factory.crearMateria("Programación", 3, "Miércoles 2-4pm");
        
        // Inscripciones
        System.out.println("\n--- Proceso de Inscripciones ---");
        ana.inscribirseEnMateria(calculo);
        carlos.inscribirseEnMateria(calculo);
        laura.inscribirseEnMateria(calculo); // Sin cupos
        
        ana.inscribirseEnMateria(filosofia);
        carlos.inscribirseEnMateria(filosofia); // Sin cupos
        
        laura.inscribirseEnMateria(programacion);
        
        // Mostrar resultados
        System.out.println("\n--- Estado de Materias ---");
        for (Materia m : factory.getMaterias()) {
            m.mostrarInscritos();
            System.out.println("  Cupos restantes: " + m.getCuposDisponibles() + "\n");
        }
        
        // ===== 2. PATRÓN VISITOR - GESTIÓN DE SOLICITUDES =====
         System.out.println("\n 2. PATRÓN VISITOR - GESTIÓN DE SOLICITUDES");
        System.out.println("============================================");
        
        // Agregar solicitudes a los estudiantes CON MANEJO DE EXCEPCIONES
        System.out.println("\n--- Creando Solicitudes ---");
        
        try {
            ana.agregarSolicitud(new SolicitudCertificado("Notas", 50.0, new Date()));
            ana.agregarSolicitud(new SolicitudCitaConsejero("Orientación académica", "Lunes", "Presencial"));
            System.out.println(" Solicitudes de Ana creadas exitosamente");
        } catch (IllegalArgumentException e) {
            System.out.println(" Error en solicitudes de Ana: " + e.getMessage());
        }
        
        try {
            // Esta línea lanzará la excepción
            carlos.agregarSolicitud(new SolicitudCitaConsejero("", "Martes", "Virtual")); // Motivo vacío
            carlos.agregarSolicitud(new SolicitudCertificado("Matrícula", 0.0, new Date()));
            System.out.println(" Solicitudes de Carlos creadas exitosamente");
        } catch (IllegalArgumentException e) {
            System.out.println(" Error en solicitudes de Carlos: " + e.getMessage());
            // Pero el programa continúa - agregamos una solicitud válida para Carlos
            System.out.println(" Creando solicitud alternativa para Carlos...");
            try {
                carlos.agregarSolicitud(new SolicitudCitaConsejero("Asesoría de horarios", "Martes", "Virtual"));
                carlos.agregarSolicitud(new SolicitudCertificado("Matrícula", 25.0, new Date()));
            } catch (IllegalArgumentException e2) {
                System.out.println(" Error en solicitud alternativa: " + e2.getMessage());
            }
        }
        
        try {
            laura.agregarSolicitud(new SolicitudCertificado("Graduación", 75.0, new Date()));
            System.out.println(" Solicitudes de Laura creadas exitosamente");
        } catch (IllegalArgumentException e) {
            System.out.println(" Error en solicitudes de Laura: " + e.getMessage());
        }
        
        // Procesar solicitudes
        SolicitudVisitor validador = new ValidacionVisitor();
        
        System.out.println("\n--- Procesando Solicitudes ---");
        ana.procesarSolicitudes(validador);
        System.out.println();
        carlos.procesarSolicitudes(validador);
        System.out.println();
        laura.procesarSolicitudes(validador);
        
        // ===== 3. PATRÓN STRATEGY - SISTEMA DE PAGOS =====
        System.out.println("\n 3. PATRÓN STRATEGY - SISTEMA DE PAGOS");
        System.out.println("=======================================");
        
        ProcesadorPagos procesador = new ProcesadorPagos();
        
        System.out.println("\n--- Procesando Pagos de Matrícula ---");
        
        // Ana paga con tarjeta
        System.out.println(" Ana García paga matrícula:");
        procesador.setMetodoPago(new PagoTarjeta());
        procesador.procesarPago(2500000);
        
        // Carlos paga con transferencia
        System.out.println(" Carlos López paga matrícula:");
        procesador.setMetodoPago(new PagoTransferencia());
        procesador.procesarPago(2300000);
        
        // Laura también paga con tarjeta
        System.out.println(" Laura Martínez paga matrícula:");
        procesador.setMetodoPago(new PagoTarjeta());
        procesador.procesarPago(2400000);
        
        System.out.println("--- Pagos de Servicios Adicionales ---");
        
        // Ana paga certificado con transferencia
        System.out.println(" Ana García paga certificado:");
        procesador.setMetodoPago(new PagoTransferencia());
        procesador.procesarPago(50000);
        
        // Carlos paga con tarjeta
        System.out.println(" Carlos López paga servicios biblioteca:");
        procesador.setMetodoPago(new PagoTarjeta());
        procesador.procesarPago(15000);
        
        // ===== RESUMEN FINAL =====
        System.out.println("\n RESUMEN FINAL DEL SISTEMA");
        System.out.println("============================");
        
        System.out.println("\n--- Resumen de Estudiantes ---");
        ana.mostrarMateriasInscritas();
        ana.mostrarSolicitudes();
        
        System.out.println();
        carlos.mostrarMateriasInscritas();
        carlos.mostrarSolicitudes();
        
        System.out.println();
        laura.mostrarMateriasInscritas();
        laura.mostrarSolicitudes();
        
        System.out.println("\n DEMOSTRACIÓN COMPLETADA - 3 PATRONES FUNCIONANDO");
    }
}