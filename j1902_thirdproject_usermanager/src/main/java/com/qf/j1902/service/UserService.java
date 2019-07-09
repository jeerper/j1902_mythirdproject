package com.qf.j1902.service;

import com.qf.j1902.pojo.User;
import com.qf.j1902.vo.EasyuiFenYe;
import com.qf.j1902.vo.UserInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2019/7/9.
 */
@FeignClient(value = "thirdproject-provider")
public interface UserService {
    @RequestMapping(value ="/userlist" )
    EasyuiFenYe getUsers(@RequestParam("page")int page,
                         @RequestParam("pageSize")int pageSize,
                         @RequestParam(value = "username",defaultValue = "")String username);

    @RequestMapping(value = "/deluser/{ids}",method = RequestMethod.POST)
    boolean delUser(@PathVariable("ids") String ids);

    @RequestMapping(value = "/findUserByUid",method = RequestMethod.POST)
    User getUserByUid(@RequestParam("uid") int uid);

    @RequestMapping(value = "/updateUserByUid",method = RequestMethod.POST)
    boolean updateUser(@RequestBody UserInfo userInfo);

    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    boolean addUser(@RequestBody UserInfo userInfo);
}
