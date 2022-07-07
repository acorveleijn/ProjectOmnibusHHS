package com.groep12.fight;

import java.util.ArrayList;

public class FightHandler {
    private static final ArrayList<TeamFight> teamFightHistory = new ArrayList<>();
    private static final ArrayList<HeroVSVillainFight> villainVsHeroFightHistory = new ArrayList<>();

    public void addTeamfight(TeamFight fight){
        teamFightHistory.add(fight);
    }

    public void addFight(HeroVSVillainFight fight){
        villainVsHeroFightHistory.add(fight);
    }

    public ArrayList<TeamFight> getTeamFightHistory() {
        return teamFightHistory;
    }

    public ArrayList<HeroVSVillainFight> getVillainVsHeroFightHistory() {
        return villainVsHeroFightHistory;
    }
    public TeamFight getTeamfightByID(int id){
        for (TeamFight teamFight : teamFightHistory) {
            if (teamFight.getID() == id) {
                return teamFight;
            }
        }
        return null;
    }
    public HeroVSVillainFight getHeroVSVillainFight(int id){
        for (HeroVSVillainFight fight : villainVsHeroFightHistory) {
            if (fight.getID() == id) {
                return fight;
            }
        }
        return null;
    }
}
