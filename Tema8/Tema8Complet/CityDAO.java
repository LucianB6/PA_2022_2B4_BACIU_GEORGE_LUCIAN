import com.opencsv.CSVReader;
import org.apache.commons.collections.iterators.SingletonIterator;
import org.apache.commons.collections.iterators.SingletonListIterator;
import org.apache.commons.lang3.ObjectUtils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;


import static java.lang.Math.*;

public class CityDAO {
    private static final SingletonTest instance;

    //Private constructor to prevent instantiation of the class from other classes.

    //Static block initialization
    static{
        try{
            instance = new SingletonTest();
        }catch(Exception e){
            throw new RuntimeException("Exception occured.");
        }
    }

    public static SingletonTest getInstance(){
        return instance;
    }

    public void create(String name, int id, String country, String capital, String latitude, String longitude) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into city (id,name,capital, latitude, country, longitude) values (?,?,?,?,?,?)")) {
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setInt(3, Integer.parseInt(capital));
            pstmt.setDouble(4, Double.parseDouble(latitude));
            pstmt.setString(5, country);
            pstmt.setDouble(6, Double.parseDouble(longitude));
            pstmt.executeUpdate();
        }
    }
    public Integer findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id from city where name='" + name + "'")) {
            return rs.next() ? rs.getInt(1) : null;
        }
    }

    public String findById(int id) throws SQLException {
        Connection con = Database.getConnection();
        if (id < 1) {
            System.out.println("Invalid ID!");
            return null;
        }
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select name from city where id='" + id + "'")) {
            return rs.next() ? rs.getCursorName() : null;
        }
    }

    public String findByCountry(String coutry) throws SQLException{
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(
                    "select city from city where country='" + coutry + "'")){
                return rs.next() ? rs.getCursorName() : null;
        }
    }
    public void feedDB(){
        String fileName = "C:\\Users\\Lucian\\IdeaProjects\\Lab8\\src\\main\\java\\concap.csv";
        try (CSVReader reader = new CSVReader(new FileReader(fileName))) {
            reader.readNext();
            String[] lineInArray;
            int id = 9;
            while ((lineInArray = reader.readNext()) != null) {
                instance.create(lineInArray[0],id,lineInArray[1],"2000000",lineInArray[2],lineInArray[3]);
                id++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void distanceCalculator(String firstCity, String secondCity) throws SQLException {
        double firstLatitude = 0.0;
        double firstLongitude = 0.0;
        double secondLatitude = 0.0;
        double secondLongitude = 0.0;

        Connection con = Database.getConnection();
        try(Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(
                "select latitude, longitude from city where country ='" + firstCity + "'")) {

            if(rs.next()){
                firstLatitude = rs.getDouble(1);
                firstLongitude = rs.getDouble(2);
            }
        }


        try(Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(
                    "select latitude, longitude from city where name ='" + secondCity + "'")){

            if(rs.next()){
                secondLatitude = rs.getDouble(1);
                secondLongitude = rs.getDouble(2);
            }
        }
        firstLatitude = toRadians(firstLatitude);
        firstLongitude = toRadians(firstLongitude);
        secondLatitude = toRadians(secondLatitude);
        secondLongitude = toRadians(secondLongitude);

        double firstLatDist = secondLatitude - firstLatitude;
        double secondLongDist = secondLongitude - firstLongitude;

        double ans = pow(sin(firstLatDist / 2), 2) +
                cos(firstLatitude) * cos(secondLatitude) *
                        pow(sin(secondLongDist / 2), 2);
        long R = 6371;
        ans = 2 * asin(sqrt(ans));

        ans = ans * R;

        System.out.println(ans);
    }
}
