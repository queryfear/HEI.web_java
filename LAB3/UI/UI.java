package LAB3.UI;

import LAB3.entities.Planet;
import LAB3.usecases.CelestialBodyService;
import LAB3.exteends.ConsoleOutputExtend;
import LAB3.interfaces.IPlanet;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class UI implements IUI {
    private final CelestialBodyService service;
    private final ConsoleOutputExtend output;
    private final ArrayList<IPlanet> planets;
    private final Scanner scanner;

    public UI(CelestialBodyService service, ConsoleOutputExtend output, ArrayList<IPlanet> planets) {
        this.service = service;
        this.output = output;
        this. planets = planets;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void start() {
        while (true) {
            // Выводим меню
            printMenu();

            // Ввод выбора действия
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    findFarthestPlanet();
                    break;

                case 2:
                    findPlanetsCloserThanEarth();
                    break;

                case 3:
                    sortPlanetsByDistance();
                    break;

                case 4:
                    findAndModifyPlanet();
                    break;
                
                case 5:
                    createNewPlanet();
                    break;

                case 6:
                    exitProgram();
                    return;

                default:
                    System.out.println("Некорректный выбор. Пожалуйста, выберите действительное действие.");
            }
        }
    }

    // Метод для нахождения самой далекой планеты
    public  void findFarthestPlanet() {
        output.printCelestialBodyInfo(service.findFarthestPlanet());
    }

    // Метод для нахождения планет, которые ближе к Солнцу, чем Земля
    public void findPlanetsCloserThanEarth() {
        List<IPlanet> closerThanEarth = service.findPlanetsCloserThanEarth(149.6);
        for (IPlanet planet : closerThanEarth) {
            output.printCelestialBodyInfo(planet);
        }
    }

    // Метод для сортировки планет по расстоянию от Солнца
    public void sortPlanetsByDistance() {
        List<IPlanet> planets = service.sortPlanetsByDistance();
        System.out.println("Планеты упорядочены по возрастанию расстояния от Солнца.");
        for (IPlanet planet : planets) {
            output.printCelestialBodyInfo(planet);
            System.out.println("\n");
        }
    }

    // Метод для поиска планеты по названию и изменения её параметров
    public void findAndModifyPlanet() {
        System.out.println("Введите название планеты для поиска:");
        scanner.nextLine(); // очищаем буфер
        String planetName = scanner.nextLine();

        Planet foundPlanet = (Planet) service.findByName(planetName);
        if (foundPlanet != null) {
            modifyPlanet(foundPlanet);
        } else {
            System.out.println("Планета с таким именем не найдена.");
        }
    }

    // Метод для изменения параметров планеты
    public void modifyPlanet(Planet foundPlanet) {
        System.out.println("\nВыберите действие:");
        System.out.println("1. Изменить название планеты");
        System.out.println("2. Изменить массу планеты");
        System.out.println("3. Изменить диаметр планеты");
        System.out.println("4. Изменить расстояние до Солнца");
        // Дополнительные параметры можно добавить здесь

        int choice = scanner.nextInt();
        scanner.nextLine(); // Очищаем буфер

        switch (choice) {
            case 1:
                System.out.println("Введите новое название для планеты " + foundPlanet.getName() + ":");
                String newName = scanner.nextLine();
                foundPlanet.updateName(newName);
                System.out.println("Название планеты обновлено.\n");
                break;

            case 2:
                System.out.println("Введите новую массу для планеты " + foundPlanet.getName() + ":");
                double newMass = scanner.nextDouble();
                foundPlanet.updateMass(newMass);
                System.out.println("Масса планеты обновлена.\n");
                break;

            case 3:
                System.out.println("Введите новый диаметр для планеты " + foundPlanet.getName() + ":");
                double newDiameter = scanner.nextDouble();
                foundPlanet.updateDiameter(newDiameter);
                System.out.println("Диаметр планеты обновлен.\n");
                break;

            case 4:
                System.out.println("Введите новое расстояние до Солнца для планеты " + foundPlanet.getName() + ":");
                double newDistanceFromSun = scanner.nextDouble();
                foundPlanet.updateDistanceFromSun(newDistanceFromSun);
                System.out.println("Расстояние до Солнца обновлено.\n");
                break;

            default:
                System.out.println("Некорректный выбор.\n");
        }

        output.printCelestialBodyInfo(foundPlanet);
    }

    public void createNewPlanet(){
        scanner.nextLine(); // Очищаем буфер

        System.out.println("Введите название новой планеты: ");
        String name = scanner.nextLine();

        System.out.println("Введите массу новой планеты: ");
        double mass = scanner.nextDouble();

        System.out.println("Введите диаметр новой планеты: ");
        double diameter = scanner.nextDouble();

        System.out.println("Введите расстояние от Солнца для новой планеты: ");
        double distanceFromSun = scanner.nextDouble();

        System.out.println("Есть атмосфера?: ");
        boolean hasAtmosphere = scanner.nextBoolean();

        System.out.println("Есть вода?: ");
        boolean hasWater = scanner.nextBoolean();

        System.out.println("Введите орбитальный период: ");
        double orbitalPeriod = scanner.nextDouble();

        System.out.println("Количество спутников: ");
        int numberOfMoons = scanner.nextInt();

        scanner.nextLine(); // Очищаем буфер
        
        System.out.println("Введите тип новой планеты: ");
        String type = scanner.nextLine();

        Planet newPlanet = new Planet(name, mass, diameter, distanceFromSun, hasAtmosphere, hasWater, orbitalPeriod, numberOfMoons, type);
        
        planets.add(newPlanet);
    }
    
    // Метод для вывода меню
    public void printMenu() {
        System.out.println("\nВыберите действие:");
        System.out.println("1. Найти самую далекую планету от Солнца");
        System.out.println("2. Найти планеты, которые ближе к Солнцу, чем Земля");
        System.out.println("3. Упорядочить планеты по расстоянию от Солнца");
        System.out.println("4. Найти планету по названию и изменить её значения");
        System.out.println("5. Создать новую планету");
        System.out.println("6. Выход");
    }

    // Метод для завершения программы
    public void exitProgram() {
        System.out.println("Программа завершена.\n");
        scanner.close();
    }
}