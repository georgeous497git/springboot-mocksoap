# springboot-mocksoap
En este proyecto podrás visualizar como generar un Web Service simulado a partir de un WSDL

## 1. Introducci&oacute;n. 
Basados en un proyecto Spring Boot expondr&eacute; un Web Service SOAP a partir de un WSDL proporcionado por un proveedor utilizando el Framework CXF de Apache para la construcci&oacute;n de las clases definidas en el esquema proporcionado.

* Insumos
  * Spring Boot 2.2.6
  * Maven 3.6.3
  * Java JDK 1.8.0_241
  * CXF Apache 3.3.6
  * SOAP UI 5.5.0


## 2. Instalaci&oacute;n

**a)** Creaci&oacute;n de proyecto Spring Boot

![Genera Spring Boot](https://github.com/georgeous497git/springboot-mocksoap/blob/master/img/001.png)


**b)** Configuraci&oacute;n de paquetes proyecto Spring Boot

![Configura Spring Boot](https://github.com/georgeous497git/springboot-mocksoap/blob/master/img/002.png)


**c)** Selecci&oacute;n de *Starter Web* proyecto Spring Boot

![Starter Spring Boot](https://github.com/georgeous497git/springboot-mocksoap/blob/master/img/003.png)


**d)** Validaci&oacute;n y ejecuci&oacute;n inicial de proyecto generado

![Validacion Spring Boot](https://github.com/georgeous497git/springboot-mocksoap/blob/master/img/004.png)
![Ejecucion Spring Boot](https://github.com/georgeous497git/springboot-mocksoap/blob/master/img/004_1.png)


**e)** Descarga e instalaci&oacute;n del WSDL ejemplo en el proyecto _http://wsf.cdyne.com/WeatherWS/Weather.asmx?WSDL_

![Descarga WSDL](https://github.com/georgeous497git/springboot-mocksoap/blob/master/img/006.png)
![Instalacion WSDL](https://github.com/georgeous497git/springboot-mocksoap/blob/master/img/009.png)


**f)** Instalaci&oacute;n del archivo binding.xml requerido por el plugin CXF

![Binding CXF](https://github.com/georgeous497git/springboot-mocksoap/blob/master/img/012.png)


**g)** Configuraci&oacute;n de plugin CXF Apache en POM del proyecto

![Configuracion CXF](https://github.com/georgeous497git/springboot-mocksoap/blob/master/img/013.png)


**h)** Construcci&oacute;n de proyecto 

![Construccion proyecto](https://github.com/georgeous497git/springboot-mocksoap/blob/master/img/013_1.png)


**i)** Validaci&oacute;n de clases generadas por el plugin CXF Apache

![Validacion clases CXF](https://github.com/georgeous497git/springboot-mocksoap/blob/master/img/014.png)



