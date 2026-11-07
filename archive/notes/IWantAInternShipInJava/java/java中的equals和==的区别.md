1. 对于==号来说，需要区分比较的对象是基本数据类型还是java里面的类。

如果是基本数据类型，那么==比较的是两个变量的值是否相等

如果是java里面的类的话，那么比较的是两个变量所指向的对象的地址。

2. equals方法只适用于java对象。基本数据类型没有这个方法

我们都知道所有的java类的基类都是Object，如果不重写该方法的话比较的是两个对象的地址。

```java
public boolean equals(Object oj){
   return (this == obj);
}
```


对于我们常用的字符串比较，如果要比较字符串的值是否相等，那么必须使用str1.equals(str2),而不能使用str1==str2.

可以去看一下String.equals方法的具体代码。

end

----

