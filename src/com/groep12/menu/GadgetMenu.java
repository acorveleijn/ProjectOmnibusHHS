package com.groep12.menu;
import com.groep12.gadget.Base;
import com.groep12.gadget.Gadget;
import com.groep12.gadget.Vehicle;
import com.groep12.gadget.Weapon;
import java.util.ArrayList;
import java.util.Scanner;

public class GadgetMenu extends Menu{
    private static final ArrayList<Gadget> gadgets = new ArrayList<>();

    public void initializeMenu(){
        choiceHandling(super.initiateInput());
    }

    public GadgetMenu() {
        super("GADGET MENU");
        String[] options = {"List of gadgets","Search","Exit","Detailed list of gadgets"};
        super.setOptions(options);
        provisionGadget();
    }

    private void provisionGadget() {
        gadgets.add(new Weapon("Boomerang", "A rang with boom", 10));
        gadgets.add(new Weapon("Massive turd", "A smelly turd, it's size is quite impressive.", 10));
        gadgets.add(new Weapon("50 cal", "Sniper with 50 caliber bullets", 10));
        gadgets.add(new Vehicle("Porsche 911", "A car with a lot pep in it's step", 120, 2));
        gadgets.add(new Vehicle("Tandem", "A bicycle of which it's origins are unknown", 120, 2));
        gadgets.add(new Vehicle("F16", "A world renown fighter jet", 120, 2));
        gadgets.add(new Base("Waterfallcave", "A surprisingly well hidden cave behind a waterfall", "Cave city"));
        gadgets.add(new Base("Treehouse", "A house in a tree", "Treeville"));
        gadgets.add(new Base("Harries dreamy roomy", "whoosh", "Hogwarts"));
        gadgets.add(new Base("HHS Warehouse", "Not really sure who gave permission for this", "The Hague"));
    }

    private void showGadgets(){
        for(Gadget gadget : gadgets) {
                System.out.println("ID: " + gadget.getID() + "\r\n" + "Name: " +
                        gadget.getName() + "\r\n" + "Description: " + gadget.getDescription() +
                            "\r\n" + "Type: " + gadget.getClass().getSimpleName() + "\r\n");
        }
        if(super.stayInMenu()) {
            initializeMenu();
        }
    }

    private void showGadgetsDetails(){
        for(Gadget gadget : gadgets) {
            if (gadget instanceof Weapon) {
                ((Weapon) gadget).showDetails();
            } else if (gadget instanceof Base) {
                ((Base) gadget).showDetails();
            } else if (gadget instanceof Vehicle) {
                ((Vehicle) gadget).showDetails();
            }
        }
        if(super.stayInMenu()) {
            initializeMenu();
        }
    }

    private void choiceHandling(int choice){
        switch (choice) {
            case 1:
                System.out.println("- List of gadgets -");
                showGadgets();
                break;
            case 2:
                System.out.println("- Search menu -");
                System.out.println("Please enter a Gadget name to search for:");
                Scanner searchInput = new Scanner(System.in);
                String searchTerm = searchInput.nextLine();
                search(searchTerm);
                break;
            case 3:
                System.out.println("Returning user to main menu");
                break;
            case 4:
                System.out.println("- Details menu -" + "\r\n");
                showGadgetsDetails();
        }
    }

    public static ArrayList<Gadget> getGadgets(){
        return gadgets;
    }

    private void search(String toSearch) {

        for(Gadget gadget : gadgets) {
            String baseText = "ID: " + gadget.getID() + "\r\n" + "Name: " +
                    gadget.getName() + "\r\n" + "Description: " + gadget.getDescription() + "\r\n" +
                    "Type: " + gadget.getClass().getSimpleName();
            if (gadget.getName().toLowerCase().contains(toSearch.toLowerCase()) && gadget instanceof Weapon) {
                System.out.println(baseText + "\r\n" + "PowerLevel: " + ((Weapon) gadget).getPowerLevel() + "\r\n");
            } else if (gadget.getName().toLowerCase().contains(toSearch.toLowerCase()) && gadget instanceof Base) {
                System.out.println(baseText + "\r\n" + "Location: " + ((Base) gadget).getLocation() + "\r\n");
            } else if (gadget.getName().toLowerCase().contains(toSearch.toLowerCase()) && gadget instanceof Vehicle) {
                System.out.println(baseText + "\r\n" + "MaxSpeed: " +
                        ((Vehicle) gadget).getMaxSpeed() + " km/h" + "\r\n" + "Capacity: " + ((Vehicle) gadget).getCapacity() + "\r\n");
            }
        }
        if(super.stayInMenu()){
            initializeMenu();
        }
    }
}
