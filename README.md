# JavaAlgorithm
Chapter1 基本算法及数据结构
1. BinaryTree  二叉树
2. LinkedList 链表
3. Queue    队列
4. SeqList  顺序表
5. Stack    栈
6. Graph.java 图


chapter2 常用算法思想
1. 穷举算法思想 Exhaustive Attack Method
 - 从所有可能的情况中搜索正确答案
 >(1) 对于一种可能的情况，计算其结果。
 >(2) 判断结果是否满足要求，如果不满足则进行执行第(1)步来继续搜索下一可能的情况; 如果满足要求，则表示寻找到一个正确答案。
 - 使用穷举法首先确定范围，确定范围之后，可以使用循环语句及条件判断语句验证大拿正确性，从而得到正确的答案。
 - 穷举算法例子：
    今有鸡兔同笼上有三十五头，下有九十四足，问鸡兔各何？
 ```
     /**
      * 穷举算法
      * @param head 头
      * @param foot 足
      * @return
      */
     public static int exhaustive(int head, int foot){
         int re, i, j;
         re = 0;
         for (i = 0; i <= head; i++){
             j = head -i;
             if (i * 2 + j * 4 == foot){
                 re = 1;
                 chicken = i;
                 rabbit = j;
             }
         }
         return re;
     }

