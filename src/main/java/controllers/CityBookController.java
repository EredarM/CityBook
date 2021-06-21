package controllers;

import service.CityService;
import service.CityServices;
import java.util.*;

public class CityBookController {
    private CityServices cityServices;

    public CityBookController() {
        cityServices = new CityService();
    }

    public void printBook() {
        cityServices.getCityFromDB().forEach(System.out::println);
    }

    public void sortByName() {
        cityServices.sortByName(cityServices.getCityFromDB()).forEach(System.out::println);
    }

    public void sortByDistrictAndName() {
        cityServices.sortByDistrictAndName(cityServices.getCityFromDB()).forEach(System.out::println);
    }

    public void searchLargePopulation() {
        System.out.println(cityServices.searchLargePopulation());
    }

    public void searchCitiesArea() {
        HashMap<String, Integer> hashMap = cityServices.searchCitiesArea();
        for (Map.Entry<String, Integer> el : hashMap.entrySet()) {
            System.out.println(el.getKey() + " - " + el.getValue());
        }
    }
}
