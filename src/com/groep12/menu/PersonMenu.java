package com.groep12.menu;

import com.groep12.Person.Fan;
import com.groep12.Person.Hero;

import com.groep12.Person.Villain;
import com.groep12.gadget.Gadget;
import com.groep12.team.HeroTeam;
import com.groep12.team.TeamHandler;
import com.groep12.team.VillainTeam;

import java.util.*;


public class PersonMenu extends Menu {

    private static final ArrayList<Hero> heroes = new ArrayList<Hero>();
    private static final ArrayList<Villain> villains = new ArrayList<Villain>();
    private static final ArrayList<Fan> fans = new ArrayList<Fan>();
    String[] heroNames = {"Strong Owl", "Venombite", "Wolf", "Electrocus", "Oxman", "Nighthawk", "Vindicator", "Phantasm", "Axeman", "Gladiator"};
    String[] villainNames = {"Kalaraja", "Raven", "Dugal", "Keres", "Killer Criminal", "Rundown", "Multilator", "Patch Galactic", "Snake", "Crypto"};
    String[] heroOwnNames = {"Bronwen Baird", "Alonzo Verstap", "Umar Morgen", "George Green", "Ivo Harper", "Mario Webber", "Rob Janssens", "Leroy Simmons", "Avery Perez", "Michel Li"};

    String[] oneliners = {
            "I'll be back",
            "All that glitters is not gold.",
            "Eighty percent of success is showing up.",
            "If you build it, they will come. ",
            "Hell is other people.",
            "If you build it, they will come.",
            "I love the smell of napalm in the morning",
            "Knowledge is power.",
            "To be or not to be, that is the question.",
            "If you want something done right, do it yourself. ",
            "May the Force be with you",
            "Houston, we have a problem.",
            "Not all those who wander are lost.",
            "What doesn't kill us makes us stronger.",
            "You talkin' to me?",
            "Veni, vidi, vici.",
            "I can tell you this much from personal experience and observation: Hate solves no problems. It only creates them.",
            "Wow”",
            "Uhh...Right.",
            "Go ahead, make my day."};


    String[] activeLocations = {
            "Oklekok",
            "Pruiword",
            "Flatosa",
            "Gobouis",
            "Sluupleim",
            "Brekeka",
            "Glaemia",
            "Dregence",
            "Kluushia",
            "Geuflaco"
    };
    String[] fanNames = {
            "Harpreet Santana",
            "Joël Bentley",
            "Nadia Trejo",
            "Karel Janssen",
            "Boris Parker",
            "Molly Gump",
            "Fred de Grote",
            "Said Mann",
            "Alex Tate ",
            "Corné de Vries "};

    String[] evilPlans = {
            "I want to rule the world by Friday",
            "I want to Build a huge army of mind controlled slaves",
            "Collapses a mine with a mass of people trapped inside",
            "Call my evil plan methodolgy ",
            "Robbing everyone of their free will, they will have no choice but to serve their rightful ruler!",
            "Why take over the world when you can blow it up?",
            "Release the source of all Evil from its prison and create havoc",
            "I want to create a great world war",
            "So what... I want to steal two nuclear missiles and try to get ransom from the U.S. by threatening to launch them",
            "I want to kill my partner in crime in the process and take over her organization afterwards."};

    private void fillLists() {
        Random rand = new Random();
        ArrayList<Gadget> listOfGadgets = GadgetMenu.getGadgets();
        for (int i = 0; i < heroNames.length; i++) {
            Hero hero = new Hero(heroNames[i], heroOwnNames[i], i, activeLocations[i], (5612 - (i * 3)), oneliners[i]);
            if (i % 2 == 0) {
                hero.addGadget(listOfGadgets.get(i));
            }
            heroes.add(hero);
        }

        for (int i = 0; i < villainNames.length; i++) {
            Villain villain = new Villain(villainNames[i], i, activeLocations[i], (5612 - (villainNames.length - i * 3)), oneliners[i], evilPlans[i]);
            if (i % 2 != 0) {
                villain.addGadget(listOfGadgets.get(i));
            }
            villains.add(villain);
        }

        for (int i = 0; i < fanNames.length; i++) {
            Fan fan = new Fan(fanNames[i]);
            fans.add(fan);
        }

        for (int i = 0; i < heroes.size(); i++) {
            ArrayList<Villain> randEnemies = new ArrayList<>();
            int enemyA = rand.nextInt(villains.size() - 1);
            int enemyB = rand.nextInt(villains.size() - 1);

            randEnemies.add(villains.get(enemyA));
            randEnemies.add(villains.get(enemyB));
            int fanA = rand.nextInt(fans.size() - 1);
            //Plaats fanOf in de actieve hero
            fans.get(fanA).addFanOf(heroes.get(i));
            //Plaats de fan in de lijst van fans
            heroes.get(i).addFan(fans.get(fanA));
            //Plaats de enemies in de heroes class
            heroes.get(i).setListOfEnemies(randEnemies);
        }

        Random rando = new Random();

        for (int i = 0; i < villains.size(); i++) {
            ArrayList<Hero> randomOfEnemies = new ArrayList<>();
            int enemyA = rando.nextInt(villains.size() - 1);
            int enemyB = rando.nextInt(villains.size() - 1);
            int enemyC = rando.nextInt(villains.size() - 1);

            randomOfEnemies.add(heroes.get(enemyA));
            randomOfEnemies.add(heroes.get(enemyB));
            randomOfEnemies.add(heroes.get(enemyC));

            int fanA = rand.nextInt(fans.size() - 1);
            //Plaats fanOf in de actieve hero
            fans.get(fanA).addFanOf(villains.get(i));
            //Plaats de fan in de lijst van fans
            villains.get(i).addFan(fans.get(fanA));

            villains.get(i).setListOfEnemies(randomOfEnemies);
        }

        String[] heroTeamNames = {"The shining twinkle heroes", "Pew pew", "Stone coal warriors"};
        for(int i = 0; i < heroTeamNames.length; i++){
            HeroTeam heroTeam = new HeroTeam(heroTeamNames[i]);
            heroTeam.addMember(heroes.get(heroes.size()-i - 1));
            TeamHandler.addHeroTeam(heroTeam);
        }

        String[] villainTeamNames = {"The dark purple monsters", "Poof Poof", "Titanium blitz"};
        for(int i = 0; i < heroTeamNames.length; i++){
            VillainTeam villainTeam = new VillainTeam(villainTeamNames[i]);
            villainTeam.addToVillainTeam(villains.get(villains.size()-i - 1));
            TeamHandler.addVillainTeam(villainTeam);
        }


    }

    public PersonMenu() {
        super("PERSON MENU");
        fillLists();
    }

    public void initiatePersonMenu() {
        //Pass a header to the super to be displayed in the top banner
        // super("Person Menu");
        //These options will be printed in the menu list

        String[] options = {
                "List of Hero's",
                "Details of Hero's",
                "List of Villains",
                "Details of Villains",
                "List of Fans",
                "Details of Fans",
                "Search",
                "Return to MainMenu"
        };

        super.setOptions(options);
        choices(super.initiateInput());
    }

    private void choices(int options) {
        switch (options) {

            case 1:
                System.out.println("You chose List of Hero's");
                for (Hero hero : heroes) {
                    System.out.println(hero.getName() + " " + hero.getID());
                }
                break;
            case 2:
                System.out.println("You chose Details of Hero's");
                for (Hero hero : heroes) {
                    hero.showDetails();
                }
                break;
            case 3:
                System.out.println("You chose List of Villains");
            {// nog aanpassen
                for (int i = 0; i < villains.size(); i++) {
                    System.out.println(villains.get(i).getName() + " " + villains.get(i).getID());
                }
            }
            break;
            case 4:
                System.out.println("You chose Details of Villains");
                for (int i = 0; i < villains.size(); i++) {
                    villains.get(i).showDetails();
                }
                break;
            case 5:
                System.out.println("You chose List of Fans");
                for (Fan fan : fans) {
                    System.out.println(fan.getName() + " " + fan.getID());
                }
                break;
            case 6:
                System.out.println("You chose Details of Fans");
                for (int i = 0; i < fans.size(); i++) {
                    fans.get(i).showDetails();
                }
                System.out.println();
                break;
            case 7:
                System.out.println("You chose Search");
                search();
                break;
            case 8:
                System.out.println("You chose Return to Main Menu");
                break;
            default:
                break;
        }
        if (super.stayInMenu()) {
            initiatePersonMenu();
        }
    }

    public void search() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(" Which person do you want to find?");

        String input = scanner.nextLine();
        boolean inHeroes = false;
        for (int i = 0; i < heroes.size(); i++) {
            if (heroes.get(i).getName().toLowerCase().contains(input.toLowerCase())) {
                inHeroes = true;
            }
        }
        boolean inVillains = false;
        for (int i = 0; i < villains.size(); i++) {
            if (villains.get(i).getName().toLowerCase().contains(input.toLowerCase())) {
                inVillains = true;
            }
        }
        boolean inFans = false;
        for (int i = 0; i < fans.size(); i++) {
            if (fans.get(i).getName().toLowerCase().contains(input.toLowerCase())) {
                inFans = true;
            }
        }
        if (inHeroes) {
            System.out.println("You can find " + input + " in Heroes");
        }
        if (inVillains) {
            System.out.println("You can find " + input + " in Villains");
        }
        if (inFans) {
            System.out.println("You can find " + input + " in  Fans");
        }
        if (super.stayInMenu()) {
            initiatePersonMenu();
        }
    }

    public static void updatePersonAfterFight(Hero heroToUpdate, Villain villainToUpdate) {
        for (int i = 0; i < heroes.size(); i++) {
            if (heroes.get(i).getID() == heroToUpdate.getID()) {
                heroes.set(i, heroToUpdate);
            }
        }
        for (int i = 0; i < villains.size(); i++) {
            if (villains.get(i).getID() == villainToUpdate.getID()) {
                villains.set(i, villainToUpdate);
            }
        }
    }

    public static void updateFanAfterFight(Fan fan) {
        for (int i = 0; i < fans.size(); i++) {
            if (fans.get(i).getID() == fan.getID()) {
                fans.set(i, fan);
            }
        }
    }

    public static ArrayList<Villain> getVillains() {
        return villains;
    }

    public static ArrayList<Hero> getHeroes() {
        return heroes;
    }
}




















