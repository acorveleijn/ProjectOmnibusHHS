package com.groep12.team;

import com.groep12.fight.TeamFight;

import java.util.ArrayList;

public class TeamHandler {
    private static final ArrayList<HeroTeam> heroTeams = new ArrayList<>();
    private  static final ArrayList<VillainTeam> villainTeams = new ArrayList<>();

    public ArrayList<HeroTeam> getHeroTeams() {
        return heroTeams;
    }

    public ArrayList<VillainTeam> getVillainTeams() {
        return villainTeams;
    }

    public static void addHeroTeam(HeroTeam team){
        heroTeams.add(team);
    }

    public static void addVillainTeam(VillainTeam team){
        villainTeams.add(team);
    }
}
