package algorithm.chapter1;

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
    static Scanner input = new Scanner(System.in);

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

    /**
     * 查找结点
     * @param treeType
     * @param data
     * @return
     */
    TreeType findTreeNode(TreeType treeType, String data){
        TreeType ptr;
        if (treeType == null){
            return null;
        }
        else {
            if (treeType.data.equals(data)){
                return treeType;
            }else{
                // 分别向左右子树递归查找
                if ((ptr=findTreeNode(treeType.left, data)) != null){
                    return ptr;
                }else if ((ptr = findTreeNode(treeType.right, data)) != null){
                    return ptr;
                }else{
                    return null;
                }
            }
        }
    }

    /**
     * 添加二叉树
     * @param treeNode
     */
    void addTreeNode(TreeType treeNode){
        TreeType pnode, parent;
        String data;
        /**
         * 选择项
         */
        int menusel;

        // 分配内存
        if ((pnode = new TreeType()) != null) {
            System.out.println("输入二叉树结点数据");
            pnode.data = input.next();
            // 设置左右子树为空
            pnode.left = null;
            pnode.right = null;

            System.out.println("输入该节点的父节点数据：");
            data = input.next();

            // 查找指定数据的结点
            parent = findTreeNode(treeNode, data);
            // 如果未找到
            if (parent == null){
                System.out.println("未找到父结点！");
                // 释放创建的内存结点
                pnode = null;
                return;
            }

            System.out.println("1. 添加该结点到左子树， 2. 添加该结点到右子树");
            do {
                // 输入选择项
                menusel = input.nextInt();
                if (menusel == 1 || menusel == 2){
                    if (parent == null){
                        System.out.println("不存在父结点，请先设置父结点");
                    }
                    else {
                       switch (menusel){
                           case 1:
                               // 添加到左结点，左子树不为空
                               if (parent.left != null){
                                   System.out.println("左子树结点不为空！");
                               }else {
                                   parent.left = pnode;
                               }
                               break;
                           case 2:
                               // 添加到右结点， 右子树不能为空
                               if (parent.right != null){
                                   System.out.println("右子树结点不为空！");
                               }else {
                                   parent.right = pnode;
                               }
                               break;
                           default:
                               System.out.println("无效参数");
                       }
                    }
                }
            } while (menusel != 1 && menusel != 2);

        }
    }

    /**
     * 获取左子树
     * @param treeType
     * @return
     */
    TreeType getLeftNode(TreeType treeType){
        if (treeType != null){
            return treeType.left;
        }else {
            return null;
        }
    }

    /**
     * 获取右子树
     * @param treeType
     * @return
     */
    TreeType getRightNode(TreeType treeType){
        if (treeType != null){
            return treeType.right;
        }else {
            return null;
        }
    }

    /**
     * 判断是否为空
     * @param treeType
     * @return
     */
    int treeIsEmpt(TreeType treeType){
        if (treeType != null){
            return 0;
        }else{
            return 1;
        }
    }

    /**
     * 计算二叉树深度
     * @param treeType
     * @return
     */
    int treeDepth(TreeType treeType){
        int depLeft, depRight;
        if (treeType == null){
            // 空树， 深度为0
            return 0;
        }else {
            // 递归调用
            depLeft = treeDepth(treeType.left);
            depRight = treeDepth(treeType.right);

            if (depLeft > depRight){
                return depLeft + 1;
            }else {
                return depRight + 1;
            }
        }
    }

    /**
     * 清空二叉树
     * @param treeType
     */
    void clearTree(TreeType treeType){
        if(treeType != null){
            // 清空左右子树
            clearTree(treeType.left);
            clearTree(treeType.right);
            // 释放当前结点所占内存
            treeType = null;
        }
    }

    /**
     * 显示结点数据
     * @param treeType
     */
    void treeData(TreeType treeType){
        System.out.printf("%s", treeType.data);
    }

    /**
     * 按层遍历
     * @param treeType
     */
    void levelTree(TreeType treeType){
        TreeType p;
        // 定义一个顺序栈
        TreeType[] q = new TreeType[MAXLEN];
        int head = 0, tail = 0;

        if (treeType != null){
            // 计算循环队列队尾序号
            tail = (tail+1) % MAXLEN;
            // 将二叉树根引用进队
            q[tail] = treeType;
        }
        // 队列不为空, 进行循环
        while(head != tail){
            // 计算循环队列的首序号
            head = (head +1) % MAXLEN;
            // 获取队首元素
            p = q[head];
           // 处理队首元素
            treeData(p);
            // 如果结点存在左子树
            if (p.left != null){
                tail = (tail +1) % MAXLEN;
                q[tail] = p.left;
            }

            // 如果结点存在右子树
            if (p.right != null){
                tail = (tail + 1) % MAXLEN;
                q[tail] = p.right;
            }
        }
    }

    /**
     * 先序遍历算法-- 左根右
     * @param treeType
     */
    void DLRTree(TreeType treeType){
        if(treeType != null){
            // 显示结点数据
            treeData(treeType);
            DLRTree(treeType.left);
            DLRTree(treeType.right);
        }
    }

    /**
     * 中序遍历算法-- 根左右
     * @param treeType
     */
    void LDRtree(TreeType treeType){
        if (treeType != null){
            // 中序遍历左子树
            LDRtree(treeType.left);
            // 显示结点数据
            treeData(treeType);
            // 中序遍历右子树
            LDRtree(treeType.right);
        }
    }

    /**
     * 后序遍历算法 -- 右
     * @param treeType
     */
    void LRDtree(TreeType treeType){
        if (treeType != null){
            // 后续遍历左子树
            LRDtree(treeType.left);
            // 后续遍历右子树
            LRDtree(treeType.right);
            // 显示结点数据
            treeData(treeType);
        }
    }


    public static void main(String[] args) {
        // root 指向二叉树根节点的引用
        TreeType root = null;
        int menusel;

        BinaryTree binaryTree = new BinaryTree();
        // 设置根元素
        root = binaryTree.initTree();
        // 添加结点
        do{
            System.out.println("请选择菜单添加二叉树的结点：");
            System.out.print("0-退出    ");
            System.out.println("1-添加二叉树结点");
            menusel = input.nextInt();
            switch (menusel){
                case 1:
                    binaryTree.addTreeNode(root);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("输入错误！");
            }
        }while (menusel != 0);

        // 遍历
        do{
            System.out.println("请选择菜单遍历二叉树，输入 0 表示退出：");
            System.out.print("1-先序遍历DLR    ");
            System.out.println("2-中序遍历LDR");
            System.out.print("3-后续遍历LRD    ");
            System.out.println("4-层次遍历");
            menusel = input.nextInt();
            switch (menusel){
                case 0:
                    break;
                case 1:
                    System.out.print("\n先序遍历DLR的结果: ");
                    binaryTree.DLRTree(root);
                    System.out.println();
                    break;
                case 2:
                    System.out.print("\n中序遍历LDR的结果：");
                    binaryTree.LDRtree(root);
                    System.out.println();
                    break;
                case 3:
                    System.out.print("\n后序遍历LRD的结果：");
                    binaryTree.LRDtree(root);
                    System.out.println();
                    break;
                case 4:
                    System.out.print("\n按层次遍历的结果：");
                    binaryTree.levelTree(root);
                    System.out.println();
                    break;
                default:
                    System.out.println("输入错误！");
            }
        }while(menusel != 0);

        // 深度
        System.out.println("\n二叉树的深度为：" + binaryTree.treeDepth(root));

        // 清空二叉树
        binaryTree.clearTree(root);
        root = null;
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
