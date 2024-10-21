package LAB3.exteends;

import LAB3.interfaces.ICelestialBody;

public class ConsoleOutputExtend {
    public void printCelestialBodyInfo(ICelestialBody body) {
        if (body != null) {
            System.out.println(body.getInfo());
        } else {
            System.out.println("Космическое тело не найдено.");
        }
    }
}

