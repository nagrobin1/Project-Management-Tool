package com.example.ppmtool.repositories;


import com.example.ppmtool.domain.Project;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ProjectRepository extends CrudRepository <Project, Long> {

    Project findByProjectIdentifier (String projectIdentifier);

    @Override
    Iterable<Project> findAll();

    @Override
    void delete(Project project);
}