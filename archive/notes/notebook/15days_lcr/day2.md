---
topic: 最大公共子序列
date: 2017/10/17
labels: 最大公共子序列，递归
---

###何为最大公共子序列
子序列的形式化定义为：给定一个序列X={x1,x2,...,xm},另一个序列Z={z1,z2,...,zk}满足如下条件时称为X的子序列（subsequence）
即存在一个严格递增的X的下标序列（i1,i2,...,ik）,对所有j=1,2,...,k,满足Xij=Zj。

例如：Z={B,C,D,B}是X={A,B,C,B,D,A,B}的子序列，对应的下标序列为{2,3,5,7}；

给定两个序列X和Y,如果Z既是X的子序列，也是Y的子序列，我们称Z为X和Y的公共子序列（common subsequence）。

本节主要讨论如何用动态规划方法来高效地求解问题。

### 步骤1：刻画最长公共子序列的特征

** 定理 ** (LCS的最优子结构)：令X={x1,x2,...,xm}和Y={y1,y2,...,yn}为两个序列，Z={z1,z2,...,zk}为X和Y的任意LCS
    1. 如果xm=yn, 则zk=xm=yn且Zk-1是Xm-1和Yn-1的一个LCS。
    2. 如果xm!=yn,则zk!=xm意味着Z是Xm-1和Y的一个LCS。
    3. 如果xm!=yn,则Zk!=yn意味着Z是X和Yn-1的一个LCS。

### 步骤2：一个递归解

1. 如果xm=yn,我们应该求解Xm-1和Yn-1的一个LCS,然后将xm=yn追加到这个LCS的末尾得到X和Y的一个LCS。
2. 如果xm!=yn,必须分解为两个子问题：求Xm-1和Y的一个LCS与X和Yn-1的一个LCS。两个LCS较长者即为X和Y的一个LCS。

因此，该问题就是将一个问题分为子问题，是典型的动态规划问题。

### 步骤3：计算LCS的长度
LCS问题只有O(m*n)的子问题，我们可以用动态规划自底向下的地计算。

```
LCS-LENGTH(X,Y)
1 m=X.length
2 n=Y.length
3 let b[1..m,1..n] and c[0..m,0..n]be new tables
4 for i=1 to m
5    c[i,0]=0
6 for j=0 to n
7    c[0,j]=0
8 for i=1 to m
9   for j=1 to n
10      if xi==yj
11         c[i,j]=c[i-1,j-1]+1
12         b[i,j]="左斜向上箭头"
13      elseif c[i-1,j]>=c[i,j-1]
14         c[i,j]=c[i-1,j]
15         b[i,j]="向上箭头"
16      else c[i,j]=c[i,j-1]
17         b[i,j]="向左箭头"
18 return c and b
```

### 构造LCS

我们可以用LCS-LENGTH返回的表b快速构造X={x1,x2,...,xm}和Y={y1,y2,...,yn}的LCS，只需简单地从b[m,n]开始，并按箭头方向追踪下去即可。
当在表项b[i,j]中遇到一个“左斜向上箭头”时，就意味着xi=yj是LCS的一个元素。按照这种方法，我们可以按逆序依次构造出LCS的所有元素。

下面的递归过程会按照正确的顺序打印出X和Y的一个LCS。起始调用为PRINT-LCS(b,X,X.length,Y.length)。

```
PRINT-LCS(b,X,i,j)
1 if i==0 or j==0
2    return
3 if b[i,j]=="左斜向上箭头"
4    PRINT-LCS(b,X,i-1,j-1)
5    print xi
6 elseif b[i,j]=="向上箭头"
7    PRINT-LCS(b,X,i-1,j)
8 else PRINT-LCS(b,X,i,j-1)

```

---
### 算法改进
一旦设计出一个算法，通常情况下你都会发现它在时空开销上有改进的余地。

例如对于LCS算法，我们可以去掉表b。每个c[i,j]项只依赖于表c的其他三项：c[i-1,j]、c[i,j-1]和c[i-1,j-1]。给定c[i,j]的值，我们可以在O(1)时间内判断出在计算c[i,j]时使用了这三项中的哪一项。
