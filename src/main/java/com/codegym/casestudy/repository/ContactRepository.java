package com.codegym.casestudy.repository;

import com.codegym.casestudy.model.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends PagingAndSortingRepository<Contact, Long> {
    List<Contact> findByNameContaining(String term);
}
