package com.groep12.gadget;
import com.groep12.interfaces.Details;

public class Base extends Gadget implements Details {
    private final String location;

    public Base(String name, String description, String location) {
        super(name, description);
        this.location = location;
    }

    @Override
    public void showDetails(){
        System.out.println("ID: " + getID() + "\r\n" + "Name: " +
                getName() + "\r\n" + "Description: " + getDescription() + "\r\n" +
                "Type: " + getClass().getSimpleName());
        System.out.println("Location: "+ getLocation() + "\r\n");
    }

    public String getLocation() {
        return location;
    }
}
