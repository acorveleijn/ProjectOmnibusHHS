package com.groep12.menu;

import com.groep12.Person.Hero;
import com.groep12.Person.Villain;
import com.groep12.fight.FightHandler;
import com.groep12.fight.HeroVSVillainFight;
import com.groep12.fight.TeamFight;
import com.groep12.team.HeroTeam;
import com.groep12.team.TeamHandler;
import com.groep12.team.VillainTeam;

import java.util.ArrayList;
import java.util.Scanner;

public class FightMenu extends Menu {

    private final FightHandler fightHandler = new FightHandler();
    private final TeamHandler teamHandler = new TeamHandler();

    public FightMenu() {
        super("FIGHT MENU");
        String[] options = {"Start 1V1 fight", "Start teamfight", "Display 1V1 fight history", "Display teamfight history", "Back to main menu"};
        super.setOptions(options);
    }

    public void initiateFightMenu() {
        optionHandling(super.initiateInput());
    }

    private void optionHandling(int choice) {
        switch (choice) {
            case 1:
                add1V1FightOpt();
                break;
            case 2:
                addTeamfightOpt();
                break;
            case 3:
                display1V1HistOpt();
                break;
            case 4:
                dispTeamfightHistOpt();
                break;
            case 5:
                super.backToMainMenu();
                break;
            default:
                break;
        }
    }

    private void add1V1FightOpt() {

        System.out.println("Select the hero that joins the fight");
        //Quick check to see if there are heroes + villains
        if (PersonMenu.getHeroes().size() > 0 && PersonMenu.getVillains().size() > 0) {
            //Since there is no PersonHandler class present we'll have to get the lists from the PersonMenu
            //In an ideal situation we would want to strip the lists/list manipulation from the Menu
            //This will prevent needless memory allocation to the rest of the menu while getting rid of the Static methods
            ArrayList<Hero> heroes = PersonMenu.getHeroes();

            for (int i = 0; i < heroes.size(); i++) {
                System.out.println((i + 1) + " " + heroes.get(i).getName());
            }
            //The get intput function returns the selected value taking in account that arrays start at 0
            //So if the user selects 3 the index will be 2
            int heroIndex = getInputIndex("Select the hero that joins the fight", heroes.size());

            ArrayList<Villain> villains = PersonMenu.getVillains();
            for (int i = 0; i < villains.size(); i++) {
                System.out.println((i + 1) + " " + villains.get(i).getName());
            }
            int villainIndex = getInputIndex("Select the villain that joins the fight", villains.size());

            System.out.println("Set a winner?");
            System.out.println("1 : " + heroes.get(heroIndex).getName());
            System.out.println("2 : " + villains.get(villainIndex).getName());
            System.out.println("3 : Let faith decide!");

            int winnerIndex = getInputIndex("Select a winner (or let faith decide):", 3);
            //winnderIndex 2 would be the faith decide option
            switch (winnerIndex) {
                //Hero won
                case 0: {
                    HeroVSVillainFight heroVSVillainFight = new HeroVSVillainFight(heroes.get(heroIndex), villains.get(villainIndex),
                            heroes.get(heroIndex));
                    fightHandler.addFight(heroVSVillainFight);
                    break;
                }
                //Villain won
                case 1: {
                    HeroVSVillainFight heroVSVillainFight = new HeroVSVillainFight(heroes.get(heroIndex), villains.get(villainIndex),
                            villains.get(heroIndex));
                    fightHandler.addFight(heroVSVillainFight);
                    break;
                }
                //2 == no predefined winner selected
                case 2: {
                    HeroVSVillainFight heroVSVillainFight = new HeroVSVillainFight(heroes.get(heroIndex), villains.get(villainIndex));
                    fightHandler.addFight(heroVSVillainFight);
                    interactiveConsoleSparkles(heroVSVillainFight.getWinner().getName());
                }
                default:
                    break;
            }
        } else {
            System.out.println("It takes two to tango, unfortunately this universe doesn't have enough heroes and villains");
        }
        //If aftercare returns true the user wants to stay in the fightMenu
        if (super.stayInMenu()) {
            initiateFightMenu();
        }

    }

    private int getInputIndex(String line, int max) {
        System.out.println(line);
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int selection = scanner.nextInt();
            if (selection <= max && selection > 0) {
                return selection - 1;
            }
            getInputIndex(line, max);
        } else {
            System.out.println("Please enter a value between 1 and " + max);
            getInputIndex(line, max);
        }
        return 0;
    }

    private void addTeamfightOpt() {
        System.out.println("Select the heroteam that joins the fight");
        //Quick check to see if there are heroes + villains
        if (teamHandler.getHeroTeams().size() > 0 && teamHandler.getVillainTeams().size() > 0) {
            //Since there is no PersonHandler class present we'll have to get the lists from the PersonMenu
            //In an ideal situation we would want to strip the lists/list manipulation from the Menu
            //This will prevent needless memory allocation to the rest of the menu while getting rid of the Static methods
            ArrayList<HeroTeam> heroTeams = teamHandler.getHeroTeams();

            for (int i = 0; i < heroTeams.size(); i++) {
                System.out.println((i + 1) + " " + heroTeams.get(i).getName());
            }
            //The get intput function returns the selected value taking in account that arrays start at 0
            //So if the user selects 3 the index will be 2
            int heroIndex = getInputIndex("Select the hero team that joins the fight", heroTeams.size());

            ArrayList<VillainTeam> villainTeams = teamHandler.getVillainTeams();
            for (int i = 0; i < villainTeams.size(); i++) {
                System.out.println((i + 1) + " " + villainTeams.get(i).getName());
            }
            int villainIndex = getInputIndex("Select the villain team that joins the fight", villainTeams.size());

            System.out.println("Set a winner?");
            System.out.println("1 : " + heroTeams.get(heroIndex).getName());
            System.out.println("2 : " + villainTeams.get(villainIndex).getName());
            System.out.println("3 : Let faith decide!");

            int winnerIndex = getInputIndex("Select a winner (or let faith decide):", 3);
            //winnderIndex 2 would be the faith decide option
            switch (winnerIndex) {
                case 0: {
                    TeamFight teamFight = new TeamFight(heroTeams.get(heroIndex), villainTeams.get(villainIndex),
                            heroTeams.get(heroIndex));
                    fightHandler.addTeamfight(teamFight);
                    break;
                }
                case 1: {
                    TeamFight teamFight = new TeamFight(heroTeams.get(heroIndex), villainTeams.get(villainIndex),
                            villainTeams.get(heroIndex));
                    fightHandler.addTeamfight(teamFight);
                    break;
                }
                //2 == no predefined winner selected
                case 2: {
                    TeamFight teamFight = new TeamFight(heroTeams.get(heroIndex), villainTeams.get(villainIndex));
                    fightHandler.addTeamfight(teamFight);
                    interactiveConsoleSparkles(teamFight.getWinner().getName());
                    break;
                }
                default:
                    break;
            }
        } else {
            System.out.println("It takes two teams to tango, unfortunately this universe doesn't have enough heroes and villain teams");
        }
        //If aftercare returns true the user wants to stay in the fightMenu
        if (super.stayInMenu()) {
            initiateFightMenu();
        }
    }

    //A little easter egg that makes the application feel more like an interactive journey
    //By adding in a little pause the engagement of the use could increase
    private void interactiveConsoleSparkles(String name) {
        System.out.println("Calculating a winner!");
        try {

            Thread.sleep(1000);
            System.out.print(".");
            Thread.sleep(1000);
            System.out.print(".");
            Thread.sleep(1000);
            System.out.print(".");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println("Faith has decided... \n " + name + " has won!");
    }

    private void display1V1HistOpt() {
        ArrayList<HeroVSVillainFight> heroVSVillainFights = fightHandler.getVillainVsHeroFightHistory();
        if (heroVSVillainFights.size() == 0) {
            System.out.println("There are no fights to display");
        } else {
            for (HeroVSVillainFight fight : heroVSVillainFights) {
                Hero hero = fight.getFighterHero();
                Villain villain = fight.getFighterVillain();
                System.out.println("------------------");
                System.out.println(hero.getName() + " VS " + villain.getName());
                System.out.println("FANS: " + hero.getListOfFans().size() + " VS " + villain.getListOfFans().size());
                System.out.println("POWER LEVEL: " + hero.getPowerlevel() + " VS " + villain.getPowerlevel());
                System.out.println("WON BY: " + fight.getWinner().getName());
            }
            System.out.println("------------------");
        }
        //If aftercare returns true the user wants to stay in the fightMenu
        if (super.stayInMenu()) {
            initiateFightMenu();
        }

    }

    private void dispTeamfightHistOpt() {
        //If aftercare returns true the user wants to stay in the fightMenu
        ArrayList<TeamFight> teamFights = fightHandler.getTeamFightHistory();
        if (teamFights.size() == 0) {
            System.out.println("There are no team fights to display");
        } else {
            for (TeamFight fight : teamFights) {
                HeroTeam heroTeam = fight.getHeroTeam();
                VillainTeam villainTeam = fight.getVillainTeam();
                System.out.println("------------------");
                System.out.println(heroTeam.getName() + " VS " + villainTeam.getName());
                System.out.println("FANS: " + fight.getNrOfHeroFans() + " VS " + fight.getNrOfVilainFans());
                System.out.println("POWER LEVEL: " + heroTeam.getTeamPowerLevel() + " VS " + villainTeam.getTeamPowerLevel());
                System.out.println("WON BY: " + fight.getWinner().getName());
            }
            System.out.println("------------------");
        }
        if (super.stayInMenu()) {
            initiateFightMenu();
        }
    }
}
