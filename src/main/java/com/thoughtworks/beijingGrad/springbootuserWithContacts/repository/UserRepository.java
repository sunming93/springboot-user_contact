package com.thoughtworks.beijingGrad.springbootuserWithContacts.repository;

import com.thoughtworks.beijingGrad.springbootuserWithContacts.domain.Contact;

import java.util.Collection;

public interface UserRepository {
    Collection<Contact> getContactsByUserId(int userId);

    Contact createContactByUserId(int userId, Contact contact);

    Contact updateContactByUserId(int userId, int contactId, Contact contact);

    void deleteContactByUserId(int userId, int contactId);
}
