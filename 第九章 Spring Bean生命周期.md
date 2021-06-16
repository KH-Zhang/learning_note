# 第九章 Spring Bean生命周期

## 9.2 元信息解析阶段：BeanDefinition的解析

• 面向资源 BeanDefinition 解析
		• BeanDefinitionReader
		• XML 解析器 - BeanDefinitionParser
• 面向注解 BeanDefinition 解析
		• AnnotatedBeanDefinitionReader  

**主程序AnnotatedBeanDefinitionParsingDemo：**

```Java
public class AnnotatedBeanDefinitionParsingDemo {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 基于 Java 注解的 AnnotatedBeanDefinitionReader 的实现
        AnnotatedBeanDefinitionReader beanDefinitionReader = new AnnotatedBeanDefinitionReader(beanFactory);
        int beanDefinitionCountBefore = beanFactory.getBeanDefinitionCount();
        // 注册当前类（非 @Component class）
        beanDefinitionReader.register(AnnotatedBeanDefinitionParsingDemo.class);
        int beanDefinitionCountAfter = beanFactory.getBeanDefinitionCount();
        int beanDefinitionCount = beanDefinitionCountAfter - beanDefinitionCountBefore;
        System.out.println("已加载 BeanDefinition 数量：" + beanDefinitionCount);
        // 普通的 Class 作为 Component 注册到 Spring IoC 容器后，通常 Bean 名称为 annotatedBeanDefinitionParsingDemo
        // Bean 名称生成来自于 BeanNameGenerator，注解实现 AnnotationBeanNameGenerator
        AnnotatedBeanDefinitionParsingDemo demo = beanFactory.getBean("annotatedBeanDefinitionParsingDemo",
                AnnotatedBeanDefinitionParsingDemo.class);
        System.out.println(demo);
    }
}
```



1.AnnotatedBeanDefinitionReader这个类中

```java
public AnnotatedBeanDefinitionReader(BeanDefinitionRegistry registry) {
   this(registry, getOrCreateEnvironment(registry));
}
```

传入参数是BeanDefinitionRegistry接口，DefaultListableBeanFactory是改接口的实现类。



2.注册当前类（非 @Component class），普通的 Class 作为 Component 注册到 Spring IoC 容器后，通常 Bean 名称为 annotatedBeanDefinitionParsingDemo。Bean 名称生成来自于 BeanNameGenerator，注解实现 AnnotationBeanNameGenerator。



3.其中AnnotationBeanNameGenerator继承自BeanNameGenerator，名称的生成来自于buildDefaultBeanName(BeanDefinition definition) 方法。



## 9.3 Bean注册阶段，BeanDefinition与单体Bean注册

BeanDefinition 注册接口
		BeanDefinitionRegistry  

其中DefaultListableBeanFactory#registerBeanDefinition方法，重点分析

```Java
this.beanDefinitionMap.put(beanName, beanDefinition);
this.beanDefinitionNames.add(beanName);
```

分别保存kv内容和注册顺序



## 9.4 BeanDefinition合并阶段，BeanDefinition合并过程是怎样出现的？

• BeanDefinition 合并
		• 父子 BeanDefinition 合并
				• 当前 BeanFactory 查找
				• 层次性 BeanFactory 查找  

User和superUser:

User是 =》RootBeanDefinition 不需要合并，不存在 parent

superUser是普通 beanDefinition =》GenericBeanDefinition



主程序：MergedBeanDefinitionDemo：

其中ConfigurableBeanFactory#getMergedBeanDefinition()方法,

其中BeanDefinition#getParentName()方法



ConfigurableBeanFactory#getMergedBeanDefinition()的实现：

改方法是唯一实现

调用的getMergedLocalBeanDefinition方法中，this.mergedBeanDefinitions.get(beanName)可以认为是本地缓存。

最终调用的

```java
protected RootBeanDefinition getMergedBeanDefinition(
      String beanName, BeanDefinition bd, @Nullable BeanDefinition containingBd)
      throws BeanDefinitionStoreException
```

是最底层的方法，重点是mbd.overrideFrom(bd);



注意点：

1、User

```java
<!-- Root BeanDefinition 不需要合并，不存在 parent -->
<!-- 普通 beanDefinition GenericBeanDefinition -->
<!-- 经过合并后 GenericBeanDefinition 变成 RootBeanDefinition -->
```

2、superUser

```java
<!-- 普通 beanDefinition GenericBeanDefinition -->
<!-- 合并后 GenericBeanDefinition 变成 RootBeanDefinition，并且覆盖 parent 相关配置-->
<!-- primary = true , 增加了一个 address 属性 -->
```



## 9.5 Bean Class加载阶段：Bean ClassLoader能够被替换吗？

• ClassLoader 类加载
• Java Security 安全控制
• ConfigurableBeanFactory 临时 ClassLoader  



1.BeanDefinition的





## 9.6 Bean实例化前阶段：Bean的实例化能否被绕开





## 9.7 Spring Bean 实例化阶段  





































