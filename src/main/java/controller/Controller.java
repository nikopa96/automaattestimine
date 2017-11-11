package controller;

import weather.DailyWeather;
import weather.Place;
import weather.WeekWeather;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Controller.
 */
public class Controller {

    private List<String> placesInStrings = new ArrayList<>();

    public String getPlaceFromConsole() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    public String getPlaceFromInputTextFile() {
        Path path = Paths.get("src\\main\\resources\\txt\\input.txt");

        try {
            Stream<String> stream = Files.lines(path);
            placesInStrings = stream.collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return placesInStrings.get(0);
    }

    public void writeInformationToOutputFile(int numberOfPlacesInFile) {
        Path path = Paths.get("src\\main\\resources\\txt\\output.txt");

        try {
            BufferedWriter writer = Files.newBufferedWriter(path);

            for (int i = 0; i < numberOfPlacesInFile; i++) {
                String placeInString = placesInStrings.get(i);

                WeekWeather weekWeather = new WeekWeather(new Place(placeInString));
                weekWeather.setResponse();
                weekWeather.sortTemperaturesByDays();

                DailyWeather dailyWeather = new DailyWeather(weekWeather.getCurrentDayWeatherList());

                writer.write("-----------------------------------------" + "\n");
                writer.write(placeInString + "\n");
                writer.write("Current weather: " + dailyWeather.getCurrentWeather() + "\n");
                writer.write("Highest temperature today: " + dailyWeather.getHighestTemperatureOfTheDay() + "\n");
                writer.write("Lowest temperature today: " + dailyWeather.getLowestTemperatureOfTheDay() + "\n");
                writer.write("-----------------------------------------" + "\n");
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
