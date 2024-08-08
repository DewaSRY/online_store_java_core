package org.sdewa.contextMapper;

import org.sdewa.AppContext.Services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface ContextMapper<U> {

    static Pattern pattern = Pattern.compile("^.*(\\.([A-Za-z])+)$");

//    default String getClassName(Object className) {
//        return parseClassName(className.getClass());
//    }

    default String parseClassName(Class<?> className) {
        Matcher getmatcher = pattern.matcher(className.toString());
        boolean b = getmatcher.find();
        return getmatcher.group(1).replace(".", "");
    }

    public <T extends U> void putService(Class<? extends U> objectName, T object);

    public U getService(Class<? extends U> service);
}