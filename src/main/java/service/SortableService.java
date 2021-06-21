package service;

import model.City;

import java.util.List;

public interface SortableService {
    List<City> sortByName(List<City> cityList);
    List<City> sortByDistrictAndName(List<City> cityList);
}
