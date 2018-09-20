package com.thoughtworks.beijingGrad.springbootuserWithContacts.repository.impl;

import com.thoughtworks.beijingGrad.springbootuserWithContacts.domain.Contact;
import com.thoughtworks.beijingGrad.springbootuserWithContacts.repository.UserRepository;
import com.thoughtworks.beijingGrad.springbootuserWithContacts.repository.UserStorage;

import java.util.Collection;

public class UserRepositoryImpl implements UserRepository {
    @Override
    public Collection<Contact> getContactsByUserId(int userId) {
        return UserStorage.getContactsByUserId(userId);
    }

    @Override
    public Contact createContactByUserId(int userId, Contact contact) {
        UserStorage.saveContactByUserId(userId, contact);
        return contact;
    }
}
