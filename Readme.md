
> 个人学习数据结构中的代码备份

## 排序算法的简介

- 内部排序: 将需要处理的所有数据都加载到**内部存储器**中进行排序.
- 外部排序: 数据量过大, 无法全部加载到内存中, 要借助外部存储进行排序
- 常见排序算法分类:
  - 内部排序:
    - 插入排序
      - 直接插入
      - 希尔排序
    - 选择排序
      - 简单选择排序
      - 堆排序
    - 交换排序
      - 冒泡
      - 快速排序
    - 归并排序
    - 基数排序(桶排序的扩展)
  - 外部排序(内存和外存结合)

- 算法的时间复杂度
    1. 事后统计法:, 这种方式，要在同一台计算机的相同状态下运行，才能比较那个算法速度更快。
    2. 事前估算: 通过分析某个算法的**时间复杂度**来判断哪个算法更优.
- 时间频度：  
  一个算法花费的时间与算法中语句的执行次数成正比例，哪个算法中语句执行次数多，它花费时间就多。一个算法中的语句执行次数称为语句频度或时间频度。记为T(n)
- 时间复杂度  
    1. 一般情况下，算法中的基本操作语句的重复执行次数是问题规模n的某个函数，用T(n)表示，若有某个辅助函数f(n)，使得当n趋近于无穷大时，T(n) / f(n) 的极限值为不等于零的常数，则称f(n)是T(n)的同数量级函数。记作 T(n)=Ｏ( f(n) )，称Ｏ( f(n) )  为算法的渐进时间复杂度，简称时间复杂度。
    2. T(n) 不同，但时间复杂度可能相同。 如：T(n)=n²+7n+6 与 T(n)=3n²+2n+2 它们的T(n) 不同，但时间复杂度相同，都为O(n²)。
    3. 计算时间复杂度的方法：
        - 用常数1代替运行时间中的所有加法常数  T(n)=n²+7n+6  => T(n)=n²+7n+1
        - 修改后的运行次数函数中，只保留最高阶项  T(n)=n²+7n+1 => T(n) = n²
        - 去除最高阶项的系数 T(n) = n² => T(n) = n² => O(n²)  
- 常见的时间复杂度
  - 常数阶O(1)
  - 对数阶O(log2n)
  - 线性阶O(n)
  - 线性对数阶O(nlog2n)
  - 平方阶O(n^2)
  - 立方阶O(n^3)
  - k次方阶O(n^k)
  - 指数阶O(2^n)
- 常见的算法时间复杂度由小到大依次为：  
  `Ο(1)＜Ο(log2n)＜Ο(n)＜Ο(nlog2n)＜Ο(n2)＜Ο(n3)＜ Ο(nk) ＜Ο(2n)`  
  随着问题规模n的不断增大，上述时间复杂度不断增大，算法的执行效率越低
  
### 1. 冒泡排序 Bubble Sorting
> cn.joe.d04sortalgorithm.BubbleSortDemo
- 基本思想是：  
  通过对待排序序列从前向后（从下标较小的元素开始）,依次比较相邻元素的值，若发现逆序则交换，使值较大的元素逐渐从前移向后部，就象水底下的气泡一样逐渐向上冒。
- 设计时为数组长度-1次大的遍历, 每次大遍历中遍历所有数字  
  可以设置一个flag , 若未发生交换, 则提前结束

### 2. 选择排序 select sorting  
> cn.joe.d04sortalgorithm.SelectSortDemo
- 选择式排序也属于内部排序法，是从欲排序的数据中，按指定的规则选出某一元素，再依规定交换位置后达到排序的目的
- 思想  
  选择排序（select sorting）也是一种简单的排序方法。  
  它的基本思想是：第一次从arr[0]~arr[n-1]中选取最小值，与arr[0]交换，第二次从arr[1]~arr[n-1]中选取最小值，与arr[1]交换，第三次从arr[2]~arr[n-1]中选取最小值，与arr[2]交换，…，第i次从arr[i-1]~arr[n-1]中选取最小值，与arr[i-1]交换，…, 第n-1次从arr[n-2]~arr[n-1]中选取最小值，与arr[n-2]交换，总共通过n-1次，得到一个按排序码从小到大排列的有序序列
    - 共有 数组长度 - 1 轮排序
    - 先假定当前数字为最小数, 和后面每个数进行比较, 如果发现有比当前数更小的数, 就重新确定最小数, 并得到下标
    - 遍历到数组最后时, 得到本轮最小数 和 下标
    - 交换当前数字和最小数, 详见代码
    
### 3. 插入排序 Insertion Sorting  
> cn.joe.d04sortalgorithm.InsertionSortDemo
- 基本思想  
  把n个待排序的元素看成为一个有序表和一个无序表，开始时有序表中只包含一个元素，无序表中包含有n-1个元素，排序过程中每次从无序表中取出第一个元素，把它的排序码依次与有序表元素的排序码进行比较，将它插入到有序表中的适当位置，使之成为新的有序表
    - 也是 n-1 次排序  
    
### 4. 希尔排序 Shell Sorting  
> cn.joe.d04sortalgorithm.ShellSortDemo
- 希尔排序也是一种插入排序，它是简单插入排序经过改进之后的一个更高效的版本，也称为缩小增量排序
- 希尔排序是把记录按下标的一定增量分组，对每组使用直接插入排序算法排序；随着增量逐渐减少，每组包含的关键词越来越多，当增量减至1时，整个文件恰被分成一组，算法便终止

### 5. 快速排序 Quick Sort
> cn.joe.d04sortalgorithm.QuickSortDemo
- 快速排序（QuickSort）是对冒泡排序的一种改进。
  - 基本思想是：  
  通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另外一部分的所有数据都要小，然后再按此方法对这两部分数据分别进行快速排序，整个排序过程可以递归进行，以此达到整个数据变成有序序列

### 6. 归并排序(MERGE-SORT)
> cn.joe.d04sortalgorithm.MergeSortDemo
- 归并排序(MERGE-SORT)是利用归并的思想实现的排序方法，该算法采用经典的分治（divide-and-conquer）策略（分治法将问题分(divide)成一些小的问题然后递归求解，而治(conquer)的阶段则将分的阶段得到的各答案"修补"在一起，即分而治之)。
- n-1次

### 7. 基数排序(radix sort)
> cn.joe.d04sortalgorithm.RadixSortDemo
- 基数排序(桶排序)介绍:
  - 基数排序（radix sort）属于“分配式排序”（distribution sort），又称“桶子法”（bucket sort）或bin sort，顾名思义，它是通过键值的各个位的值，将要排序的元素分配至某些“桶”中，达到排序的作用
  - 基数排序法是属于稳定性的排序，基数排序法的是效率高的稳定性排序法
  - 基数排序(Radix Sort)是桶排序的扩展
  - 基数排序是1887年赫尔曼·何乐礼发明的。它是这样实现的：将整数按位数切割成不同的数字，然后按每个位数分别比较

## 2. 查找算法

- 查找算法介绍  
  在java中，我们常用的查找有四种:
  1) 顺序(线性)查找 cn.joe.d05search.SeaSearch
  2) 二分查找/折半查找 cn.joe.d05search.BinarySearch
  3) 插值查找 cn.joe.d05search.InsertSearch
  4) 斐波那契查找 cn.joe.d05search.FibonacciSearch
  
1. 线性查找: 不需要数组是有序的, 就是全部遍历一遍
2. 二分查找: 有序数组  
3. 插值查找:  
    - 插值查找算法类似于二分查找，不同的是插值查找每次从自适应mid处开始查找
    - 将折半查找中的求mid 索引的公式 , low 表示左边索引left, high表示右边索引right.key 就是前面我们讲的  findVal  
    - `int mid = low + (high - low) * (key - arr[low]) / (arr[high] - arr[low])`  ;/*插值索引*/对应前面的代码公式：`int mid = left + (right – left) * (findVal – arr[left]) / (arr[right] – arr[left])`
    - 插值查找注意事项：      
      - 对于数据量较大，关键字分布比较均匀的查找表来说，采用插值查找, 速度较快.
      - 关键字分布不均匀的情况下，该方法不一定比折半查找要好
4. 斐波那契查找:
    - 斐波那契查找原理与前两种相似，仅仅改变了中间结点(mid)的位置，mid不再是中间或插值得到，而是位于黄金分割点附近，即`mid=low+F(k-1)-1`

## 3. 二叉树

### 1. 顺序存储二叉树
> cn.joe.d07tree.ArrayBinaryTree
- 顺序存储二叉树的特点:
  1. 顺序存储二叉树通常只考虑完全二叉树
  2. 数组中索引为 `n` 的元素的左子节点的索引为: `2*n+1`
  3. 数组中索引为 `n` 的元素的右子节点的索引为: `2*n+2`
  4. 数组中索引为 `n` 的元素的父节点的索引为: `(n-1)/2`
### 2. 线索化二叉树
> cn.joe.d07tree.ThreadedBinaryTree
- 线索化二叉树基本介绍
  1. n个节点的二叉链表中含有`n+1`个空指针域(`2n-(n-1)=n+1`)  
    利用二叉链表中的空指针域, 存放指向该节点在**某种遍历次序**下的前驱和后继节点的指针  
    这样附加的指针称为"线索"
  2. 这种加上了线索的二叉链表称为线索链表, 相应的二叉树称为线索二叉树(Threaded BinaryTree)  
    根据线索的性质不同, 可分为前序线索二叉树, 中序线索二叉树, 后序线索二叉树三种
- 当线索化后, 节点的左/右指针指向的可能是左/右子树, 也可能是前驱/后继节点

### 3. 树结构的应用

#### 1. 堆排序

- 基本介绍
    1. 堆排序是利用堆设计的一种排序算法，堆排序是一种选择排序，它的最坏，最好，平均时间复杂度均为O(nlogn)，它也是不稳定排序。
    2. 堆是具有以下性质的完全二叉树：  
      每个结点的值都大于或等于其左右孩子结点的值，称为大顶堆   
      注意: **没有要求结点的左孩子的值和右孩子的值的大小关系**
    3. 每个结点的值都小于或等于其左右孩子结点的值，称为小顶堆
    
- 堆排序的基本思想是：
  1. 将待排序序列构造成一个大顶堆
  2. 此时，整个序列的最大值就是堆顶的根节点。
  3. 将其与末尾元素进行交换，此时末尾就为最大值。
  4. 然后将剩余n-1个元素重新构造成一个堆，这样会得到n个元素的次小值。如此反复执行，便能得到一个有序序列了
> 在顺序存储二叉树中, 最后一个非叶子节点的索引为:  `arr.length / 2 - 1`
#### 2. 哈夫曼树(Huffman Tree)

- 基本介绍  
  - 给定n个权值作为n个叶子结点，构造一棵二叉树，若该树的带权路径长度(wpl)达到最小，称这样的二叉树为最优二叉树，也称为哈夫曼树(Huffman Tree), 还有的书翻译为霍夫曼树。
  - 赫夫曼树是带权路径长度最短的树，权值较大的结点离根较近
  - 结点的带权路径长度为：从根结点到该结点之间的路径长度与该结点的权的乘积
  - 树的带权路径长度：所有叶子结点的带权路径长度之和，记为WPL(weighted path length) ,权值越大的结点离根结点越近的二叉树才是最优二叉树。
  - WPL最小的就是赫夫曼树

  > 若规定根节点的层数为1, 则根节点到L层节点的路径长度为`L-1`