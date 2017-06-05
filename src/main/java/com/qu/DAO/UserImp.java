package com.qu.DAO;

import com.qu.po.User;

import java.util.List;

/**
 * Created by Qu on 2017/6/3.
 */
public interface UserImp {
    public User selectUserByID(int id);
    public List<User> selectUsersByName(String username);
    public void addUser(User user);
    public void updateUser(User user);
    public void deleteUser(User user);
}
