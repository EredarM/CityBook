import junit.framework.TestCase;
import service.CityService;
import service.CityServices;

import java.util.HashMap;


public class SearchingTest extends TestCase {
    String searchLargePopulationExpected;
    HashMap<String, Integer> searchCitiesAreaExpected;
    CityServices cityServices;

    @Override
    public void setUp() {
        searchCitiesAreaExpected = new HashMap<>();
        cityServices = new CityService();

        searchLargePopulationExpected = "[0] = 1495066";

        searchCitiesAreaExpected.put("Уральский", 2);
        searchCitiesAreaExpected.put("Сибирский" , 2);
        searchCitiesAreaExpected.put("Приволжский", 2);
    }


    public void testSearchingByCitiesArea() {
        assertEquals(searchCitiesAreaExpected, cityServices.searchCitiesArea());
    }

    public void testSearchingLargePopulation(){
        assertEquals(searchLargePopulationExpected, cityServices.searchLargePopulation());
    }
}
