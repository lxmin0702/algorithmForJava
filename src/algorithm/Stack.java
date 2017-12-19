package algorithm;

import java.util.Scanner;

/**
 * Created by baymux on 2017/12/19.
 *
 * @author baymux
 **/
public class Stack {
    private static final String ERR = "0";

    public static void main(String[] args) {

        StackType stackType = new StackType();
        StackData stackData = new StackData();

        // 初始化栈
        StackType stack = stackType.stackInit();
        Scanner input = new Scanner(System.in);
        System.out.println("入栈操作");
        System.out.println("输入 姓名  年龄 进行入栈操作：");
        do{
            StackData data = new StackData();
            data.name = input.next();
            if (data.name.equals(ERR)){
                break;
            }else {
                data.age = input.nextInt();
                stackType.pushSt(stack, data);
            }
        }while (true);

        String temp  = "1";

        System.out.println("出栈操作， 按任意非0键进行出栈操作：");
        temp = input.next();
        while (!temp.equals(ERR)){
            stackData = stackType.popSt(stack);
            System.out.printf("出栈的数据是：%s, %d\n", stackData.name, stackData.age);
            temp = input.next();
        }

        System.out.println("测试结束！");
        stackType.stFree(stackType);
    }
}

/**
 * 准备栈数据
 * @author baymux
 */
class StackData{
    String name;
    int age;
}


/**
 * 栈数据类型
 * @author baymux
 */
class StackType{
    private static final int MAXLEN = 50;
    /**
     * 数据元素
     */
    StackData[] stackData = new StackData[MAXLEN+1];
    /**
     * 栈顶
     */
    private int top;

    /**
     * 初始化栈结构
     *  1、按常量指定大小申请一片内存空间，保存栈中数据
     *  2、设置栈顶的引用值为0，表示为一个空栈
     * @return StackType 栈
     */
    StackType stackInit(){
        StackType p;
        //申请栈内存
        if ((p=new StackType()) != null) {
            // 设置栈顶为0， 表示为空栈
            p.top = 0;
            // 返回栈顶的引用
            return p;
        }
        return null;
    }

    /**
     * 判断空栈
     * @param p 栈
     * @return Boolean
     */
    boolean stIsEmpty(StackType p){
        boolean b;
        b = (p.top == 0);
        return  b;
    }

    /**
     * 判断满栈
     * @param p 栈
     * @return Boolean
     */
    boolean stIsFull(StackType p){
        boolean b;
        b = (p.top == MAXLEN);
        return b;
    }

    /**
     * 清空栈
     * @param p 栈
     */
    void stClear(StackType p){
        p.top = 0;
    }

    /**
     * 释放空间
     * @param p 栈
     */
    void stFree(StackType p){
        if (p != null){
            p = null;
        }
    }

    /**
     * 入栈
     *  1.首先判断栈顶top，如果top大于SIZE, 则栈溢出，进行错误操作，否则执行入栈操作
     *  2.设置 top = top + 1，栈顶引用加1，指向入栈地址
     *  3.将入栈元素保存到top指向的位置
     * @param p 栈
     * @param stackData 数据
     * @return 1
     */
    int pushSt(StackType p, StackData stackData){
        if ((p.top+1) > MAXLEN){
            System.out.println("栈溢出！");
            return 0;
        }
        // 将元素入栈
        p.stackData[++p.top] = stackData;
        return 1;
    }

    /**
     * 出栈操作
     *  1.判断栈顶，如果top等于0，则为空栈，进行错误操作，否则执行出栈操作
     *  2.将栈顶引用top所指元素返回。
     *  3.设置 top = top -1, 栈顶应用减一，指向栈下一个元素，原来栈元素被弹出
     * @param p 栈
     * @return p
     */
    StackData popSt(StackType p){
        if (p.top == 0){
            System.out.println("栈为空!");
            System.exit(0);
        }
        return (p.stackData[p.top--]);
    }

    StackData peekSt(StackType p){
        if (p.top == 0){
            System.out.println("栈为空！");
            System.exit(0);
        }
        return p.stackData[p.top];
    }
}