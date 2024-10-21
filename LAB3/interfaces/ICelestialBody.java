package LAB3.interfaces;

public interface ICelestialBody {
	String getName();
	double getMass();
	double getDiameter();
	double getDistanceFromSun();
	void updateName(String newName);
	void updateMass(double newMass);
	void updateDiameter(double newDiameter);
	void updateDistanceFromSun(double newDistanceFromSun);
	String getInfo();
}