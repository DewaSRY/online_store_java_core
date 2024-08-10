package org.sdewa.menues;

import com.sun.source.tree.BreakTree;
import org.sdewa.AppContext.Context;
import org.sdewa.AppContext.Menu;

public class MainMenu implements Menu {
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
                context.runMenu(AuthMenu.class);
                isStop = false;
            }
            case 1 -> {
                context.runMenu(CheckoutMenu.class);
                isStop = false;
            }
            case 2 -> {
                context.runMenu(CustomerListMenu.class);
                isStop = false;
            }
            case 3 -> {
                context.runMenu(MyOrderMenu.class);
                isStop = false;
            }
            case 4 -> {
                context.runMenu(ProductCatalogMenu.class);
                isStop = false;
            }
            case 5 -> {
                context.runMenu(SettingMenu.class);
                isStop = false;
            }
            default -> {
                System.out.println("by by");

            }
        }
        return isStop;
    }
}
