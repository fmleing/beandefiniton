package com.feng.spring.bean.definition;

import com.feng.spring.bean.factory.UserFactory;
import com.feng.spring.bean.pojo.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 层次性依赖查找示例
 */
public class HierarchicalDependencyDemo {

    public static void main(String[] args) {
        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册 Configuration 类
        applicationContext.register(HierarchicalDependencyDemo.class);
        // 启动 applicationContext
        applicationContext.refresh();

        // 1. 获取 HierarchicalBeanFactory <- ConfigurableBeanFactory <- ConfigurableListableBeanFactory
        ConfigurableListableBeanFactory beanFactory = applicationContext.getBeanFactory();
        System.out.println("当前 BeanFactory 的 parent 的 BeanFactory:" + beanFactory.getParentBeanFactory());

        // 2. 设置 Parent BeanFactory
        // 关闭 applicationContext
        applicationContext.close();

    }
}
