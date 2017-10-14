package weather;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Tests 2.
 */
public class WeatherTest2 {

    private Place place;

    @Before
    public void setUp() throws Exception {
        place = new Place("Tallinn", "EE", "59.44:24.75", 3);
    }

    @Test
    public void testRequestLatitude() {
        try {
            assertEquals("59.44", place.getLatitude());
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }

    @Test
    public void testRequestLongitude() {
        try {
            assertEquals("24.75", place.getLongitude());
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }

    @Test
    public void testLowestTemperatureOfTheDay() {
        List<Integer> fakeDailyTemperatures = Arrays.asList(5, 6, 4);

        DailyWeather dailyWeather = new DailyWeather(fakeDailyTemperatures);

        try {
            assertEquals(4, dailyWeather.getLowestTemperatureOfTheDay());
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }

    @Test
    public void testHighestTemperatureOfTheDay() {
        List<Integer> fakeDailyTemperatures = Arrays.asList(5, 6, 4);

        DailyWeather dailyWeather = new DailyWeather(fakeDailyTemperatures);

        try {
            assertEquals(6, dailyWeather.getHighestTemperatureOfTheDay());
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }

    @Test
    public void testCurrentTemperatureOfTheDay() {
        List<Integer> fakeDailyTemperatures = Arrays.asList(5, 6, 4);

        DailyWeather dailyWeather = new DailyWeather(fakeDailyTemperatures);

        try {
            assertEquals(5, dailyWeather.getCurrentWeather());
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }

    @Test
    public void testTemperatureRightLength() throws IOException {
        WeekWeather weekWeather = new WeekWeather();
        weekWeather.getResponse(place);
        weekWeather.sortTemperaturesByDays();
        DailyWeather dailyWeather = new DailyWeather(weekWeather.getCurrentDayWeatherList());

        try {
            assertTrue(String.valueOf(dailyWeather.getCurrentWeather()).length() >= 2);
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }

    @Test
    public void testTemperatureCelsiusNotFahrenheit() throws IOException {
        WeekWeather weekWeather = new WeekWeather();
        weekWeather.getResponse(place);
        weekWeather.sortTemperaturesByDays();
        DailyWeather dailyWeather = new DailyWeather(weekWeather.getCurrentDayWeatherList());

        try {
            assertTrue(dailyWeather.getHighestTemperatureOfTheDay() <= 40);
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }
}