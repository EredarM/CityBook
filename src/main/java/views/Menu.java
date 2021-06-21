package views;

import controllers.CityBookController;
import java.util.Scanner;

public class Menu {
    public static String path = "src/main/resources/city.txt";
    private CityBookController cityBookController;

    public Menu() {
        cityBookController = new CityBookController();
    }

    public void startMenu() {
        try {
            printMenu();
            Scanner scanner = new Scanner(System.in);
            while (!scanner.hasNext("0")) {
                String num = scanner.nextLine();
                switch (num) {
                    case "1":
                        cityBookController.printBook();
                        break;
                    case "2":
                        cityBookController.sortByName();
                        break;
                    case "3":
                        cityBookController.sortByDistrictAndName();
                        break;
                    case "4":
                        cityBookController.searchLargePopulation();
                        break;
                    case "5":
                        cityBookController.searchCitiesArea();
                        break;
                    case "6":
                        printMenu();
                        break;
                    default:
                        System.out.println("Error");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printMenu() {
        System.out.println("\n1 - Распечатать список городов\n" +
                "2 - Отсортировать по наименованию\n" +
                "3 - Отсортировать по федеральному округу и наименованию\n" +
                "4 - Поиск города с наибольшим количество житилей\n" +
                "5 - Поиск количества городов в регионе\n" +
                "6 - Инфо\n" +
                "0 - Выход\n");
    }
}
