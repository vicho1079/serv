@echo off

rem Definir el nombre de la imagen
set IMAGEN=servfpyme


echo Borrando imagen existente: %IMAGEN%
docker rmi %IMAGEN%

if %errorlevel% neq 0 (
    echo Ya imagen ya esta borrada
    exit /b %errorlevel%
)

echo Construyendo la imagen de Docker: %IMAGEN%
docker build -t %IMAGEN% .
if %errorlevel% neq 0 (
    echo Error al construir imagen
    exit /b %errorlevel%
)
echo Imagen construida exitosamente.


echo Iniciando el contenedor con Docker Compose...
docker-compose up -d
if %errorlevel% neq 0 (
    echo Error al construir contenedor
    exit /b %errorlevel%
)
echo Contenedor iniciado exitosamente.