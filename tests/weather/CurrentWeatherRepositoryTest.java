package weather;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Tests for CurrentWeatherRepository class.
 */
public class CurrentWeatherRepositoryTest {

    private static final String EE = "Estonia";
    private static final String UK = "United Kingdom";

    @Test
    void testMetricsLatitude() {
        WeatherRequest request = new WeatherRequest("London", UK, "515:012");

        try {
            assertEquals("515", request.getLatitude());
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }

    @Test
    void testMetricsLongitude() {
        WeatherRequest request = new WeatherRequest("London", UK, "515:012");

        try {
            assertEquals("012", request.getLongitude());
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }

    @Test
    void testMetricsForbiddenSymbols() {
        WeatherRequest request = new WeatherRequest("London", UK, "515/012");

        try {
            assertEquals(null, request.getCityName());
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }

    @Test
    void testCityForbiddenSize() {
        WeatherRequest request = new WeatherRequest("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", UK, "515:012");

        CurrentWeatherRepository repository = new CurrentWeatherRepository();

        try {
            assertEquals(null, repository.getCurrentWeather(request));
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }

    @Test
    void testCurrentWeatherTemperature() {
        WeatherRequest request = new WeatherRequest("London", UK, "515:012");
        CurrentWeatherRepository repository = new CurrentWeatherRepository();
        repository.setCurrentWeather("+15");

        try {
            assertEquals("+15", repository.getCurrentWeather(request));
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }

    @Test
    void testCurrentWeatherForbiddenTemperature() {
        WeatherRequest request = new WeatherRequest("London", UK, "515/012");
        CurrentWeatherRepository repository = new CurrentWeatherRepository();
        repository.setCurrentWeather("-200");

        try {
            assertEquals(null, repository.getCurrentWeather(request));
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }

    @Test
    void testCurrentWeatherHighestTemperature() {
        WeatherRequest request = new WeatherRequest("Tallinn", EE, "315:045");
        CurrentWeatherRepository repository = new CurrentWeatherRepository();

        List<String> currentWeatherList = new ArrayList<>();
        currentWeatherList.add("-6");
        currentWeatherList.add("0");
        currentWeatherList.add("-1");

        repository.addCurrentWeatherList(currentWeatherList);

        try {
            assertEquals("0", repository.getCurrentWeatherHighestTemperature(request));
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }

}