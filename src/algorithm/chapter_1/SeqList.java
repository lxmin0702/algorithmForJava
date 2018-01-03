package algorithm.chapter_1;

/**
 * Created by baymux on 2017/12/11.
 **/

import java.util.Scanner;

/**
 * @author baymux
 */
public class SeqList {
    public static void main(String[] args) {
        // 定义顺序表变量
        SlType slType = new SlType();
        // 定义结点保存引用变量
        Data pdata ;
        // 保存关键字
        String key;

        int i;
        System.out.println("顺序表操作演示：");

        // 初始化顺序表
        slType.sLinit(slType);
        System.out.println("初始化顺序表完毕；");

        Scanner input = new Scanner(System.in);

        // 循环添加结点数据
        do{
            System.out.println("输入添加的结点（学号 姓名 年龄）：");
            Data data = new Data();
            data.key = input.next();
            data.name = input.next();
            data.age = input.nextInt();

            //如果年龄部位 0
            if (data.age != 0) {
                // 如果结点添加失败
                if (slType.sLadd(slType,data) == 0) {
                    // 退出
                    break;
                }
            }else { // 年龄为 0， 退出
                break;
            }
        }while (true);
        System.out.println("\n顺序表中的结点顺序为：");
        // 显示所有结点
        slType.sLall(slType);

        System.out.println("\n要取出的结点序号：");
        i = input.nextInt();
        pdata = slType.sLfindByNum(slType, i);
        if (pdata != null) {
            System.out.printf("第%d个结点为：(%s, %s, %d)\n", i, pdata.key, pdata.name, pdata.age);
        }

        System.out.println("\n要查找结点的关键字：");
        key = input.next();
        i = slType.sLfinfByCount(slType, key);
        pdata = slType.sLfindByNum(slType, i);
        if (pdata != null) {
            System.out.printf("第%d个结点为：(%s, %s, %d)\n", i, pdata.key, pdata.name, pdata.age);
        }
    }
}

/**
 * 定义结点关键字
 * 准备数据
 */
class Data{
    String key;
    String name;
    int age;
}

/**
 * 定义顺序表结构
 */
class SlType{
    static final int MAXLEN = 100;
    /**
     * 保存顺序表的结构数组
     */
    Data[] listData = new Data[MAXLEN+1];
    /**
     *  顺序表已存结点的数量
     */
    int listLen;

    /**
     * 初始化顺序表
     * @param slType
     */
    void sLinit(SlType slType){
        // 初始化为空表
        slType.listLen = 0;
    }

    /**
     * 返回顺序表的元素数量
     * @param slType
     * @return
     */
    int sLlength(SlType slType){
        return(slType.listLen);
    }

    /**
     * 插入结点
     * @param slType
     * @param n
     * @param data
     * @return
     */
    int sLinsert(SlType slType, int n, Data data){
        int i;
        // 如果顺序表结点超过最大数量
        if (slType.listLen >= MAXLEN) {
            System.out.println("顺序表已满，不能插入结点");
            // 返回0 表示插入不成功
            return 0;
        }

        // 如果插入结点号不正确
        if (n < 1 || n > slType.listLen-1){
            System.out.println("插入元素序号错误，不能插入数据");
            return 0;
        }
        // 将顺序表中的数据向后移动
        for (i = slType.listLen; i >= n; i--) {
            slType.listData[i+1] = slType.listData[i];
        }

        // 插入结点
        slType.listData[n] = data;
        // 顺序表数量增加1
        slType.listLen += 1;
        // 插入成功，返回1
        return 1;
    }

    /**
     * 追加结点
     * @param slType
     * @param data
     * @return
     */
    int sLadd(SlType slType, Data data){
        // 顺序表已满
        if (slType.listLen >= MAXLEN) {
            System.out.println("顺序表已满，不能添加结点");
            return 0;
        }

        slType.listData[++slType.listLen] = data;
        return 1;
    }

    /**
     * 删除结点
     * @param slType
     * @param n
     * @return
     */
    int sLdel(SlType slType, int n){
        // 结点顺序不正确
        if (n < 1 || n > slType.listLen + 1) {
            System.out.println("删除结点号错误，不能删除结点");
            return 0;
        }
        // 将顺序表中的数据向前移动
        for (int i = n; i < slType.listLen; i++) {
            slType.listData[i] = slType.listData[i+1];
        }
        // 顺序表中的结点数量减一
        slType.listLen --;
        return 1;
    }

    /**
     * 按照序号查找结点数据元素
     * @param slType
     * @param n
     * @return
     */
    Data sLfindByNum(SlType slType, int n){
        // 结点序号不正确
        if (n < 1 || n > slType.listLen + 1) {
            System.out.println("结点号错误，不能返回结点");
            return null;
        }
        return slType.listData[n];
    }

    /**
     * 按照关键字返回结点
     * @param slType
     * @param keys
     * @return
     */
    int sLfinfByCount(SlType slType, String keys){
        for (int i = 1; i <= slType.listLen; i++) {
            // 如果找到所需要的结点，返回结点序号
            if (slType.listData[i].key.compareTo(keys) == 0) {
                return i;
            }
        }
        return 0;
    }

    /**
     * 显示所有结点
     * @param slType 结点
     * @return int
     */
    int sLall(SlType slType){
        for (int i = 1; i <= slType.listLen; i++) {
            System.out.printf("(%s, %s, %d)\n",
                    slType.listData[i].key, slType.listData[i].name, slType.listData[i].age);
        }
        return 0;
    }

}