package com.groep12.gadget;
import com.groep12.interfaces.Details;

public class Weapon extends Gadget implements Details {
    private final int powerLevel;

    public Weapon(String name, String description, int powerLevel) {
        super(name, description);
        this.powerLevel = powerLevel;
    }

    @Override
    public void showDetails(){
        System.out.println("ID: " + getID() + "\r\n" + "Name: " +
                getName() + "\r\n" + "Description: " + getDescription() + "\r\n" +
                "Type: " + getClass().getSimpleName());
        System.out.println("powerLevel: "+ getPowerLevel() + "\r\n");
    }

    public int getPowerLevel(){
        return powerLevel;
    }
}
