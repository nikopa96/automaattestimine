package weather;

import tools.Connection;
import tools.Parser;
import tools.PlaceNotFoundException;

import java.io.IOException;
import java.util.List;

/**
 * WeatherRepository
 */
public class WeatherRepository {

    private Connection connection;
    private Parser parser;

    public WeatherRepository(Connection connection, Parser parser) {
        this.connection = connection;
        this.parser = parser;
    }

    public WeatherForecast getCurrentWeather(WeatherRequest weatherRequest) throws IOException, PlaceNotFoundException {
        String weatherData = connection.getData(weatherRequest);

        return parser.createForecast(weatherData, weatherRequest).get(0);
    }

    public List<WeatherForecast> getCurrentAndNextThreeDaysWeather(WeatherRequest weatherRequest) throws IOException, PlaceNotFoundException {
        String weatherData = connection.getData(weatherRequest);

        return parser.createForecast(weatherData, weatherRequest);
    }

}
