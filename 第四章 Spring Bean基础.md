# 第四章 Spring Bean基础

## 4.1 定义 Spring Bean  

• 什么是 BeanDefinition？
• BeanDefinition 是 Spring Framework 中定义 Bean 的配置元信息接口，包含：
		• Bean 的类名
		• Bean 行为配置元素，如作用域、自动绑定的模式，生命周期回调等
		• 其他 Bean 引用，又可称作合作者（collaborators）或者依赖（dependencies）
		• 配置设置，比如 Bean 属性（Properties）  

![image-20210627153143405](C:\Users\KeHe\AppData\Roaming\Typora\typora-user-images\image-20210627153143405.png)



• BeanDefinition 构建
		• 通过 BeanDefinitionBuilder
		• 通过 AbstractBeanDefinition 以及派生类  



主程序BeanDefinitionCreationDemo：

```java
public static void main(String[] args) {

    // 1.通过BeanDefinitionBuilder 构建
    BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
    // 通过属性设置
    beanDefinitionBuilder.addPropertyValue("id",1);
    beanDefinitionBuilder.addPropertyValue("name","aaa");
    // 获取BeanDefinition 实例
    BeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
    // BeanDefinition并非Bean最终状态，可以自定义修改

    // 2.通过 AbstractBeanDefinition以及派生类
    GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
    // 设置Bean
    genericBeanDefinition.setBeanClass(User.class);
    MutablePropertyValues propertyValues = new MutablePropertyValues();
    /*propertyValues.addPropertyValue("id",1);
    propertyValues.addPropertyValue("name","aaa");*/

    propertyValues.add("id",1).add("name","aaa");
    genericBeanDefinition.setPropertyValues(propertyValues);

}
```



其中，beanDefinitionBuilder.getBeanDefinition();的getBeanDefinition返回的对象是AbstractBeanDefinition抽象类





## 4.2 Spring Bean 的别名  

主程序BeanAliasDemo：

```java
public static void main(String[] args) {

    BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/bean-definitions-context.xml");

    //通过别名xiaomage-user获取曾用名user的bean
    User xiaomageUser = beanFactory.getBean("xiaomage-user", User.class);
    User user = beanFactory.getBean("user", User.class);
    System.out.println(user == xiaomageUser);

}
```





## 4.3 注册 Spring Bean  

![image-20210627165224331](C:\Users\KeHe\AppData\Roaming\Typora\typora-user-images\image-20210627165224331.png)



**通过Java注解的方式**

注解 BeanDefinition 示例，主程序：AnnotationBeanDefinitionDemo

- 使用到的是AnnotationConfigApplicationContext。



1、通过 @Bean 方式定义

```java
public static class Config{

    /**
     *  // 1. 通过 @Bean 方式定义
     * 通过java注解的方式定义一个bean
     */
    @Bean(name = {"user","xiaomage-user"})
    public User user() {
        User user = new User();
        user.setId(1L);
        user.setName("aaa");
        return user;
    }
}
```



2、通过 @Component 方式定义

```java
// 2. 通过 @Component 方式定义
@Component //定义当前类作为Spring bean组件
public static class Config{

    /**
     *  // 1. 通过 @Bean 方式定义
     * 通过java注解的方式定义一个bean
     */
    @Bean(name = {"user","xiaomage-user"})
    public User user() {
        User user = new User();
        user.setId(1L);
        user.setName("aaa");
        return user;
    }
}
```



3、通过 @Import 来进行导入

```java
@Import(AnnotationBeanDefinitionDemo.Config.class) // 3. 通过 @Import 来进行导入
```

所以会有重复的定义？

```Java
// 按照类型进行查找,不会重复注册
/**
 * bean的名称的定义 {@link AnnotationBeanNameGenerator}
 */
System.out.println("Config类型所有的 Beans：" + applicationContext.getBeansOfType(Config.class));
System.out.println("User类型所有的 Beans：" + applicationContext.getBeansOfType(User.class));
```

结论：按照类型查找是不会重复注册的



**通过javaAPI的方式**

解释前面两种，命名方式  和 非命名方式  

```java
// 1.命名bean注册方式
registerUserBeanDefinition(applicationContext,"mercyblitz-user");
// 2.非命名bean注册方式
registerUserBeanDefinition(applicationContext);
```



```Java 
public static void registerUserBeanDefinition(BeanDefinitionRegistry registry,String beanName) {
    BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
    beanDefinitionBuilder
            .addPropertyValue("id",1L)
            .addPropertyValue("name","小马哥");

    // 判断 如果beanName 参数存在时，
    if (StringUtils.hasText(beanName)) {
        // 注册BeanDefinition
        registry.registerBeanDefinition(beanName,beanDefinitionBuilder.getBeanDefinition());
    } else {
        BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinitionBuilder.getBeanDefinition(),registry);
    }
}
```

重点：

```java
// 判断 如果beanName 参数存在时，
if (StringUtils.hasText(beanName)) {
    // 注册BeanDefinition
    registry.registerBeanDefinition(beanName,beanDefinitionBuilder.getBeanDefinition());
} else {
    BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinitionBuilder.getBeanDefinition(),registry);
}
```



## 4.4 实例化 Spring Bean  

![image-20210627192509106](C:\Users\KeHe\AppData\Roaming\Typora\typora-user-images\image-20210627192509106.png)

**常规方式**

主程序BeanInstantiationDemo：

```java
public static void main(String[] args) {
    BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/bean-instantiation-context.xml");
    User user1 = beanFactory.getBean("user-by-static-method", User.class);
    User user2 = beanFactory.getBean("user-by-instance-method", User.class);
    User user3 = beanFactory.getBean("user-by-factory-bean", User.class);
    System.out.println(user1);
    System.out.println(user2);
    System.out.println(user3);
    System.out.println(user1 == user2);

}
```

```xml
<!--静态方法实例化 Bean-->
<bean id="user-by-static-method" class="ioc.overview.domain.User"
      factory-method="createUser"/>

<!--实例（Bean）方法实例化 Bean-->
<bean id="user-by-instance-method" factory-bean="userFactory" factory-method="createUser"/>

<!--FactoryBean实例化 bean-->
<bean id="user-by-factory-bean" class="bean.factory.UserFactoryBean"/>

<bean id="userFactory" class="bean.factory.DefaultUserFactory"/>
```

三种实现方式。



**特殊方式**

主程序SpecialBeanInstantiationDemo





























