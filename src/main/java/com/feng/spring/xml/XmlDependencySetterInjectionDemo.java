package com.feng.spring.xml;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * 基于 XML 资源的依赖 Setter 方法注入示例
 */
public class XmlDependencySetterInjectionDemo {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader xmlReader = new XmlBeanDefinitionReader(beanFactory);

        String xmlResourcePath = "classpath:META-INF/bean-setter-inject.xml";
        xmlReader.loadBeanDefinitions(xmlResourcePath);
    }
}
