package com.qf.j1902.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Administrator on 2019/7/4.
 */
@Controller
public class IndexController {
    @RequestMapping("/")
    public String index(){
        return "index";
    }
    //讲树形节点的自定义资源地址设定为选项请求的资源地址
    @RequestMapping("/{page}")
    public String page(@PathVariable("page")String page){
        return page;
    }
}
