# AlgorithmAndDataStructure
算法与数据结构记录

### [Red and Black Tree](https://github.com/buildupchao/AlgorithmAndDataStructure/tree/master/src/main/java/com/buildupchao/datastructure/basic/tree/rb)

### Heap

- [SmallHeadHeap](https://github.com/buildupchao/AlgorithmAndDataStructure/tree/master/src/main/java/com/buildupchao/datastructure/basic/heap)

- [HeapSort](https://github.com/buildupchao/AlgorithmAndDataStructure/tree/master/src/main/java/com/buildupchao/algorithm/newsort/heap)

### [Dynamic Programming](https://github.com/buildupchao/AlgorithmAndDataStructure/tree/master/src/main/java/com/buildupchao/algorithm/dynamic)

### 快速排序算法

- 时间复杂度（nlog2(n)）

- 算法思想：分而治之

  QuickSort伪代码:
  ```bash
  QuickSort(A, low, high)
    if low < high
      then q = Partition(A, low, high)
           QuickSort(A, low, q - 1)
           QuickSort(A, q + 1, high)

  ```

  Partition伪代码:
  ```bash
  Partition(A, low, high)
    base <- A[high]
    i <- low - 1
    for j <- p to high - 1
        do if A[j] <= base
              then i <- i + 1
                    swap A[i] <-> A[j]
    swap A[i + 1] <-> A[high]
    return i + 1
  ```

- 代码实现: [快速排序代码实现](https://github.com/buildupchao/AlgorithmAndDataStructure/blob/master/src/main/java/com/buildupchao/algorithm/sort/QuickSort.java)

### 插入排序算法

- 直接插入排序

- 折半插入排序

- 希尔排序

- 代码实现: [插入排序代码实现](https://github.com/buildupchao/AlgorithmAndDataStructure/blob/master/src/main/java/com/buildupchao/algorithm/sort/InsertSort.java)
