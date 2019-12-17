package com.example.vidgitProjectDins.service;


import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class BookOwnersService {
    //Создаем переменную id и увеличиваем ее каждый раз, когда добавляем нового пользователя телефонной книги
    private int id = 0;

    HashMap<Integer, String> Users = new HashMap<>();

    public void createUser(String name) {
        id++;
        Users.put(id, name);
    }

    public String getUserById(int id) {

        return (Users.get(id));

    }

    public void removeUserById(int id) {
        Users.remove(id);
    }

    //Передаем данные, а именно какого юзера имя поменять нужно и на какое
    public HashMap editUser(int id, String newName) {
        Users.put(id, newName);
        return Users;

    }

    public HashMap getAllOwners() {
        return Users;
    }

    // В этом методе мы возвращаем все имена содержащие указанное имя(или его часть)
    public String findUserByName(String name) {
        StringBuilder sb = new StringBuilder();
        for (HashMap.Entry<Integer, String> entry : Users.entrySet()) {
            if (entry.getValue().contains(name)) {
                sb.append(entry.getValue());
            }
        }
        return sb.toString();
    }

}
