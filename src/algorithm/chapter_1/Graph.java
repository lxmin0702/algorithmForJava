package algorithm.chapter_1;

import java.util.Scanner;

/**
 * Created by baymux on 2018/1/2.
 *
 * @author baymux
 **/
public class Graph {

    static Scanner input = new Scanner(System.in);
    /**
     * 创建图
     * @param graphMatrix
     */
    static void createGraph(GraphMatrix graphMatrix){
        int i,j,k;
        // 权
        int weight;
        // 边的起始顶点
        char EstartV, EendV;
        System.out.println("输入图中各顶点的信息\n");
        for (i = 0; i < graphMatrix.VertexNum; i++){
            System.out.printf("第%d个顶点：",i+1);
            // 保存到各顶点的数组元素中
            graphMatrix.Vertex[i] = (input.next().toCharArray())[0];
        }
        System.out.println("输入构成各边的顶点及权值：\n");
        for (k = 0; k < graphMatrix.EdgeNum; k++){
            System.out.printf("第%d条边：", k+1);
            EstartV = input.next().charAt(0);
            EendV = input.next().charAt(0);
            weight = input.nextInt();
            // 在已有顶点中查找开始点
            for(i = 0; EstartV !=graphMatrix.Vertex[i]; i++);
            // 在已有顶点中查找结束点
            for(j = 0; EendV !=graphMatrix.Vertex[j]; j++);
            // 对应保存权值，表示有一条边
            graphMatrix.EdgeWeight[i][j] = weight;
            // 若是无向图
            if (graphMatrix.GraphType == 0){
                // 在对角位置保存权值
                graphMatrix.EdgeWeight[j][i] = weight;
            }
        }

    }

    /**
     * 清空图
     * @param graphMatrix
     */
    static void clearGraph(GraphMatrix graphMatrix){
        int i, j;
        // 清空矩阵
        for (i = 0; i < graphMatrix.VertexNum; i++) {
            for (j = 0; j < graphMatrix.VertexNum; j++) {
                graphMatrix.EdgeWeight[i][j] = GraphMatrix.MAXVALUE;
            }
        }
    }

    /**
     * 显示图
     * @param graphMatrix
     */
    static void outGraph(GraphMatrix graphMatrix){
        int i,j;
        for (j = 0; j < graphMatrix.VertexNum; j++) {
            System.out.printf("\t%c", graphMatrix.Vertex[j]);
        }
        System.out.println();
        for (i = 0; i < graphMatrix.VertexNum; i++) {
            System.out.printf("%c", graphMatrix.Vertex[i]);
            for (j = 0; j < graphMatrix.VertexNum; j++) {
                if (graphMatrix.EdgeWeight[i][j] == GraphMatrix.MAXVALUE){
                    System.out.println("\t Z");
                }else {
                    System.out.printf("\t%d", graphMatrix.EdgeWeight[i][j]);
                }
            }
            System.out.println();
        }
    }

    /**
     * 从第n个结点开始， 深度遍历图
     * @param graphMatrix
     * @param n
     */
    static void deepTraOne(GraphMatrix graphMatrix, int n){
        int i;
        // 标记该顶点已经处理过
        graphMatrix.isTrav[n] = 1;
        // 输出结点数据
        System.out.printf("->%c", graphMatrix.Vertex[n]);

        // 添加处理结点的操作
        for (i = 0; i < graphMatrix.VertexNum; i++) {
            if (graphMatrix.EdgeWeight[n][i] != GraphMatrix.MAXVALUE && graphMatrix.isTrav[n] == 0){
                // 递归遍历
                deepTraOne(graphMatrix, i);
            }
        }
    }

    /**
     * 深度优先遍历
     * @param graphMatrix
     */
    static void deepTraGraph(GraphMatrix graphMatrix){
        int i;
        for (i = 0; i < graphMatrix.VertexNum; i++) {
            // 清除各顶点遍历标志
            graphMatrix.isTrav[i] = 0;
        }

        System.out.println("深度优先遍历结点：");

        for (i = 0; i < graphMatrix.VertexNum; i++) {
            if (graphMatrix.isTrav[i] == 0){
                deepTraOne(graphMatrix, i);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        GraphMatrix graphMatrix = new GraphMatrix();
        System.out.println("输入生成图的类型：");
        graphMatrix.GraphType = input.nextInt();
        System.out.println("输入图的顶点数量：");
        graphMatrix.VertexNum = input.nextInt();
        System.out.println("输入图的边数量：");
        graphMatrix.EdgeNum = input.nextInt();
        clearGraph(graphMatrix);
        createGraph(graphMatrix);
        System.out.println("该图的邻接矩阵数据如下：\n");
        outGraph(graphMatrix);
        deepTraGraph(graphMatrix);
    }
}


/**
 * 准备数据
 */
class GraphMatrix{
    static final int MAXNUM = 20;
    static final int MAXVALUE = 65535;
    /**
     * 保存顶点信息
     */
    char[] Vertex = new char[MAXNUM];

    /**
     * 图的类型 0 无向图   1 有向图
     */
    int GraphType;
    /**
     *  顶点的数量
     */
    int VertexNum;

    /**
     * 边的数量
     */
    int EdgeNum;

    /**
     * 保存边的权
     */
    int[][] EdgeWeight = new int[MAXNUM][MAXNUM];

    int[] isTrav = new int[MAXNUM];
}
