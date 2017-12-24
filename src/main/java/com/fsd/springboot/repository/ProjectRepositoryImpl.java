package com.fsd.springboot.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.fsd.springboot.model.Project;

@Repository
public class ProjectRepositoryImpl implements ProjectRepository {
	 @PersistenceContext
	    private EntityManager entityManager;
	@Override
	@Transactional
	public void persist(final Project project) {
		entityManager.persist(project);
	}

}
