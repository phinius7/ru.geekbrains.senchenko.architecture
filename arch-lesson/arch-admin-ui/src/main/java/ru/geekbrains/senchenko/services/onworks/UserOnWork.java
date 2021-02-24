package ru.geekbrains.senchenko.services.onworks;

import ru.geekbrains.senchenko.entities.User;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserOnWork {

    private static final Map<Integer, User> userMap = new ConcurrentHashMap<>();

    public void addUser(User user) {
        userMap.put(user.getId(), user);
    }

    public User getUser(Integer id) {
        return userMap.get(id);
    }
}
