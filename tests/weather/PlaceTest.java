package weather;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Place test.
 */
class PlaceTest {

    private Place place;

    void setUp() throws Exception {
        this.place = new Place();
    }

    @Test
    void testLatitudeSize() {
        place.setLatitude("4444");

        try {
            assertEquals(null, place.getLatitude());
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }

    @Test
    void testLatitudeForbiddenSymbols() {
        place.setLatitude("!18");

        try {
            assertEquals(null, place.getLatitude());
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }

    @Test
    void testLatitudeNullPointerException() {
        place.setLatitude(null);

        try {
            assertEquals(null, place.getLatitude());
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }

    @Test
    void testLongitudeSize() {
        place.setLongitude("98642345");

        try {
            assertEquals(null, place.getLongitude());
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }

    @Test
    void testLongitudeForbiddenSymbols() {
        place.setLongitude("5*9");

        try {
            assertEquals(null, place.getLongitude());
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }

    @Test
    void testLongitudeNullPointerException() {
        place.setLongitude(null);

        try {
            assertEquals(null, place.getLongitude());
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }

    @Test
    void testPlaceNameSize() {
        place.setPlaceName("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
        "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

        try {
            assertEquals(null, place.getPlaceName());
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }

    @Test
    void testPlaceNameForbiddenSymbols() {
        place.setPlaceName("Tall995inn");

        try {
            assertEquals(null, place.getPlaceName());
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }

    @Test
    void testPlaceNameNullPointerException() {
        place.setPlaceName(null);

        try {
            assertEquals(null, place.getPlaceName());
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }

    @Test
    void testCurrentDayWeatherForbiddenSymbols() {
        place.setCurrentDay("?18");

        try {
            assertEquals(null, place.getCurrentDay());
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }

    @Test
    void testCurrentDayWeatherForbiddenTemperature() {
        place.setCurrentDay("-50");

        try {
            assertEquals(null, place.getCurrentDay());
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }

    @Test
    void testCurrentDayWeatherNullPointerException() {
        place.setCurrentDay(null);

        try {
            assertEquals(null, place.getCurrentDay());
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }

    @Test
    void testFirstDayWeatherForbiddenSymbols() {
        place.setFirstDay("*14");

        try {
            assertEquals(null, place.getFirstDay());
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }

    @Test
    void testFirstDayWeatherForbiddenTemperature() {
        place.setFirstDay("+60");

        try {
            assertEquals(null, place.getFirstDay());
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }

    @Test
    void testFirstDayWeatherNullPointerException() {
        place.setFirstDay(null);

        try {
            assertEquals(null, place.getFirstDay());
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }

    @Test
    void testSecondDayWeatherDayForbiddenSymbols() {
        place.setSecondDay("//65");

        try {
            assertEquals(null, place.getSecondDay());
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }

    @Test
    void testSecondDayWeatherNullPointerException() {
        place.setSecondDay(null);

        try {
            assertEquals(null, place.getSecondDay());
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }

    @Test
    void testSecondDayWeatherForbiddenTemperature() {
        place.setSecondDay("-84");

        try {
            assertEquals(null, place.getSecondDay());
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }

    @Test
    void testThirdDayWeatherDayForbiddenSymbols() {
        place.setThirdDay("s4");

        try {
            assertEquals(null, place.getThirdDay());
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }

    @Test
    void testThirdDayWeatherNullPointerException() {
        place.setThirdDay(null);

        try {
            assertEquals(null, place.getThirdDay());
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }

    @Test
    void testThirdDayWeatherForbiddenTemperature() {
        place.setThirdDay("+75");

        try {
            assertEquals(null, place.getThirdDay());
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }

    @Test
    void testCurrentDayHighestTemperature() {
        List<String> currentDayTemperatures = new ArrayList<>();
        currentDayTemperatures.add("-4");
        currentDayTemperatures.add("-6");
        currentDayTemperatures.add("0");

        place.setCurrentDayHighestTemperature(currentDayTemperatures);

        try {
            assertEquals("0", place.currentDayHighestTemperature());
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }

    @Test
    void testCurrentDayLowestTemperature() {
        List<String> currentDayTemperatures = new ArrayList<>();
        currentDayTemperatures.add("+4");
        currentDayTemperatures.add("-6");
        currentDayTemperatures.add("+14");

        place.setCurrentDayLowestTemperature(currentDayTemperatures);

        try {
            assertEquals("-6", place.currentDayLowestTemperature());
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }

    @Test
    void testFirstDayHighestTemperatureWithForbiddenValue() {
        List<String> firstDayTemperatures = new ArrayList<>();
        firstDayTemperatures.add("+7");
        firstDayTemperatures.add("-65");
        firstDayTemperatures.add("+5");

        place.setFirstDayHighestTemperature(firstDayTemperatures);

        try {
            assertEquals(null, place.firstDayHighestTemperature());
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }

    @Test
    void testFirstDayLowestTemperatureWithForbiddenValue() {
        List<String> firstDayTemperatures = new ArrayList<>();
        firstDayTemperatures.add("-77");
        firstDayTemperatures.add("+6");
        firstDayTemperatures.add("+5");

        place.setFirstDayLowestTemperature(firstDayTemperatures);

        try {
            assertEquals(null, place.firstDayLowestTemperature());
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }

    @Test
    void testSecondDayHighestTemperature() {
        List<String> secondDayTemperatures = new ArrayList<>();
        secondDayTemperatures.add("+7");
        secondDayTemperatures.add("+6");
        secondDayTemperatures.add("0");

        place.setSecondDayLowestTemperature(secondDayTemperatures);

        place.setSecondDayHighestTemperature(secondDayTemperatures);

        try {
            assertEquals("+7", place.secondDayHighestTemperature());
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }

    @Test
    void testSecondDayLowestTemperature() {
        List<String> secondDayTemperatures = new ArrayList<>();
        secondDayTemperatures.add("+7");
        secondDayTemperatures.add("+6");
        secondDayTemperatures.add("0");

        place.setSecondDayLowestTemperature(secondDayTemperatures);

        try {
            assertEquals("0", place.secondDayLowestTemperature());
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }

    @Test
    void testThirdDayHighestTemperature() {
        List<String> thirdDayTemperatures = new ArrayList<>();
        thirdDayTemperatures.add("+7");
        thirdDayTemperatures.add("+6");
        thirdDayTemperatures.add("0");

        place.setThirdDayHighestTemperature(thirdDayTemperatures);

        try {
            assertEquals("+7", place.thirdDayHighestTemperature());
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }

    @Test
    void testThirdDayLowestTemperatureFromList() {
        List<String> thirdDayTemperatures = new ArrayList<>();
        thirdDayTemperatures.add("+7");
        thirdDayTemperatures.add("+6");
        thirdDayTemperatures.add("0");

        place.setThirdDayLowestTemperature(thirdDayTemperatures);

        try {
            assertEquals("0", place.thirdDayLowestTemperature());
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }

    @Test
    void testThirdDayLowestTemperatureNullPointerException() {
        place.setThirdDayLowestTemperature(null);

        try {
            assertEquals("+9", place.thirdDayLowestTemperature());
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }

}