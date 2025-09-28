#!/bin/bash
echo "Compilando proyecto..."

# Crear directorio bin si no existe
mkdir -p bin

# Compilar todos los archivos Java
find src -name "*.java" > sources.txt
javac -d bin @sources.txt
rm sources.txt

echo "Compilación completada. Ejecutando..."
java -cp bin main.MainGeneral