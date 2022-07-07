package com.groep12.Person;

import com.groep12.interfaces.Details;
import java.util.ArrayList;

public class Hero extends Person implements Details {
    protected ArrayList<Villain> listOfEnemies = new ArrayList<>();
    protected Villain archEnemy;
    private String ownName;


    public Hero(String name){
        super(name);
    }

    public Hero(String name,String ownName,int ID, String activeLocation, int powerlevel, String oneLiner) {
        super(name, ID, activeLocation, powerlevel, oneLiner);
        this.ownName = ownName;
    }
    public Hero(String name,String ownName,int ID, String activeLocation, int powerlevel, String oneLiner,ArrayList<Villain> listOfEnemies) {
        super(name, ID, activeLocation, powerlevel, oneLiner);
        this.listOfEnemies = listOfEnemies;
        this.ownName = ownName;
    }
    public void showDetails()
    {
        System.out.println("---------------");
        System.out.println("Hero: "+ getName());
        System.out.println("Own name: " + this.ownName);
        System.out.println("ID: " + this.getID());
        System.out.println("Location: " + this.getActiveLocation());
        System.out.println("Power level: " + this.getPowerlevel());
        System.out.println("Oneliner: " + this.getOneLiner());


        for(int i = 0; i < listOfEnemies.size(); i++){
            System.out.println("Enemy: " + listOfEnemies.get(i).getName());
        }
        for(int i = 0; i < getListOfFans().size(); i++){
            System.out.println("Fan: " + getListOfFans().get(i).getName());
        }
        for(int i = 0; i < super.getListOfGadgets().size(); i++){
            System.out.println("Gadgets: " + super.getListOfGadgets().get(i).getName());
        }
    }

    public ArrayList<Villain> getListOfEnemies() {
        return listOfEnemies;
    }

    public void setListOfEnemies(ArrayList<Villain> listOfEnemies) {
        this.listOfEnemies = listOfEnemies;
    }

    public Villain getArchEnemy() {
        return archEnemy;
    }

    public void setArchEnemy(Villain archEnemy) {
        this.archEnemy = archEnemy;
    }

    public String getOwnName() {
        return ownName;
    }

    public void setOwnName(String ownName) {
        this.ownName = ownName;
    }

}
