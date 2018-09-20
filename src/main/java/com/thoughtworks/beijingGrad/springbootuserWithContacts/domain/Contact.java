package com.thoughtworks.beijingGrad.springbootuserWithContacts.domain;

public class Contact {
    private int id;
    private String name;
    private long phoneNumber;
    private int age;
    private Gender gender;

    public Contact() {
    }

    public Contact(int id, String name, long phoneNumber, int age, Gender gender) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }
}
