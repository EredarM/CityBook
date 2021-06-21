package DAO;

import model.City;
import views.Menu;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CityDAO implements DAO{
    private Connection connection;
    private Statement statement;

    public CityDAO() {
        start();
        loadDataFromTxt(Menu.path);
    }

    private void start() {
        try {
            connection = DriverManager.getConnection("jdbc:h2:mem:CityBook", "sa", "");
            statement = connection.createStatement();
            statement.execute("CREATE TABLE city (id INT PRIMARY KEY AUTO_INCREMENT," +
                    " name VARCHAR(20), region VARCHAR (30), district VARCHAR (30)," +
                    " population INT, foundation VARCHAR(10))");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void loadDataFromTxt(String path) {
        try {
            Scanner scanner = new Scanner(new File(path)).useDelimiter(";");
            List<String> paramList = new ArrayList<>();
            while (scanner.hasNext()) {
                paramList.add(scanner.next().trim());
                if (paramList.size() == 6) {
                    add(paramList);
                    paramList.clear();
                }
            }
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<City> get() {
        List<City> resultCityList = null;
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM city");
            resultCityList = createCities(resultSet);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return resultCityList;
    }

    @Override
    public void add(List<String> cityList) {
        try {
            String query = "INSERT INTO city (name, region, district, population, foundation) Values (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, cityList.get(1));
            preparedStatement.setString(2, cityList.get(2));
            preparedStatement.setString(3, cityList.get(3));
            preparedStatement.setInt(4, Integer.parseInt(cityList.get(4)));
            preparedStatement.setString(5, cityList.get(5));
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<City> getBookSortedByName() {
        List<City> resultCityList = null;
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM city ORDER BY lower(NAME)");
            resultCityList = createCities(resultSet);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return resultCityList;
    }

    public List<City> getBookSortedByDistrictAndName() {
        List<City> resultCityList = null;
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM city ORDER BY lower(district), lower(name)");
            resultCityList = createCities(resultSet);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return resultCityList;
    }

    private List<City> createCities(ResultSet resultSet) {
        List<City> cityList = new ArrayList<>();
        try {
            while(resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String region = resultSet.getString(3);
                String district = resultSet.getString(4);
                int population = resultSet.getInt(5);
                String foundation = resultSet.getString(6);

                cityList.add(new City(id, name, region, district, population, foundation));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return cityList;
    }
}
