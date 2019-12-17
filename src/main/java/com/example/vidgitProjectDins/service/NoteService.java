package com.example.vidgitProjectDins.service;

public class NoteService {
    public static int id = 0;
    public int idOfThisNote;
    private String number;
    private String nameNote;

    public NoteService() {
    }

    public NoteService(String nameNote, String number) {
        id++;
        this.number = number;
        this.nameNote = nameNote;
        this.idOfThisNote = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNameNote() {
        return nameNote;
    }

    public void setNameNote(String nameNote) {
        this.nameNote = nameNote;
    }

}
