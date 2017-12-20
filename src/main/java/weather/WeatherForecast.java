package weather;

/**
 * WeatherForecast.
 */
public class WeatherForecast {

    private double minTemperature;
    private double maxTemperature;
    private double currentTemperature;
    private double pressure;
    private String description;
    private String date;
    private WeatherRequest weatherRequest;

    public void setMinTemperature(double minTemperature) {
        this.minTemperature = minTemperature;
    }

    public void setMaxTemperature(double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public void setCurrentTemperature(double currentTemperature) {
        this.currentTemperature = currentTemperature;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setWeatherRequest(WeatherRequest weatherRequest) {
        this.weatherRequest = weatherRequest;
    }

    public String getPlaceName() {
        return weatherRequest.getPlaceName();
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Place name: " + weatherRequest.getPlaceName() + "\n"
                + "Current temperature: " + currentTemperature + "\n"
                + "Max temperature: " + maxTemperature + "\n"
                + "Min temperature: " + minTemperature + "\n"
                + "Pressure: " + pressure + "\n"
                + "Description: " + description + "\n"
                + "Date: " + date.replaceAll("-", ".");
    }
}
