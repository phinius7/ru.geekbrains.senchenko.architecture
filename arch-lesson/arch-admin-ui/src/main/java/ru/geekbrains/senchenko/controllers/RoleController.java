package ru.geekbrains.senchenko.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.senchenko.entities.Role;
import ru.geekbrains.senchenko.services.RoleService;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @GetMapping
    public String showRoleListForm(Model model) {
        List<Role> roles = roleService.findAll();
        model.addAttribute("roles", roles);
        return "roles";
    }

    @GetMapping("/add")
    public String showAddRoleForm(Model model) {
        model.addAttribute("new_role", new Role());
        return "add_role";
    }

    @PostMapping("/add")
    public String showAddRoleForm(@Valid @ModelAttribute Role role, BindingResult bindingResult) throws IOException {
        if (bindingResult.hasErrors()) {
            return "add_role";
        }
        roleService.save(role);
        return "redirect:/roles";
    }

    @GetMapping("/edit/{id}")
    public String showEditRoleForm(@PathVariable Integer id, Model model) {
        model.addAttribute("role", roleService.findById(id));
        return "edit_role";
    }

    @PostMapping("/edit")
    public String showEditRoleForm(@ModelAttribute Role role, BindingResult bindingResult) throws IOException {
        if (bindingResult.hasErrors()) {
            return "edit_role";
        }
        roleService.save(role);
        return "redirect:/roles";
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable Integer id) {
        roleService.delete(id);
        return "redirect:/roles";
    }
}
