package ru.geekbrains.senchenko.services.onworks;

import ru.geekbrains.senchenko.entities.ClientCard;

import java.util.HashMap;
import java.util.Map;

public class ClientCardOnWork {

    private static final Map<Integer, ClientCard> clientCardMap = new HashMap<>();

    public void addClientCard(ClientCard card) {
        clientCardMap.put(card.getId(), card);
    }

    public ClientCard getClientCard(Integer id) {
        return clientCardMap.get(id);
    }
}
