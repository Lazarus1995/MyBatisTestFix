package com.qu.DAO;

import com.qu.po.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Qu on 2017/6/3.
 */
public interface UserImp {

    @Select("select * from user where id=#{id}")
    public User selectUserByID(int id);
    public List<User> selectUsersByName(String username);
    public void addUser(User user);
    public void updateUser(User user);
    public void deleteUser(User user);
}
