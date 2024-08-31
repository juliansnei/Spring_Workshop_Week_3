# Spring Boot Week - 3

RIWI se enfrenta al desafío de mejorar la gestión de contenido multimedia para sus clases 
virtuales. Para abordar esta problemática, se requiere el desarrollo de un sistema que 
permita gestionar de manera eficiente las clases, lecciones, materiales multimedia y 
estudiantes. Este sistema debe ser capaz de relacionar correctamente las clases con las 
lecciones y materiales multimedia, garantizando así la integridad y coherencia de los 
datos recopilados.

## Objetivo:
Desarrollar un sistema de gestión de contenido multimedia para clases virtuales que 
permita a RIWI almacenar y gestionar de manera eficiente las clases, lecciones y 
materiales multimedia.
## Alcance:
Para la primera versión de la aplicación se espera satisfacer unos requimientos. (Que 
pueden encontrarse en un Excel dentro de la misma carpeta que estará este documento)

## Criterios de aceptación generales.
1. Se debe realizar la API con Spring Boot, Spring JPA (Java Persistence API) y 
Hibernate.
2. Todos los endpoints deben estar documentados en Swagger.
3. Se debe manejar DTOs (Data Transfer Objects) para la respuesta y entrada de 
datos.
4. La información debe venir de la base de datos.
5. Todas las entradas deben tener validaciones para que no afecte a la base de 
datos.
6. Si no se encuentra algún registro, se debe manejar el error y responder con un 
mensaje y su respectivo estatus de error, evitando los errores 500.
7. Las relaciones con JPA deben ser bidireccionales. 
8. Cada tarea debe se debe realizar en una rama del repositorio de GitHub y todas 
las ramas deben unirse a una rama principal (develop), se deben unir mediante 
pull request.
### Ejemplo de nombre de rama: feature/task-dev-01-endpoint-add-class
## Entregables:

● Enlace del repositorio de GitHub (público) donde debe estar el código de la 
prueba con las respectivas ramas y pull request.

● Zip comprimido, donde debe estar el código finalizado y funcional, con su 
respectiva documentación.


