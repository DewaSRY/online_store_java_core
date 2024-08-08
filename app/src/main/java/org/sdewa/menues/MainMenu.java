package org.sdewa.menues;

import com.sun.source.tree.BreakTree;
import org.sdewa.AppContext.Context;
import org.sdewa.AppContext.Menu;

public class MainMenu implements Menu {
    private Context context;


    @Override
    public void printMenu() {
        String menuOption = """
                (0) Auth Menu
                (1) Checkout Menu
                (2) Customer List Menu
                (3) My order Menu
                (4) Product Catalog Menu
                (5) Setting Catalog Menu
                (b) close""";
        System.out.println(menuOption);
    }

    @Override
    public void run() {
        while (true) {
            String userInput = getUserInput("Insert your input");
            if (runSelectedMenu(getInputIdx(userInput))) {
                break;
            } else {
                printMenu();
            }
        }

    }

    private boolean runSelectedMenu(int userInput) {
        boolean isStop = true;
        switch (userInput) {
            case 0 -> {
                context.runtMenu(AuthMenu.class);
                isStop = false;
            }
            case 1 -> {
                context.runtMenu(CheckoutMenu.class);
                isStop = false;
            }
            case 2 -> {
                context.runtMenu(CustomerListMenu.class);
                isStop = false;
            }
            case 3 -> {
                context.runtMenu(MyOrderMenu.class);
                isStop = false;
            }
            case 4 -> {
                context.runtMenu(ProductCatalogMenu.class);
                isStop = false;
            }
            case 5 -> {
                context.runtMenu(SettingMenu.class);
                isStop = false;
            }
            default -> {
                System.out.println("by by");
            }
        }
        return isStop;
    }
}
