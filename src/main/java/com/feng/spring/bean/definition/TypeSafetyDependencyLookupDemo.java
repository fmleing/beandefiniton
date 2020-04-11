package com.feng.spring.bean.definition;

import com.feng.spring.dependency.lookup.ObjectProviderDemo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 类型安全 依赖查找示例
 */
public class TypeSafetyDependencyLookupDemo {
    public static void main(String[] args) {
        // 创建 ApplicationContext 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册 ObjectProvider 配置类
        applicationContext.register(ObjectProviderDemo.class);

        // 启动 ApplicationContext 容器
        applicationContext.refresh();

        // 关闭 容器
        applicationContext.close();
    }
}
