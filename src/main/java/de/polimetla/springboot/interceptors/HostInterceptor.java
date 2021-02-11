package de.polimetla.springboot.interceptors;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HostInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(request.getServerName().contains(System.getenv("URL"))){
            return true;
        }
        response.getWriter().write("This is not an authenticated route. Please access the API through https://" + System.getenv("URL"));
        return false;
    }
}
