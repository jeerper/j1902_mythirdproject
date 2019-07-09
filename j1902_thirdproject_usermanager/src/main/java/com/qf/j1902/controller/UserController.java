package com.qf.j1902.controller;

import com.qf.j1902.pojo.User;
import com.qf.j1902.service.UserService;
import com.qf.j1902.vo.EasyuiFenYe;
import com.qf.j1902.vo.MsgResult;
import com.qf.j1902.vo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2019/7/9.
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @ResponseBody
    @RequestMapping(value = "/usermanager")
    public EasyuiFenYe getUsers(@RequestParam(value = "page",defaultValue = "1")int page,
                                @RequestParam(value = "rows",defaultValue = "10")int pageSize,
                                @RequestParam(value = "username",defaultValue = "")String username){
        EasyuiFenYe fenYe = userService.getUsers(page, pageSize, username);
        return  fenYe;
    }
    @ResponseBody
    @RequestMapping(value = "/deluser",method = RequestMethod.POST)
    public MsgResult deluser(@RequestParam(value = "ids",defaultValue = "")String ids){
        System.out.println(ids);
        boolean delitem= userService.delUser(ids);
        if (delitem){
            MsgResult msgResult = new MsgResult();
            msgResult.setMsg("删除成功");
            msgResult.setStatus(200);
            return msgResult;
        }else {
            MsgResult msgResult = new MsgResult();
            msgResult.setMsg("删除失败");
            msgResult.setStatus(500);
            return msgResult;
        }
    }
    @ResponseBody
    @RequestMapping(value = "findUserByUid",method = RequestMethod.POST)
    public UserInfo findUserByUid(@RequestParam("uid") int uid, HttpSession session){
        session.setAttribute("userid",uid);
        User user= userService.getUserByUid(uid);
        System.out.println(user.getUsername()+"2222222");
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(user.getUsername());
        userInfo.setUpassword(user.getUpassword());
        userInfo.setRealname(user.getRealname());
        userInfo.setUseremail(user.getUseremail());
        userInfo.setTelphone(user.getTelphone());
        userInfo.setAddress(user.getAddress());
        userInfo.setGender(user.getGender());
        System.out.println(userInfo+"fffff");
        return userInfo;
    }
    @ResponseBody
    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    public String updateUser(UserInfo userInfo,HttpSession session){
        Object userids = session.getAttribute("userid");
        Integer userid=(Integer)userids;
        System.out.println(userid+"6666");
        userInfo.setUserid(userid);
        System.out.println(userInfo.getUpassword()+"密码");
        System.out.println(userInfo.getUseremail()+"邮箱");
        boolean updateUser=userService.updateUser(userInfo);
        session.setAttribute("userid",null);
        return "修改成功";
    }
    @ResponseBody
    @RequestMapping(value = "/addusertj",method = RequestMethod.POST)
    public String addusertj(UserInfo userInfo){
        System.out.println(userInfo.getUseremail()+"666");
        boolean add=userService.addUser(userInfo);
        return "success";
    }
}
