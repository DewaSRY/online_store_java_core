package org.sdewa.menues;

import org.sdewa.AppContext.Context;
import org.sdewa.AppContext.Menu;

public class AuthMenu implements Menu {

    private Context context;

    
    @Override
    public void printMenu() {
        String menuOption = """
                Auth Menu :
                (0) Sing up menu
                (1) Sing in menu
                (2) Sing out menu
                (b) back""";
        System.out.println(menuOption);
    }

    @Override
    public void run() {
        String userInput = getUserInput("insert your input");
        runSelectedMenu(getInputIdx(userInput));
    }

    private void runSelectedMenu(int inputIdx) {
        switch (inputIdx) {
            case 0 -> {
                context.runtMenu(SignUpMenu.class);
            }
            case 1 -> {
                context.runtMenu(SignInMenu.class);
            }
            case 2 -> {
                context.runtMenu(SignOutMenu.class);
            }
            default -> {

            }
        }
    }
}
