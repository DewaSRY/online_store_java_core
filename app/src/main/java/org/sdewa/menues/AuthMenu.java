package org.sdewa.menues;

import org.sdewa.AppContext.Context;
import org.sdewa.AppContext.Menu;
import org.sdewa.AppContext.MenuInteractive;

public class AuthMenu implements Menu, MenuInteractive {

    private final Context context;

    public AuthMenu(Context context) {
        this.context = context;
    }

    @Override
    public String printMenu() {
        return """
                Auth Menu :
                (0) Sing up menu
                (1) Sing in menu
                (2) Sing out menu
                (b) back""";
    }


    @Override
    public boolean runSelectedMenu(String userInput) {
        switch (Integer.parseInt(userInput)) {
            case 0 -> context.runMenu(SignUpMenu.class);
            case 1 -> context.runMenu(SignInMenu.class);
            case 2 -> context.runMenu(SignOutMenu.class);
            default -> {
            }
        }
        return false;
    }

    @Override
    public boolean runSelectedMenu() {
        String userInput = getUserInput("insert your input");
        return runSelectedMenu(getInputIdx(userInput));
    }


}
