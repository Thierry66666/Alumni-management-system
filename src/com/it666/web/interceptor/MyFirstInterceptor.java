package com.it666.web.interceptor;

import com.it666.web.po.User;
import org.springframework.web.context.request.SessionScope;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MyFirstInterceptor implements HandlerInterceptor {
    @Override
    //������������ִ��֮ǰ����
    //����ֵ: true  ����   false  ������    ��ִ�в��˴���������
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //��ȡ�����RUi:ȥ��http:localhost:8080�ⲿ��ʣ�µ�
        String uri = request.getRequestURI();
        //UTL:����login.jsp�ǿ��Թ������ʵģ�������URL���������ؿ���
        if (uri.indexOf("/login") >= 0) {
            return true;
        }
        //��ȡsession
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("USER_SESSION");
        //�ж�session���Ƿ����û����ݣ�����У��򷵻�true����������ִ��
        if (user != null) {
            return true;
        }
        //�����������ĸ�����ʾ��Ϣ����ת������¼ҳ��
        request.setAttribute("msg", "����û�е�¼�����ȵ�¼��");
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
        return false;
    }

    @Override
    //������������ִ��֮����Զ����õ���
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle������������ִ��֮����Զ����õ���1");
    }

    @Override
    //���������֮��, �����
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion���������֮��,�����1");
    }
}
