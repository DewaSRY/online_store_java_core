package org.sdewa.AppContext;


public interface Menu {

    String printMenu();

    default String printMenu(String menuName) {
        return "%s%s%s".formatted(
                "*".repeat(15),
                menuName,
                "*".repeat(15));
    }

    /**
     * runSelectedMenu with String parameter use to make conditional operation
     * base on the parameter
     */
    boolean runSelectedMenu(String userInput);

    /**
     * runSelectedMenu without parameter use to expression
     * to decide is the menu still running or not
     */
    boolean runSelectedMenu();
}
