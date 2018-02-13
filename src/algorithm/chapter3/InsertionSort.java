package algorithm.chapter3;

/**
 * Created by baymux on 2018/1/23
 * 插入排序法
 * @author baymux
 **/
public class InsertionSort {
    static final int SIZE = 10;
    static void insertSort(int[] a){
        int i,j,t,h;
        for (i = 0; i < a.length; i++) {
            t = a[i];
            j = i-1;
            while  (j >= 0 && t < a[j]){
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = t;

            System.out.println("第" + i + "步排序的结果：");
            for (h = 0; h < a.length; h++) {
                System.out.print(" " + a[h]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] array = new int[SIZE];
        int i;
        for (i = 0; i < SIZE; i++) {
            array[i] = (int) (100+Math.random()*(100+1));
        }
        System.out.println("排序前的数组为：");
        for (i = 0; i < SIZE; i++) {
            System.out.print(" " + array[i]);
        }
        System.out.println();

        insertSort(array);

        System.out.println("排序后的数组：");
        for (i = 0; i < SIZE; i++) {
            System.out.print(" " + array[i]);
        }
        System.out.println();
    }
}
