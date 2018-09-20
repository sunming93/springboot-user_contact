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

    @Override
    public Contact updateContactByUserId(int userId, int contactId, Contact contact) {
        return UserStorage.updateContactByUserId(userId, contactId, contact);
    }

    @Override
    public void deleteContactByUserId(int userId, int contactId) {
        UserStorage.deleteContactByUserId(userId, contactId);
    }

    @Override
    public Contact getContactByUserNameAndContactName(String userName, String contactName) {
        return UserStorage.getContactByUserNameAndContactName(userName, contactName);
    }
}
