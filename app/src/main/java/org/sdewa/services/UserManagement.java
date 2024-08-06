package org.sdewa.services;


import org.sdewa.entities.User;

import java.util.List;

public interface UserManagement {

    String registerUser(User user);

    List<User> getUsers();

    User getUserByEmail(String userEmail);
}
