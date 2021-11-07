# Java集合框架高级应用

## 一、空集合接口（Collections.empty*）  

• 枚举： Collections.emptyEnumeration()
• 迭代器器： emptyIterator()、 emptyListIterator()
• List： emptyList()
• Set: emptySet()、 emptySortedSet()、 emptyNavigableSet()
• Map： emptyMap()、 emptySortedMap()、 emptyNavigableMap()  

1、代码示例
EmptyCollectionDemo

```java
public static void main(String[] args) {

    // 对自己（严格）：所有的返回接口类型的方法禁止返回 null
    // 对别人（宽容）：要做 null 判断（尤其在 RPC 场景）

    // 集合方法入参：
    // 1. 如果能用 Iterable 尽量用
    // 2. 其次是 Collection
    // 3. 再者是 List 或 Set
    // 禁止使用具体类型，比如：ArrayList，LinkedHashSet
}

public static List<String> getIdsList(String name) {
    if(name ==null || name.length() < 1){
        return Collections.emptyList();
    }
    // 只读 empty List
    // 实现 Java 序列化
    return Collections.emptyList();
}
```



## 二、转换集合接口（Collections.*、 Arrays.*）  

• Enumeration: Collections.enumeration(Collection)
• List: Collections.list(Enumeration<T>)、 Arrays.asList(T…)
• Set: Collections.newSetFromMap(Map<E, Boolean>)
• Queue: Collections.asLifoQueue(Deque<T>)
• HashCode: Arrays.hashCode(…)
• String: Arrays.toString(…)  



## 三、列举集合接口（*.of(…)）  

• java.util.BitSet.valueOf(…)
• java.util.EnumSet.of(…) （Since 1.5）
• java.util.Stream.of(…) （Since 1.8）
• java.util.List.of(…) （Since 9）
• java.util.Set.of(…) （Since 9）
• java.util.Map.of(…) （Since 9）  



## 四、Java 集合包装实现  

基本介绍
Add functionality, such as synchronization, to other implementations.
功能性添加，⽐比如同步以及其他实现
• 设计原则： Wrapper 模式原则，⼊入参集合类型与返回类型相同或者其子类
• 主要⼊入口
• java.util.Collections  

包装接口类型
• 同步包装接口（java.util.Collections.synchronized*）
• 只读包装接口（java.util.Collections.unmodifiable*）
• 类型安全包装接口（java.util.Collections.checked*）  



checked的设计，主程序：CheckedTypeCollectionDemo：

```java
public static void main(String[] args) {
        // List 元素类型是 java.lang.Integer
        List<Integer> values = new ArrayList<>(Arrays.asList(1, 2, 3));
//        values.add("1"); // 编译错误
        // 泛型是编译时检查，运行时擦写

        // 引用 List<Integer> 类型的对象 values
        List referencedValues = values;

        System.out.println(referencedValues == values);

        referencedValues.add("A"); // 添加 "A" 进入 List<Integer> values

        // 运行时的数据 List<Integer>  == List<Object> == List
        // values.add("1") // 运行时允许，因为成员类型是 Object

        for (Object value : values) {
            System.out.println(value);
        }

        // values
        // [0] = 1, [1] = 2, [2] = 3, [3] = "A"
        // 创建时尚未检查内部的数据是否类型相同，操作时做检查，Wrapper 模式（装饰器模式）的运用
        // Collections.checked* 接口是弥补泛型集合在运行时中的擦写中的不足
        // 强约束：编译时利用 Java 泛型、运行时利用  Collections.checked* 接口
        List<Integer> checkedTypeValues = Collections.checkedList(values, Integer.class);
//        checkedTypeValues.add("1"); // 编译错误
        // 运行时检查

        // 又将 checkedTypeValues 引用给 referencedValues
        referencedValues = checkedTypeValues;

        System.out.println(referencedValues == values);

        System.out.println(referencedValues == checkedTypeValues);

        // 添加 "B" 进入 referencedValues
        referencedValues.add("B");


    }
```

- Collections.checked* 接口是弥补泛型集合在运行时中的擦写中的不足

























