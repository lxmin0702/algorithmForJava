package algorithm.chapter2;

import java.util.Scanner;

/**
 * Created by baymux on 2018/1/4.
 *
 * @author baymux
 **/
public class Recursion {
   static Scanner input = new Scanner(System.in);
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

    public static void main(String[] args) {
        System.out.println("递推算法求解兔子产仔问题");
        System.out.println("请先输入时间：");
        int n = input.nextInt();
        int num = fibonacci(n);
        System.out.println("经过"+ n + "个月， 共繁殖" + num + "对兔子！");
    }
}
