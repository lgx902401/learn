package com.example.shiro.shiro1;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    @PostMapping("/doLogin")
    public String doLogin(String username, String password, Model model){
        System.out.println(username);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        try {
            subject.login(token);
            System.out.println("登陆成功！");
            return "redirect:/index";
        }catch (UnknownAccountException e) {
            //e.printStackTrace();
            //登录失败:用户名不存在
            model.addAttribute("msg", "用户名不存在");
            return "login";
        }catch (IncorrectCredentialsException e) {
            //e.printStackTrace();
            //登录失败:密码错误
            model.addAttribute("msg", "密码错误");
            return "login";
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

    @RequestMapping("/index")
    public String index(){
        return "/index";
    }
}
