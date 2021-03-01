package ru.geekbrains.senchenko.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.senchenko.entities.User;
import ru.geekbrains.senchenko.repositories.UserRepository;
import ru.geekbrains.senchenko.services.onworks.UserOnWork;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private UserOnWork userOnWork = new UserOnWork();
    private final UserRepository userRepository;

    @Override
    public void save(User user) throws IOException {
        userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Integer id) {
        if (userOnWork.getUser(id) != null) {
            return Optional.of(userOnWork.getUser(id));
        }
        userOnWork.addUser(userRepository.findById(id).get());
        return userRepository.findById(id);
    }

    @Override
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }
}
