package com.example.vidgitProjectDins.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;


public class BookOwnersServiceTest {

    @Test
    public void getUserById() {

        BookOwnersService bookOwnersServiceTest = new BookOwnersService();
        bookOwnersServiceTest.createUser("Vidgit");
        bookOwnersServiceTest.createUser("Alex");
        bookOwnersServiceTest.createUser("Paraboloid");

        Assertions.assertEquals("Vidgit", bookOwnersServiceTest.getUserById(1));
        Assertions.assertEquals("Alex", bookOwnersServiceTest.getUserById(2));
        Assertions.assertEquals("Paraboloid", bookOwnersServiceTest.getUserById(3));
    }

    @Test
    public void getAllOwners() {
        BookOwnersService bookOwnersServiceGetAll = new BookOwnersService();
        bookOwnersServiceGetAll.createUser("Vidgit");
        bookOwnersServiceGetAll.createUser("Alex");
        bookOwnersServiceGetAll.createUser("Paraboloid");
        HashMap<Integer, String> expectedBookOwners = new HashMap<>();
        expectedBookOwners.put(1, "Vidgit");
        expectedBookOwners.put(2, "Alex");
        expectedBookOwners.put(3, "Paraboloid");
        Assertions.assertEquals(expectedBookOwners, bookOwnersServiceGetAll.getAllOwners());

    }

    @Test
    public void removeUserById() {
        BookOwnersService bookOwnersService = new BookOwnersService();
        bookOwnersService.createUser("Vidgit");
        bookOwnersService.createUser("Alex");
        bookOwnersService.createUser("Paraboloid");
        bookOwnersService.removeUserById(2);
        HashMap<Integer, String> expectedBookOwners = new HashMap<>();
        expectedBookOwners.put(1, "Vidgit");
        expectedBookOwners.put(3, "Paraboloid");
        Assertions.assertEquals(expectedBookOwners, bookOwnersService.getAllOwners());
    }

    @Test
    public void editUser() {
        BookOwnersService bookOwnersServiceTest = new BookOwnersService();
        bookOwnersServiceTest.createUser("Vidgit");
        bookOwnersServiceTest.createUser("Alex");
        bookOwnersServiceTest.createUser("Paraboloid");
        bookOwnersServiceTest.editUser(1, "Vitya");
        Assertions.assertEquals("Vitya", bookOwnersServiceTest.getUserById(1));
    }

    @Test
    public void createUser() {
        BookOwnersService bookOwnersServiceTest = new BookOwnersService();
        bookOwnersServiceTest.createUser("Vidgit");
        Assertions.assertEquals("Vidgit", bookOwnersServiceTest.getUserById(1));
    }

    @Test
    public void findUserByName() {
        BookOwnersService bookOwnersServiceTest = new BookOwnersService();
        bookOwnersServiceTest.createUser("Vidgit");
        bookOwnersServiceTest.createUser("Alex");
        bookOwnersServiceTest.createUser("Paraboloid");
        Assertions.assertEquals("Vidgit", bookOwnersServiceTest.findUserByName("idg"));

    }


}