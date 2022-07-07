package com.groep12.gadget;

public abstract class Gadget {
    private final int ID;
    private final String name;
    private final String description;
    private static int lastUsedID = 0;

    public Gadget(String name, String description) {
        this.ID = lastUsedID++;
        this.name = name;
        this.description = description;
    }

    public int getID() {return ID;}

    public String getName() {return name;}

    public String getDescription() {return description;}

}
