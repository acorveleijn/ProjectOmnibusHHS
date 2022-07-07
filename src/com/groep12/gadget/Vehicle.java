package com.groep12.gadget;
import com.groep12.interfaces.Details;

public class Vehicle extends Gadget implements Details {
    private final int maxSpeed;
    private final int capacity;

    public Vehicle(String name, String description, int maxSpeed, int capacity) {
        super(name, description);
        this.maxSpeed = maxSpeed;
        this.capacity = capacity;
    }

    @Override
    public void showDetails() {
        System.out.println("ID: " + getID() + "\r\n" + "Name: " +
                getName() + "\r\n" + "Description: " + getDescription() + "\r\n" +
                "Type: " + getClass().getSimpleName());
        System.out.println("Maximum speed: "+ getMaxSpeed() + " km/h");
        System.out.println("Capacity: "+ getCapacity() + " people" + "\r\n");
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getCapacity() {
        return capacity;
    }
}
