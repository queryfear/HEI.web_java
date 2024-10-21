package LAB3.entities;

import LAB3.interfaces.ICelestialBody;

public abstract class CelestialBody implements ICelestialBody {
    protected String name;
    protected double mass;
    protected double diameter;
    protected double distanceFromSun;
    protected String type;

    public CelestialBody(String name, double mass, double diameter, double distanceFromSun, String type) {
        this.name = name;
        this.mass = mass;
        this.diameter = diameter;
        this.distanceFromSun = distanceFromSun;
        this.type = type;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getMass() {
        return mass;
    }

    @Override
    public double getDiameter() {
        return diameter;
    }

    @Override
    public double getDistanceFromSun() {
        return distanceFromSun;
    }

    @Override
    public void updateName(String newName) {
        this.name = newName;
    }
		@Override
    public void updateMass(double newMass) {
        this.mass = newMass;
    }

    @Override
    public void updateDiameter(double newDiameter) {
        this.diameter = newDiameter;
    }

		@Override
    public void updateDistanceFromSun(double newDistanceFromSun) {
        this.distanceFromSun = newDistanceFromSun;
    }

    @Override
    public abstract String getInfo();
}
