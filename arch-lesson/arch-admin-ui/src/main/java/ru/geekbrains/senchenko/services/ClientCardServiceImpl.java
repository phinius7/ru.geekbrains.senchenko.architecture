package ru.geekbrains.senchenko.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.senchenko.entities.ClientCard;
import ru.geekbrains.senchenko.repositories.ClientCardRepository;
import ru.geekbrains.senchenko.services.onworks.ClientCardOnWork;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientCardServiceImpl implements ClientCardService {

    private ClientCardOnWork cardOnWork = new ClientCardOnWork();
    private final ClientCardRepository clientCardRepository;

    @Override
    public void save(ClientCard cCard) throws IOException {
        clientCardRepository.save(cCard);
    }

    @Override
    public List<ClientCard> findAll() {
        return clientCardRepository.findAll();
    }

    @Override
    public Optional<ClientCard> findById(Integer id) {
        if (cardOnWork.getClientCard(id) != null) {
            return Optional.of(cardOnWork.getClientCard(id));
        }
        cardOnWork.addClientCard(clientCardRepository.findById(id).get());
        return clientCardRepository.findById(id);
    }

    @Override
    public void delete(Integer id) {
        clientCardRepository.deleteById(id);
    }

    //TODO реализовать логику отмены
    public void undo(ClientCard clientCard) throws IOException {

    }

    //TODO реализовать логику повтора
    public void redo(ClientCard clientCard) throws IOException {

    }
}
