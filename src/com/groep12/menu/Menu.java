package com.groep12.menu;

import java.util.Scanner;

public abstract class Menu {

    private String menuString;
    private String[] options;
    private final String headerName;


    public Menu(String headerName) {
        this.headerName = headerName;

    }

    private void displayMenuText() {
        System.out.println(menuString);
    }


    protected void backToMainMenu() {

    }

    protected void setOptions(String[] options) {
        this.options = options;
        this.menuString = generateMenuText();
    }


    protected int initiateInput() {
        displayMenuText();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter choice:");
            if (scanner.hasNextInt()) {
                int nr = scanner.nextInt();
                if (nr > 0 && nr <= options.length) {
                    return nr;
                }

            } else {
                StringBuilder inputOptions = new StringBuilder();
                for (int i = 0; i < options.length; i++) {
                    inputOptions.append(i + 1);
                    if (i < options.length - 1) {
                        inputOptions.append(", ");
                    }
                }
                System.out.println("Please enter a valid choice (" + inputOptions + ")");
                initiateInput();
            }
        }
    }

    protected String generateMenuText() {
        StringBuilder menuStringBuilder = new StringBuilder();
        String header = "|" + headerName + "|";

        //.repeat() was a java 11 function. Back to ye olde loop it is
        for(int i = 0; i < headerName.length() + 2;  i++){
            menuStringBuilder.append("-");
        }

        menuStringBuilder.append("\n");
        menuStringBuilder.append(header);
        menuStringBuilder.append("\n");

        for(int i = 0; i < headerName.length() + 2;  i++){
            menuStringBuilder.append("-");
        }

        menuStringBuilder.append("\n");
        menuStringBuilder.append("OPTIONS:\n");
        for (int i = 0; i < options.length; i++) {
            menuStringBuilder.append(i + 1).append(" : ").append(options[i]).append("\n");
        }
        return String.valueOf(menuStringBuilder);
    }

    protected boolean stayInMenu() {
        System.out.println("Do you want to stay in the " + headerName + "?\n y/n");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("y")) {
                return true;
            } else if (input.equalsIgnoreCase("n")) {
                backToMainMenu();
                return false;
            } else {
                System.out.println("Please enter a valid option (y/n)");
            }
        }
    }
}
