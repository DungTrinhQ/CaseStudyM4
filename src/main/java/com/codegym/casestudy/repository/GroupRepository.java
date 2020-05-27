package com.codegym.casestudy.repository;

import com.codegym.casestudy.model.Group;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface GroupRepository extends PagingAndSortingRepository<Group, Long> {
}
