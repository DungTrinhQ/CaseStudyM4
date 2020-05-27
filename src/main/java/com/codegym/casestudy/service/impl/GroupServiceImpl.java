package com.codegym.casestudy.service.impl;

import com.codegym.casestudy.model.Group;
import com.codegym.casestudy.repository.GroupRepository;
import com.codegym.casestudy.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupRepository groupRepository;

    @Override
    public Iterable<Group> findAll() {
        return groupRepository.findAll();
    }

    @Override
    public Optional<Group> findById(Long id) {
        return groupRepository.findById(id);
    }

    @Override
    public void save(Group group) {
        groupRepository.save(group);
    }

    @Override
    public void remove(Long id) {
        groupRepository.deleteById(id);
    }
}
