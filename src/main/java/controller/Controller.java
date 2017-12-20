package controller;

import tools.PlaceNotFoundException;
import weather.WeatherForecast;

import java.io.*;
import java.util.List;

/**
 * Controller.
 */
public class Controller {

    private OutputFileWriter outputFileWriter;

    public Controller(OutputFileWriter outputFileWriter) {
        this.outputFileWriter = outputFileWriter;
    }

    public void getWeatherUsingConsoleOneFile() throws IOException, PlaceNotFoundException {
        List<WeatherForecast> weatherForecastList = outputFileWriter.readInformationFromConsole();
        outputFileWriter.writeInformationToExistingOutputFile(weatherForecastList);

        System.out.println("Congratulations! Current and next 4 days forecast in the output file.");
    }

    public void getWeatherUsingInputOneFile() throws IOException, PlaceNotFoundException {
        List<WeatherForecast> weatherForecastList = outputFileWriter.readInformationFromInputFile();
        outputFileWriter.writeInformationToExistingOutputFile(weatherForecastList);

        System.out.println("Congratulations! Current and next 4 days forecast in the output file.");
    }

    public void getWeatherUsingInputMultipleFiles() throws IOException, PlaceNotFoundException {
        outputFileWriter.writeInformationWithNewOutputFileCreation();

        System.out.println("Congratulations! New output files have been created in folder user_outputs");
    }

}
