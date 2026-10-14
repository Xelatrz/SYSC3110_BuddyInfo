package org.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddressBookController {

    private final AddressBookRepository addressBookRepository;

    public AddressBookController(AddressBookRepository addressBookRepository) {
        this.addressBookRepository = addressBookRepository;
    }

    @GetMapping("/addressbook")
    public String addressBook(@RequestParam(name="id") Long id, Model model) {
        AddressBook addressBook = addressBookRepository.findById(id).orElse(null);
        model.addAttribute("addressBookId", id);
        model.addAttribute("buddies", addressBook.getBuddyList());
        return "addressbook";
    }
}