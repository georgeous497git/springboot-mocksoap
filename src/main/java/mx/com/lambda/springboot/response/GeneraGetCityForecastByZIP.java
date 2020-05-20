package mx.com.lambda.springboot.response;

import java.util.ArrayList;
import java.util.List;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import org.springframework.stereotype.Component;
import com.cdyne.ws.weatherws.ArrayOfForecast;
import com.cdyne.ws.weatherws.Forecast;
import com.cdyne.ws.weatherws.ForecastReturn;
import com.cdyne.ws.weatherws.GetCityForecastByZIP;
import com.cdyne.ws.weatherws.GetCityForecastByZIPResponse;
import com.cdyne.ws.weatherws.POP;
import com.cdyne.ws.weatherws.Temp;

@Component
public class GeneraGetCityForecastByZIP {

	public GetCityForecastByZIPResponse getResponseForecast(GetCityForecastByZIP request) {
		
		String zip = request.getZIP();
		
		GetCityForecastByZIPResponse response = new GetCityForecastByZIPResponse();
		response.setGetCityForecastByZIPResult(getForecastReturn(zip));
		
		return response;
	}
	
	private ForecastReturn getForecastReturn(String zip) {
		
		ForecastReturn forecastReturn = new ForecastReturn();
		
		switch (zip) {
		
			case "98501":
				forecastReturn.setCity("Olympia");	
				break;
			case "98101":
				forecastReturn.setCity("Seattle");
				break;
			default:
				forecastReturn.setCity("Unknow");
				break;
		}

		forecastReturn.setState("Washington");
		forecastReturn.setSuccess(true);
		forecastReturn.setResponseText("Success");
		forecastReturn.setWeatherStationCity("Weather Station from Wahington");
		forecastReturn.setForecastResult(getArrayOfForecast());
		
		return forecastReturn;
	}
	
	private ArrayOfForecast getArrayOfForecast() {
		
		ArrayOfForecast arrayForecast = new ArrayOfForecast();
		List<Forecast> listForecast = new ArrayList<>();
		listForecast.add(getForecast());
		
		return arrayForecast;
	} 
	
	private Forecast getForecast() {
		
		Forecast forecast = new Forecast();
		forecast.setWeatherID((short) 1234);
		forecast.setDesciption("Climate");
		forecast.setTemperatures(getTemp());
		forecast.setProbabilityOfPrecipiation(getPop());
		
		try {
			forecast.setDate(DatatypeFactory.newInstance().newXMLGregorianCalendar());
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}

		return forecast;
	}
	
	private POP getPop() {
		
		POP pop = new POP();
		pop.setDaytime("06:54:24");
		pop.setNighttime("20:06:33");
		
		return pop;
	} 
	
	private Temp getTemp() {
		Temp temp = new Temp();
		temp.setDaytimeHigh("76°F");
		temp.setMorningLow("53°F");
		
		return temp;
	}
}
