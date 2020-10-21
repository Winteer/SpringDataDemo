package com.winter.springdatademo.filter;

import com.winter.springdatademo.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName : AclInterceptor
 * @Description : ACL访问控制
 * @Author : Winter
 * @Date: 2020-10-21 09:47
 */
@Component
public class AclInterceptor extends HandlerInterceptorAdapter {
    private String[] permitUrls = new String[]{"/users/login"};

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("访问控制 -- 4");
        boolean result = true;

        User user = (User) request.getAttribute("user");

        //根据用户信息来
        if (user == null) {
            response.setContentType("text/plain");
            response.getWriter().write("need authentication!");
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            result = false;

        } else {
            //根据方法来
            String method = request.getMethod();
            if (!user.hasPermission(method)) {
                response.setContentType("text/plain");
                response.getWriter().write("forbidden!");
                response.setStatus(HttpStatus.FORBIDDEN.value());
                result = false;
            }
        }
        return result;
    }
}