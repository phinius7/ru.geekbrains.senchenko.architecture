package ru.geekbrains.senchenko.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.senchenko.entities.User;
import ru.geekbrains.senchenko.services.RoleService;
import ru.geekbrains.senchenko.services.UserService;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping
    public String showUserListForm(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/add")
    public String showAddUserForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("roles", roleService.findAll());
        return "add_user";
    }

    @PostMapping("/add")
    public String showAddUserForm(@Valid @ModelAttribute User user, BindingResult bindingResult) throws IOException {
        if (bindingResult.hasErrors()) {
            return "add_user";
        }
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String showEditUserForm(@PathVariable Integer id, Model model) {
        model.addAttribute("user", userService.findById(id).get());
        model.addAttribute("roles", roleService.findAll());
        return "edit_user";
    }

    @PostMapping("/edit")
    public String showEditUserForm(@Valid @ModelAttribute User user, BindingResult bindingResult) throws IOException {
        if (bindingResult.hasErrors()) {
            return "edit_user";
        }
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable Integer id) {
        userService.delete(id);
        return "redirect:/roles";
    }
}
