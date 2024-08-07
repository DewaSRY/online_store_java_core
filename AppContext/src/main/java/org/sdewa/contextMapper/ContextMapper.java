package org.sdewa.contextMapper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface ContextMapper {

    static Pattern pattern = Pattern.compile("^.*(\\.([A-Za-z])+)$");

    default String getClassName(Object className) {
        return parseClassName(className.getClass());
    }

    default String parseClassName(Object className) {
        Matcher getmatcher = pattern.matcher(className.toString());
        boolean b = getmatcher.find();
        return getmatcher.group(1).replace(".", "");
    }

    public <T> void putService(Object service, T serviceObject);

    public <T> T getService(Object service);
}