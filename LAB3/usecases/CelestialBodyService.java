package LAB3.usecases;

import LAB3.interfaces.IPlanet;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CelestialBodyService {
    private List<IPlanet> planets;

    public CelestialBodyService(List<IPlanet> planets) {
			this.planets = planets;
		}

		public IPlanet findFarthestPlanet() {
        return planets.stream().max(Comparator.comparingDouble(IPlanet::getDistanceFromSun)).orElse(null);
    }

    public List<IPlanet> findPlanetsCloserThanEarth(double earthDistance) {
        List<IPlanet> result = new ArrayList<>();
        for (IPlanet planet : planets) {
            if (planet.getDistanceFromSun() < earthDistance) {
                result.add(planet);
            }
        }
        return result;
    }

    public List<IPlanet> sortPlanetsByDistance() {
        planets.sort(Comparator.comparingDouble(IPlanet::getDistanceFromSun));
        return planets;
    }

    public IPlanet findByName(String name) {
        for (IPlanet planet : planets) {
            if (planet.getName().equalsIgnoreCase(name)) {
                return planet;
            }
        }
        return null;
    }
}
