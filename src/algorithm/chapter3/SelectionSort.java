package algorithm.chapter3;

/**
 * Created by baymux on 2018/1/22.
 * 选择排序算法
 * @author baymux
 **/
public class SelectionSort {
    static final int SIZE=10;
    public static void selectSort(int[] a){
        int index, temp;
        for (int i=0; i<a.length; i++){
            index = i;
            for (int j=i+1; j<a.length; j++){
                if (a[j] < a[index]){
                    index = j;
                }
            }
            // 交换两个数
            if (index != i){
                temp = a[i];
                a[i] = a[index];
                a[index] = temp;
            }
            System.out.println("第" + i + "步的排序结果为：");
            for (int h=0; h<a.length; h++){
                System.out.print(" " + a[h]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] array = new int[SIZE];
        int i;

        for (i=0; i<SIZE; i++){
            array[i] = (int)(100+Math.random()*(100+1));
        }
        System.out.println("排序前的数组为：");
        for (i=0; i<SIZE; i++){
            System.out.print(" " + array[i]);
        }
        System.out.println();

        selectSort(array);

        System.out.println("排序后的数组为：");
        for (i=0; i<SIZE; i++){
            System.out.print(" " + array[i]);
        }
        System.out.println();
    }
}
