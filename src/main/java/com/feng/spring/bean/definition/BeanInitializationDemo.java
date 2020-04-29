package com.feng.spring.bean.definition;

import com.feng.spring.bean.factory.DefaultUserFacoty;
import com.feng.spring.bean.factory.UserFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * Bran 初始化 示例
 */
@Configuration  // 配置 类
public class BeanInitializationDemo {

    public static void main(String[] args) {
        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册 Configuration 类
        applicationContext.register(BeanInitializationDemo.class);
        // 启动 applicationContext
        applicationContext.refresh();
        // 非延迟初始化在 Spring 应用上下文启动完成后，被初始化
        System.out.println("Spring 应用上下文已启动...");
        UserFactory userFactory = applicationContext.getBean(UserFactory.class);
        System.out.println("Spring 应用准备关闭...");
        // 关闭 applicationContext
        applicationContext.close();
        System.out.println("Spring 应用已关闭...");


        System.out.println(")");
    }

    @Bean(initMethod = "initMethod",destroyMethod = "destoryMethod")
    public UserFactory initUserFactory(){
        return new DefaultUserFacoty();
    }
}
