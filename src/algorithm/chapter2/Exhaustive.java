package algorithm.chapter2;

import java.util.Scanner;

/**
 * Created by baymux on 2018/1/3.
 * 鸡兔同笼问题
 * @author baymux
 **/
public class Exhaustive {
    /**
     * chicken 鸡
     * rabbit 兔
     */
    static int chicken, rabbit;

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

    public static void main(String[] args) {
        int re, head, foot;
        Scanner input = new Scanner(System.in);
        System.out.println("穷举算法求解鸡兔同笼问题");
        System.out.print("请输入头数：");
        head = input.nextInt();
        System.out.print("请输入脚的数量：");
        foot = input.nextInt();

        re = exhaustive(head, foot);
        if (re == 1){
            System.out.println("鸡有" + chicken + "只, " + "兔有" + rabbit + "只");
        }else {
            System.out.println("没有正确答案！");
        }
    }
}
