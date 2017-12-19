package algorithm;

/**
 * Created by baymux on 2017/12/12.
 *
 * @author baymux
 **/


import java.util.Scanner;

/**
 * 准备数据
 */
class LinkedData{
    /**
     * 结点关键字
     */
    String key;
    String name;
    int age;
}

/**
 * 数据结点类型
 * 定义链表结构
 */
class ClType{
    LinkedData noteData = new LinkedData();
    ClType nextNode;

    /**
     * 添加结点
     *  1、分配内存空间，保存新增的结点
     *  2、从头head开始检查，找到最后一个结点
     *  3、将表尾结点地址设为新增的地址
     *  4、将新增结点地址设置为空，为表尾
     * @param head  头结点
     * @param noteData 新增结点数据
     * @return 结点地址(头结点)
     */
    ClType clAddEnd(ClType head, LinkedData noteData){
        ClType node, htemp;
//      分配内存失败
        if ((node = new ClType()) == null) {
            System.out.println("内存申请失败！");
            return  null;
        }else {
//          保存数据
            node.noteData = noteData;
//            设置结点为null
            node.nextNode = null;
//            头结点引用
            if(head == null){
                head = node;
                return head;
            }
            htemp = head;
//            查找链表末尾
            while (htemp.nextNode != null){
                htemp = htemp.nextNode;
            }
            htemp.nextNode = node;
            return head;
        }
    }

    /**
     * 插入头结点
     *  1、分配内存空间，保存新增的结点
     *  2、使新增的结点指向引用head所指向的结点
     *  3、使头引用head指向新增结点
     * @param head 头结点引用
     * @param noteData 结点保存数据
     * @return head
     */
    ClType clAddFirst(ClType head, LinkedData noteData){
        ClType node;
        if ((node = new ClType()) == null){
            System.out.println("分配内存空间失败！");
            return null;
        }else {
//            保存数据
            node.noteData = noteData;
//            指向头引用锁指向的结点
            node.nextNode = head;
//            头引用指向心的结点
            head = node;
            return head;
        }
    }

    /**
     * 通过关键字查找结点
     * @param head
     * @param key
     * @return
     */
    ClType clFindNode(ClType head, String key) {
        ClType htemp;
//        初始化，保存链表头引用
        htemp = head;
//        结点不为null，开始查找
        while (htemp != null) {
//            若关键字相同
            if (htemp.noteData.key.compareTo(key) == 0) {
                return htemp;
            }
            htemp = htemp.nextNode;
        }
        return null;
    }

    /**
     * 插入结点
     *  1、分配内存空间， 保存结点
     *  2、找到要插入的逻辑位置（那两个结点之间）
     *  3、修改插入结点的引用，使其指向新结点，新结点指向原插入位置所指向的结点
     * @param head
     * @param findkey
     * @param nodeData
     * @return
     */
    ClType clInsertNode(ClType head, String findkey, LinkedData nodeData){
        ClType node, nodetemp;
        // 分配保存结点的内容
        if ((node = new ClType()) == null){
            System.out.println("申请内存失败");
            return null;
        }
        // 保存结点的数据
        node.noteData = nodeData;
        // nodetemp 保存找到的结点位置
        nodetemp = clFindNode(head, findkey);
        if (nodetemp != null){
            // 新插入的结点指向关键结点的下一个结点
            node.nextNode = nodetemp.nextNode;
            // 关键结点指向新插入的结点
            nodetemp.nextNode = node;
        }else {
            System.out.println("未找到正确的插入位置");
        }
        return head;
    }

    /**
     * 删除结点
     *  1、找到需要删除的结点
     *  2、使前一结点指向当前结点的下一个结点
     *  3、删除结点
     * @param head
     * @param key
     * @return
     */
    int clDelNode(ClType head, String key){
        // node保存删除结点的前一个结点
        ClType node, htemp;
        htemp = head;
        node = head;
        while (htemp != null){
            //找到关键字
            if (htemp.noteData.key.compareTo(key) == 0){
                node.nextNode = htemp.nextNode;
                // 释放内存
                htemp = null;
                return 1;
            }else {
                // 指向当前结点
                node = htemp;
                // 指向下一个结点
                htemp = htemp.nextNode;
            }
        }
        return 0;
    }

    /**
     * 计算链表长度
     * @param head
     * @return
     */
    int clLength(ClType head){
        ClType htemp;
        int len = 0;
        htemp = head;
        while (htemp != null){
            len ++;
            htemp = htemp.nextNode;
        }
        return len;
    }

    /**
     * 遍历链表
     * @param head
     */
    void clAllNode(ClType head){
        ClType htemp;
        LinkedData nodeDate;
        htemp = head;
        System.out.printf("当前链表共有%d个结点。链表所有数据如下：\n", clLength(head));
        while (htemp != null){
            nodeDate = htemp.noteData;
            System.out.printf("结点（%s, %s, %d）\n", nodeDate.key, nodeDate.name, nodeDate.age);
            htemp = htemp.nextNode;
        }
    }

}

/**
 * @author baymux
 */
public class LinkedList {
    static  final String BREAK = "0";
    public static void main(String[] args) {
        ClType clType = new ClType();
        ClType node, heda = null;
        String key, findkey;
        Scanner input = new Scanner(System.in);

        System.out.println("链表测试，先输入链表中的数据, 格式为：关键字 姓名 年龄");

        do {
            LinkedData nodeDate = new LinkedData();
            nodeDate.key = input.next();
            if (nodeDate.key.equals(BREAK)) {
                break;
            } else {
                nodeDate.name = input.next();
                nodeDate.age = input.nextInt();
                heda = clType.clAddEnd(heda, nodeDate);
            }
        } while (true);

        // 显示所有结点
        clType.clAllNode(heda);

        System.out.print("演示插入结点，输入插入位置的关键字：");
        findkey = input.next();
        System.out.println();
        System.out.print("输入要插入的数据， 格式为：关键字 姓名 年龄：");
        LinkedData nodeDate1 = new LinkedData();
        nodeDate1.key =input.next();
        nodeDate1.name = input.next();
        nodeDate1.age = input.nextInt();

        // 插入结点数据
        heda = clType.clInsertNode(heda, findkey, nodeDate1);
        // 显示所有结点
        clType.clAllNode(heda);

        System.out.print("演示删除结点， 输入删除关键字");
        key = input.next();
        System.out.println();
        clType.clDelNode(heda, key);
        clType.clAllNode(heda);

        System.out.print("演示查找结点，输入查找关键字：");
        key = input.next();
        System.out.println();
        node = clType.clFindNode(heda, key);
        if(node != null){
            nodeDate1 = node.noteData;
            System.out.printf("关键字%s对应的结点为：%s, %s, %d\n", key, nodeDate1.key, nodeDate1.name, nodeDate1.age);
        }else {
            System.out.printf("在链表中没有找到关键字%s的结点\n", key);
        }
    }
}