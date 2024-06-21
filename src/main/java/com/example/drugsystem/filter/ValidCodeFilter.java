package com.example.drugsystem.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;

@Component
public class ValidCodeFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        //下面代码表示只过滤/login
        if ("POST".equalsIgnoreCase(request.getMethod()) && "/login".equals(request.getServletPath())) {
            String requestCode = request.getParameter("code"); //从前端获取用户填写的验证码
            String validcode = (String) request.getSession().getAttribute("validcode");
            if (!validcode.toLowerCase().equals(requestCode.toLowerCase())) { // 验证码不相同就跳转
                //手动设置异常
                request.getSession().setAttribute("msg","验证码错误");//存储错误信息，以便前端展示
                response.sendRedirect("/toLogin");
            }
        }
        chain.doFilter(request, response);//验证码相同放行
    }
}
