public class City {
    private int id;
    private String name;
    private String country;
    private String capital;
    private double latitude;
    private double longitude;

    public City(){}

    public City(int id, String name, String country, String capital, double latitude,
                double longitude) {
        this.id = id;
        this.name = name;
        this.capital = capital;
        this.country = country;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("City{ ");
        sb.append("id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", country=").append(country);
        sb.append(", capital=").append(capital);
        sb.append(", latitude=").append(latitude);
        sb.append(", longitude=").append(longitude);
        sb.append("}");
        return sb.toString();
    }
}
