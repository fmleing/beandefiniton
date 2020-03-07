package com.feng.spring.bean.factory;

import com.feng.spring.bean.pojo.User;

/**
 * {@link User} 工厂类
 */
public interface UserFactory {
    default User createUser(){
        return new User();
    }

}
