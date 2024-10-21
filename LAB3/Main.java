package LAB3;

import LAB3.entities.Planet;
import LAB3.usecases.CelestialBodyService;
import LAB3.exteends.ConsoleOutputExtend;
import LAB3.interfaces.IPlanet;
import LAB3.UI.UI;

import java.util.Arrays;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // Инициализация данных
        Planet earth = new Planet("Earth", 5.972e24, 12742, 149.6, true, true, 365.25, 1, "Скалистый");
        Planet mars = new Planet("Mars", 6.39e23, 6779, 227.9, true, false, 687, 2, "Скалистый");
        Planet jupiter = new Planet("Jupiter", 1.898e27, 139820, 778.5, true, false, 4333, 79, "Газовый гигант");

        ArrayList<IPlanet> planets = new ArrayList<IPlanet>(Arrays.asList(earth, mars, jupiter));

        CelestialBodyService service = new CelestialBodyService(planets);
        ConsoleOutputExtend output = new ConsoleOutputExtend();

        System.out.println("\nЛабораторная работа №3 ООП в Java. Выполнили Арефьев Данил, Владислав Медушонков");
        System.out.println("\nЗадание: Реализовать в рамках ООП на языке Java предложенные. Реализовать иерархию минимум из 3 классов. Каждый класс должен иметь в своем составе минимум 5 полей и 3 метода.");
        // Создаем и запускаем UI
        UI ui = new UI(service, output, planets);
        ui.start();
    }
}
