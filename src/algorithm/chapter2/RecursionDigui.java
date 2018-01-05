package algorithm.chapter2;

import java.util.Scanner;

/**
 * Created by baymux on 2018/1/5.
 *
 * @author baymux
 **/
public class RecursionDigui {
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

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int i;
        System.out.println("请输入一个要求阶乘的的一个整数：");
        i = input.nextInt();
        // 调用方法
        System.out.println(i + "的阶乘结果为：" + fact(i));
    }
}
