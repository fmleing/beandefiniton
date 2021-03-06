package com.feng.spring.bean.factory;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 默认 {@link UserFactory} 实现
 */
public class DefaultUserFacoty implements  UserFactory ,InitializingBean,DisposableBean {

    // 1. 基于 @PostConstruct 注解
    @PostConstruct
    public void init(){
        System.out.println(" @PostConstruct 初始化。。。 ");
    }

    // 3.2 基于 @Bean initMethod 方法
    public void initMethod(){
        System.out.println(" @Bean$initMethod 初始化...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(" InitializingBean#afterPropertiesSet 初始化..  ");
    }

    // 1. 基于 @PreDestroy 注解
    @PreDestroy
    public void perDestroy(){
        System.out.println(" @PreDestroy 销毁... ");
    }

    // 4.2 基于 @Bean initMethod 方法
    public void destoryMethod(){
        System.out.println(" @Bean$destoryMethod 初始化...");
    }


    @Override
    public void destroy() throws Exception {
        System.out.println(" DisposableBean#destroy 销毁... ");
    }
}
