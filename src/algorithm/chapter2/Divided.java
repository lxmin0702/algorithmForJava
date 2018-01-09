package algorithm.chapter2;


import java.util.Scanner;

/**
 * Created by baymux on 2018/1/8.
 * 分治算法求假币问题
 * @author baymux
 **/
public class Divided {

    static final int MAXNUM = 30;
    /**
     * 1、首先为每个硬币编号，然后将所以的硬币分为两份，放在天平两端，这样就将分辨三十个硬币变为分辨两堆硬币
     * 2、较轻一边的硬币中必定包含假币
     * 3、再将较轻的一边分为两堆，重复上述步骤
     * 4/直到剩余两个硬币，就可以分辨出假币
     * @param coin
     * @param low
     * @param high
     * @return
     */
    static int falseCoin(int[] coin, int low, int high){
        int i, sum1, sum2, sum3;
        int re = 0;
        sum1 = sum2 = sum3 = 0;
        if (low + 1 == high){
            if(coin[low] < coin[high]){
                re = low + 1;
                return re;
            }else {
                re = high + 1;
                return re;
            }
        }

        if ((high-low+1)%2 == 0){
            for (i=low; i <=low + (high-low)/2; i++){
                // 前半段和
                sum1 = sum1 + coin[i];
            }
            for (i=low + (high-low)/2+1; i <=high; i++){
                // 后半段和
                sum2 = sum2 + coin[i];
            }
            if (sum1 > sum2){
                re = falseCoin(coin, low+(high-low)/2 + 1, high);
                return re;
            }else if (sum1 < sum2){
                re = falseCoin(coin, low, low + (high-low)/2);
                return re;
            }else {

            }
        }else {
            for (i=low; i<low+(high-low)/2; i++){
                sum1 = sum1 + coin[i];
            }
            for (i=low+(high-low)/2+1; i<high; i++){
                sum2 = sum2 + coin[i];
            }
            sum3 = coin[low + (high-low)/2];
            if (sum1 > sum2){
                re = falseCoin(coin, low + (high-low)/2+1, high);
                return re;
            }else if (sum1 < sum2){
                re = falseCoin(coin, low, low+(high-low)/2+1);
                return re;
            }else {

            }

            if (sum1 + sum3 == sum2 + sum3){
                re = low + (high-low)/2 + 1;
                return re;
            }

        }
        return re;
    }


    public static void main(String[] args) {
        int[] coin = new int[MAXNUM];
        int i, n;
        int weizhi;
        System.out.println("分治算法求假币问题");
        System.out.println("请输入硬币总个数：");
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        System.out.println("请输入硬币的真假：");
        for (i=0; i < n; i++){
            coin[i] = input.nextInt();
        }
        weizhi = falseCoin(coin, 0, n-1);
        System.out.println("在上述" + MAXNUM + "个硬币中，第"+ weizhi + "个硬币是假的！");
    }
}
