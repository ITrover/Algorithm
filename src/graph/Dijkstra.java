package graph;

import java.util.Arrays;

/**
 * Dijkstra算法
 * 求解单源结点到其他结点的最短路径
 */
public class Dijkstra {
    public static final int INTFINY = 10000;

    /**
     *
     * @param edge 图
     * @param start 源节点
     * @param dis 距离
     * @param p 路径的前一个结点 pre
     */
    public void djsk(int[][] edge, int start, int dis[], int p[]) {
        //初始化
        // 标记是否访问过
        Boolean[] bj = new Boolean[edge.length];
        for (int i = 0; i < edge.length; i++) {
            // 源节点到任意结点的直接距离
            dis[i] = edge[start][i];
            bj[i] = false;
        }
        //将初始点标记为已经访问过
        bj[start] = true;
        dis[start] = 0;
        p[start] = -1;
        //核心算法
        for (int i = 0; i < edge.length; i++) {
            //findMin
            //寻找未访问的节点中离起始点最近的节点
            int k = 0;
            int min = INTFINY;
            for (int j = 0; j < edge.length; j++) {
                // 找到没有访问过，同时也是最近的结点
                if (!bj[j] && dis[j] < min) {
                    min = dis[j];
                    k = j;
                }
            }
            //将最近的节点标记为已访问
            bj[k] = true;
            //update
            //通过刚才找到的最近节点，刷新最短路径
            for (int j = 0; j < edge.length; j++) {
                if (!bj[j] && dis[j] > dis[k] + edge[k][j]) {
                    dis[j] = dis[k] + edge[k][j];
                    //记录前驱
                    p[j]=k;
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
        Dijkstra dijkstra = new Dijkstra();
        // 最短路径
        int[] dis = new int[edge.length];
        // 前驱
        int[] p = new int[edge.length];
        dijkstra.djsk(edge,1,dis,p);
        System.out.println(Arrays.toString(dis));
        System.out.println(Arrays.toString(p));
    }
}
