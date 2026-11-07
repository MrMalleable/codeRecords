---
topic: 计数排序
date: 2017/10/25
labels: 排序
---
今天本来打算不写了这么晚了，但是一想到就此中断了的话，在明天的我看来就是一个遗憾了，因为昨天是回不来了，所以即使是写的很少很差，还是想坚持下来。因为慢慢坚持下来最后就会认真地思考自己做的不好的地方。

如果连坚持都做不到，更不用谈质量的好坏，我是这么想的。

---
计数排序假设n个输入元素的每一个都是在0和k区间内的一个整数，其中k是某个整数。

## 基本思想
对每一个输入元素x，确定小于x的元素个数。利用这个信息，就可以直接把x放到它在输出数组的位置上了。当有几个元素相同时，这一方案需要略微修改。因为不能把它们放在同一个输出位置上。

伪代码如下;假设输入的是一个数组A[1..n],A.length=n.我们还需要两个数组：B[1..n]存放排序的输出，C[0..k]提供临时存储空间

```
COUNT-SORT(A,B,k)
1 let C[0..k] be a new array
2 for i=0 to k
3    C[i]=0
4 for j=1 to A.length
5    C[A[j]]=C[A[j]]+1
6 //C[i] now contains the number of elements equal to i
7 for i=1 to k
8    C[i]=C[i]+C[i-1]
9 //C[i] now contains the number of elements less than or equal to i.
10 for j=A.length downto 1
11    B[C[A[j]]]=A[j]
12    C[A[j]]=C[A[j]]-1
```
---
