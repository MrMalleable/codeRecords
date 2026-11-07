---
topic: 插入排序
date: 2017/10/21
labels: 插入排序，循环不变式
---
就像打牌一样，我们每抓到一张牌，我们都会根据自己的习惯一般会按照从小到大的顺序插到相应的位置。

其实插入排序就是这样的思想：

从第二个元素开始，默认第一个元素是有序的，这样每次前面的元素都是有序的，找到相应的插入位置插入即可。

其伪代码为：

```
INSERTION-SORT(A):
1 for j =2 to A.length
2   key = A[j]
3   //Insert A[j] into the sorted sequence A[1..j-1]
4   i = j-1
5   while i>0 and A[i] > key
6       A[i+1] = A[i]
7       i = i -1
8   A[i+1] = key
```
