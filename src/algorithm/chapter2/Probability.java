package algorithm.chapter2;

import java.util.Scanner;

/**
 * Created by baymux on 2018/1/15.
 * 蒙特卡罗π算法
 * @author baymux
 **/
public class Probability {

    /**
     * 蒙特卡罗算法
     * @param n
     * @return
     */
    static double MontePI(int n){
        double PI;
        double x, y;
        int i, sum;
        sum = 0;

        for (i=0; i < n; i++){
            x = Math.random();
            y = Math.random();
            if ((x*x+ y*y) <= 1) {
                sum++;
            }
        }
        PI = 4.0 * sum / n;
        return PI;
    }

    public static void main(String[] args) {
        int n;
        double PI;
        System.out.println("蒙特卡罗算法计算π");
        Scanner input = new Scanner(System.in);
        System.out.println("输入点的数量：");
        n = input.nextInt();
        PI = MontePI(n);
        System.out.println("π = " + PI);
    }
}
