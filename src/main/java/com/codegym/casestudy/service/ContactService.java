package com.codegym.casestudy.service;

import com.codegym.casestudy.model.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ContactService {
    Page<Contact> findAll(Pageable pageable);

    List<Contact> search(String term);

    Optional<Contact> findOne(Long id);

    void save(Contact contact);

    void delete(Long id);
}
