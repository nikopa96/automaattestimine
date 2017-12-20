package tools;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import weather.WeatherForecast;
import weather.WeatherRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * Parser.
 */
public class Parser {

    public List<WeatherForecast> createForecast(String weatherData, WeatherRequest weatherRequest) throws PlaceNotFoundException {
        List<WeatherForecast> weatherForecastList = new ArrayList<>();
        List<String> duplicatesDates = new ArrayList<>();

        JSONObject jsonObject = new JSONObject(weatherData);
        JSONArray jsonArray;

        try {
            jsonArray = jsonObject.getJSONArray("list");
        } catch (JSONException e) {
            throw new PlaceNotFoundException("The place not found");
        }

        for (int i = 0; i < jsonArray.length(); i++) {
            String date = jsonArray.getJSONObject(i).getString("dt_txt").substring(0, 10);

            if (!duplicatesDates.contains(date)) {
                duplicatesDates.add(date);

                JSONObject weatherJson = jsonArray.getJSONObject(i).getJSONObject("main");
                WeatherForecast weatherForecast = new WeatherForecast();

                weatherForecast.setCurrentTemperature(weatherJson.getDouble("temp"));
                weatherForecast.setMinTemperature(weatherJson.getDouble("temp_min"));
                weatherForecast.setMaxTemperature(weatherJson.getDouble("temp_max"));
                weatherForecast.setPressure(weatherJson.getDouble("pressure"));
                weatherForecast.setDescription(jsonArray.getJSONObject(i).getJSONArray("weather")
                        .getJSONObject(0).getString("description"));
                weatherForecast.setDate(date);
                weatherForecast.setWeatherRequest(weatherRequest);

                weatherForecastList.add(weatherForecast);
            }
        }


        return weatherForecastList.subList(0, 4);
    }

}
