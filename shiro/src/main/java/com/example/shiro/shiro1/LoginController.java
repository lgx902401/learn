package com.example.shiro.shiro1;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @RequestMapping("/doLogin")
    public void doLogin(String username,String password){
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(new UsernamePasswordToken(username,password));
            System.out.println("登陆成功！");
        }catch (AuthenticationException e){
            e.printStackTrace();
            System.out.println("登陆失败！");
        }
    }
    @RequestMapping("/noAuth")
    public String noAuth(){
        return "/noAuth";
    }
    @RequestMapping("/login")
    public String login(){
        return "/login";
    }

    @RequestMapping("/test")
    public String test(){
        return "/test";
    }

    @RequestMapping("/test2")
    public String test2(){
        return "/test2";
    }
}
