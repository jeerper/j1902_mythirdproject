package com.qf.j1902.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.j1902.pojo.User;
import com.qf.j1902.service.UserService;
import com.qf.j1902.vo.EasyuiFenYe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2019/7/9.
 */
@Controller
public class UserController {
    @Autowired
    UserService userService;
    @ResponseBody
    @RequestMapping(value = "/userlist")
    public EasyuiFenYe getUsers(@RequestParam("page")int page,
                                @RequestParam("pageSize")int pageSize,
                                @RequestParam(value = "username",defaultValue = "")String username){
        EasyuiFenYe fenYe = new EasyuiFenYe();
        PageHelper.startPage(page,pageSize);
        List<User> users = userService.getUsers(username);
        PageInfo<User> pageInfo = new PageInfo<>(users);
        long total = pageInfo.getTotal();
        fenYe.setTotal(total);
        fenYe.setRows(users);
        return  fenYe;
    }
    @ResponseBody
    @RequestMapping(value = "/deluser/{ids}",method = RequestMethod.POST)
    public boolean deluser(@PathVariable("ids") String ids){
        boolean del= userService.delUserByIds(ids);
        return del;
    }
    @ResponseBody
    @RequestMapping(value = "/findUserByUid",method = RequestMethod.POST)
    public User adduser(@RequestParam("uid") int uid){
        System.out.println(uid);
        User user=userService.getUserByUid(uid);
        return user;
    }
    @ResponseBody
    @RequestMapping(value = "/updateUserByUid",method = RequestMethod.POST)
    public boolean updateUserByUid(@RequestBody User user){
        System.out.println(user.getUserid()+"8888888");
        boolean update=userService.updateUserById(user);
        return update;
    }
    @ResponseBody
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    boolean addUser(@RequestBody User user){
        boolean add=userService.addUser(user);
        return add;
    }
}

