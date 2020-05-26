package com.codegym.casestudy.repository;

import com.codegym.casestudy.model.Contact;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository {
    List<Contact> findByNameContaining(String term);
}
