package algorithm.chapter1;

import java.util.Scanner;

/**
 * Created by baymux on 2017/12/20.
 *
 * @author baymux
 **/
public class Queue {
    private static final String RETURN = "0";
    public static void main(String[] args) {

        Queuetype queuetype = new Queuetype();
        QueueDate queueDate;

        Scanner input = new Scanner(System.in);
        // 初始化队列
        Queuetype queue = queuetype.queueInit();
        // 入队列操作
        System.out.println("入队列操作");
        System.out.println("输入姓名  年龄 进行入队列操作：");
        do {
            QueueDate data = new QueueDate();
            data.name = input.next();
            data.age = input.nextInt();
            if (data.name.equals(RETURN)){
                break;
            }else {
                queuetype.inQueue(queue,data);
            }
        }while (true);

        String temp = "1";
        System.out.println("出队列操作，输入任意非0键进行出队列：");
        temp = input.next();
        while (!temp.equals(RETURN)){
            queueDate = queuetype.outQueue(queue);
            System.out.printf("%s, %d\n", queueDate.name, queueDate.age);
            temp = input.next();
        }

        System.out.println("测试结束");
        // 释放占用的空间
        queuetype.queueFree(queue);

    }
}

/**
 * 准备数据
 * @author baymux
 */
class QueueDate{
    String name;
    int age;
}

/**
 * @author baymux
 * 定义队列类型
 */
class Queuetype{
    private static final int RETURN = 0;
    private static final int QUEUELEN = 15;
    /**
     * 队列数组
     */
    QueueDate[] queueDates = new QueueDate[QUEUELEN];

    /**
     * 队头
     */
    private int head;

    /**
     * 队尾
     */
    private int tail;

    /**
     * &#x521d;&#x59cb;&#x5316;&#x961f;&#x5217;
     * @return queuetype
     */
    Queuetype queueInit(){
        Queuetype queuetype;
        // 申请内存
        if (null != (queuetype = new Queuetype())){
            queuetype.head = 0;
            queuetype.tail = 0;
            return queuetype;
        }else {
            return null;
        }
    }

    /**
     * 判断队列是否为空，如果为空只能进行入队列，不能进行出队列
     * @param queuetype
     * @return
     */
    int queueIsEmpty(Queuetype queuetype){
        int temp = RETURN;
        if (queuetype.head == queuetype.tail){
            temp = 1;
        }
        return temp;
    }

    /**
     * 判断队列是否满
     * @param queuetype
     * @return
     */
    int queueIsFull(Queuetype queuetype){
        int temp = RETURN;
        if (queuetype.tail == QUEUELEN){
            temp = 1;
        }
        return temp;
    }

    /**
     * 清空队列
     * @param queuetype
     */
    void queueClear(Queuetype queuetype){
        queuetype.head = 0;
        queuetype.tail = 0;
    }

    /**
     * 释放内存空间
     * @param queuetype
     */
    void queueFree(Queuetype queuetype){
        if (queuetype != null){
            queuetype = null;
        }
    }

    /**
     * 入队列
     *  1、判断队尾，如果队尾等于 QUEUELEN,表示队列溢出
     *  2、设置 tail = tail + 1，
     *  3、保存对了元素
     * @param queuetype
     * @param queueDate
     * @return
     */
    int inQueue(Queuetype queuetype, QueueDate queueDate){
        if (queuetype.tail == QUEUELEN){
            System.out.println("队列已满，操作失败");
            return 0;
        }
        else {
            queuetype.queueDates[queuetype.tail++] = queueDate;
            return 1;
        }
    }

    /**
     * 出队列
     *  1、判断队列是否为空（head = 0）,为空则不能出队列，进行错误处理
     *  2、从队列取出队头元素
     *  3、修改队头序号，指向下一个元素
     * @param queuetype
     * @return
     */
    QueueDate outQueue(Queuetype queuetype){
        if (queuetype.head == queuetype.tail){
            System.out.println("队列为空，操作失败");
            System.exit(0);
        }else {
            return queuetype.queueDates[queuetype.head++];
        }
        return null;
    }

    /**
     * 读取结点数据-头数据
     * @param queuetype
     * @return
     */
    QueueDate peekQueue(Queuetype queuetype){
        if (queueIsEmpty(queuetype) == 1){
            System.out.println("空队列");
            return null;
        }else {
            return queuetype.queueDates[queuetype.head];
        }
    }

    /**
     * 计算队列长度
     * @param queuetype
     * @return
     */
    int queueLen(Queuetype queuetype){
        int len = queuetype.tail - queuetype.head;
        return len;
    }
}