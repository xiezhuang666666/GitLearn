package com.chen.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.chen.pojo.Student;
import com.chen.pojo.User;
import com.chen.service.LoginService;

@Controller//Spring 会自动扫描并注册这个类为一个 Spring Bean
@RequestMapping("/login")
public class LoginController
{
    @Autowired
    private LoginService loginService;

    @RequestMapping("/1")
    public String Login(Model model, User user, HttpServletRequest request, HttpServletResponse response)
    {
        boolean flag = loginService.login(user.getName(), user.getPassword());
        if (flag)
        {
            HttpSession session = request.getSession();
            session.setAttribute("name", user.getName());
            session.setMaxInactiveInterval(6000);
            return "main";
        }
        else
        {
            model.addAttribute("msg", "登录失败！");
            return "login";
        }
    }


    @RequestMapping("/userexit")
    public String UserExit(User user, HttpServletRequest request, HttpServletResponse response)
    {

//        HttpSession session = request.getSession();
//        session.setAttribute("name", user.getName());
//        session.removeAttribute("userName");
        request.setAttribute("info", null);
        return "logoff";
    }

    @RequestMapping("/updatepad")
    public String updatePassword(Model model, HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        String loginedUser = (String) session.getAttribute("name");
        String oldPwd = request.getParameter("oldpass");
        String newPwd = request.getParameter("newpass");

        User user = loginService.queryByName(loginedUser);

        if (user.getPassword().equals(oldPwd))
        {
            int r = loginService.updateUserPad(loginedUser, newPwd);
            if (r > 0)
            {
                model.addAttribute("msg", "更新成功！");
                System.out.println("更新成功！");
                return "login";
            }
            else
            {
                model.addAttribute("msg", "更新失败！");
            }
        }
        else
        {
            model.addAttribute("msg", "原密码错误！");
        }
        return "updatepad";
    }

    @RequestMapping("/register")
    public String register(Model model, User user, HttpServletRequest request)
    {
        boolean flag = loginService.studentRegister(user.getName(), user.getPassword());
        if (flag)
        {
            model.addAttribute("msg", "注册成功！");
            return "register";
        }
        else
        {
            System.out.println("注册失败");
            model.addAttribute("msg", "注册失败！");
            return "register";
        }
    }
}
