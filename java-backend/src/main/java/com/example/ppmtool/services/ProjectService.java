package com.example.ppmtool.services;


import com.example.ppmtool.domain.Project;
import com.example.ppmtool.exceptions.ProjectIdException;
import com.example.ppmtool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {


    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project project) throws ProjectIdException {
        try{
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return projectRepository.save(project);
        }catch (Exception e){
            throw new ProjectIdException("Project ID '"+project.getProjectIdentifier().toUpperCase()+"' already exists");
        }

    }


    public Project findProjectByIdentifier (String projectIdentifier) throws ProjectIdException {

        Project project = projectRepository.findByProjectIdentifier(projectIdentifier.toUpperCase());

        if (project == null) {
            throw new ProjectIdException("Project ID '"+ projectIdentifier +"' does not exist");
        }

        return project;
    }


    public Iterable<Project> findAllProjects () {
        return projectRepository.findAll();
    }


    public void deleteProjectByProjectIdentifier(String projectIdentifier) {

        Project project = this.findProjectByIdentifier(projectIdentifier);
        if (project != null) {
            throw new ProjectIdException("Project ID '"+ projectIdentifier +"' does not exist. Cannot delete!");
        }
        projectRepository.delete(project);
    }
}


