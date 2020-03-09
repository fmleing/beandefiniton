package com.feng.spring.bean.definition;

import com.feng.spring.bean.factory.DefaultUserFacoty;
import com.feng.spring.bean.factory.UserFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutowireCapableBeanFactoryDemo {

    public static void main(String[] args) {
        // 配置 xml 配置文件，启动 Spring 应用上下文
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/special-bean-instantiation-context.xml");

        AutowireCapableBeanFactory beanFactory = applicationContext.getAutowireCapableBeanFactory();

        UserFactory userFactory = beanFactory.createBean(DefaultUserFacoty.class);
        System.out.println(userFactory.createUser());
    }
}
