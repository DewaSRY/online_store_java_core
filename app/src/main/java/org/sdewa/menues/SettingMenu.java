package org.sdewa.menues;

import com.sun.source.tree.BreakTree;
import org.sdewa.AppContext.Context;
import org.sdewa.AppContext.Menu;
import org.sdewa.AppContext.MenuInteractive;

public class SettingMenu implements Menu, MenuInteractive {


    private final Context context;

    public SettingMenu(Context context) {
        this.context = context;
    }

    @Override
    public String printMenu() {
        return """
                Setting Option
                (0) Change email menu
                (1) Change Password menu
                (b) Back""";
    }

    @Override
    public boolean runSelectedMenu(String userInput) {
        try {
            int indexUserInput = Integer.parseInt(userInput);
            return switch (indexUserInput) {
                case 0 -> !selectMenuOption(ChangeEmailMenu.class, context);
                case 1 -> !selectMenuOption(ChangePasswordMenu.class, context);
                default -> !selectMenuOption("Please selected correct input");
            };
        } catch (Exception e) {
            return true;
        }
    }

    @Override
    public boolean runSelectedMenu() {
        var userInput = getUserInput("insert your input (B)");
        return runSelectedMenu(userInput);
    }

}
