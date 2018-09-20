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

    public static void saveContactByUserId(int userId, Contact contact) {
        USERS.get(userId).getContacts().put(contact.getId(), contact);
    }

    public static Map<Integer, User> getUSERS() {
        return USERS;
    }

    public static Contact updateContactByUserId(int userId, int contactId, Contact contact) {
        USERS.get(userId).getContacts().get(contactId)
                .setName(contact.getName())
                .setAge(contact.getAge())
                .setPhoneNumber(contact.getPhoneNumber())
                .setGender(contact.getGender());
        return contact;
    }

    public static void deleteContactByUserId(int userId, int contactId) {
        USERS.get(userId).getContacts().remove(contactId);
    }

    public static Contact getContactByUserNameAndContactName(String userName, String contactName) {
        for(int userId : USERS.keySet()){

            User user = USERS.get(userId);
            if(user.getName().equals(userName)){

                Map<Integer, Contact> contacts = user.getContacts();
                for(int contactId : contacts.keySet()){

                    Contact contact = contacts.get(contactId);
                    if(contact.getName().equals(contactName)){
                        return contact;
                    }
                }
            }
        }
        return null;
    }
}
