package org.sdewa.menues;

import com.sun.source.tree.BreakTree;
import org.sdewa.AppContext.Context;
import org.sdewa.AppContext.Menu;

public class SettingMenu implements Menu {


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
    public void run() {
        String userInput = getUserInput("insert your input");
        runSelectedMenu(getInputIdx(userInput));
    }

    private void runSelectedMenu(int userInput) {
        switch (userInput) {
            case 0 -> {
                context.runMenu(ChangeEmailMenu.class);
            }
            case 1 -> {
                context.runMenu(ChangePasswordMenu.class);
            }
            default -> {

            }
        }
    }
}
