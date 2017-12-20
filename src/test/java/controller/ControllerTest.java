package controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import tools.Connection;
import tools.Parser;
import weather.WeatherForecast;
import weather.WeatherRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * ControllerTest.
 */
public class ControllerTest {

    private Controller controller;
    private OutputFileWriter outputFileWriter;

    @Before
    public void setUp() {
        outputFileWriter = mock(OutputFileWriter.class);
        controller = new Controller(outputFileWriter);
    }

    @Test
    public void getWeatherUsingConsoleOneFileTest() throws Exception {
        controller.getWeatherUsingConsoleOneFile();
        List<WeatherForecast> weatherForecastList = new ArrayList<>();
        verify(outputFileWriter).writeInformationToExistingOutputFile(weatherForecastList);
    }

    @Test
    public void getWeatherUsingInputOneFileTest() throws Exception {
        controller.getWeatherUsingInputOneFile();
        List<WeatherForecast> weatherForecastList = new ArrayList<>();
        verify(outputFileWriter).writeInformationToExistingOutputFile(weatherForecastList);
    }

    @Test
    public void getWeatherUsingInputMultipleFilesTest() throws Exception {
        controller.getWeatherUsingInputMultipleFiles();
        verify(outputFileWriter).writeInformationWithNewOutputFileCreation();
    }

}