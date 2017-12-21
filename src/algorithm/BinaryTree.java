package algorithm;

import java.util.Scanner;

/**
 * Created by baymux on 2017/12/21.
 *
 * @author baymux
 **/
public class BinaryTree {
    static final int MAXLEN;
    static {
        MAXLEN = 20;
    }
    Scanner input = new Scanner(System.in);

    /**
     * 初始化二叉树
     * @return
     */
    TreeType initTree(){
        TreeType node;
        // 申请内存
        if ((node = new TreeType()) != null){
            System.out.println("请先输入一个根节点数据：");
            node.data = input.next();
            // 设置左子树和右子树引用为空
            node.left = null;
            node.right = null;

            if (node != null){
                return node;
            }else {
                return null;
            }
        }
        return null;
    }

    void addTreeNode(TreeType treeNode){
        TreeType pnode, parent;
        String data;
        int menusel;

        // 分配内存
        if ((pnode = new TreeType()) != null) {
            System.out.println("输入二叉树结点数据");
            pnode.data = input.next();
            // 设置左右子树为空
            pnode.left = null;
            pnode.right = null;

            System.out.println("输入该节点的父节点数据：");
        }
    }
}

/**
 * 准备数据
 * 定义二叉树结构类型
 */
class TreeType{
    /**
     * 元素数据
     */
    String data;
    /**
     * 左子树结点引用
     */
    TreeType left;
    /**
     * 右子树结点引用
     */
    TreeType right;
}
