package com.feng.spring.bean.definition;

import com.feng.spring.bean.pojo.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * bean 实例化 示例
 */
public class BeanInstantiationDemo {
    public static void main(String[] args) {
        // 配置 XML 配置文件
        // 启动 Spring 应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-creation-context.xml");

        User user = beanFactory.getBean("user-by-static-method", User.class);
        System.out.println(user);
    }
}