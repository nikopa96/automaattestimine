package weather;

/**
 * Place.
 */
public class Place {
    private String city;
    private String country;
    private String latitude;
    private String longitude;
    private int days;

    public Place(String city, String country, String coordinates, int days) {
        this.city = city;
        this.country = country;
        this.latitude = coordinates.substring(0, coordinates.indexOf(":"));
        this.longitude = coordinates.substring(coordinates.indexOf(":") + 1);
        this.days = days;
    }

    public String getCityName() {
        return city;
    }

    public String getCountryName() {
        return country;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public int getRequestedDays() {
        return days;
    }
}
