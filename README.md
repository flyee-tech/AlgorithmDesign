# AlgorithmDesign
算法与数据结构之Java语言实现

- JDK使用版本: 1.8
- 官方Mac环境安装地址：http://algs4.cs.princeton.edu/mac/

## 项目结构及内容简介

#### Algorithm Design Base
    |com.peierlong.base  //基础
        |Euclid.java
        |-----------------  //欧几里得算法实现
        |Array.java
        |-----------------  //数组典型处理代码
    |com.peierlong.exercise
        |ParseString.java
        |-----------------  //字符串处理小练习
        |DynamicProgramming.java
        |-----------------  //动态规划的实现
    |com.peierlong.coursera.algorithms.week1.union_find //第一周
            |UF.java
            |-----------------  //dynamic connectivity            
            |QuickFindUF.java
            |-----------------  //快速查找算法      
            |QuickUnionUF.java
            |-----------------  //快速合并算法      
            |WeightedQuickUnionUF.java
            |-----------------  //加权并查集的实现
    |com.peierlong.coursera.algorithms.week1 //第一周
            |BinarySearch.java
            |-----------------  //二分查找实现
    |com.peierlong.coursera.algorithms.week1.homework //第一周-homework
            |Successor.java
            |-----------------  //exercise
            |Percolation.java
            |-----------------  //渗透问题建模
            |PercolationStats.java
            |-----------------  //蒙特卡洛模拟
            |ThreeSum.java
            |-----------------  //3SUM的平方级实现(针对有序数组)
            |SimpleBitonicArraySearch.java
            |-----------------  //双调数组查找普通版（~3lgN）
            |FastBitonicArraySearch.java
            |-----------------  //双调数组查找升级版（~2lgN）
    |com.peierlong.coursera.algorithms.week2 //第二周
            |LinkedStackOfStrings.java
            |-----------------  //使用链表实现栈
            |ArrayStackOfStrings.java
            |-----------------  //使用数组实现栈
            |Temperature.java
            |-----------------  //Comparable接口错误实现示例
            |SelectionSort.java
            |-----------------  //选择排序的实现
            |InsertionSort.java
            |-----------------  //插入排序的实现
            |ShellSort.java
            |-----------------  //希尔排序的实现
            |Shuffle.java
            |-----------------  //Shuffling 实现
    |com.peierlong.coursera.algorithms.week2.interview //第二周-面试题
            |IntersectionOfSet.java
            |-----------------  //求两个点数组的交集的数量
            |Permutation.java
            |-----------------  //判断两个非有序的整型数组是否拥有相同个元素个数
    |com.peierlong.coursera.algorithms.week2.homework //第二周-homework
            |TwoStackQueue.java
            |-----------------  //使用两个栈实现一个队列
            |MaximumNumbersStack.java
            |-----------------  //求栈中最大值实现
            |Deque.java
            |-----------------  //链表的双向队列的实现
            |RandomizedQueue.java
            |-----------------  //数组实现的具有取随机数功能的队列

