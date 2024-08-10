package org.sdewa.AppContext;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface ContextMapper<U> {

    static Pattern pattern = Pattern.compile("^.*(\\.([A-Za-z])+)$");


    default String parseClassName(Class<?> className) {
        Matcher getmatcher = pattern.matcher(className.toString());
        boolean b = getmatcher.find();
        return getmatcher.group(1).replace(".", "");
    }

    public <T extends U> void storeObject(Class<? extends U> objectClass, T object);

    public Optional<U> geObject(Class<? extends U> objectClass);
}
