package com.groep12.Person;

import com.groep12.interfaces.Details;

import java.util.ArrayList;

public class Villain extends Person implements Details {
    public ArrayList<Hero> listOfEnemies = new ArrayList<Hero>();
    public Hero archEnemy;
    private String evilPlan;


    public Villain(String name, int ID, String activeLocation, int powerlevel, String oneLiner,String evilPlan){
        super(name,ID,activeLocation,powerlevel,oneLiner);
        this.evilPlan = evilPlan;
    }
    public Villain(String name, int ID, String activeLocation, int powerlevel, String oneLiner,ArrayList<Hero> listOfEnemies,String evilPlan){
        super(name,ID,activeLocation,powerlevel,oneLiner);
        this.listOfEnemies = listOfEnemies;
        this.evilPlan = evilPlan;
    }

    public void showDetails()
    {
        System.out.println("---------------");
        System.out.println("Villain: "+ getName());
        System.out.println("Evil plan: " + this.evilPlan);
        System.out.println("ID: " + this.getID());
        System.out.println("Location: " + this.getActiveLocation());
        System.out.println("Power .printllevel: " + this.getPowerlevel());
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
    public ArrayList<Hero> getListOfEnemies() {
        return listOfEnemies;
    }

    public void setListOfEnemies(ArrayList<Hero> listOfEnemies) {
        this.listOfEnemies = listOfEnemies;
    }

    public Hero getArchEnemy() {
        return archEnemy;
    }

    public void setArchEnemy(Hero archEnemy) {
        this.archEnemy = archEnemy;
    }

    public String getEvilPlan() {
        return evilPlan;
    }

    public void setEvilPlan(String evil_plan) {
        this.evilPlan = evil_plan;
    }


}

