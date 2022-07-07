package com.groep12.fight;

import com.groep12.Person.Fan;
import com.groep12.Person.Hero;
import com.groep12.Person.Person;
import com.groep12.Person.Villain;
import com.groep12.menu.PersonMenu;

import java.util.ArrayList;


public class HeroVSVillainFight extends Fight {
    private Person winner;
    private final Hero fighterHero;
    private final Villain fighterVillain;

    public HeroVSVillainFight(Hero fighterHero, Villain fighterVillain) {
        this.fighterHero = fighterHero;
        this.fighterVillain = fighterVillain;
        calculateWinner();
        calculateLoss();
    }

    public HeroVSVillainFight(Hero fighterHero, Villain fighterVillain, Person winner) {
        this.fighterHero = fighterHero;
        this.fighterVillain = fighterVillain;
        this.winner = winner;
    }

    private void calculateWinner() {
        super.setNrOfHeroFans(fighterHero.getListOfFans().size());
        super.setNrOfVilainFans(fighterVillain.getListOfFans().size());

        super.setHeroPowerLevel(fighterHero.getPowerlevel());
        super.setVillainPowerLevel(fighterVillain.getPowerlevel());

        super.setRollStats();
        switch (super.rollForWinner()) {
            case HERO:
                winner = fighterHero;
                break;
            case VILLAIN:
                winner = fighterVillain;
                break;
            default:
                break;
        }
    }

    public Person getWinner() {
        return this.winner;
    }

    public Hero getFighterHero() {
        return fighterHero;
    }

    public Villain getFighterVillain() {
        return fighterVillain;
    }

    private void calculateLoss() {
        ArrayList<Fan> lostFans;
        if (winner instanceof Hero) {
            lostFans = fighterVillain.getListOfFans();
            fighterVillain.clearListOfFans();
            for (Fan fan : lostFans) {
                fighterHero.addFan(fan);
                fan.swapFanOf(fighterVillain, fighterHero);
                PersonMenu.updateFanAfterFight(fan);
            }
        } else {
            lostFans = fighterHero.getListOfFans();
            fighterHero.clearListOfFans();
            for (Fan fan : lostFans) {
                fighterVillain.addFan(fan);
                fan.swapFanOf(fighterHero, fighterVillain);
                PersonMenu.updateFanAfterFight(fan);
            }

        }
        PersonMenu.updatePersonAfterFight(fighterHero, fighterVillain);
    }
}
