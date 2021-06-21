import junit.framework.TestCase;
import model.City;
import service.CityService;
import service.CityServices;

import java.util.ArrayList;
import java.util.List;

public class SortedTest extends TestCase {
    List<City> sortByNameExpectedList;
    List<City> sortByDistrictAndNameExpectedList;
    CityServices cityServices;

    @Override
    public void setUp()  {
        sortByNameExpectedList = new ArrayList<>();
        sortByDistrictAndNameExpectedList = new ArrayList<>();
        cityServices = new CityService();

        City city1 = new City(2, "Абаза", "Хакасия", "Сибирский", 17111, "1867");
        City city2 = new City(3, "Абакан", "Хакасия", "Сибирский", 165183, "1931");
        City city3 = new City(3, "Абдулино", "Оренбургская область", "Приволжский", 20663, "1795");
        City city4 = new City(4, "Асбест", "Свердловская область", "Уральский", 62285, "1889");
        City city5 = new City(1, "Екатеринбург", "Свердловская область", "Уральский", 1495066, "1723");
        City city6 = new City(1, "Ульяновск", "Ульяновская область", "Приволжский", 149066, "1923");


        sortByNameExpectedList.add(city1);
        sortByNameExpectedList.add(city2);
        sortByNameExpectedList.add(city3);
        sortByNameExpectedList.add(city4);
        sortByNameExpectedList.add(city5);
        sortByNameExpectedList.add(city6);

        sortByDistrictAndNameExpectedList.add(city1);
        sortByDistrictAndNameExpectedList.add(city2);
        sortByDistrictAndNameExpectedList.add(city3);
        sortByDistrictAndNameExpectedList.add(city4);
        sortByDistrictAndNameExpectedList.add(city5);
        sortByDistrictAndNameExpectedList.add(city6);
    }

    public void testSortByDistrictAndNameExpectedList() {

        assertEquals(sortByDistrictAndNameExpectedList, cityServices.sortByName(cityServices.getCityFromDB()));
    }

    public void testSortingByName() {
        assertEquals(sortByNameExpectedList, cityServices.sortByName(cityServices.getCityFromDB()));
    }


}
