package org.sdewa.menues;

import org.sdewa.AppContext.Context;
import org.sdewa.AppContext.Menu;

public class AuthMenu implements Menu {

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
    public void run() {
        String userInput = getUserInput("insert your input");
        runSelectedMenu(getInputIdx(userInput));
    }

    private void runSelectedMenu(int inputIdx) {
        switch (inputIdx) {
            case 0 -> context.runMenu(SignUpMenu.class);
            case 1 -> context.runMenu(SignInMenu.class);
            case 2 -> context.runMenu(SignOutMenu.class);
            default -> {
            }
        }
    }
}
