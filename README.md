# Taller de Patrones de Diseño GoF

Este repositorio contiene la implementación del **Taller de Patrones de Diseño GoF**, aplicado al sistema universitario **Intranet**.  
El propósito es aplicar patrones de diseño para resolver problemas comunes en la gestión académica, mejorando la escalabilidad, el mantenimiento y la reutilización del código.

---

## 📖Ejercicios Implementados
### 1. Abstract Factory – Gestión de Inscripción en Materias 📆
Permite crear y gestionar materias con cupos y horarios, garantizando que los estudiantes se inscriban de manera correcta y que el sistema administre la disponibilidad.

### 2. Visitor – Gestión de Solicitudes de Estudiantes 📜
Gestiona solicitudes como certificados o citas con el consejero, aplicando validaciones específicas según el tipo de solicitud.

### 3. Patrón Adicional - Strategy 💵
Se implementó el patrón **Strategy** para la gestión flexible de pagos dentro del sistema universitario.  
El patrón permite definir una **familia de algoritmos de pago** (tarjeta, transferencia, etc.) y encapsularlos en clases separadas, de manera que el algoritmo utilizado pueda variar en tiempo de ejecución sin modificar el código del cliente.

---
## ▶️Compilación y ejecución
Reccomendamos usar GitHub Codespaces o un entorno Linux/Mac. En Windows se puede usar Git Bash o WSL para ejecutar el script sin problemas.

Para compilar y ejecutar seguir estos pasos:

1. Clonar este repositorio:
```bash
git clone https://github.com/brangarcor05/Taller_Patron.git
```
2. Cambiar al directorio del repositorio:
```bash
cd Taller_Patron
```
3. Dar permisos al script `compile.sh` (solo la primera vez):
```bash
chmod +x compile.sh
```
4. Compilar y ejecutar el programa:
```bash
./compile.sh
```
### 💡Qué hace `compile.sh`?
1. Crea la carpeta bin/ automáticamente (si no existe)
2. Compila todos los archivos .java dentro de la carpeta src/
3. Ejecuta la clase principal Main
4. Muestra mensajes de progreso y resultado en la consola
---

## 🗂️Estructura del proyecto
```bash
├── docs/                                    # Diagramas de clase y documentación
│   ├── ejercicio1-patron Abstract Factory/  # Abstract Factory
│   ├── ejercicio2-patron Visitor/           # Visitor
│   └── patrones integrados.jpg              # Diagrama de clases integrado Factory-Visitor
├── src/                                     # Código fuente de los ejercicios
│   └── main/
│       ├── abstractfactory/                 # Abstract Factory
│       ├── visitor/                         # Visitor
│       ├── strategy/                        # Patrones adicionales
│       └── MainGeneral.java                 # Archivo main
├── LICENSE
├── README.md
└── compile.sh                               # Archivo para compilar y ejecutar
```
---

## ✅Entregables
- Diagramas de clase de cada patrón implementado
- Código funcional en Java
- Informe con justificación de los patrones adicionales seleccionados

---

## 👥Equipo de Desarrollo
- Brandon García
- Mateo Zamora
- Samuel Rey
- Andrés Beltrán
- Eileen Rodríguez
