package com.groep12.team;

import com.groep12.Person.Hero;

import java.util.ArrayList;

public class HeroTeam extends Team {

    private final ArrayList<Hero> members = new ArrayList<>();

    public HeroTeam(String name) {
        super(name);
    }

    public void addMember(Hero hero) {
        members.add(hero);
    }

    public int getTeamPowerLevel() {
        int powerLevel = 0;
        for(Hero hero : members){
            powerLevel+= hero.getAdjustedPowerLevel();
        }
        return powerLevel;
    }

    @Override
    public void showDetails() {

        StringBuilder detailStr = new StringBuilder();
        String headerStr = "|Team of heroes " + super.getName() + " details|\n";

        //.repeat() was a java 11 function. Back to ye olde loop it is
        for (int i = 0; i < headerStr.length() + 2; i++) {
            detailStr.append("-");
        }

        detailStr.append(headerStr);

        //Im aware this could be placed in a string handler to avoid duplication
        for (int i = 0; i < headerStr.length() + 2; i++) {
            detailStr.append("-");
        }

        String nameLine = "Team name: " + super.getName() + "\n";
        detailStr.append(nameLine);
        String powerLevelLine = "Power-level: " + getTeamPowerLevel() + "\n";
        detailStr.append(powerLevelLine);
        String amntOfMembers = "The team has " + members.size() + " members";
        detailStr.append(amntOfMembers);


        System.out.println(detailStr);
    }

    public ArrayList<Hero> getMembers() {
        return this.members;
    }
}
