package service;

import DAO.*;
import model.City;
import java.util.HashMap;
import java.util.List;

public class CityService implements CityServices {
    private DAO dao;

    public CityService() {
        dao = new CityDAO();
    }

    @Override
    public List<City> getCityFromDB() {
        return dao.get();
    }

    @Override
    public List<City> sortByName(List<City> cityList) {
        return dao.getBookSortedByName();
//        return cityList.stream().sorted(Comparator.comparing((City city) -> city.getName().toLowerCase()))
//                .collect(Collectors.toList());
    }

    @Override
    public List<City> sortByDistrictAndName(List<City> cityList) {
        return dao.getBookSortedByDistrictAndName();
//        cityList.sort(Comparator.comparing((City city) -> city.getDistrict().toLowerCase())
//                .thenComparing((City city) -> city.getName().toLowerCase()));
//        return cityList;
    }

    @Override
    public String searchLargePopulation() {
        City[] cities = dao.get().toArray(new City[0]);

        int maxPopulation = 0;
        int maxIndex = 0;
        for (int i = 0; i < cities.length; i++) {
            if (cities[i].getPopulation() > maxPopulation) {
                maxPopulation = cities[i].getPopulation();
                maxIndex = i;
            }
        }
        return "[" + maxIndex + "] = " + maxPopulation;
    }

    @Override
    public HashMap<String, Integer> searchCitiesArea() {
        HashMap<String, Integer> hashMap = new HashMap<>();

        dao.get().forEach(city -> {
            int count = 1;
            if (hashMap.containsKey(city.getDistrict())) {
                count = hashMap.get(city.getDistrict()) + 1;
            }
            hashMap.put(city.getDistrict(), count);
        });

        return hashMap;
    }
}
