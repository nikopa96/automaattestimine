package weather;

import constants.Constants;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * WeatherForecastTest
 */
public class WeatherForecastTest {

    @Test
    public void toStringBeautyAnswerTest() throws Exception {
        WeatherForecast weatherForecast = new WeatherForecast();
        weatherForecast.setMinTemperature(10);
        weatherForecast.setMaxTemperature(20);
        weatherForecast.setCurrentTemperature(15);
        weatherForecast.setPressure(0.5);
        weatherForecast.setDescription("rain");
        weatherForecast.setDate("25-05-2017");

        WeatherRequest weatherRequest = new WeatherRequest("London", Constants.metric);
        weatherForecast.setWeatherRequest(weatherRequest);

        String beautyAnswer = "Place name: London" + "\n"
                + "Current temperature: 15.0" + "\n"
                + "Max temperature: 20.0" + "\n"
                + "Min temperature: 10.0" + "\n"
                + "Pressure: 0.5" + "\n"
                + "Description: rain" + "\n"
                + "Date: 25.05.2017";

        assertEquals(beautyAnswer, weatherForecast.toString());
    }

}