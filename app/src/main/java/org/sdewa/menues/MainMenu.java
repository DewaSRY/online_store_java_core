package org.sdewa.menues;

import com.sun.source.tree.BreakTree;
import org.sdewa.AppContext.Context;
import org.sdewa.AppContext.Menu;
import org.sdewa.AppContext.MenuInteractive;

import java.sql.Struct;

public class MainMenu implements Menu, MenuInteractive {
    private final Context context;

    public MainMenu(Context context) {
        this.context = context;
    }


    @Override
    public String printMenu() {
        return """
                (0) Auth Menu
                (1) Checkout Menu
                (2) Customer List Menu
                (3) My order Menu
                (4) Product Catalog Menu
                (5) Setting Catalog Menu
                (b) close""";
    }

    @Override
    public boolean runSelectedMenu(String userInput) {
        try {
            return switch (Integer.parseInt(userInput)) {
                case 0 -> selectMenuOption(AuthMenu.class, context);
                case 1 -> selectMenuOption(CheckoutMenu.class, context);
                case 2 -> selectMenuOption(CustomerListMenu.class, context);
                case 3 -> selectMenuOption(MyOrderMenu.class, context);
                case 4 -> selectMenuOption(ProductCatalogMenu.class, context);
                case 5 -> selectMenuOption(SettingMenu.class, context);
                default -> selectMenuOption("by by");
            };
        } catch (Exception e) {
            selectMenuOption("by by");
            return false;
        }
    }


    @Override
    public boolean runSelectedMenu() {
        String userInput = getUserInput("Insert your input");
        return runSelectedMenu(userInput);
    }
}
