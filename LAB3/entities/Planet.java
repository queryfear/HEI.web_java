package LAB3.entities;

import LAB3.interfaces.IPlanet;

public class Planet extends CelestialBody implements IPlanet {
    private boolean hasAtmosphere;
    private boolean hasWater;
    private double orbitalPeriod;
    private int numberOfMoons;
    private String surfaceType;

    public Planet(String name, double mass, double diameter, double distanceFromSun, 
                  boolean hasAtmosphere, boolean hasWater, double orbitalPeriod, 
                  int numberOfMoons, String surfaceType) {
        super(name, mass, diameter, distanceFromSun, "Планета");
        this.hasAtmosphere = hasAtmosphere;
        this.hasWater = hasWater;
        this.orbitalPeriod = orbitalPeriod;
        this.numberOfMoons = numberOfMoons;
        this.surfaceType = surfaceType;
    }

    @Override
    public boolean hasWater() {
        return hasWater;
    }

    @Override
    public String getClimateInfo() {
        return hasAtmosphere ? "Есть атмосфера" : "Нет атмосферы";
    }

    @Override
    public int getNumberOfMoons() {
        return numberOfMoons;
    }

    @Override
    public String getInfo() {
        return "Планета " + name + ": " + 
               "\nМасса: " + mass + " кг" +
               "\nДиаметр: " + diameter + " км" +
               "\nРасстояние до солнца: " + distanceFromSun + " миллионы км" +
               "\nЕсть Атмосфера: " + hasAtmosphere +
               "\nЕсть Вода: " + hasWater +
               "\nПериод полного оборота: " + orbitalPeriod + " дней" +
               "\nКоличество спутников: " + numberOfMoons +
               "\nТип планеты: " + surfaceType;
    }
}
