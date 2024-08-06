package org.sdewa.AppContext;

import java.util.Scanner;

public interface Menu {

    void printMenu();

    void run();

    default String getUserInput(String message) {
        try (var sc = new Scanner(System.in)) {
            System.out.printf("%s : ", message);
            return sc.next();
        }
    }

}
