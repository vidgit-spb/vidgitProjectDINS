package com.example.vidgitProjectDins.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;


@Service
public class FileService {

    // В качестве ключа в даной струтуре представлен объект , в качестве значение id владельца книги, наоборот не сделано по той причине
    // что у одного Юзера может находиться в записной книжке несколько объектов а не наоборот, даже если имена и номера будут совпадать
    // Будут отличаться id
    HashMap<NoteService, Integer> PhoneBook = new HashMap<>();

    public void createPhonebookUser(Integer idOwner, String number, String name) {
        NoteService currentNote = new NoteService(name, number);
        PhoneBook.putIfAbsent(currentNote, idOwner);
        PhoneBook.put(currentNote, idOwner);
    }

    //В этом методе мы выводим объект с нужным id
    public NoteService getNoteById(int id) {
        NoteService service = new NoteService();

        for (HashMap.Entry<NoteService, Integer> entry : PhoneBook.entrySet()) {
            if (entry.getKey().idOfThisNote == id) {
                service = entry.getKey();
            }
        }
        return service;
    }

    public void editNotebyId(int id, String newNumber, String newName) {

        for (HashMap.Entry<NoteService, Integer> entry : PhoneBook.entrySet()) {
            if (entry.getKey().idOfThisNote == id) {
                entry.getKey().setNameNote(newName);
                entry.getKey().setNumber(newNumber);
            }
        }
    }

    public void removeNoteById(int id) {
        for (HashMap.Entry<NoteService, Integer> entry : PhoneBook.entrySet()) {
            if (entry.getKey().idOfThisNote == id) {
                PhoneBook.remove(entry.getKey());
                break;
            }
        }
    }

    public NoteService findByNumber(String number) {
        NoteService service = new NoteService();
        for (HashMap.Entry<NoteService, Integer> entry : PhoneBook.entrySet()) {
            if (entry.getKey().getNumber().equals(number)) {
                service = entry.getKey();
                break;
            }
        }
        return service;
    }

    public HashMap getAllNotes() {
        return PhoneBook;
    }

}


