package weather;

import java.util.Collections;
import java.util.List;

/**
 * DailyWeather.
 */
public class DailyWeather {

    private List<Integer> temperaturesOfTheDay;

    public DailyWeather(List<Integer> dailyWeatherList) {
        this.temperaturesOfTheDay = dailyWeatherList;
    }

    public int getCurrentWeather() {
        return temperaturesOfTheDay.get(0);
    }

    public int getHighestTemperatureOfTheDay() {
        return Collections.max(temperaturesOfTheDay);
    }

    public int getLowestTemperatureOfTheDay() {
        return Collections.min(temperaturesOfTheDay);
    }


}
