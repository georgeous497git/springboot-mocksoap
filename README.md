![Presentacion](https://github.com/georgeous497git/springboot-mocksoap/blob/master/img/miniatura.png)

# Web Service SOAP con Spring Boot
En este mini-tutorial basados en un proyecto Spring Boot expondr&eacute; un Web Service SOAP a partir de un WSDL proporcionado por un proveedor utilizando el Framework CXF de Apache para la construcci&oacute;n de las clases definidas en el esquema proporcionado.

## Resultado esperado
Al finalizar el tutorial tendr&aacute;s como resultado un Web Service SOAP expuesto desde el servidor local de tu computadora y que podr&aacute; ser consumido por un cliente SOAP conectado a tu misma red.

* Insumos
  * IDE Spring Tool Suite 4 
  * Spring Boot 2.2.6
  * Maven 3.6.3
  * Java JDK 1.8.0_241
  * CXF Apache 3.3.6
  * SOAP UI 5.5.0
__________________________________________________________________
## 1. Inicio e Instalaci&oacute;n

**a)** Creaci&oacute;n de proyecto Spring Boot<br>
![Genera Spring Boot](https://github.com/georgeous497git/springboot-mocksoap/blob/master/img/001.png)
__________________________________________________________________
**b)** Configuraci&oacute;n de paquetes proyecto Spring Boot<br>
![Configura Spring Boot](https://github.com/georgeous497git/springboot-mocksoap/blob/master/img/002.png)
__________________________________________________________________
**c)** Selecci&oacute;n de *Starter Web* proyecto Spring Boot<br>
![Starter Spring Boot](https://github.com/georgeous497git/springboot-mocksoap/blob/master/img/003.png)
__________________________________________________________________
**d)** Validaci&oacute;n y ejecuci&oacute;n inicial de proyecto generado<br>
![Validacion Spring Boot](https://github.com/georgeous497git/springboot-mocksoap/blob/master/img/004.png)<br>
![Ejecucion Spring Boot](https://github.com/georgeous497git/springboot-mocksoap/blob/master/img/004_1.png)
__________________________________________________________________
**e)** Descarga e instalaci&oacute;n del WSDL ejemplo en el proyecto.<br>(URL de descarga de WSDL: _http://wsf.cdyne.com/WeatherWS/Weather.asmx?WSDL_)<br>
![Descarga WSDL](https://github.com/georgeous497git/springboot-mocksoap/blob/master/img/006.png)<br>
![Instalacion WSDL](https://github.com/georgeous497git/springboot-mocksoap/blob/master/img/009.png)
__________________________________________________________________
**f)** Instalaci&oacute;n del archivo _binding.xml_ requerido por el plugin CXF<br>
![Binding CXF](https://github.com/georgeous497git/springboot-mocksoap/blob/master/img/012.png)
__________________________________________________________________
**g)** Configuraci&oacute;n de plugin CXF Apache en POM del proyecto<br>
![Configuracion CXF](https://github.com/georgeous497git/springboot-mocksoap/blob/master/img/013.png)
__________________________________________________________________
**h)** Construcci&oacute;n de proyecto<br>
![Construccion proyecto](https://github.com/georgeous497git/springboot-mocksoap/blob/master/img/013_1.png)
__________________________________________________________________
**i)** Validaci&oacute;n de clases generadas por el plugin CXF Apache<br>
![Validacion clases CXF](https://github.com/georgeous497git/springboot-mocksoap/blob/master/img/014.png)

________________________________________________________________________________________________________________________

## 2. Codificaci&oacute;n

**_i. Exposici&oacute;n de Web Service (Clase Java)_**

Generar la clase con la que se expondr&aacute; el Web Service con ayuda de las anotaciones _@WebService_ y _@SOAPBinding_  ![WebService](https://github.com/georgeous497git/springboot-mocksoap/blob/master/img/015.PNG)

Con el objetivo de simular el servicio como si realmente estuviera funcional debemos considerar agregar las propiedades necesarias en la anotaci&oacute;n _@WebService_.

El valor de las propiedades podr&aacute;n ser obtenidas del WSDL ejemplo como se muestra a continuaci&oacute;n:

_serviceName_ y _portName_

    <wsdl:service name="Weather">
      <wsdl:port name="WeatherSoap" binding="tns:WeatherSoap">
        <soap:address location="http://wsf.cdyne.com/WeatherWS/Weather.asmx"/>
      </wsdl:port>
      ...
    </wsdl:service>
  
 _targetNamespace_
      
      <wsdl:types>
        <s:schema elementFormDefault="qualified" targetNamespace="http://ws.cdyne.com/WeatherWS/">
        ...
      </wsdl:types>
	

**_ii. Configuraci&oacute;n de Endpoint_**

Gracias a la configuraci&oacute;n del _Starter Web_ de Spring Boot el cual ejecuta un servidor Tomcat, s&oacute;lo es necesario configurar el Endpoint para exponer el servicio web desde nuestro localhost. Para esta configuraci&oacute;n haremos uso de la clase que inicia el contexto de la aplicaci&oacute;n Spring Boot la cual podemos identificar con la anotaci&oacute;n _@SpringBootApplication_.

S&oacute;lo para hacerlo m&aacute;s elegante se hace uso de la anotaci&oacute;n _@PostConstruct_ para iniciar el Endpoint, pero bien se puede iniciar dentro el m&eacute;todo main.

En este apartado es donde se har&aacute; uso de la clase previamente generada que contiene la anotaci&oacute;n _@WebService_

    NOTA: En el ejemplo se asume que el puerto por defecto que utiliza Tomcat es el 8080 y para exponer el WS usaremos el puerto 8084.

![Endpoint](https://github.com/georgeous497git/springboot-mocksoap/blob/master/img/016.PNG)

**_iii. Generaci&oacute;n de m&eacute;todos del Web Service_**

Aqu&iacute; vamos a utilizar la anotaci&oacute;n _@WebMethod_ junto con la propiedad _operationName_ para generar la operaci&oacute;n del Web Service.

Si a&uacute;n no tienes indentificados que m&eacute;todos son los que deber&iacute;an generarse, basta con indentificar dentro del WSDL ejemplo los elementos `<wsdl:operation>`, los cuales, en este caso ser&iacute;an _GetCityForecastByZIP_, _GetCityForecastByZIP_ y _GetCityWeatherByZIP_.  

    <wsdl:portType name="WeatherSoap">
		<wsdl:operation name="GetWeatherInformation">
			<wsdl:documentation
				xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Gets Information for each WeatherID</wsdl:documentation>
			<wsdl:input message="tns:GetWeatherInformationSoapIn" />
			<wsdl:output message="tns:GetWeatherInformationSoapOut" />
		</wsdl:operation>
		<wsdl:operation name="GetCityForecastByZIP">
			<wsdl:documentation
				xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Allows you to get your City Forecast Over the Next 7
				Days, which is updated hourly. U.S. Only</wsdl:documentation>
			<wsdl:input message="tns:GetCityForecastByZIPSoapIn" />
			<wsdl:output message="tns:GetCityForecastByZIPSoapOut" />
		</wsdl:operation>
		<wsdl:operation name="GetCityWeatherByZIP">
			<wsdl:documentation
				xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Allows you to get your City's Weather, which is updated
				hourly. U.S. Only</wsdl:documentation>
			<wsdl:input message="tns:GetCityWeatherByZIPSoapIn" />
			<wsdl:output message="tns:GetCityWeatherByZIPSoapOut" />
		</wsdl:operation>
    </wsdl:portType>

Una vez identificados los m&eacute;todos deseados podr&aacute;s auxiliarte de los elementos `<wsdl:input>` y `<wsdl:output>` para buscar dentro del WSDL los elementos que van a corresponder al _request_ y _response_ del m&eacute;todo web.

#### Ejemplo de Request

Considerando el elemento `<wsdl:input message="tns:GetWeatherInformationSoapIn"/>` va a corresponder con lo siguiente:

    <wsdl:message name="GetCityForecastByZIPSoapIn">
      <wsdl:part name="parameters" element="tns:GetCityForecastByZIP"/>
    </wsdl:message>
	
Aqu&iacute; se identifica como el objeto request del m&eacute;todo web la clase Java _GetCityForecastByZIP_

#### Ejemplo de Response

Considerando el elemento `<wsdl:output message="tns:GetCityForecastByZIPSoapOut" />` va a corresponder con lo siguiente:

    <wsdl:message name="GetCityForecastByZIPSoapOut">
      <wsdl:part name="parameters" element="tns:GetCityForecastByZIPResponse"/>
    </wsdl:message>

Aqu&iacute; se identifica como el objeto response del m&eacute;todo web la clase Java _GetCityForecastByZIPResponse_
_______________________________________
Es as&iacute; como se podr&aacute; generar en la clase Java el m&eacute;todo web _GetCityForecastByZIP_  ![M&eacute;todo web](https://github.com/georgeous497git/springboot-mocksoap/blob/master/img/017.PNG)




