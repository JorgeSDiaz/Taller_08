# Taller Mircroservicios 
## Integrantes:
- Jorge Saenz
- David Leon
- Juan Molina
## Objetivo: 
- Desarrollar microservicos similares a Twitter utilizando Quarkus, implementando seguridad JWT con el servicio cognito de AWS y separando el monolito en tres microservicios independientes para su despliegue en AWS con EC2. También se debe crear una aplicación JS para usar el servicio, desplegarla en S3 y realizar pruebas para asegurar su correcto funcionamiento.
## Herramientas
 - Maven
 - Java 
 - Git 
 - Quarkus
 - AWS
 - MongoDB
## RUN QUARTUS

  ./mvnw package quarkus
  
  
  ./mvnw compile quarkus:dev
  
  http://localhost:8080
## Arquitectura
![image](https://user-images.githubusercontent.com/98216838/233513748-69e53594-2ede-4ab8-a522-992988d564f8.png)
## API TWITTER
## JS
## FUNCIONAMIENTO AWS
### EC2
- En EC2 vamos a estar corriendo el API twitter desarrollada en QUARTUS
- Verificamos que este corriendo con los logs
![image](https://user-images.githubusercontent.com/98216838/233522449-d00b44c5-0d49-4375-9e31-0f932846d0ab.png)

### S3
- En el Bucket de S3 vamos a tener la parte front de Twitter la cual va estar conectada a la api la cual se encuentra en una instancia EC2
## Video explicativo
- https://youtu.be/vdWq0J_30pI
## Documentacion

Para crear la documentación del proyecto se hace con el siguiente comando:
    
    mvn javadoc:javadoc
    


