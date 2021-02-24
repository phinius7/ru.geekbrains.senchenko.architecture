package ru.geekbrains.senchenko.services.onworks;

import ru.geekbrains.senchenko.entities.Role;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RoleOnWork {

    private static final Map<Integer, Role> roleMap = new ConcurrentHashMap<>();

    public void addRole(Role role) {
        roleMap.put(role.getId(), role);
    }

    public Role getRole(Integer id) {
        return roleMap.get(id);
    }
}
