package com.cg.service;

import com.cg.model.User;

import java.util.List;

public interface IOUserService {


    public List<User> SelectUser();


    public Boolean AddUser(User user);


    public User ShowUser(int id);


    public boolean EditUser(User user);


    public boolean deleteUser(int id);


}
