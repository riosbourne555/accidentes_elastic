# Proyecto API Rest para busqueda de accidentes

## Este proyecto permite realizar 5 consultas diferentes a un conjunto de aproximadamente 3 millones de accidentes en EEUU (año 2019).
## Se desplegó ElasticSearch en un contenedor Docker, luego se realizo la ingesta de los datos con Logstash y se codificó en IDE Visual Studio Code utilizando Spring Boot, Spring Data y Maven.

##  Requisitos
1. JDK 1.8
2. Docker 19.03.12
3. Docker Compose 3
5. Elasticsearch 7.7.0
6. Logstash 7.4.2
7. Apache Maven 4.4.0
8. Spring Boot 2.3.2
9. IDE Visual Studio Code 1.48.1



##  Estructura de la aplicación
1. Base de datos: Elasticsearch (NoSQL) para almacenar y recuperar datos.
2. Capa RestController: para controlar solicitudes y respuestas.
3. Capa de repositorio: para almacenar y recuperar datos de la base de datos.
4. Cliente: el cliente que desea acceder al recurso API.


A continuación se muestra el diagrama de la arquitectura tipo API Rest de la aplicación.

![alt text](https://github.com/riosbourne555/accidentes_elastic/blob/master/src/main/resources/img/spring-boot-elasticsearch.png)

# A continuación se muestran las 5 consultas y sus endpoint respectivos:

1. Devolver todos los accidentes ocurridos entre 2 fechas dadas
    * endpoint: http://localhost:7070/api/from/{fecha1}/to/{fecha2}
    #### *Formato de Fechas: {yyyy-MM-dd HH:mm:ss)

2. Determinar las condiciones más comunes en los accidentes (condiciones climáticas)
    * endpoint: http://localhost:7070/api/WeatherCondition
      
3. Dado un punto geográfico y un radio (expresado en kilómetros) y devolver todos los accidentes ocurridos dentro del radio.
    * endpoint: http://localhost:7070/api/{latitud}/{longitud}/{radio_Km}

4. Devolver los 5 puntos más peligrosos (definiendo un determinado radio)
    * endpoint: http://localhost:7070/api/severity/{latitud}/{longitud}/{radio_Km}

5. Obtener la distancia promedio desde el inicio al fin del accidente
    * endpoint: http://localhost:7070/api/DistanciaPromedio


### Integrantes del proyecto: Cristian Emmanuel Rios, Emmanuel Portugal.