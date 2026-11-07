---
topic: 堆排序
date: 2017/10/16
label: 堆，堆的性质，建堆，堆排序算法，优先队列
---
堆排序的时间复杂度为： O(logn)

堆排序具有空间原址性：任何时候都只需要常数个额外的元素空间存储临时数据。

### 堆的概念
1. 二叉堆是一个数组，根节点在arr[0], 一般有最大堆和最小堆。最大堆就是除根节点外的每个结点的父节点比自身要大或相等，最小堆同理。

2.对于第i个节点的元素，arr[i-1/2]为其父节点，arr[2*i+1]为其左孩子，arr[2*i+2]为其右孩子。

在**堆排序算法**中，我们使用的是**最大堆**。

一般**最小堆**通常用于构造优先队列。

### 维护堆的性质

MAX-HEAPIFY是用于维护最大堆性质的重要过程。

```

//The implementation of maxheapify in java
//下标是从0开始的

public int parent(int i) { return (i-1)/2; }

// to get index of left child of node at index i
public int left(int i) { return (2*i + 1); }

// to get index of right child of node at index i
public int right(int i) { return (2*i + 2); }

public void maxheapify(int[] arr, int i){
  int left=left(i);
  int right=right(i);
  int largest=i; //假设当前节点是最大的
  if (left < arr.length && arr[left] > arr[i]){
    largest=left;  //如果左孩子比当前节点大，则将最大的节点的下标设为left
  }
  if(right < arr.length && arr[right] > arr[largest]){
    largest=right;
  }
  if(largest != i){
    swap(arr[largest],arr[i]); //如果当前结点不是最大的，则交换
    maxheapify(arr,largest); //继续对新的最大节点开始递归最大堆化
  }
}

```

### 建堆
伪代码：

```
build-max-heap(A)
1 A.heap-size = A.length
2 for i = A.length/2 downto 1
3    maxheapify(A,i)
```

分析：

因为A([n/2]+1..n)中的元素都是树的叶结点，每个叶结点都相当于只包含一个元素的最大堆，这就不用再遍历这些结点了。
建堆的时间复杂度是：O(n)

### 堆排序算法
主要思想：
堆排序算法利用build-max-heap将输入数组A[1..n]建成最大堆，其中n=A.length。因为数组中的最大元素总在根节点A[1]中，通过把它与A[n]交换
，我们可以让该元素放到正确的位置。这时候，如果我们从堆中去掉结点n(这一操作可以通过减少A.heap-size的值来实现)，剩余的节点中，原来根的孩子节点还是最大堆，而
新的节点可能会违背最大堆的性质。为了维护最大堆的性质，调用maxheapify(A,1)，从而在A[1..n-1]上构造一个新的最大堆。也就是说每次将最大堆的元素放到堆后面的一个元素，然后重新
调整堆成为最大堆，这样的话最后从左往右就是从小到大的顺序了。

堆排序算法一直重复这过程，直到堆的大小从n-1降到2.画图比较容易理解。

### 优先队列
有最大优先队列和最小优先队列之分。
我们这里关注基于最大堆的最大优先队列。

优先队列是一种用来维护由一组元素构成的集合S的数据结构，其中的每一个元素都有一个相关的值，成为关键字。

一个最大优先队列支持以下操作：

insert(S,x):将x插入到集合S中

maximum(S):返回S中具有最大键字的元素。

extractMax(S): 去掉并返回S中的具有最大键字的元素。

increaseKey(S,x,k): 将元素x的关键字值增加到k,这里假设k的值不小于x的原关键字值。

对于以上操作：返回最大键字的元素就是将数组的第一个元素返回即可。

去掉最大键字的元素：和堆排序算法类似

```
heap-extract-max(A)
1 if A.heap-size < 1
2     error "heap underflow"
3 max=A[1]
4 A[1]=A[A.heap-size]
5 A.heap-size = A.heap-size -1
6 MaxHeapify(A,1)
7 return max
```

increasekey操作：

```
heap-increasekey(A,i,key)
1 if key < A[i]
2    error"new key is smaller than current key"
3 A[i]=key
4 while i > 1 and A[parent(i)] < A[i]
5      exchange A[i] with A[parent(i)]
6      i=parent(i)
```

insert操作：

```
max-heap-insert(A,key)
1 A.heap-size = A.heap-size + 1
2 A[A.heap-size]=负无穷
3 heap-increkey(A,A.heap-size,key)
```

---
主要就是要掌握最大堆的性质，每次从堆中删除了元素就应该重新调整堆成为最大堆。
