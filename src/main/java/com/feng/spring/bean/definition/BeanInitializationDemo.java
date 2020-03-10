package com.feng.spring.bean.definition;

import com.feng.spring.bean.factory.DefaultUserFacoty;
import com.feng.spring.bean.factory.UserFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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

        UserFactory userFactory = applicationContext.getBean(UserFactory.class);
        // 关闭 applicationContext
        applicationContext.close();
    }

    @Bean(initMethod = "initMethod")
    public UserFactory initUserFactory(){
        return new DefaultUserFacoty();
    }
}
