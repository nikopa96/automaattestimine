package weather;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

/**
 * WeekWeather.
 */
public class WeekWeather {

    private List<Integer> currentDayWeatherList = new ArrayList<>();
    private List<Integer> firstDayWeatherList = new ArrayList<>();
    private List<Integer> secondDayWeatherList = new ArrayList<>();
    private List<Integer> thirdDayWeatherList = new ArrayList<>();
    private List<List<Integer>> temperaturesByDays = Arrays.asList(currentDayWeatherList, firstDayWeatherList,
            secondDayWeatherList, thirdDayWeatherList);

    private String JSONResponse;

    private OkHttpClient client = new OkHttpClient();

    public void getResponse(Place place) throws IOException {
        String city = place.getCityName();
        String country = place.getCountryName();

        Request request = new Request.Builder()
                .url("http://api.openweathermap.org/data/2.5/forecast?q=" + city + "," + country
                        + "&units=metric&lang=en&appid=05d34fad269d1a87279992b506b6dd98")
                .build();

        Response response = client.newCall(request).execute();
        JSONResponse = response.body().string();
    }


    public void sortTemperaturesByDays() {
        LocalDate localDate = LocalDate.now();
        int currentDay = 0;

        JSONObject jsonObject1 = new JSONObject(JSONResponse);
        JSONArray jsonArray = jsonObject1.getJSONArray("list");

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject2 = jsonArray.getJSONObject(i);
            String date = jsonObject2.getString("dt_txt").substring(0, 10);

            JSONObject jsonObject3 = jsonObject2.getJSONObject("main");
            int temperature = (int) Math.round(jsonObject3.getDouble("temp"));

            if (date.equals(localDate.getYear() + "-" + localDate.getMonth().getValue() + "-"
                    + localDate.getDayOfMonth())) {
                temperaturesByDays.get(currentDay).add(temperature);
            } else {
                currentDay++;
                localDate = LocalDate.now().plusDays(currentDay);
                if (currentDay <= 3) {
                    temperaturesByDays.get(currentDay).add(temperature);
                } else {
                    break;
                }
            }
        }
    }

    public List<Integer> getCurrentDayWeatherList() {
        return currentDayWeatherList;
    }

    public List<Integer> getFirstDayWeatherList() {
        return firstDayWeatherList;
    }

    public List<Integer> getSecondDayWeatherList() {
        return secondDayWeatherList;
    }

    public List<Integer> getThirdDayWeatherList() {
        return thirdDayWeatherList;
    }

}
