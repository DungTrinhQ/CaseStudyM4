package com.codegym.casestudy.service;


import com.codegym.casestudy.model.Group;

import java.util.Optional;


public interface GroupService {
    Iterable<Group> findAll();

    Optional<Group> findById(Long id);

    void save(Group group);

    void remove(Long id);
}
