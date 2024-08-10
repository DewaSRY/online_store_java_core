package org.sdewa.AppContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface MenuInteractive {
    static Pattern numberPattern = Pattern.compile("[\\d]");

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

    /**
     * getInputIdx use to get index insert by user.
     * it's only return integer in string format
     */
    default String getInputIdx(String userInput) {
        Matcher userInputMatcher = numberPattern.matcher(userInput);
        while (userInputMatcher.find()) {
            return userInputMatcher.group();
        }
        return "-1";
    }

    default boolean selectMenuOption(Class<? extends Menu> menu, Context context) {
        context.runMenu(menu);
        return true;
    }

    default boolean selectMenuOption(String message) {
        System.out.printf("%s%s%s",
                "+".repeat(15), message, "+".repeat(15));
        return false;
    }

}
