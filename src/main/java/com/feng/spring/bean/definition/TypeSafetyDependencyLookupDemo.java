package com.feng.spring.bean.definition;

import com.feng.spring.bean.pojo.User;
import com.feng.spring.dependency.lookup.ObjectProviderDemo;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 类型安全 依赖查找示例
 */
public class TypeSafetyDependencyLookupDemo {
    public static void main(String[] args) {
        // 创建 ApplicationContext 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册 TypeSafetyDependencyLookupDemo 配置类
        applicationContext.register(TypeSafetyDependencyLookupDemo.class);

        // 启动 ApplicationContext 容器
        applicationContext.refresh();

        // 演示 BeanFactory#getBean()方法的安全性
        displayBeanFactoryGetBean(applicationContext);
        // 演示 ObjectFactory#getObject()方法的安全性
        displayObjectFactoryGetObject(applicationContext);
        // 演示 ObjectProvider#getIfAvailable()方法的安全性
        displayObjectProviderGetIfAvailable(applicationContext);

        // 演示 ListableBeanFactory#getBeansOfType()方法的安全性
        displayListableBeanFactoryGetBeansOfType(applicationContext);
        // 关闭 容器
        applicationContext.close();
    }

    private static void displayListableBeanFactoryGetBeansOfType(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<User> userObjectProvider = applicationContext.getBeanProvider(User.class);
        printBeansException(()->userObjectProvider.stream().forEach(System.out::println));
    }

    private static void displayListableBeanFactoryGetBeansOfType(ListableBeanFactory beanFactory) {
        printBeansException(()->beanFactory.getBeansOfType(User.class));
    }

    private static void displayObjectProviderGetIfAvailable(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<User> objectProvider = applicationContext.getBeanProvider(User.class);
        printBeansException(()->objectProvider.getIfAvailable());
    }

    private static void displayObjectFactoryGetObject(AnnotationConfigApplicationContext applicationContext) {
        ObjectFactory<User> objectFactory = applicationContext.getBeanProvider(User.class);
        printBeansException(()->objectFactory.getObject());
    }

    private static void displayBeanFactoryGetBean(AnnotationConfigApplicationContext applicationContext) {
        printBeansException(()->applicationContext.getBean(User.class));
    }

    private static void printBeansException(Runnable runnable){
        try {
            runnable.run();
            // 由于 BeansException 是 RuntimeException 因此不会被 Runnable.run() 捕获到
        } catch (BeansException exception) {
            // 线程安全的，生产上不要使用，容易发生阻塞
            exception.printStackTrace();
        }
    }
}
