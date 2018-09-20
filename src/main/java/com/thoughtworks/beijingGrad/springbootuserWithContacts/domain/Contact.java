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

    public Contact setName(String name) {
        this.name = name;
        return this;
    }

    public Contact setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public Contact setAge(int age) {
        this.age = age;
        return this;
    }

    public Contact setGender(Gender gender) {
        this.gender = gender;
        return this;
    }
}
