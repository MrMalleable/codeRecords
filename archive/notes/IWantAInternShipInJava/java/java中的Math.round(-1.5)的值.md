答案为-1

将括号内的数+0.5之后，向下取值.

看Math.round()内的实现，但JDK1.8内代码有点多（不知道其他版本的是怎样的），但其真正的意思也就是如下：
public static int round(float a) {
return (int)floor(a + 0.5f);
}

public static long round(double a) {
return (long)floor(a + 0.5d);
}
看到有两个重载的方法，一个接收float类型返回int类型，另一个接收double类型返回long类型，这也很好理解，float和int都是占4个字节，double和long占8个字节，这样精度就没有丢失。但平时使用的时候还是要注意，因为实际应用中最常用double和int，所以可能需要转换。
1）从上面的两个方法可以看出，都是对数字加0.5后在再floor()方法
2）floo()方法的原理：取小于等于参数的最大整数浮点数（可以理解为向下取整数浮点数），如floor(12.5)=12.0，floor(12.9)=12.0，floor(-12.5)=-13.0，floor(-12.9)=-13.0。
3、结论
Math中的round方法，求的值就是取小于等于（参数+0.5）的最大整数。
---------------------
作者：三只小奶狗
来源：CSDN
原文：https://blog.csdn.net/rt12345678910/article/details/78009529
版权声明：本文为博主原创文章，转载请附上博文链接！
