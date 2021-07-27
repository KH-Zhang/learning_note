# 第六章 Spring 依赖注入

## 6.1 依赖注入的模式和类型  

• 手动模式 - 配置或者编程的方式，提前安排注入规则
		• XML 资源配置元信息
		• Java 注解配置元信息
		• API 配置元信息
• 自动模式 - 实现方提供依赖自动关联的方式，按照內建的注入规则
		• Autowiring（自动绑定  



依赖注入类型  

| 依赖注入类型 | 配置元数据举例                                   |
| ------------ | ------------------------------------------------ |
| Setter 方法  | <proeprty name="user" ref="userBean"/>           |
| 构造器       | <constructor-arg name="user" ref="userBean" />   |
| 字段         | @Autowired User user;                            |
| 方法         | @Autowired public void user(User user) { ... }   |
| 接口回调     | class MyBean implements BeanFactoryAware { ... } |





## 6.2 自动绑定（Autowiring）  

官方说明
The Spring container can autowire relationships between collaborating beans. You can let Spring
resolve collaborators (other beans) automatically for your bean by inspecting the contents of the
ApplicationContext.
优点
• Autowiring can significantly reduce the need to specify properties or constructor arguments.（自动绑定，比如name属性，直接byName，字段就变成了bean的名称，如果字段名称变化了，那么就关联不上了）
• Autowiring can update a configuration as your objects evolve.  （类型转换或者类型传输的作用）



**Autowiring modes**  

| 模式             | 说明                                                         |
| ---------------- | ------------------------------------------------------------ |
| **no（不推荐）** | 默认值，未激活 Autowiring，需要手动指定依赖注入对象。        |
| byName           | 根据被注入属性的**名称**作为 **Bean 名称**进行依赖查找，并将对象设置到该 属性。 |
| byType           | 根据被注入属性的类型作为依赖类型进行查找，并将对象设置到该属性。类型相同就设置primary来区别 |
| constructor      | 特殊 byType 类型，用于构造器参数。                           |

参考枚举：org.springframework.beans.factory.annotation.Autowire  





## 6.3 自动绑定（Autowiring）限制和不足  



## 6.4 Setter 方法注入  

实现方法
• 手动模式
		• XML 资源配置元信息
		• Java 注解配置元信息
		• API 配置元信息
• 自动模式
		• byName
		• byType  



**手动模式：**

1、 XML 资源配置元信息

主程序：XmlDependencySetterInjectionDemo

xml文件中

```xml
<bean class="org.geekbang.thinking.in.spring.ioc.dependency.injection.UserHolder">
    <property name="user" ref="superUser" />
</bean>
```

此时更改superUser和User，就会有不同的结果



2、Java 注解配置元信息

主程序：AnnotationDependencySetterInjectionDemo

```java
@Bean
public UserHolder userHolder(User user) {
    UserHolder userHolder = new UserHolder();
    userHolder.setUser(user);
    return userHolder;
}
```

方法的依赖注入

如果前面不加

```java
String xmlResourcePath = "classpath:/META-INF/dependency-lookup-context.xml";
// 加载 XML 资源，解析并且生成 BeanDefinition
beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);
```

会报错：找不到



3、api配置元信息

主程序：ApiDependencySetterInjectionDemo

```java
private static BeanDefinition createUserHolderBeanDefinition() {
    BeanDefinitionBuilder definitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(UserHolder.class);
    definitionBuilder.addPropertyReference("user", "superUser");
    return definitionBuilder.getBeanDefinition();
}
```

关联bean的Reference，生成BeanDefinition，标准的Java代码的方式



**自动模式：**

1、byName

主程序AutoWiringByNameDependencySetterInjectionDemo

```xml
<bean class="org.geekbang.thinking.in.spring.ioc.dependency.injection.UserHolder"
          autowire="byType"
    >
<!--  <property name="user" ref="superUser" /> 替换成 autowiring 模式 -->
    </bean>
```

会有两个user。



2、byType

直接修改类型，由于定义了primary，所以就会找SuperUser。



## 6.5 构造器注入  

• 手动模式
		• XML 资源配置元信息
		• Java 注解配置元信息
		• API 配置元信息
• 自动模式
		• constructor  

**xml中修改constructor-arg**



**手动模式**

1、 XML 资源配置元信息

主程序XmlDependencyConstructorInjectionDemo

**重点：**

**xml文件中**

```xml
<bean class="org.geekbang.thinking.in.spring.ioc.dependency.injection.UserHolder">
    <constructor-arg name="user" ref="superUser" />
</bean>
```

在user的set中打断点



2、 Java 注解配置元信息

主程序AnnotationDependencyConstructorInjectionDemo





3、API 配置元信息

主程序ApiDependencyConstructorInjectionDemo

```java
private static BeanDefinition createUserHolderBeanDefinition() {
    BeanDefinitionBuilder definitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(UserHolder.class);
    definitionBuilder.addConstructorArgReference("superUser");
    return definitionBuilder.getBeanDefinition();
}
```

addConstructorArgReference可以根据构造器上面的参数的顺序来决定。



**自动模式**

xml文件修改

```xml
<bean class="org.geekbang.thinking.in.spring.ioc.dependency.injection.UserHolder"
      autowire="constructor">
    <!--        <property name="user" ref="superUser" /> 替换成 autowiring 模式 -->
</bean>
```

主程序AutoWiringConstructorDependencyConstructorInjectionDemo



## 6.6 字段注入  

实现方法
	• 手动模式
			• Java 注解配置元信息
				• @Autowired
				• @Resource
				• @Inject（可选）  



主程序AnnotationDependencyFieldInjectionDemo

```java
// 依赖查找 AnnotationDependencyFieldInjectionDemo Bean
AnnotationDependencyFieldInjectionDemo demo = applicationContext.getBean(AnnotationDependencyFieldInjectionDemo.class);

// @Autowired 字段关联
UserHolder userHolder = demo.userHolder;
System.out.println(userHolder);
System.out.println(demo.userHolder2);

System.out.println(userHolder == demo.userHolder2);
```

**注意问题：**

```java
@Bean
public UserHolder userHolder(User user) {
    return new UserHolder(user);
}
```

**这个和Autowired注入的字段不冲突，这个是注入bean，而注解bean也是一个bean。**

@Autowired 会忽略掉静态字段，只注入实例字段或者说是对象字段。

```java
@Resource
private UserHolder userHolder2;
```



## 6.7 方法注入  

手动模式
		• Java 注解配置元信息
		• @Autowired
		• @Resource
		• @Inject（可选）
		• @Bean  



## 6.14 依赖处理过程  

基础知识
		• 入口 - DefaultListableBeanFactory#resolveDependency
		• 依赖描述符 - DependencyDescriptor
		• 自动绑定候选对象处理器 - AutowireCandidateResolver

主程序AnnotationDependencyInjectionResolutionDemo



1、查看DefaultListableBeanFactory的resolveDependency方法，查看DependencyDescriptor

重点debug：

- resolveDependency中的descriptor描述信息的部分解释
- 进入doResolveDependency方法的findAutowireCandidates(beanName, type, descriptor)方法
- 进入findAutowireCandidates方法中candidateNames有两个
- 发现是matchingBeans的时候，matchingBeans.size() > 1，就会进入determineAutowireCandidate
- 其中的priorityCandidate就是superUser
- 往下走descriptor.resolveCandidate就会getBean



## 6.15 @Autowired注入的规则和原理

@Autowired 注入过程
		• 元信息解析
		• 依赖查找
		• 依赖注入（字段、方法）  



debug过程：

- 在resolveDependency方法第一行上打断点
- 从方法调用堆栈上可以看出上一步调用的是inject方法
- 这里面把依赖处理或者查找的结果的value，通过依赖注入找到对应的字段进行反射注入
- 

































  















