---
title: 基数排序
date: 2017/10/26
label: 排序，卡片排序机
---
radix sort是一种用在卡片排序机上的算法。

对十进制数字来说，每列只会用到10个位置（另外两个位置用于编码非数值字符）。一个d位数将占用d位。因为卡片排序机一次只能查看一列，所以需要对n张卡片上的d位进行排序。

基数排序算法是稳定的。

```
RADIX-SORT(A,d)
1 for i=1 to d
2   use a stable sort to sort array A on digit i

```

---

