package com.feng.spring.bean.factory;

import javax.annotation.PostConstruct;

/**
 * 默认 {@link UserFactory} 实现
 */
public class DefaultUserFacoty implements  UserFactory {

    // 1. 基于 @PostConstruct 注解
    @PostConstruct
    public void init(){
        System.out.println(" @PostConstruct 初始化。。。 ");
    }
}
