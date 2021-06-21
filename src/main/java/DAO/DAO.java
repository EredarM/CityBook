package DAO;

import model.City;

import java.util.List;

public interface DAO {
    List<City> get();
    List<City> getBookSortedByName();
    List<City> getBookSortedByDistrictAndName();
    void add(List<String> cityList);
}
