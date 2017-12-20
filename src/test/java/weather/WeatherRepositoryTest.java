package weather;

import constants.Constants;
import org.junit.Before;
import org.junit.Test;
import tools.Connection;
import tools.Parser;
import tools.PlaceNotFoundException;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * WeatherRepositoryTest.
 */
public class WeatherRepositoryTest {

    private static final String LONG_JSON = "{ \"cod\":\"200\", \"message\":0.0031, \"cnt\":40, \"list\":[ { \"dt\":1513803600, \"main\":{ \"temp\":2.67, \"temp_min\":1.7, \"temp_max\":2.67, \"pressure\":1030, \"sea_level\":1033.65, \"grnd_level\":1030, \"humidity\":100, \"temp_kf\":0.97 }, \"weather\":[ { \"id\":500, \"main\":\"Rain\", \"description\":\"light rain\", \"icon\":\"10n\" } ], \"clouds\":{ \"all\":92 }, \"wind\":{ \"speed\":9.97, \"deg\":209.004 }, \"rain\":{ \"3h\":0.31 }, \"snow\":{ }, \"sys\":{ \"pod\":\"n\" }, \"dt_txt\":\"2017-12-20 21:00:00\" }, { \"dt\":1513814400, \"main\":{ \"temp\":3.45, \"temp_min\":2.72, \"temp_max\":3.45, \"pressure\":1027.31, \"sea_level\":1030.84, \"grnd_level\":1027.31, \"humidity\":100, \"temp_kf\":0.72 }, \"weather\":[ { \"id\":500, \"main\":\"Rain\", \"description\":\"light rain\", \"icon\":\"10n\" } ], \"clouds\":{ \"all\":92 }, \"wind\":{ \"speed\":10.12, \"deg\":212.008 }, \"rain\":{ \"3h\":1.335 }, \"snow\":{ }, \"sys\":{ \"pod\":\"n\" }, \"dt_txt\":\"2017-12-21 00:00:00\" }, { \"dt\":1513825200, \"main\":{ \"temp\":4.18, \"temp_min\":3.7, \"temp_max\":4.18, \"pressure\":1024.17, \"sea_level\":1027.77, \"grnd_level\":1024.17, \"humidity\":100, \"temp_kf\":0.48 }, \"weather\":[ { \"id\":500, \"main\":\"Rain\", \"description\":\"light rain\", \"icon\":\"10n\" } ], \"clouds\":{ \"all\":92 }, \"wind\":{ \"speed\":9.06, \"deg\":218.503 }, \"rain\":{ \"3h\":1.595 }, \"snow\":{ }, \"sys\":{ \"pod\":\"n\" }, \"dt_txt\":\"2017-12-22 03:00:00\" }, { \"dt\":1513836000, \"main\":{ \"temp\":4.5, \"temp_min\":4.26, \"temp_max\":4.5, \"pressure\":1022.09, \"sea_level\":1025.76, \"grnd_level\":1022.09, \"humidity\":98, \"temp_kf\":0.24 }, \"weather\":[ { \"id\":500, \"main\":\"Rain\", \"description\":\"light rain\", \"icon\":\"10n\" } ], \"clouds\":{ \"all\":92 }, \"wind\":{ \"speed\":6.82, \"deg\":235.001 }, \"rain\":{ \"3h\":1.09 }, \"snow\":{ }, \"sys\":{ \"pod\":\"n\" }, \"dt_txt\":\"2017-12-23 06:00:00\" }, { \"dt\":1513846800, \"main\":{ \"temp\":3.11, \"temp_min\":3.11, \"temp_max\":3.11, \"pressure\":1022.14, \"sea_level\":1025.65, \"grnd_level\":1022.14, \"humidity\":100, \"temp_kf\":0 }, \"weather\":[ { \"id\":500, \"main\":\"Rain\", \"description\":\"light rain\", \"icon\":\"10d\" } ], \"clouds\":{ \"all\":92 }, \"wind\":{ \"speed\":5.26, \"deg\":301.007 }, \"rain\":{ \"3h\":0.15 }, \"snow\":{ }, \"sys\":{ \"pod\":\"d\" }, \"dt_txt\":\"2017-12-24 09:00:00\" } ], \"city\":{ \"id\":590447, \"name\":\"Tallinn\", \"coord\":{ \"lat\":59.4372, \"lon\":24.7454 }, \"country\":\"EE\", \"population\":16630 } }";
    private static final String JSON_WITHOUT_INFORMATION = "{\"cod\":\"404\",\"message\":\"city not found\"}";

    private Connection connection;
    private WeatherRepository weatherRepository;

    @Before
    public void setUp() {
        connection = mock(Connection.class);
        weatherRepository = new WeatherRepository(connection, new Parser());
    }

    @Test
    public void getCurrentWeatherTest() throws Exception {
        WeatherRequest weatherRequest = mock(WeatherRequest.class);

        when(connection.getData(weatherRequest)).thenReturn(LONG_JSON);
        assertEquals(weatherRepository.getCurrentWeather(weatherRequest).getDate(), "2017-12-20");
        verify(connection).getData(weatherRequest);
    }

    @Test
    public void getCurrentAndNextThreeDaysWeather() throws IOException, PlaceNotFoundException {
        WeatherRequest weatherRequest = mock(WeatherRequest.class);

        when(connection.getData(weatherRequest)).thenReturn(LONG_JSON);
        assertEquals(weatherRepository.getCurrentAndNextThreeDaysWeather(weatherRequest).size(), 4);
        verify(connection).getData(weatherRequest);
    }

    @Test(expected = PlaceNotFoundException.class)
    public void placeNotFoundExceptionTest() throws IOException, PlaceNotFoundException {
        WeatherRequest weatherRequest = mock(WeatherRequest.class);

        when(connection.getData(weatherRequest)).thenReturn(JSON_WITHOUT_INFORMATION);
        weatherRepository.getCurrentAndNextThreeDaysWeather(weatherRequest);
        verify(connection).getData(weatherRequest);
    }

}