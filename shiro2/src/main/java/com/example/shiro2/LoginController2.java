package com.example.shiro2;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController2 {
    @PostMapping("/doLogin2")
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
    @GetMapping("/hello2")
    public String hello(){
        return "hello";
    }
    @GetMapping("login2")
    public String login(){
        return "please login!";
    }
}
