package org.sdewa.services.impl;

import org.sdewa.AppContext.Services;
import org.sdewa.entities.User;
import org.sdewa.services.AuthManagement;


public class AuthManagementServices implements AuthManagement, Services {
    private User currentUser;

    @Override
    public void setCurrentUser(User user) {
        currentUser = user;

    }

    @Override
    public User getCurrentLoginUser() {
        return currentUser;
    }

    @Override
    public void removeCurrentLoginUser() {
        currentUser = null;
    }
}
