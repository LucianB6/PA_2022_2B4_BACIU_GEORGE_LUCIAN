import java.sql.SQLException;

public class Main {
    public static void main(String args[]) {

        try {
            var continents = new ContinentDAO();

            continents.create(1, "Europe");
           // Database.getConnection().commit();

            var countries = new CountryDAO();

            countries.create("Romania", 1);
            countries.create("Ukraine", 2);

            //Database.getConnection().commit();
            var city = new CityDAO();

            city.distanceCalculator("Romania", "Olanda");

            Database.getConnection().close();
        } catch (SQLException e) {
            System.err.println(e);
           // Database.rollback();
        }

    }
}
