package org.sdewa.menues;

import org.sdewa.AppContext.Context;
import org.sdewa.AppContext.Menu;

public class SettingMenu implements Menu {


    private final Context context;

    public SettingMenu(Context context) {
        this.context = context;
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
