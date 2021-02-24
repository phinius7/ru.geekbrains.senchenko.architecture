package ru.geekbrains.senchenko.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.senchenko.entities.ClientCard;
import ru.geekbrains.senchenko.services.ClientCardServiceImpl;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientCardController {

    private final ClientCardServiceImpl clientCardService;

    @GetMapping
    public String showClientCardListForm(Model model) {
        List<ClientCard> clients = clientCardService.findAll();
        model.addAttribute("clients", clients);
        return "clients";
    }

    @GetMapping("/add")
    public String showAddClientCardForm(Model model) {
        model.addAttribute("new_client", new ClientCard());
        return "add_client";
    }

    @PostMapping("/add")
    public String showAddClientCardForm(@Valid @ModelAttribute ClientCard client, BindingResult bindingResult) throws IOException {
        if (bindingResult.hasErrors()) {
            return "add_client";
        }
        clientCardService.save(client);
        return "redirect:/clients";
    }

    @GetMapping("/edit/{id}")
    public String showEditClientCardForm(@PathVariable Integer id, Model model) {
        model.addAttribute("client", clientCardService.findById(id));
        return "edit_client";
    }

    @PostMapping("/edit")
    public String showEditClientCardForm(@ModelAttribute ClientCard client, BindingResult bindingResult) throws IOException {
        if (bindingResult.hasErrors()) {
            return "edit_client";
        }
        clientCardService.save(client);
        return "redirect:/clients";
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable Integer id) {
        clientCardService.delete(id);
        return "redirect:/clients";
    }

    @GetMapping("/undo/{id}")
    public String undo(@PathVariable Integer id) throws IOException {
        if (clientCardService.findById(id).isPresent()) {
            clientCardService.undo(clientCardService.findById(id).get());
        }
        return "redirect:/clients";
    }

    @GetMapping("/redo/{id}")
    public String redo(@PathVariable Integer id) throws IOException {
        if (clientCardService.findById(id).isPresent()) {
            clientCardService.redo(clientCardService.findById(id).get());
        }
        return "redirect:/clients";
    }
}
