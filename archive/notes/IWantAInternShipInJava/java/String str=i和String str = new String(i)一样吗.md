tring str1 = “str1”：

1、 在栈中创建str1的引用。

2、 去常量池中查看是否有相同Unicode编码的字符串常量。如果有将str1指向该常量，如果没有则创建一个内容为”str1”的字符串常量，将str1的引用指向该常量。

3、 如果str1进行了赋值str1= “123”,则栈中的str1的引用指向新的内容为“123”的字符串常量。

4、 String str1 = “str1”; String str2 = “str1”;str2的引用指向常量池中已经存在的内容为“str1”的常量，不会重新创建新的常量，str1和str2的引用指向同一个常量。

str1 == str2; str1+”a” != str2+”a”;

String str1 = new String(“str1”)：

1、 在常量池中创建内容为“str1”的对象，在堆中创建内容为“str1”的对象。

2、 String str1 = new String(“str1”); String str2 = new String(“str1”);str2不会指向之前创建的对象，而是重新创建一个对象。

str1 != str2;

代码如下：

        String str1 = "str1";
        String str2 = "str1";
        String str3 = new String("str1");
        String str4 = new String("str1");
        System.out.println(str1==str2);//true地址一样
        System.out.println(str3==str4);//false,但地址不一样
        System.out.println(str3.equals(str4));//true,值一样
        System.out.println(str2.equals(str3));//true,值一样
        System.out.println((str1+"a")==(str2+"a"));//false;进行了+连接地址不一样
        System.out.println((str1+"a").equals((str2+"a")));//true;进行了+连接值一样
--------------------- 
作者：追魂嫖客 
来源：CSDN 
原文：https://blog.csdn.net/siqiangming/article/details/74452215 
版权声明：本文为博主原创文章，转载请附上博文链接！
