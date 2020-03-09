package com.feng.spring.bean.definition;

import com.feng.spring.bean.factory.UserFactory;

import java.util.Iterator;
import java.util.ServiceLoader;

public class ServiceLoaderDemo {

    public static void main(String[] args) {
        demoServiceLoader();

    }
    public static void demoServiceLoader(){
        // service 加载
        ServiceLoader<UserFactory> serviceLoader = ServiceLoader.load(UserFactory.class, Thread.currentThread()
                .getContextClassLoader());
        // 使用迭代器 进行迭代
        Iterator<UserFactory> iterator = serviceLoader.iterator();
        while (iterator.hasNext()) {
            UserFactory userFactory = iterator.next();
            System.out.println(userFactory.createUser());
        }
    }
}