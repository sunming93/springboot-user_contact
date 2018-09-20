package com.thoughtworks.beijingGrad.springbootuserWithContacts.repository;

import com.thoughtworks.beijingGrad.springbootuserWithContacts.domain.Contact;
import com.thoughtworks.beijingGrad.springbootuserWithContacts.domain.Gender;
import com.thoughtworks.beijingGrad.springbootuserWithContacts.domain.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class UserStorage {
    private static final Map<Integer, User> USERS = new HashMap<>();

    static {
        Map<Integer, Contact> contacts = new HashMap<>();
        contacts.put(1, new Contact(1, "wu qian", 1234567890L, 18, Gender.Female));
        contacts.put(2, new Contact(2, "xin kuan", 1234567890L, 18, Gender.Female));

        USERS.put(5, new User(5, "zhou tian", contacts));
    }

    public static Collection<Contact> getContactsByUserId(int userId) {
        return USERS.get(userId).getContacts().values();
    }
}
