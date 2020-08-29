package graph;

/**
 * @author MaYunHao
 * @version 1.0
 * @description
 * @date 2020/7/18 10:53
 */

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 求解每个点到其他点的最短路径
 * 也可以用dijkstra算法
 * 但是floyd算法更加简洁，时间复杂度，同为o(n^3)
 *
 * 每次插入一个结点
 */
public class Floyd {
    public static final int INTFINY = 10000;

    public void floyd(int[][] edge, int[][] d, int[][] path) {
        int length = edge.length;
        // 初始化
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                d[i][j] = edge[i][j];
                path[i][j] = -1;
            }
        }
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                for (int k = 0; k < length; k++) {
                    // 更新最短路径, 不更新自身
                    // 插入结点，如果是两个结点之一，无意义。
                    if (j != i && k != i && j != k) {
                        int len = d[j][i] + d[i][k];
                        if (len < d[j][k]) {
                            // 当前的最短路径
                            d[j][k] = len;
                            // 插入的结点，也就是中间结点
                            path[j][k] = i;
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] edge = {{INTFINY, 2, 4, 22, INTFINY, INTFINY},
                {2, INTFINY, 1, 6, INTFINY, INTFINY},
                {4, 1, INTFINY, 1, 4, INTFINY},
                {22, 6, 1, INTFINY, 10, 5},
                {INTFINY, INTFINY, 4, 10, INTFINY, 3},
                {INTFINY, INTFINY, INTFINY, 5, 3, INTFINY}};
        Floyd floyd = new Floyd();
        int[][] d = new int[edge.length][edge.length];
        int[][] p = new int[edge.length][edge.length];
        floyd.floyd(edge, d, p);
        System.out.println("最短路径长度");
        for (int i = 0; i < edge.length; i++) {
            System.out.println(Arrays.toString(d[i]));
        }
        System.out.println("插入结点");
        for (int i = 0; i < edge.length; i++) {
            System.out.println(Arrays.toString(p[i]));
        }
    }

}
