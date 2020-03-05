package com.feng.spring.bean.definition;

import com.feng.spring.bean.pojo.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;

public class BeanDefianitonDemo {

    public static void main(String[] args) {
        //1. 通过 BeanDefinitionBuilder
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        // 通过属性设置
        beanDefinitionBuilder.addPropertyValue("id", 1);
        beanDefinitionBuilder.addPropertyValue("name", "小明");
        BeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();

        // 2. 通过 AbstractBeanDefinition 以及派生类
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        // 设置 Bean 类型
        genericBeanDefinition.setBeanClass(User.class);
        // 通过 MutablePropertyValues 批量操作属性
        MutablePropertyValues propertyValues = new MutablePropertyValues();
        propertyValues.add("id", 1).add("name", "小红");
        genericBeanDefinition.setPropertyValues(propertyValues);

    }
}
