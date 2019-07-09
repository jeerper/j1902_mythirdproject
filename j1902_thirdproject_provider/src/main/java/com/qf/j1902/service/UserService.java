package com.qf.j1902.service;

import com.qf.j1902.pojo.User;

import java.util.List;

/**
 * Created by Administrator on 2019/7/9.
 */
public interface UserService {
    List<User> getUsers(String username);

    boolean delUserByIds(String ids);

    User getUserByUid(int uid);

    boolean updateUserById(User user);

    boolean addUser(User user);
}
