---
title: 栈和队列
date: 2017/10/23
labels: 压入，入队
---
栈和队列是我们很熟悉的常用的数据结构。

对于栈来说，是后进先出（FILO）策略。
对于队列来说是先进先出（FIFO）策略。

根据这样的思想我们可以利用数组来实现栈，首先向栈中插入元素成为压入（push），从栈中删除元素称为弹出（pop）,我们用一个指针top来指向栈顶，即最新插入的元素。

当top=0代表栈为空，即没有元素。

```
//判断栈为空
STACK-EMPTY(S)
1 if S.top == 0
2   return true
3 else return false

//压入
PUSH(S,x) //x代表要插入的元素
1 S.top = S.top + 1
2 S[S.top] = x

//弹出
POP(S)  
1 if STACK-EMPTY(S)  //如果栈为空则抛出异常
2   error "underflow"
3 else S.top = S.top -1
4   return S[S.top+1]
```

队列的插入叫做入队（ENQUEUE），删除元素叫做出队（DEQUEUE），队列需要设置tail和head两个指针指向头元素和尾元素。

```
//入队
ENQUEUE(Q,x)
1 Q[Q.tail] = x
2 if Q.tail == Q.length
3    Q.tail = 1
4 else Q.tail = Q.tail + 1

//出队
DEQUEUE(Q)
1 x = Q[Q.head]
2 if Q.head = Q.length
3    Q.head = 1
4 else Q.head = Q.head + 1
5 return x

```
