package ru.geekbrains.senchenko.services.onworks;

import ru.geekbrains.senchenko.entities.Role;

import java.util.HashMap;
import java.util.Map;

public class RoleOnWork {

    private static final Map<Integer, Role> roleMap = new HashMap<>();

    public void addRole(Role role) {
        roleMap.put(role.getId(), role);
    }

    public Role getRole(Integer id) {
        return roleMap.get(id);
    }
}
