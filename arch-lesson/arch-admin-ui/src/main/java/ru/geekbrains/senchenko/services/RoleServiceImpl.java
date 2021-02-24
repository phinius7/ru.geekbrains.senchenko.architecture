package ru.geekbrains.senchenko.services;

import ru.geekbrains.senchenko.entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.senchenko.repositories.RoleRepository;
import ru.geekbrains.senchenko.services.onworks.RoleOnWork;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    private RoleOnWork roleOnWork = new RoleOnWork();
    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void save(Role role) throws IOException {
        roleRepository.save(role);

    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Optional<Role> findById(Integer id) {
        if (roleOnWork.getRole(id) != null) {
            return Optional.of(roleOnWork.getRole(id));
        }
        roleOnWork.addRole(roleRepository.findById(id).get());
        return roleRepository.findById(id);
    }

    @Override
    public void delete(Integer id) {
        roleRepository.deleteById(id);
    }
}
