package com.it666.web.controller;

import com.it666.web.po.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class MyController {
    /**
     * ���û���¼ҳ����ת
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String toLogin() {
        return "login";
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(User user, Model model, HttpSession session) {
        //��ȡ�û���������
        String username = user.getUsername();
        String password = user.getPassword();
        //Щ���������ݿ��л�ȡ���û��������������ж�
        if (username != null && username.equals("admin") && password != null && password.equals("admin")) {
            //���û�������ӵ�Session��
            session.setAttribute("USER_SESSION", user);
            //�ض�����ҳ�����ת����
            return "redirect:main";
        }
        model.addAttribute("msg", "�û�����������������µ�¼��");
        return "login";
    }

    @RequestMapping(value = "/main")
    public String toMain() {
        return "main";
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpSession session) {
        //���session
        session.invalidate();
        //�ض��򵽵�¼ҳ�����ת����
        return "redirect:login";
    }
}
