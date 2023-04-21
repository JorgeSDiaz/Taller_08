# TALLER 8: Microservicios
Utilizando el Framework orientado a contenedores quarkus, se desarrolla una aplicación que permite realizar un Log-in para registrar Twitts en una base de datos y poder recuperar los ultimos 10 registrados. La aplicación se despliega en AWS utilizando sus servicios de S3 e EC2.
![Arquitectura](https://i.imgur.com/9d1ttHm.png)

---
### Prerrequisitos
Para elaborar este proyecto requerimos de las siguientes tecnologías:

 - **[Maven](https://openwebinars.net/blog/que-es-apache-maven/)**: Apache Maven es una herramienta que estandariza la configuración de un proyecto en todo su ciclo de vida.
 - **[Git](https://learn.microsoft.com/es-es/devops/develop/git/what-is-git)**: Es un sistema de control de versiones distribuido (VCS).
 - **[Docker](https://www.ibm.com/co-es/topics/docker)**: Docker es una plataforma de código abierto de contenedorización . Permite a los desarrolladores empaquetar aplicaciones en contenedores, componentes ejecutables estandarizados que combinan el código fuente de la aplicación con las bibliotecas del sistema operativo (SO) y las dependencias necesarias para ejecutar ese código en cualquier entorno.
 - **[Quarkus](https://es.quarkus.io/about/)**:Quarkus fue creado para permitir a los desarrolladores de Java crear aplicaciones para un mundo moderno y nativo de la nube. Quarkus es un marco Java nativo de Kubernetes adaptado a GraalVM y HotSpot, elaborado a partir de las mejores bibliotecas y estándares Java. El objetivo es convertir a Java en la plataforma líder en Kubernetes y entornos sin servidor, al tiempo que ofrece a los desarrolladores un marco para abordar una gama más amplia de arquitecturas de aplicaciones distribuidas.

---
### Instalación
instalamos Doker en nuestras instancias EC2

	 sudo yum install docker

Ponemos a correr dentro de la instancia, el contenedor usando la imagen alojada en nuestro repositorio de Dockerhub

	 docker run -d -p 5000:8080 --name taller jsdiaz/quarkust

---
### Corriendo
Una vez creada la instancia para alojar el contenedor(EC2) y la instancia para alojar el front (S3)
![ec2](https://i.imgur.com/giitBbp.png)
![s3](https://i.imgur.com/tp9gLrP.png)

Ponemos a correr dentro de la instancia, el contenedor usando la imagen alojada en nuestro repositorio de Dockerhub

	 docker run -d -p 5000:8080 --name taller jsdiaz/quarkust

### Log - In
Los archivos estaticos necesarios para desplegarlo, se encuentran en este repositorio, lo unico seria clonarlo con el siguiente comando

	git clone https://github.com/jorge-stack/Taller_08.git
	
	http://fronttaller08.s3-website-us-east-1.amazonaws.com
	
![Log in](https://i.imgur.com/3IaMud0.png)

### Message Service
![Imgur](https://i.imgur.com/zOM8MU1.png)
![Imgur](https://i.imgur.com/nyKZrtv.png)

### Run

[Aquí ](https://youtu.be/vdWq0J_30pI) podran encontrar un video muestra del funcionamiento de la aplicación una vez es desplegada

---
## Construido con

* [Maven](https://maven.apache.org/): Apache Maven es una herramienta que estandariza la configuración de un proyecto en todo su ciclo de vida.
* [Git](https://rometools.github.io/rome/):  Es un sistema de control de versiones distribuido (VCS).
* [IntelliJ](https://www.jetbrains.com/idea/): Es un entorno de desarrollo integrado para el desarrollo de programas informáticos.
* [Java 17](https://www.java.com/es/): Lenguaje de programación de propósito general, es decir, que sirve para muchas cosas, para web, servidores, aplicaciones móviles, entre otros. Java también es un lenguaje orientado a objetos, y con un fuerte tipado de variables.
* [Html](https://developer.mozilla.org/es/docs/Learn/Getting_started_with_the_web/HTML_basics): Es el código que se utiliza para estructurar y desplegar una página web y sus contenidos.
* [JavaScript](https://developer.mozilla.org/es/docs/Learn/JavaScript/First_steps/What_is_JavaScript): JavaScript es un lenguaje de programación o de secuencias de comandos que te permite implementar funciones complejas en páginas web
* [CSS](https://developer.mozilla.org/es/docs/Learn/CSS/First_steps/What_is_CSS): Las hojas de estilo en cascada permiten crear páginas web atractivas.
* [AWS](https://www.inbest.cloud/comunidad/qu%C3%A9-es-aws): Amazon Web Services es una plataforma de servicios de nube que te ofrece potencia de cómputo, almacenamiento de bases de datos, entrega de contenido y otra funcionalidad para ayudar a tu negocio a escalar y crecer

## Autores
* **[Jorge David Saenz Diaz](https://co.linkedin.com/in/jorgedsaenzd/en)**  - [Jorge-Stack](https://github.com/jorge-stack)
* **[Juan Camilo Molina Leon](https://co.linkedin.com/in/jorgedsaenzd/en)**  - [liontama2121](https://github.com/liontama2121)
* **[David Alejandro Leon Moreno](https://co.linkedin.com/in/jorgedsaenzd/en)**  - [davidleon03](https://github.com/davidleon03)

## Licencia
**©** Jorge David Saenz Diaz, Estudiante de Ingeniería de Sistemas de la Escuela Colombiana de Ingeniería Julio Garavito.
