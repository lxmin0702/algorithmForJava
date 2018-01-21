package algorithm.chapter3;

/**
 * Created by baymux on 2018/1/21.
 * 冒泡排序算法
 * @author baymux
 **/
public class BubbleSort {
    static final int SIZE = 10;

    public static void Bubble(int[] a){
        int temp;
        for (int i=1; i<a.length; i++){
            for (int j=0; j<a.length-i; j++){
                // 将相邻两个数进行比较，较大的书往后冒泡
                if (a[j] > a[j+1]){
                    // 交换相邻的两个数
                    temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
            System.out.println("第"+ i + "步的排序结果：");
            for (int k=0; k<a.length; k++){
                System.out.print(" " + a[k]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] array = new int[SIZE];
        int i;

        // 初始化数组
        for (i=0; i<SIZE; i++){
            // 初始化数组
            array[i] = (int)(100+Math.random()*(100+1));
        }
        System.out.println("排序前的数组为：");
        for (i=0; i<SIZE; i++){
            System.out.print(" " + array[i]);
        }
        System.out.println();
        // 排序
        Bubble(array);

        // 排序后的数组
        System.out.println("排序后的数组");
        for (i=0; i<SIZE; i++){
            System.out.print(" " + array[i]);
        }
        System.out.println();
    }
}
