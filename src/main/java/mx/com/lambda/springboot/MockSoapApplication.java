package mx.com.lambda.springboot;

import javax.annotation.PostConstruct;
import javax.xml.ws.Endpoint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import mx.com.lambda.springboot.ws.WeatherSoapWS;

@SpringBootApplication
public class MockSoapApplication {
	
	private static final String HTTP_PROTOCOL = "http://";
	private static final String IP = "127.0.1";

	public static void main(String[] args) {
		SpringApplication.run(MockSoapApplication.class, args);
	}

	@PostConstruct
	private void iniciaWS() {
		
		Endpoint.publish(HTTP_PROTOCOL + IP + ":8084/", new WeatherSoapWS());
		
	}
	
}
