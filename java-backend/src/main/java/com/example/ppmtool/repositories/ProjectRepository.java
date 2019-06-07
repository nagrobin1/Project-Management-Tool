package com.example.ppmtool.repositories;


import com.example.ppmtool.domain.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends CrudRepository <Project, Long> {


    // Built-in methods
    @Override
    Iterable<Project> findAllById(Iterable<Long> iterable);


}