package com.codegym.casestudy.service;

import com.codegym.casestudy.model.Contact;

import java.util.List;

public interface ContactService {
    Iterable<Contact> findAll();

    List<Contact> search(String term);

    Contact findOne(Integer id);

    void save(Contact contact);

    void delete(Integer id);
}
