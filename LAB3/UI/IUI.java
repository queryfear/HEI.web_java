package LAB3.UI;

import LAB3.entities.Planet;

public interface IUI {
	void start();
	void findFarthestPlanet();
	void findPlanetsCloserThanEarth();
	void sortPlanetsByDistance();
	void findAndModifyPlanet();
	void modifyPlanet(Planet foundPlanet);
	void createNewPlanet();
	void printMenu();
	void exitProgram();
}
