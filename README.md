# JavaAlgorithm
## Chapter1 基本算法及数据结构
1. BinaryTree  二叉树
2. LinkedList 链表
3. Queue    队列
4. SeqList  顺序表
5. Stack    栈
6. Graph.java 图


## chapter2 常用算法思想

1. 穷举算法思想 Exhaustive Attack Method
- 从所有可能的情况中搜索正确答案
 > (1) 对于一种可能的情况，计算其结果。  
 > (2) 判断结果是否满足要求，如果不满足则进行执行第(1)步来继续搜索下一可能的情况; 如果满足要求，则表示寻找到一个正确答案。
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

```
2.递推算法思想 
- 适合有明显公式规律的场合
> (1) 根据已知结果和关系，求解中间结果。  
> (2) 判断是否达到要求，如果没有达到，则继续根据已知结果和关系继续求解结果，如果满足，则表示寻找到一个答案。
- 递推实例
Q: 一对两个月大的兔子以后每一个月都可以生一对小兔子，而一对新生的兔子两个月后才可以生小兔子，假定一年内没有兔子死亡，
那么一年后会有多少对兔子？  
 第一个月：1对  
 第二个月：1对  
 第三个月：2对  
 第四个月：3对  
 第五个月：5对  
 ...
 ```
     /**
      * 递归
      * @param n
      * @return
      */
     public  static int fibonacci(int n){
         int t1, t2;
         if(n == 1 || n == 2){
             return 1;
         }else {
             t1 = fibonacci(n-1);
             t2 = fibonacci(n-2);
             return t1 + t2;
         }
     }
 ```
 3.递归算法思想
 递归算法实在程序中不断反复调用自身来求解问题的方法。  
 重点是调用自身，递归调用是一个方法在其方法体内调用其自身的方法调用方法。  
 方法的的递归调用分为两种情况：直接递归和简介递归。 
 - 直接递归：在方法中调用方法本身。
 - 间接递归：A 方法调用 B方法，B方法调用 A方法.
 - 递归方法，必须使用if语句强制方法在未执行递归调用前返回。  
 - 优点：代码简洁清晰，可读性好。
 - 缺点：运行速度慢，附加的方法调用增加时间开销，结构太深，还可能导致堆栈溢出。  
 - 递归算法：  
    阶乘，n! = n*(n-1)* (n-2)* ... * 2* 1  
         (n-1)! = (n-1)* (n-2)* ... * 2*1  
         n! = n * (n-1)! 
```
    /**
     * 求阶乘方法
     * @param n
     * @return
     */
    static long fact(int n){
        if(n <= 1){
            return 1;
        }else {
            // 递归
            return n * fact(n-1);
        }
    }
```  