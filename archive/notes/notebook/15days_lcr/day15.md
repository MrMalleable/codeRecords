---
title: 数据结构与java类集框架
date: 2017/10/30
labels: 数据结构
---
one important application of this principle of data abstraction is that if class A uses class B, then class A's methods should not access class B's fields.

```
import java.util.*
class Employeee{
    private static final String EMPTY_STRING="";
    private static final String NAME_SENTINEL="***";
    private static final double GROSS_PAY_SENTINEL= -1.00;
    private String name;
    private double grossPay;

    //postcondition: this employee has been initialized: the name is an empty string and the gross pay is 0.00
    public Employee(){
       name=EMPTY_STRING;
    }//default constructor

    //postcondition: this employee has been initialized from s, which consists of a name and gross pay, with at least one blank in between.
    public Employee(String s){
       StringTokenizer tokens=new StringTokenizer(s);
       name=tokens.nextToken();
       grossPay=Double.parseDouble(tokens.nextToken());
    }

    //postcondition: true has been returned if this employee is the senitel. Otherwise ,false has been returned.
    public boolean isSenitel(){
       if(name.equals(NAME_SENTINEL)&& grossPay == GROSS_PAY_SENTINEL){
          return true;
       }
       return false;
    }
    
    //postcondition: if the employee's gross pay is larger than otherEmployee's gross pay, true has been returned. Otherwise, false has been returned.
    public boolean makesMorethan(Employee otherEmployee){
       return grossPay > otherEmployee.grossPay;
    }

    //postcondition: a String representatin of this employee's name and gross pay has been returned in the form <name$gross pay>
    public String toString(){
       finale String DOLLAR_SIGN="$";
       return name+DOLLAR_SIGN+grossPay;
    }
}
```

当我们想要去修改一个已经被很多其他类使用了的类的定义时，这是一种比较不推荐的操作。这被成为open-closed原则：**Every class should be open(extendible through inheritance) and closed(stable for existing applications)**.

所以最好的办法是重新定义一个新的类继承该类，然后在新定义的类中添加你的修改。

**subclass substitution rule**: whenever a reference-to-superclass-object is called for in an expression, a referrence-to-subclass-object may be substituted.

面向对象的三大特性：
1. 封装（encapsulation）
2. 继承（inheritance）
3. 多态（polymorphism） the ability of a reference to refer to different objects

课后习题：

---
changelog:2017/10/30 第一章java基本语法
