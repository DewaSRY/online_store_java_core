package org.sdewa.contextMapper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface ContextMapper {

    static Pattern pattern = Pattern.compile("^.*(\\.([A-Za-z])+)$");

    default String getClassName(Object className) {
        Matcher getmatcher = pattern.matcher(className.getClass().toString());
        boolean b = getmatcher.find();
        return getmatcher.group(1).replace(".", "");
    }


    public <T> void putService(Object service, T serviceObject);

    @SuppressWarnings("unchecked")
    public <T> T getService(Object service);
}