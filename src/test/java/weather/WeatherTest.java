package weather;

import controller.Controller;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Tests 2.
 */
public class WeatherTest {

    private Place place;

    @Before
    public void setUp() throws Exception {
        place = new Place("Tallinn");
    }

    @Test
    public void testLatitude() throws IOException {
        WeekWeather weekWeather = new WeekWeather(place);
        weekWeather.setResponse();
        weekWeather.setCoordinates();

        try {
            assertEquals("59,44", place.getLatitude());
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }

    @Test
    public void testLongitude() throws IOException {
        WeekWeather weekWeather = new WeekWeather(place);
        weekWeather.setResponse();
        weekWeather.setCoordinates();

        try {
            assertEquals("24,75", place.getLongitude());
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
        WeekWeather weekWeather = new WeekWeather(place);
        weekWeather.setResponse();
        weekWeather.sortTemperaturesByDays();
        DailyWeather dailyWeather = new DailyWeather(weekWeather.getCurrentDayWeatherList());

        try {
            assertTrue(String.valueOf(dailyWeather.getCurrentWeather()).length() >= 1
                    && String.valueOf(dailyWeather.getCurrentWeather()).length() < 3);
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }

    @Test
    public void testTemperatureCelsiusNotFahrenheit() {
        WeekWeather weekWeather = mock(WeekWeather.class);

        List<Integer> fakeTemperaturesList = Arrays.asList(33, 25, -8);
        when(weekWeather.getCurrentDayWeatherList()).thenReturn(fakeTemperaturesList);

        DailyWeather dailyWeather = new DailyWeather(fakeTemperaturesList);

        try {
            assertTrue(dailyWeather.getHighestTemperatureOfTheDay() <= 40
                    && dailyWeather.getHighestTemperatureOfTheDay() >= -40);
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }

    }
}