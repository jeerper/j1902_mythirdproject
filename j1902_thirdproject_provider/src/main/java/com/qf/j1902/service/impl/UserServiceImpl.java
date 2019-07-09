package com.qf.j1902.service.impl;

import com.qf.j1902.mapper.UserMapper;
import com.qf.j1902.pojo.User;
import com.qf.j1902.pojo.UserExample;
import com.qf.j1902.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2019/7/9.
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> getUsers(String username) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        if(!StringUtils.isEmpty(username)){
            criteria.andUsernameLike("%"+username+"%");
        }
        List<User> users = userMapper.selectByExample(example);
        return users;
    }
    @Override
    public boolean delUserByIds(String ids) {
        String[] split=null;
        if (!StringUtils.isEmpty(ids)){
            split= ids.split(",");
        }
        System.out.println("split"+split);
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        List<String> list = Arrays.asList(split);
        List<Integer> list1=new ArrayList<>();
        for (String s:list){
            int i = Integer.parseInt(s);
            list1.add(i);
        }
        criteria.andUseridIn(list1);
        userMapper.deleteByExample(example);
        return true;
    }

    @Override
    public User getUserByUid(int uid) {
        User user = userMapper.selectByPrimaryKey(uid);
        return user;
    }

    @Override
    public boolean updateUserById(User user) {
        int i = userMapper.updateByPrimaryKey(user);
        return true;
    }

    @Override
    public boolean addUser(User user) {
        int insert = userMapper.insert(user);
        return true;
    }
}
