package com.groep12.menu;

public class MainMenu extends Menu {
    GadgetMenu gadgetMenu = new GadgetMenu();
    PersonMenu personMenu = new PersonMenu();
    FightMenu fightMenu = new FightMenu();


    public MainMenu() {
        super("MAIN MENU");
        String[] options = {"Heroes and villains", "Gadgets", "Fights", "Exit"};
        super.setOptions(options);
    }

    public void initiateMainMenu() {
        optionHandling(super.initiateInput());
    }

    public void optionHandling(int choice) {
        switch (choice) {
            case 1:
                openHeroesAndVillainsMenu();
                break;
            case 2:
                openGadgetsMenu();
                break;
            case 3:
                openFightsMenu();
                break;
            default:
                break;
        }
    }

    public void openHeroesAndVillainsMenu() {
        this.personMenu.initiatePersonMenu();
        optionHandling(super.initiateInput());
    }

    public void openGadgetsMenu() {
        this.gadgetMenu.initializeMenu();
        optionHandling(super.initiateInput());
    }

    public void openFightsMenu() {
        this.fightMenu.initiateFightMenu();
        optionHandling(super.initiateInput());
    }
}
