package com.fsd.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fsd.springboot.model.Project;
import com.fsd.springboot.model.User;
import com.fsd.springboot.repository.ProjectRepository;
import com.fsd.springboot.service.ProjectService;


@RestController
public class ProjectRestController {

@Autowired private ProjectService projectService;

@Autowired private ProjectRepository projectRepository;

@RequestMapping(value = "/addProject", method = RequestMethod.POST)
public ResponseEntity<String> addProject(@RequestBody Project project) {
 // if (userService.isValid(user)) {
	projectRepository.persist(project);
    return ResponseEntity.status(HttpStatus.CREATED).build();
 // }
 // return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
}
}