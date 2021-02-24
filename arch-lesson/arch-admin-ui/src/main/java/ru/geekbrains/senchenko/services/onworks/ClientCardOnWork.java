package ru.geekbrains.senchenko.services.onworks;

import ru.geekbrains.senchenko.entities.ClientCard;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ClientCardOnWork {

    private static final Map<Integer, ClientCard> clientCardMap = new ConcurrentHashMap<>();

    public void addClientCard(ClientCard card) {
        clientCardMap.put(card.getId(), card);
    }

    public ClientCard getClientCard(Integer id) {
        return clientCardMap.get(id);
    }
}
