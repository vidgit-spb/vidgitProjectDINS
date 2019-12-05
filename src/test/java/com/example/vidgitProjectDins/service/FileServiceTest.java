package com.example.vidgitProjectDins.service;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.util.HashMap;

public class FileServiceTest {


    @Test
    public void createPhonebookUser() {
        BookOwnersService bs = new BookOwnersService();
        FileService fs = new FileService();
        bs.createUser("Vidgit");
        bs.createUser("Alex");
        bs.createUser("Paraboloid");
        fs.createPhonebookUser(1, "123", "Masha");
        fs.createPhonebookUser(1, "1111111", "Dasha");
        fs.createPhonebookUser(1, "2222222", "Nastya");
        fs.createPhonebookUser(2, "123123123", "Roman");
        fs.createPhonebookUser(2, "895416782", "Vitya");
        fs.createPhonebookUser(3, "3333333", "Artem");
        Assertions.assertEquals(1, fs.getNoteById(1).idOfThisNote);
        Assertions.assertEquals("Masha", fs.getNoteById(1).getNameNote());
        Assertions.assertEquals("123", fs.getNoteById(1).getNumber());
    }

    @Test
    public void getNoteById() {
        BookOwnersService bs = new BookOwnersService();
        FileService fs = new FileService();
        bs.createUser("Vidgit");
        bs.createUser("Alex");
        bs.createUser("Paraboloid");
        fs.createPhonebookUser(1, "123", "Masha");
        fs.createPhonebookUser(1, "1111111", "Dasha");
        fs.createPhonebookUser(1, "2222222", "Nastya");
        fs.createPhonebookUser(2, "123123123", "Roman");
        fs.createPhonebookUser(2, "895416782", "Vitya");
        fs.createPhonebookUser(3, "3333333", "Artem");
        Assertions.assertEquals(1, fs.getNoteById(1).idOfThisNote);
        Assertions.assertEquals("Masha", fs.getNoteById(1).getNameNote());
        Assertions.assertEquals("123", fs.getNoteById(1).getNumber());
    }

    @Test
    public void editNotebyId() {
        BookOwnersService bs = new BookOwnersService();
        FileService fs = new FileService();
        bs.createUser("Vidgit");
        bs.createUser("Alex");
        bs.createUser("Paraboloid");
        fs.createPhonebookUser(1, "123", "Masha");
        fs.createPhonebookUser(1, "1111111", "Dasha");
        fs.createPhonebookUser(1, "2222222", "Nastya");
        fs.createPhonebookUser(2, "123123123", "Roman");
        fs.createPhonebookUser(2, "895416782", "Vitya");
        fs.createPhonebookUser(3, "3333333", "Artem");
        fs.editNotebyId(1, "1111", "Misha");
        Assertions.assertEquals(1, fs.getNoteById(1).idOfThisNote);
        Assertions.assertEquals("Misha", fs.getNoteById(1).getNameNote());
        Assertions.assertEquals("1111", fs.getNoteById(1).getNumber());

    }

    @Test
    public void removeNoteById() {
        BookOwnersService bs = new BookOwnersService();
        FileService fs = new FileService();
        bs.createUser("Vidgit");
        bs.createUser("Alex");
        bs.createUser("Paraboloid");
        fs.createPhonebookUser(1, "123", "Masha");
        fs.createPhonebookUser(1, "1111111", "Dasha");
        fs.createPhonebookUser(1, "2222222", "Nastya");
        fs.createPhonebookUser(2, "123123123", "Roman");
        fs.createPhonebookUser(2, "895416782", "Vitya");
        fs.createPhonebookUser(3, "3333333", "Artem");
        fs.removeNoteById(1);
        Assertions.assertEquals(5, fs.PhoneBook.size());

    }

    @Test
    public void findByNumber() {
        BookOwnersService bs = new BookOwnersService();
        FileService fs = new FileService();
        bs.createUser("Vidgit");
        bs.createUser("Alex");
        bs.createUser("Paraboloid");
        fs.createPhonebookUser(1, "123", "Masha");
        fs.createPhonebookUser(1, "1111111", "Dasha");
        fs.createPhonebookUser(1, "2222222", "Nastya");
        fs.createPhonebookUser(2, "895416782", "Vitya");
        fs.createPhonebookUser(3, "3333333", "Artem");
        NoteService ns2 = fs.findByNumber("123");
        Assertions.assertEquals(fs.getNoteById(1), fs.findByNumber("123"));
    }


}
