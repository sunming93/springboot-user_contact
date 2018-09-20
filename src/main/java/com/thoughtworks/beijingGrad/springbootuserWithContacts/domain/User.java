package com.thoughtworks.beijingGrad.springbootuserWithContacts.domain;

import java.util.Map;

public class User {
    private int id;
    private String name;
    private Map<Integer, Contact> contacts;

    public User() {
    }

    public User(int id, String name, Map<Integer, Contact> contacts) {
        this.id = id;
        this.name = name;
        this.contacts = contacts;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Map<Integer, Contact> getContacts() {
        return contacts;
    }
}
