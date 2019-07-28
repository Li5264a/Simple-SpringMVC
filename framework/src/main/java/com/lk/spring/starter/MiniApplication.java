package com.lk.spring.starter;

import com.lk.spring.beans.BeanFactory;
import com.lk.spring.core.ClassScanner;
import com.lk.spring.web.handler.HandlerManager;
import com.lk.spring.web.server.TomcatServer;
import org.apache.catalina.LifecycleException;

import java.io.IOException;
import java.util.List;

public class MiniApplication {
    public static void run(Class<?> cls, String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Hello MiniApplication!");
        TomcatServer tomcatServer = new TomcatServer(args);
        try {
            tomcatServer.startServer();
            List<Class<?>> classList = ClassScanner.scanClasses(cls.getPackage().getName());
            BeanFactory.initBean(classList);
            HandlerManager.resolveMappingHandler(classList);
            classList.forEach(it-> System.out.println(it.getName()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
