package mx.com.lambda.springboot.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cdyne.ws.weatherws.GetCityForecastByZIP;
import com.cdyne.ws.weatherws.GetCityForecastByZIPResponse;
import com.cdyne.ws.weatherws.GetCityWeatherByZIP;
import com.cdyne.ws.weatherws.GetCityWeatherByZIPResponse;
import com.cdyne.ws.weatherws.GetWeatherInformation;
import com.cdyne.ws.weatherws.GetWeatherInformationResponse;

import mx.com.lambda.springboot.response.GeneraGetCityForecastByZIP;

@WebService(targetNamespace = "http://wsf.cdyne.com/",
			portName = "WeatherSoap",
			serviceName = "Weather")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public class WeatherSoapWS {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(WeatherSoapWS.class);
	
	@WebMethod(operationName = "GetCityForecastByZIP")
	public GetCityForecastByZIPResponse getCityForecastByZIP(@WebParam GetCityForecastByZIP request) {
		
		LOGGER.debug("Invocando el metodo WsS getCityForecastByZIP");
		GeneraGetCityForecastByZIP generaGetCityForecastByZIP = new GeneraGetCityForecastByZIP(); 
		
		return generaGetCityForecastByZIP.getResponseForecast(request);
	}

	
	@WebMethod(operationName = "GetCityWeatherByZIP")
	public GetCityWeatherByZIPResponse getCityWeatherByZIP(@WebParam GetCityWeatherByZIP request) {
		
		LOGGER.debug("Invocando el metodo WsS getCityForecastByZIP");
		
		return null;
	}
	
	
	@WebMethod(operationName = "GetWeatherInformation")
	public GetWeatherInformationResponse getWeatherInformation(@WebParam GetWeatherInformation request) {
		
		LOGGER.debug("Invocando el metodo WsS getCityForecastByZIP");
		
		return null;
	}
	
	
	
}
