package leetcode.verifyPostorder;

/**
 * @author MaYunHao
 * @version 1.0
 * @description
 * @date 2020/9/3 14:33
 * 剑指 Offer 33.二叉搜索树的后序遍历序列
 * 利用二叉搜索树序列的特点
 * 1. 序列的最后一个数一定是树的跟结点
 * 2. 前面小于根节点的部分是左子树，大于根结点的树是树的右子树
 * 只要能被拆分成小于根节点和大于根结点的两部分
 * 就是二叉搜索树
 */
public class Solution {
    public boolean verifyPostorder(int[] postorder) {
        return verifyPostorder(postorder, 0, postorder.length - 1);
    }

    /**
     * 给定一个序列
     * 判断是否能够拆成两部分
     *
     * @return
     */
    public boolean verifyPostorder(int[] postorder, int start, int end) {
        if (start >= end) {
            return true;
        }
        int mid = start;
        while (mid < end && postorder[mid] < postorder[end]) {
            // 找到第一个大于根结点的位置
            mid++;
        }
        int i = mid + 1;
        while (i < end) {
            if (postorder[i] < postorder[end]) {
                return false;
            }
            i++;
        }
        return verifyPostorder(postorder, start, mid - 1) &&
                verifyPostorder(postorder, mid, end - 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = new int[]{4, 5, 3};
        System.out.println(solution.verifyPostorder(ints));
    }
}
