package tools;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import weather.WeatherRequest;

import java.io.IOException;

/**
 * Connection.
 */
public class Connection {

    private OkHttpClient okHttpClient = new OkHttpClient();

    public String getData(WeatherRequest weatherRequest) throws IOException {
        String placeName = weatherRequest.getPlaceName();
        String unit = weatherRequest.getUnit();

        Request request = new Request.Builder()
                .url("http://api.openweathermap.org/data/2.5/forecast?q=" + placeName + "&units="
                        + unit + "&lang=en&appid=05d34fad269d1a87279992b506b6dd98").build();

        Response response = okHttpClient.newCall(request).execute();

        return response.body().string();
    }

}
