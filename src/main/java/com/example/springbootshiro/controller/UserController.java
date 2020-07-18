package com.example.springbootshiro.controller;

import com.example.springbootshiro.po.User;
import com.example.springbootshiro.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("/user/controller")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/sayHello")
    @ResponseBody
    public String sayHello(){
        System.out.println("UserController sayHello!");
        return "ok";
    }

    @GetMapping("/add")
    public String add(){
        System.out.println("UserController add!");
        return "user/add";
    }

    @GetMapping("/upd")
    public String upd(){
        System.out.println("UserController upd!");
        return "user/upd";
    }
    @RequestMapping("/tologin")
    public String tologin(){
        System.out.println("UserController tologin!");
        return "login";
    }
    //授权页面
    @RequestMapping("/noauth")
    public String noauth(){
        System.out.println("UserController noauth!");
        return "noauth";
    }

    /**
     * 登录操作
     * @return
     */
    @RequestMapping("/login")
    public String login( String name,String password,Model model){
        System.out.println("name="+name+"password"+password);
        System.out.println("UserController login!");

        /**
         * 使用shiro编写认证操作
         */
        //获取subject
        Subject subject= SecurityUtils.getSubject();
        //封装用户数据
        UsernamePasswordToken token=new UsernamePasswordToken(name,password);

        try {
            //登录
            subject.login(token);
            //跳转主页
            return "redirect:/user/controller/test/thymeleaf";
        } catch (UnknownAccountException e) {
//            e.printStackTrace();
            model.addAttribute("msg","用户不存在！");
            return "login";
        }catch (IncorrectCredentialsException e) {
//            e.printStackTrace();
            model.addAttribute("msg","密码错误！");
            return "login";
        }
    }
    /**
     * 测试thymeleaf模板
     *
     */

    @GetMapping("/test/thymeleaf")
    public String testThymeleaf(Model model){
        model.addAttribute("name","黑马程序员");
        return "test";
    }


    /**
     * 查询用户
     */

    @GetMapping("/user/list")
    @ResponseBody
    public List<User> getUserList(){
        return userService.getUserList();
    }
}
