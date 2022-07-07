package com.groep12.Person;

import com.groep12.gadget.Gadget;

import com.groep12.gadget.Weapon;

import java.util.ArrayList;

public abstract class Person {


    private String name;
    private int ID;
    private String activeLocation;
    private int powerlevel;
    private String oneLiner;
    private ArrayList<Gadget> listOfGadgets = new ArrayList<>();
    private ArrayList<Fan> listOfFans = new ArrayList<>();


    public Person(String name) {
        this.name = name;
    }

    public Person(String name, int ID) {
        this.name = name;
        this.ID = ID;
    }

    public void person(String name, int ID, String activeLocation, int powerlevel) {
        this.name = name;

        this.ID = ID;
        this.activeLocation = activeLocation;
        this.powerlevel = powerlevel;
        this.oneLiner = oneLiner;

    }

    public Person(String name, int ID, String activeLocation, int powerlevel, String oneLiner) {
        this.name = name;
        this.ID = ID;
        this.activeLocation = activeLocation;
        this.powerlevel = powerlevel;
        this.oneLiner = oneLiner;


    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getActiveLocation() {
        return activeLocation;
    }

    public void setActiveLocation(String activeLocation) {
        this.activeLocation = activeLocation;
    }

    public int getPowerlevel() {
        return powerlevel;
    }

    public void setPowerlevel(int powerlevel) {
        this.powerlevel = powerlevel;
    }

    public String getOneLiner() {
        return oneLiner;
    }

    public void setOneLiner(String oneLiner) {
        this.oneLiner = oneLiner;
    }

    public void addFan(Fan fan) {
        this.listOfFans.add(fan);
    }


    public ArrayList<Gadget> getListOfGadgets() {
        return listOfGadgets;
    }

    public void setListOfGadgets(ArrayList<Gadget> listOfGadgets) {
        this.listOfGadgets = listOfGadgets;
    }

    public ArrayList<Fan> getListOfFans() {
        return listOfFans;
    }

    public void setListOfFans(ArrayList<Fan> listOfFans) {
        this.listOfFans = listOfFans;
    }
    public void clearListOfFans(){
        listOfFans.clear();
    }
    public void addGadget(Gadget gadget){
        listOfGadgets.add(gadget);
    }

    public int getAdjustedPowerLevel(){
        int powerlevel = this.powerlevel;
        for(Gadget gadget:listOfGadgets){
            if(gadget instanceof Weapon){
                powerlevel += ((Weapon) gadget).getPowerLevel();
            }
        }
        return powerlevel;
    }
}





