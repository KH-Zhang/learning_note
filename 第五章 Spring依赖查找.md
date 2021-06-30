# 第五章 Spring依赖查找

## 5.1 单一类型依赖查找  

**单一类型依赖查找接口 - BeanFactory**
• 根据 Bean 名称查找
		• getBean(String)
		• Spring 2.5 覆盖默认参数：getBean(String,Object...)
• 根据 Bean 类型查找
		• Bean 实时查找
				• Spring 3.0 getBean(Class)
				• Spring 4.1 覆盖默认参数：getBean(Class,Object...)
		• Spring 5.1 Bean 延迟查找
				• getBeanProvider(Class)
				• getBeanProvider(ResolvableType)
• 根据 Bean 名称 + 类型查找：getBean(String,Class)  



主程序ObjectProviderDemo：

定义两个Bean

```java
@Bean
@Primary
public String helloWorld() {
    return "hello,World";
}

@Bean
public String message() {
    return "Message";
}
```

```java
private static void lookupByObjectProvider(AnnotationConfigApplicationContext applicationContext) {
    ObjectProvider<String> beanProvider = applicationContext.getBeanProvider(String.class);
    System.out.println(beanProvider.getObject());
}
```



## 5.2 根据集合类型查找

**集合类型依赖查找接口 - ListableBeanFactory**
• 根据 Bean 类型查找
		• 获取同类型 Bean 名称列表
				• getBeanNamesForType(Class)
				• Spring 4.2 getBeanNamesForType(ResolvableType)
		• 获取同类型 Bean 实例列表
				• getBeansOfType(Class) 以及重载方法
• 通过注解类型查找
		• Spring 3.0 获取标注类型 Bean 名称列表
				• getBeanNamesForAnnotation(Class<? extends Annotation>)
		• Spring 3.0 获取标注类型 Bean 实例列表
				• getBeansWithAnnotation(Class<? extends Annotation>)
		• Spring 3.0 获取指定名称 + 标注类型 Bean 实例
				• findAnnotationOnBean(String,Class<? extends Annotation>)****  



**这一节需要重新学习**



## 5.3 层次性依赖查找

**层次性依赖查找接口 - HierarchicalBeanFactory**
• 双亲 BeanFactory：getParentBeanFactory()
• 层次性查找
		• 根据 Bean 名称查找
				• 基于 containsLocalBean 方法实现
		• 根据 Bean 类型查找实例列表
				• 单一类型：BeanFactoryUtils#beanOfType
				• 集合类型：BeanFactoryUtils#beansOfTypeIncludingAncestors
		• 根据 Java 注解查找名称列表
				• BeanFactoryUtils#beanNamesForTypeIncludingAncestors  



主程序HierarchicalDependencyLookupDemo



首先看HierarchicalBeanFactory

```java
@Nullable
BeanFactory getParentBeanFactory();

boolean containsLocalBean(String name);
```

只有这两个方法，没有ListableBeanFactory

子接口ConfigurableBeanFactory包含

查看ConfigurableListableBeanFactory，即是可罗列的，又是层次性的实现。



**根据 Bean 名称查找**

1. 首先，获取 HierarchicalBeanFactory <- ConfigurableBeanFactory <- ConfigurableListableBeanFactory

2. 设置 Parent BeanFactory，查看主程序中的方法createParentBeanFactory

3. ```java
   displayContainsLocalBean(beanFactory,"user");
   displayContainsLocalBean(parentBeanFactory,"user");
   ```

   分别是当前的BeanFactory和parent BeanFactory实现，可以得出结论：containsLocalBean方法的实现是查找当前层级的Bean。

4. ```java
   displayContainsBean(beanFactory,"user");
   displayContainsBean(parentBeanFactory, "user");
   ```

   采用递归的方式，首先查看是否有父类，

   ```java
   private static boolean containsBean(HierarchicalBeanFactory beanFactory, String beanName) {
       BeanFactory parentBeanFactory = beanFactory.getParentBeanFactory();
       if (parentBeanFactory instanceof HierarchicalBeanFactory) {
           HierarchicalBeanFactory parentHierarchicalBeanFactory = HierarchicalBeanFactory.class.cast(parentBeanFactory);
           if (containsBean(parentHierarchicalBeanFactory,beanName)) {
               return true;
           }
       }
       return beanFactory.containsLocalBean(beanName);
   }
   ```

   parentBeanFactory instanceof HierarchicalBeanFactory ：即判断了类型，也判断是否为空



**根据 Bean 类型查找实例列表**

查看源码：BeanFactoryUtils#beansOfTypeIncludingAncestors



## 5.4 延迟依赖查找  

**Bean 延迟依赖查找接口**
• org.springframework.beans.factory.ObjectFactory
• org.springframework.beans.factory.ObjectProvider
		• Spring 5 对 Java 8 特性扩展
			• 函数式接口
				• getIfAvailable(Supplier)
				• ifAvailable(Consumer)
		• Stream 扩展 - stream()  



1. 首先查看ObjectProvider接口中T getObject(Object... args) 方法，同时继承ObjectFactory中的getObject方法。

2. 主程序ObjectProviderDemo#lookupIfAvailable方法：

   其中的userObjectProvider.getIfAvailable(User::createUser);是一个函数式接口，如果当前BeanFactory中没有就创建这个Bean。

   ```java
   private static void lookupIfAvailable(AnnotationConfigApplicationContext applicationContext) {
       ObjectProvider<User> userObjectProvider = applicationContext.getBeanProvider(User.class);
       //User user = userObjectProvider.getIfAvailable(() -> User.createUser());
       User user = userObjectProvider.getIfAvailable(User::createUser);
       System.out.println("当前 User 对象：" + user);
   }
   ```

3. 主程序ObjectProviderDemo#llookupByStreamOps操作：

   ```java
   private static void lookupByStreamOps(AnnotationConfigApplicationContext applicationContext) {
       ObjectProvider<String> objectProvider = applicationContext.getBeanProvider(String.class);
       /*Iterable<String> stringIterable = objectProvider;
       for (String string : stringIterable) {
          System.out.println(string);
       }*/
   
       objectProvider.stream().forEach(System.out::println);
   }
   ```

   



## 5.5 安全依赖查找  

依赖查找安全性对比  :

| 依赖查找类型 | 代表实现                           | 是否安全 |
| ------------ | ---------------------------------- | -------- |
| 单一类型查找 | BeanFactory#getBean                | 否       |
|              | ObjectFactory#getObject            | 否       |
|              | ObjectProvider#getIfAvailable      | 是       |
| 集合类型查找 | ListableBeanFactory#getBeansOfType | 是       |
|              | ObjectProvider#stream              | 是       |



主程序TypeSafetyDependencyLookupDemo

第一种：

```java
// 演示 BeanFactory#getBean 方法的安全性
displayBeanFactoryGetBean(applicationContext);
```

查看beanFactory.getBean(User.class)中的getBean方法的解释：

```java
* @throws NoSuchBeanDefinitionException if no bean of the given type was found
* @throws NoUniqueBeanDefinitionException if more than one bean of the given type was found
* @throws BeansException if the bean could not be created
```

该案例是NoSuchBeanDefinitionException。



第二种：

```java
// 演示 ObjectFactory#getObject 方法的安全性
displayObjectFactoryGetObject(applicationContext);
```

也会抛出NoSuchBeanDefinitionException异常。



第三种：

```java
// 演示 ObjectProvider#getIfAvaiable 方法的安全性
displayObjectProviderIfAvailable(applicationContext);
```

是安全的，没有打印出异常。



第四种：

```java
// 演示 ListableBeanFactory#getBeansOfType 方法的安全性
displayListableBeanFactoryGetBeansOfType(applicationContext);
```



第五种：

```java
// 演示 ObjectProvider Stream 操作的安全性
displayObjectProviderStreamOps(applicationContext);
```

























