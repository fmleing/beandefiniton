package com.feng.spring.dependency.lookup;

import com.feng.spring.bean.pojo.User;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * 通过 {@link ObjectProvider} 进行依赖查找
 *
 */
public class ObjectProviderDemo {

    public static void main(String[] args) {
        // 创建 ApplicationContext 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册 ObjectProvider 配置类
        applicationContext.register(ObjectProviderDemo.class);

        // 启动 ApplicationContext 容器
        applicationContext.refresh();

        // 依赖查找
        lookupIfAvaiable(applicationContext);

        // 关闭 容器
        applicationContext.close();
    }

    public static void lookupIfAvaiable(AnnotationConfigApplicationContext applicationContext){
        ObjectProvider<User> userObjectProvider = applicationContext.getBeanProvider(User.class);
        User u = userObjectProvider.getIfAvailable(() -> User.createUser());
    }

    @Bean
    public String helloWorld(){
        return "Hello World";
    }

    private static void lookupByObjectProvider(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<String> objectProvider = applicationContext.getBeanProvider(String.class);
        System.out.println(objectProvider.getObject());
    }
}
