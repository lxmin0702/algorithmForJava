package algorithm.chapter3;

/**
 * Created by baymux on 2018/4/1
 * shell排序
 * @author baymux
 **/
public class ShellSort {
    static final int SIZE = 10;

    /**
     * shell 排序
     * @param a
     */
    static void shellSort(int[] a){
        int i, j, h;
        int r, temp;
        int x = 0;

        // 划组排序
        for (r = a.length/2; r >= 1; r /= 2){
            for (i = r; i < a.length; i++) {
                temp = a[i];
                j = i - r;
                while (j >= 0 && temp < a[j]){
                    a[j+r] = a[j];
                    j -= r;
                }
                a[j+r] = temp;
            }

            x++;
            System.out.print("第" + x + "步排序结果：");
            for (h = 0; h < a.length; h++) {
                System.out.print(" " + a[h]);
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        int[] array = new int[SIZE];
        int i;

        for (i = 0; i < SIZE; i++){
            array[i] = (int)(100 + Math.random()*(100+1));
        }

        System.out.println("排序前的数组为：");
        for (i = 0; i < SIZE; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();

        shellSort(array);

        System.out.println("排序后的数组为：");

        for (i = 0; i < SIZE; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
