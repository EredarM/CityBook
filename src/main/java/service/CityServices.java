package service;

import model.City;
import java.util.List;

public interface CityServices extends SortableService, SearchableService{
    List<City> getCityFromDB();
}
