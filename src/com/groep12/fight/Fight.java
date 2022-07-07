package com.groep12.fight;

import java.util.Random;

public abstract class Fight {
    protected enum Winner {
        HERO,
        VILLAIN
    }
    private final int ID;
    private static int lastUsedID;
    private int nrOfHeroFans = 0, nrOfVilainFans = 0;
    private int heroRollCount = 1, villainRollCount = 1;
    private int heroMaxRollValue = 100, villainMaxRollValue = 100;
    private int heroPowerLevel = 0, villainPowerLevel = 0;

    public Fight() {
         this.ID = lastUsedID++;
         lastUsedID++;
    }

    protected double calculateFanRatio(int teamA, int teamB) {
        if (teamA != teamB) {
            int max = Math.max(teamA, teamB);
            int min = Math.min(teamA, teamB);

            return (float) 80 + ((float) (min / max) * 20);
        }
        return 100;
    }

    protected void setRollStats() {
        //This small algorithm adds functionality to the fan Concept
        //Having more fans provides an advantage to the team with the most fans
        //This will give larger + stronger teams a slight chance to lose
        if (nrOfHeroFans != nrOfVilainFans) {
            int lowerFanCountRatioPenalty = (int) calculateFanRatio(nrOfHeroFans, nrOfVilainFans);
            if (nrOfHeroFans > nrOfVilainFans) {
                villainMaxRollValue = 80 + lowerFanCountRatioPenalty;
            } else {
                heroMaxRollValue = 80 + lowerFanCountRatioPenalty;
            }
        }
        //Higher power level grants extra rolls. More strength is more power
        //Remember, empires can always fall
        if (heroPowerLevel != villainPowerLevel) {
            if (heroPowerLevel > villainPowerLevel) {
                heroRollCount += 2;
            } else {
                villainRollCount += 2;
            }
        }

    }

    protected Winner rollForWinner() {
        //This lets us loop through the rolls until we have a winner
        //Ties are boring
        while(true) {
            int[] heroRolls = new int[heroRollCount];
            int[] villainRolls = new int[villainRollCount];

            Random r = new Random();

            for (int i = 0; i < heroRollCount; i++) {
                heroRolls[i] = r.nextInt(heroMaxRollValue);
            }
            for (int i = 0; i < villainRollCount; i++) {
                villainRolls[i] = r.nextInt(villainMaxRollValue);
            }


            //The lower rollCount gets an advantage due to being the underdog
            //A roll of equal value lets the underdog win
            if (heroRollCount != villainRollCount) {
                //AKA the villain is the underdog in this check
                //Since the underdog only gets 1 roll we can access index 0
                boolean heroIsUnderdog = (heroRollCount > villainRollCount);
                int highestUnderdogRoll = heroIsUnderdog ? villainRolls[0] : heroRolls[0];

                boolean didUnderdogWin = (heroIsUnderdog) ? hasHigherRol(highestUnderdogRoll, heroRolls) : hasHigherRol(highestUnderdogRoll, villainRolls);
                boolean didHeroWin = (heroIsUnderdog && didUnderdogWin) || (!heroIsUnderdog && !didUnderdogWin);

                return (didHeroWin) ? Winner.HERO : Winner.VILLAIN;
            } else {
                if (heroRolls[0] == villainRolls[0]) {

                    if (nrOfHeroFans != nrOfVilainFans) {
                        return (nrOfHeroFans > nrOfVilainFans) ? Winner.HERO : Winner.VILLAIN;
                    }
                } else {
                    //If fancount H == V and powerLevel H == V
                    return (heroRolls[0] > villainRolls[0]) ? Winner.HERO : Winner.VILLAIN;
                }
            }
        }
    }

    public void setHeroPowerLevel(int heroPowerLevel) {
        this.heroPowerLevel = heroPowerLevel;
    }

    public void setVillainPowerLevel(int villainPowerLevel) {
        this.villainPowerLevel = villainPowerLevel;
    }

    public void setNrOfHeroFans(int nrOfHeroFans) {
        this.nrOfHeroFans = nrOfHeroFans;
    }

    public void setNrOfVilainFans(int nrOfVilainFans) {
        this.nrOfVilainFans = nrOfVilainFans;
    }

    public int getNrOfHeroFans() {
        return nrOfHeroFans;
    }

    public int getNrOfVilainFans() {
        return nrOfVilainFans;
    }

    private boolean hasHigherRol(int max, int[] rolls) {
        for (int roll : rolls) {
            if (roll > max) {
                return true;
            }
        }
        return false;
    }

    public int getID(){
        return ID;
    }
}
