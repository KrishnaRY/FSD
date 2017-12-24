package com.fsd.springboot.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fsd.springboot.model.Project;
import com.fsd.springboot.repository.ProjectRepository;
import com.fsd.springboot.service.ProjectService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ProjectRestController.class)
public class ProjectRestControllerTest {
	 @Autowired private MockMvc mockMvc;

	  @Autowired private ObjectMapper objectMapper;

	  @MockBean private ProjectService projectService;

	  @MockBean private ProjectRepository projectRepository;

	  private JacksonTester<Project> projectTester;

	  private Project project;

	  @Before
	  public void setup() {
	    JacksonTester.initFields(this, objectMapper);
	    project = new Project();
	  }

	  @Test
	  public void persistProject_IsValid_ProjectPersisted() throws Exception {
	    final String projectDTOJson = projectTester.write(project).getJson();
	    given(projectService.isValid(any(Project.class))).willReturn(true);
	    mockMvc
	        .perform(post("/addProject").content(projectDTOJson).contentType(APPLICATION_JSON_UTF8))
	        .andExpect(status().isCreated());
	    verify(projectRepository).persist(any(Project.class));
	  }

	/*  @Test
	  public void persistProject_IsNotValid_ProjectNotPersisted() throws Exception {
	    final String projectDTOJson = projectTester.write(project).getJson();
	    given(projectService.isValid(any(Project.class))).willReturn(false);
	    mockMvc
	        .perform(post("/addProject").content(projectDTOJson).contentType(APPLICATION_JSON_UTF8))
	        .andExpect(status().isIAmATeapot());
	    verify(projectRepository, times(0)).persist(any(Project.class));
	  }*/
}
