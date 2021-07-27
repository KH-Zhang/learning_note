# 第七章 Spring IOC依赖来源

## 7.4 Spring BeanDefinition 作为依赖来源  

要素
• 元数据：BeanDefinition
• 注册：BeanDefinitionRegistry#registerBeanDefinition
• 类型：延迟和非延迟
• 顺序：Bean 生命周期顺序按照注册顺序  



1、注册接口，注册中心BeanDefinitionRegistry，只有一个标准的实现**DefaultListableBeanFactory#registerBeanDefinition**方法：

```java
BeanDefinition existingDefinition = this.beanDefinitionMap.get(beanName);
```

其中,if (!isAllowBeanDefinitionOverriding()),不允许定义相同的Bean。

```java
this.beanDefinitionMap.put(beanName, beanDefinition);
```

如果if (hasBeanCreationStarted())没有被创建，存两个值

```
this.beanDefinitionMap.put(beanName, beanDefinition);
this.beanDefinitionNames.add(beanName);
```

这个beanDefinitionNames是控制注入的顺序的，beanDefinitionMap是线程安全的但是无序，确保注册顺序。



## 7.5  单例对象作为依赖来源  

• 要素
		• 来源：外部普通 Java 对象（不一定是 POJO）
		• 注册：SingletonBeanRegistry#registerSingleton
• 限制
		• 无生命周期管理
		• 无法实现延迟初始化 Bean 

限制的原因：由于是单例对象，来源于spring的外部，生命周期不由spring上下文进行托管



参考SingletonBeanRegistrationDemo，其中的singletonBeanRegistry.registerSingleton("userFactory", userFactory);



SingletonBeanRegistry通常只有一个DefaultListableBeanFactory实现

注意DefaultListableBeanFactory#registerSingleton的super方法



其AbstractBeanFactory#public Object getBean(String name)通过名称查找：

其中会调用doGetBean方法：

首先查找Object sharedInstance = getSingleton(beanName)，如果找到了就可以直接返回。而BeanDefinition在查找到之后还要讲BeanDefinition变成bean，会激活所有的生命周期，相对比较复杂。



## 7.6 非 Spring 容器管理对象作为依赖来源  

• 要素
		• 注册：ConfigurableListableBeanFactory#registerResolvableDependency
• 限制
		• 无生命周期管理
		• 无法实现延迟初始化 Bean
		• 无法通过依赖查找  

例程：ResolvableDependencySourceDemo，主程序：

```java
public class ResolvableDependencySourceDemo {
    @Autowired
    private String value;

    @PostConstruct
    public void init() {
        System.out.println(value);
    }

    public static void main(String[] args) {
        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        // 注册 Configuration Class（配置类） -> Spring Bean
        applicationContext.register(ResolvableDependencySourceDemo.class);

        applicationContext.addBeanFactoryPostProcessor(beanFactory -> {
            // 注册 Resolvable Dependency
            beanFactory.registerResolvableDependency(String.class, "Hello,World");
        });

        // 启动 Spring 应用上下文
        applicationContext.refresh();

        // 显示地关闭 Spring 应用上下文
        applicationContext.close();
    }
}
```

注意问题：

接口回调，addBeanFactoryPostProcessor的回调的过程





























