package com.fsd.springboot.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.fsd.springboot.model.User;

@Repository
public class UserRepositoryImpl implements UserRepository {
	 @PersistenceContext
	    private EntityManager entityManager;
	@Override
	@Transactional
	public void persist(final User user) {
		entityManager.persist(user);
	}
	@Override
	public List<User> getAllUsers()
		
		{
	        return entityManager.createQuery("select user from User user").getResultList();
	    }
	
	 @Override
	 @Transactional
	    public void updateUser(User user)
	    {
	        entityManager.merge(user);
	    }
	  @Override
	  @Transactional
	    public void deleteUser(long user_ID)
	    {
		  User user = entityManager.find(User.class,user_ID);
	        entityManager.remove(user);
	    }
}
