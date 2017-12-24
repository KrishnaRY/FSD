package com.fsd.springboot.service;

import org.springframework.stereotype.Service;

import com.fsd.springboot.model.User;

@Service
public class UserServiceImpl implements UserService {

  @Override
  public boolean isValid(User user) {
    return user != null;
       
  }
}
