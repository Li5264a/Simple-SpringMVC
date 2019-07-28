package com.lk.spring.web.handler;

import com.lk.spring.beans.BeanFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MappingHandler {
    private String uri;
    private Method method;
    private Class<?> controller;
    private String[] args;

    public boolean handle(ServletRequest request, ServletResponse res) throws IllegalAccessException, InstantiationException, InvocationTargetException, IOException {
        String requestUri = ((HttpServletRequest) request).getRequestURI();

        if (!uri.equals(requestUri)) {
            return false;
        }

        Object[] parameters = new Object[args.length];
        for (int i = 0;i < args.length;i++) {
            parameters[i] = request.getParameter(args[i]);
        }

        Object ctl = BeanFactory.getBean(controller);
        Object response = method.invoke(ctl,parameters);
        res.getWriter().println(response.toString());
        return true;
    }

    public MappingHandler(String uri, Method method, Class<?> controller, String[] args) {
        this.uri = uri;
        this.method = method;
        this.controller = controller;
        this.args = args;
    }
}
