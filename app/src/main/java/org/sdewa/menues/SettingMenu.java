package org.sdewa.menues;

import org.sdewa.AppContext.Context;
import org.sdewa.AppContext.Menu;
import org.sdewa.services.AuthManagement;

public class SettingMenu implements Menu {


    private final Context context;
    private final AuthManagement authManagement;

    public SettingMenu(Context context, AuthManagement authManagement) {
        this.context = context;
        this.authManagement = authManagement;
    }

    @Override
    public void printMenu() {
        String SettingOption = """
                Setting Option
                (0) Change email menu
                (1) Change Password menu
                (b) Back""";
        System.out.println(SettingOption);
    }

    @Override
    public void run() {
        String userInput = getUserInput("insert your input");
        runSelectedMenu(getInputIdx(userInput));
    }

    private void runSelectedMenu(int userInput) {
        switch (userInput) {
            case 0 -> {
                context.runtMenu(ChangeEmailMenu.class);
            }
            case 1 -> {
                context.runtMenu(ChangePasswordMenu.class);
            }
            default -> {

            }
        }
    }
}
