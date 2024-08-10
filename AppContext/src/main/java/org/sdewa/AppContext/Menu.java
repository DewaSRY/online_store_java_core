package org.sdewa.AppContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface Menu {
    static Pattern numberPattern = Pattern.compile("[\\d]");

    void printMenu();

    void run();

    default String getUserInput(String message) {
        var sc = new Scanner(System.in);
        System.out.printf("%s : ", message);
        return sc.next();
    }


    default List<Integer> getInputIndexList(String userInput) {
        List<Integer> userInputList = new ArrayList<>();
        Matcher userInputMatcher = numberPattern.matcher(userInput);
        while (userInputMatcher.find()) {
            userInputList.add(Integer.parseInt(userInputMatcher.group()));
        }
        return userInputList;
    }

    default int getInputIdx(String userInput) {
        Matcher userInputMatcher = numberPattern.matcher(userInput);
        while (userInputMatcher.find()) {
            return Integer.parseInt(userInputMatcher.group());
        }
        return -1;
    }
}
