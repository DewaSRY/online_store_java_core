package org.sdewa.AppContext;


public interface Context {
    public <T extends Services> void putServices(T service);

    public Services getService(Class<? extends Services> service);

    public void putMenu(MenuGetter menuGetter);

    public void runMenu(Class<? extends Menu> menu);
}


