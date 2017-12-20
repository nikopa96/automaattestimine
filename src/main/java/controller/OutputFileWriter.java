package controller;

import tools.Connection;
import tools.Parser;
import tools.PlaceNotFoundException;
import weather.WeatherForecast;
import weather.WeatherRepository;
import weather.WeatherRequest;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static constants.Constants.metric;

/**
 * OutputFileWriter
 */
public class OutputFileWriter {

    private String inputFilePath;
    private String outputFilePath;

    public OutputFileWriter(String inputFilePath, String outputFilePath) {
        this.inputFilePath = inputFilePath;
        this.outputFilePath = outputFilePath;
    }

    List<WeatherForecast> readInformationFromConsole() throws IOException, PlaceNotFoundException {
        List<WeatherForecast> weatherForecastList = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the place: ");

        if (scanner.hasNext()) {
            WeatherRequest weatherRequest = new WeatherRequest(scanner.next(), metric);
            WeatherRepository weatherRepository = new WeatherRepository(new Connection(), new Parser());

            weatherForecastList.addAll(weatherRepository.getCurrentAndNextThreeDaysWeather(weatherRequest));
        } else {
            System.out.println("Error");
        }

        return weatherForecastList;
    }

    List<WeatherForecast> readInformationFromInputFile() throws IOException, PlaceNotFoundException {
        Path path = Paths.get(inputFilePath);
        List<WeatherForecast> weatherForecastList = new ArrayList<>();

        Stream<String> stream = Files.lines(path);
        List<String> placesInStrings = stream.collect(Collectors.toList());

        for (String place : placesInStrings) {
            WeatherRequest weatherRequest = new WeatherRequest(place, metric);
            WeatherRepository weatherRepository = new WeatherRepository(new Connection(), new Parser());
            weatherForecastList.addAll(weatherRepository.getCurrentAndNextThreeDaysWeather(weatherRequest));
        }

        return weatherForecastList;
    }

    void writeInformationToExistingOutputFile(List<WeatherForecast> weatherForecastList) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(outputFilePath)));

        for (WeatherForecast weatherForecast: weatherForecastList) {
            bufferedWriter.write(weatherForecast.toString() + "\n\n");
        }

        bufferedWriter.close();
    }

    void writeInformationWithNewOutputFileCreation() throws IOException, PlaceNotFoundException {
        Path path = Paths.get(inputFilePath);

        Stream<String> stream = Files.lines(path);
        List<String> placesInStrings = stream.collect(Collectors.toList());

        for (String place : placesInStrings) {
            List<WeatherForecast> weatherForecastList = new ArrayList<>();

            WeatherRequest weatherRequest = new WeatherRequest(place, metric);
            WeatherRepository weatherRepository = new WeatherRepository(new Connection(), new Parser());
            weatherForecastList.addAll(weatherRepository.getCurrentAndNextThreeDaysWeather(weatherRequest));

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("src\\main\\resources\\user_outputs\\" + place + ".txt")));

            for (WeatherForecast weatherForecast : weatherForecastList) {
                bufferedWriter.write(weatherForecast.toString() + "\n\n");
            }

            bufferedWriter.close();
        }
    }

}
