# ServFpyme:
## Contenidos
* [Stack](https://github.com/vicho1079/serv/tree/dev?tab=readme-ov-file#stack).
* [Estructura del proyecto](https://github.com/vicho1079/serv/tree/dev?tab=readme-ov-file#estructura-del-proyecto)
* [Tareas pendientes](https://github.com/vicho1079/serv/tree/dev?tab=readme-ov-file#tareas-pendientes)
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
* ApplicationConfig: Esta clase crea todos los beans necesarios para que la autenticación pueda funcionar(AuthenticationManager, AuthenticationProvider, PasswordEncoder y UserDetailsService). Esta clase no tiene el mejor nombre y deberia ser cambiado.
* WebSecurityConfig: Esta clase crea el bean SecurityFilterChain que se encarga de filtrar las request http para que cumplan los parametros de seguridad que son:
  * csrf: desactivado.
  * authorizedHttpRequest: Las request que lleguen al endpoint "/auth/**" y "/doc/swagger-ui.html" quedan autorizadas automanticamente el resto sigen la cadena de seguridad.
  * sesionManagement: La politica de las sesiones es Stateless.
  * authenticationProvider: El auth provider va a ser el bean que fue declarado en la clase "ApplicationConfig".
  * addFilterBefore: Se aplica el filter personalizado para validar tokens jwt.
 
### Controllers
Esta carpeta consta de 3 archivos:
* AuthController: Este controlador se encarga de los endpoint que llegan a la ruta "/auth/**". Se tiene 2 metodos:
  * login: Se encarga de los metodos HTTP POST que llegan al endpoint "/login". Espera un "LoginRequest" como request body, el cual esta especificado en ["LoginRequest.java"](src/main/java/com/fpyme/serv/model/dto/LoginRequest.java). Retorna el resultado de llamar el metodo login de AuthService.

 ## Tareas pendientes
 * agregar.
