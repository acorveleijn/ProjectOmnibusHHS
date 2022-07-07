package com.groep12.fight;

import com.groep12.Person.Hero;
import com.groep12.Person.Villain;
import com.groep12.team.HeroTeam;
import com.groep12.team.Team;
import com.groep12.team.VillainTeam;


//TODO test
public class TeamFight extends Fight {

    private Team winner;
    private final HeroTeam heroTeam;
    private final VillainTeam villainTeam;

    //We've added two constructors to either have a pre-defined winner
    //or A winner that get's determined by our winner magic
    //cool kids want to use the winner magic robot ;)
    public TeamFight(HeroTeam heroTeam, VillainTeam villainTeam) {
        this.heroTeam = heroTeam;
        this.villainTeam = villainTeam;
        calculateWinner();
    }

    public TeamFight(HeroTeam heroTeam, VillainTeam villainTeam, Team winner) {
        this.heroTeam = heroTeam;
        this.villainTeam = villainTeam;
        this.winner = winner;
    }

    public Team getWinner() {
        return winner;
    }

    public HeroTeam getHeroTeam() {
        return this.heroTeam;
    }

    public VillainTeam getVillainTeam() {
        return this.villainTeam;
    }

    private void calculateWinner() {
        super.setHeroPowerLevel(heroTeam.getTeamPowerLevel());
        super.setVillainPowerLevel(heroTeam.getTeamPowerLevel());
        countFans();
        super.setRollStats();
        switch (super.rollForWinner()) {
            case HERO:
                winner = heroTeam;
                break;
            case VILLAIN:
                winner = villainTeam;
                break;
            default:
                winner = null;
                break;
        }
    }

    private void countFans() {
        //Iterate through arrays to retrieve the current fans
        //Since fans are dynamically allocated based on wins + losses
        //I wanted to load the amount of fans at the fight initiation phase
        int counterHero = 0;
        for (Hero person : heroTeam.getMembers()) {
            counterHero += person.getListOfFans().size();
        }
        super.setNrOfHeroFans(counterHero);

        int counterVillain = 0;
        for(Villain person : villainTeam.getMembers()){
            counterVillain += person.getListOfFans().size();
        }
        super.setNrOfVilainFans(counterVillain);
    }

}
