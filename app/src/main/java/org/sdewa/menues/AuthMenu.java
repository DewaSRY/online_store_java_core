package org.sdewa.menues;

import org.sdewa.AppContext.Context;
import org.sdewa.AppContext.Menu;
import org.sdewa.services.AuthManagement;
import org.sdewa.services.UserManagement;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AuthMenu implements Menu {

    private final Context context;
    private final AuthManagement authManagement;
    private final UserManagement userManagement;

    public AuthMenu(Context context, AuthManagement authManagement, UserManagement userManagement) {
        this.context = context;
        this.authManagement = authManagement;
        this.userManagement = userManagement;
    }

    @Override
    public void printMenu() {
        String menuOption = """
                Auth Menu :
                (0) Sing up menu
                (1) Sing in menu
                (2) Sing out menu
                (b) back""";
    }

    @Override
    public void run() {
        String userInput = getUserInput("insert your input ");
        var scUserInput = new Scanner(userInput);
        var findUserInput = scUserInput.findAll(Pattern.compile("[\\d]")).findFirst();
        findUserInput.ifPresent((input) -> {
            runSelectedMenu(Integer.parseInt(input.group()));
        });


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
