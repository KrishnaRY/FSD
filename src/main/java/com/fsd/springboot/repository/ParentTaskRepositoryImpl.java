package com.fsd.springboot.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class ParentTaskRepositoryImpl implements ParentTaskRepository {
	 @PersistenceContext
	    private EntityManager entityManager;
	
	@Override
	public List getAllParentTasks() {
		 return entityManager.createQuery("select parentTask from ParentTask parentTask").getResultList();
	}

}
