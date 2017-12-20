package weather;

/**
 * Weather request.
 */
public class WeatherRequest {

    private String placeName;
    private String unit;

    public WeatherRequest(String placeName, String unit) {
        this.placeName = placeName;
        this.unit = unit;
    }

    public String getPlaceName() {
        return placeName;
    }

    public String getUnit() {
        return unit;
    }

}
