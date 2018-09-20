package com.thoughtworks.beijingGrad.springbootuserWithContacts.repository;

import com.thoughtworks.beijingGrad.springbootuserWithContacts.domain.Contact;

import java.util.Collection;

public interface UserRepository {
    Collection<Contact> getContactsByUserId(int userId);
}