package com.groep12.Person;

import com.groep12.interfaces.Details;
import java.util.ArrayList;

public class Fan implements Details {
    private String name;
    private int ID;
    static int lastUsedID = 0;
    private ArrayList<Person> listFanOf = new ArrayList<>();


    public Fan(String name){
        this.name = name;
        this.ID = lastUsedID;
        lastUsedID++;

    }
    public Fan(String name,int ID){
        this.name = name;
        this.ID = lastUsedID;
        lastUsedID++;

    }

    public String getName() {
        return name;
    }

    public void addFanOf(Person person){
        this.listFanOf.add(person);
    }

    public void setName(String name) {
        this.name = name;
    }

    public  int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public static int getLastUsedID(int lastUsedID) {
        return lastUsedID;
    }

    public ArrayList<Person> getListFanOf (){
        return listFanOf;
    }

    public void setListFanOf(ArrayList<Person> listToSet) {
        this.listFanOf = listToSet;
    }


    @Override
    public void showDetails() {
        System.out.println("-------------");
        System.out.println("Fan name: " + name);
        System.out.println("ID: " + ID);
        for (int i = 0; i < listFanOf.size(); i++){
            System.out.println("Fan of: " + listFanOf.get(i).getName());
        }
    }
    public void swapFanOf(Person from, Person to) {
        for (int i = 0; i < listFanOf.size(); i++) {
            if (listFanOf.get(i).getID() == from.getID()) {
                listFanOf.set(i, to);
            }
        }
    }
}



