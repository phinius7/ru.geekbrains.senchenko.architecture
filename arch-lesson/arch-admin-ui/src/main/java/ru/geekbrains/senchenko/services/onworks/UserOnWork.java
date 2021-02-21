package ru.geekbrains.senchenko.services.onworks;

import ru.geekbrains.senchenko.entities.User;

import java.util.HashMap;
import java.util.Map;

public class UserOnWork {

    private static final Map<Integer, User> userMap = new HashMap<>();

    public void addUser(User user) {
        userMap.put(user.getId(), user);
    }

    public User getUser(Integer id) {
        return userMap.get(id);
    }
}
