package tencent.spiralOrder;

import java.util.ArrayList;
import java.util.List;

class Solution2 {

    static class Position {
        int left;
        int right;
        int up;
        int down;

        public Position(int left, int right, int up, int down) {
            this.left = left;
            this.right = right;
            this.up = up;
            this.down = down;
        }

        public boolean isValid() {
            return left <= right && up <= down;
        }
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new ArrayList<>();
        }
        int n = matrix.length;
        int m = matrix[0].length;
        int len = n * m;
        List<Integer> res = new ArrayList<>(len);
        Position p = new Position(0, m - 1, 0, n - 1);
        while (p.isValid()) {
            // 左到右
            leftToRight(matrix, res, p);
            // 上到下
            upToDown(matrix, res, p);
            // 右到左
            rightToLeft(matrix, res, p);
            // 下到上
            downToUp(matrix, res, p);
        }
        return res;
    }

    private void leftToRight(int[][] matrix, List<Integer> res, Position p) {
        if (!p.isValid()) {
            return;
        }
        int k = p.left;
        // 从左到右
        while (k <= p.right) {
            res.add(matrix[p.up][k]);
            k++;
        }
        p.up++;
    }

    private void upToDown(int[][] matrix, List<Integer> res, Position p){
        if (!p.isValid()){
            return;
        }
        int k = p.up;
        // 从上到下
        while (k <= p.down) {
            res.add(matrix[k][p.right]);
            k++;
        }
        p.right--;
    }

    private void rightToLeft(int[][] matrix, List<Integer> res, Position p){
        if (!p.isValid()){
            return;
        }
        int k = p.right;
        // 从右到左
        while (k >= p.left) {
            res.add(matrix[p.down][k]);
            k--;
        }
        p.down--;
    }

    private void downToUp(int[][] matrix, List<Integer> res, Position p){
        if (!p.isValid()){
            return;
        }
        int k = p.down;
        // 从下到上
        while (k >= p.up) {
            res.add(matrix[k][p.left]);
            k--;
        }
        p.left++;
    }
}
