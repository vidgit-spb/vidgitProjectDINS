package com.example.vidgitProjectDins;

import com.example.vidgitProjectDins.service.BookOwnersService;
import com.example.vidgitProjectDins.service.FileService;
import com.example.vidgitProjectDins.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class RootController {

    @Autowired
    private FileService fs;
    @Autowired
    private BookOwnersService bs;
    private int idOwner;
    private String number;
    private String nameNote;

    // В этом методе мы заполняем данными коллекции
    @GetMapping("/initialization")
    public String initialization(@RequestParam(name = "path") String name, Model model) {
        bs.createUser("Vidgit");
        bs.createUser("Alex");
        bs.createUser("Paraboloid");
        fs.createPhonebookUser(1, "123", "Masha");
        fs.createPhonebookUser(1, "1111111", "Dasha");
        fs.createPhonebookUser(1, "2222222", "Nastya");
        fs.createPhonebookUser(2, "123123123", "Roman");
        fs.createPhonebookUser(2, "895416782", "Vitya");
        fs.createPhonebookUser(3, "3333333", "Artem");

        model.addAttribute("book", bs.getAllOwners());

        return "main";
    }

    @GetMapping("/GetAllUsers")
    public HashMap getAllUsers() {
        return fs.getAllNotes();

    }

    @GetMapping("/GetUserById")
    public String getUserById(@RequestParam(name = "id", required = true) int id, Model model) {
        return bs.getUserById(id);
    }

    @GetMapping("/GetNoteById")
    public NoteService getNoteById(@RequestParam(name = "id", required = true) int id, Model model) {

        return fs.getNoteById(id);
    }

    @DeleteMapping("/DeleteUserById")
    public void removeUserById(@RequestParam(name = "id", required = true) int id, Model model) {
        bs.removeUserById(id);
    }

    @DeleteMapping("/DeleteNoteById")
    public void removeNoteById(@RequestParam(name = "id", required = true) int id, Model model) {
        fs.removeNoteById(id);
    }

    @GetMapping("/findByNumber")
    public void findByNumber(@RequestParam(name = "number", required = true) String number, Model model) {
        fs.findByNumber(number);
    }

    @GetMapping("/findUserByName")
    public void findUserByName(@RequestParam(name = "name", required = true) String name, Model model) {
        bs.findUserByName(name);
    }

    @PostMapping("/createPhonebookUser")
    public void createPhonebookUser(@RequestParam(name = "idOwner") int idOwner,
                                    @RequestParam(name = "number") String number,
                                    @RequestParam(name = "nameNote") String nameNote) {
        fs.createPhonebookUser(idOwner, number, nameNote);
    }

    @PutMapping("/editNotebyId")
    public void editNotebyId(@RequestParam(name = "id") int id,
                             @RequestParam(name = "newNumber") String newNumber,
                             @RequestParam(name = "newNote") String newNote) {
        fs.editNotebyId(id, newNumber, newNote);
    }

    @PutMapping("/editUser")
    public void editUser(@RequestParam(name = "id") int id,
                         @RequestParam(name = "newName") String newName) {
        bs.editUser(id, newName);
    }

    @GetMapping("/getAllNotes")
    public HashMap getAllNotes() {
        return fs.getAllNotes();
    }

}