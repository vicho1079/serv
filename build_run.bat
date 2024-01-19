@echo off

rem Definir el nombre de la imagen
set IMAGEN=servfpyme

echo Recompilando servidor
mvn clean install -DskipTests

if %errorlevel% neq 0(
    echo Error al recompilar
    exit /b %errorlevel%
)

echo Borrando imagen existente: %IMAGEN%
docker rmi %IMAGEN%

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