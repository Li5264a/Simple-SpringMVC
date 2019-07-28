package com.lk.spring;

import com.lk.spring.starter.MiniApplication;

import java.io.IOException;

public class Application {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        try {
            MiniApplication.run(Application.class,args);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
