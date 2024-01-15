#!/bin/bash
# Script para construir la imagen de Docker y ejecutar Docker Compose

# Nombre de la imagen
nombre_imagen="servfpyme"

# Construir la imagen con Docker
echo "Construyendo la imagen con Docker..."

# Comprobar si la construcción fue exitosa
if ! docker build -t nombre_imagen . ; then
  echo "Error durante la construcción de la imagen."
  exit 1
fi
echo "Construcción exitosa. Iniciando Docker Compose..."
# Ejecutar Docker Compose

if ! docker-compose up -d; then
  echo "Error durante la construcción del contenedor."
  exit 1
fi

echo "Construcción exitosa. Iniciando"