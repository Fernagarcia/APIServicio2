# Reconocimientos Extra
>V1.0

La API Reconocimientos Extra facilitara la selección de colaboradores de la ONG. 

### ¿Como buscamos colaboradores?
Se solicitará que ingresen:
* Una cantidad mínima de puntos requeridas
* Una cantidad mínima de donaciónes realizadas el último mes
* Una cantidad máxima de colaboradores que quieran ser incorporados

La API brindara todos los colaborades posibles, en el caso que no hayan traido la cantidad maxima de colaboradores a incorporar es porque no existen más colaboradores.


### Instalacion

1. Clonar el repositorio
2. Crea un esquema en el motor de base de datos con el nombre que más te guste
3. Abrir el archivo application.properties dentro de resourses y modificar los datos 
   * spring.datasource.url=jdbc:mysql://127.0.0.1:3306/nombre_del_esquema_creado
   * spring.datasource.username=tu_nombre
   * spring.datasource.password=tu_contraseña
4. (Opcional) Correr el archivo colaboradoresSeeder.sql para tener datos de prueba en la BD
5. Correr ReconocimientosExtraApplication

Una vez hecho estos pasos abri tu navegador he ingresa a http://localhost:8080/swagger-ui/index.html para poder visualizar el endpoint y sus respuestas.




