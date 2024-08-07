package org.sdewa.services;

import org.sdewa.entities.User;

public interface AuthManagement {

    void setCurrentUser(User user);

    User getCurrentLoginUser();

    void removeCurrentLoginUser();

}
