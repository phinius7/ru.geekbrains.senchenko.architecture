package ru.geekbrains.senchenko.services.memento;

import ru.geekbrains.senchenko.entities.ClientCard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class MementoClientCard {

    private static MementoClientCard instance;

    private MementoClientCard() {
    }

    public static MementoClientCard getInstance() {
        if (instance == null) {
            instance = new MementoClientCard();
        }
        return instance;
    }

    private static final Map<Integer, ArrayList<ClientCard>> state = new HashMap<>();

    public ClientCard getState(Integer id) {
        ArrayList<ClientCard> bufList = state.get(id);
        return bufList.get(bufList.size() - 1);
    }

    public void setState(ClientCard clientCard) {
        Objects.requireNonNull(state.put(clientCard.getId(), state.get(clientCard.getId()))).add(clientCard);
    }
}
