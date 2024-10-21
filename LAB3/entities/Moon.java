package LAB3.entities;

import LAB3.interfaces.IMoon;

public class Moon extends CelestialBody implements IMoon {
    private Planet planetHost;
    private double orbitRadius;
    private double gravity;

    public Moon(String name, double mass, double diameter, double distanceFromSun, 
                Planet planetHost, double orbitRadius, double gravity) {
        super(name, mass, diameter, distanceFromSun, "Спутник");
        this.planetHost = planetHost;
        this.orbitRadius = orbitRadius;
        this.gravity = gravity;
    }

    @Override
    public String checkForLife() {
        return gravity > 1.6 && planetHost.hasWater() ? "Потенциальна для жизни" : "Не потенциальна для жизни";
    }

    @Override
    public String getInfo() {
        return "Спутник " + name + ": " + 
               "\nМасса: " + mass + " кг" +
               "\nДиаметр: " + diameter + " км" +
               "\nРасстояние до солнца: " + distanceFromSun + " миллионов км" +
               "\nАрбита планеты: " + planetHost.getName() +
               "\nРадиус орбиты: " + orbitRadius + " тысячи км" +
               "\nГравитация: " + gravity + " m/s^2";
    }
}