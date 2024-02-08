# ServFpyme:
## Stack
Se utiliza springboot v3.2.1 del lado del servidor usando las dependencias:
* Spring Web;
* Spring Security;
* Spring Data Jpa;
* Mysql Driver v8.2.0;
* io.jsonwebtoken v0.11.5;
* y otras especificadas en el archivo pom.xlm.
Como gestor de dependencias se usa Maven.
Para desplegar la aplicación se utiliza docker, para más detalles visitar archivos "Dockerfile" y "compose.yaml". Se utiliza la imagen "amazoncorretto:17" para crear la imagen del servidor y se utilizan las imagenes "mysqlo:8.2.0" y "phpmyadmin/phpmyadmin" como DBMS.
## Estructura del proyecto:
En la carpeta serv que se en cuentra en la ruta "src/main/java/com/fpyme/serv" se encuentran distribuidos los paquetes que conforman el servidor. Estos son:
* configuration.
* controllers.
* jwtSecurity.
* model.
* repositories.
* services.
### Configuration
Esta carpeta consta con 2 archivos:
* WebSecurityConfig: 
