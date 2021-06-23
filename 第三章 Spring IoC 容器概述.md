# 第三章 Spring IoC 容器概述  

## 3.1 Spring IoC 依赖查找   

• 根据 Bean 名称查找
		• 实时查找
		• 延迟查找
• 根据 Bean 类型查找
		• 单个 Bean 对象
		• 集合 Bean 对象
• 根据 Bean 名称 + 类型查找
• 根据 Java 注解查找
		• 单个 Bean 对象
		• 集合 Bean 对象  

主程序DependencyLookupDemo

**1.根据Bean名称**

- 实时查找：

```Java
private static void lookupInRealTime(BeanFactory beanFactory) {
        User user = (User) beanFactory.getBean("user");
        System.out.println("实时查找" + user);
 }
```

- 延时查找：

查看ObjectFactory，有一个FactoryBean的实现ObjectFactoryCreatingFactoryBean。

里面有个targetBeanName，需要关联user,帮助我们间接的获取，当我们获取到ObjectFactory时，并不是立刻初始化或者马上去get这个bean。

```java
private static void lookupInLazy(BeanFactory beanFactory) {
    ObjectFactory<User> objectFactory = (ObjectFactory<User>)beanFactory.getBean("objectFactory");
    User user = objectFactory.getObject();
    System.out.println("延时查找" + user);
}
```



**2.根据 Bean 类型查找**

- 单个 Bean 对象：

```java
private static void lookupByType(BeanFactory beanFactory) {
    User user = beanFactory.getBean(User.class);
    System.out.println("按照类型查找" + user);
}
```

此时xml中只有user和objectFactory，objectFactory没有生成新的bean。

打印的结果只有一个user。



- 集合 Bean 对象

```Java
private static void lookupCollectionByType(BeanFactory beanFactory) {
    if (beanFactory instanceof ListableBeanFactory) {
        ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
        Map<String, User> user = listableBeanFactory.getBeansOfType(User.class);
        System.out.println("查找所用的User集合对象" + user);
    }
}
```

查看getBeansOfType方法返回的Map，会把bean的名称作为key(id)，相关的实例作为value(内容),

打印结果也是一个user。



**3.根据 Bean 名称 + 类型查找**

不再演示



**4.根据 Java 注解查找**

新建超级用户：

```Java
public class SuperUser extends User {
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "SuperUser{" +
                "address='" + address + '\'' +
                "} " + super.toString();
    }
}
```

未来区分user和superUser，新建一个注解：

```java
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Super {

}
```

在superUser类上加注解。

在xml中新增Bean:

```xml
<bean id="SuperUser" class="ioc.overview.domain.SuperUser" parent="user" primary="true">
    <property name="address" value="杭州" />
</bean>
```

此时根据类型查找会报错，有两个user，需要在xml中加上primary="true"。

主程序：

```java
private static void lookupByAnnotationType(BeanFactory beanFactory) {
    if (beanFactory instanceof ListableBeanFactory) {
        ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
        Map<String, User> user = (Map) listableBeanFactory.getBeansWithAnnotation(Super.class);
        System.out.println("查找标注@Super 的所用的User集合对象" + user);
    }
}
```

因为也是集合类型，所以也使用ListableBeanFactory。



## 3.2 Spring IoC 依赖注入  

• 根据 Bean 名称注入
• 根据 Bean 类型注入
		• 单个 Bean 对象
		• 集合 Bean 对象
• 注入容器內建 Bean 对象
• 注入非 Bean 对象
• 注入类型
		• 实时注入
		• 延迟注入  

主程序：DependencyinjectionDemo



**1.根据 Bean 名称注入**

新建用户仓库：

```java
public class UserRepository {

    private Collection<User> users; // 自定义bean
    
    //get、set
}
```



