package everyday.videoStitching;

import java.util.Arrays;

/**
 * @author itrover
 * 1024. 视频拼接 https://leetcode-cn.com/problems/video-stitching/
 * 贪心算法
 * 时间复杂度o(n*log(n))
 */
class Solution {
    public int videoStitching(int[][] clips, int T) {
        Arrays.sort(clips, (a, b) -> a[0] - b[0]);
        // 起点不在0，不可能有结果
        if (clips[0][0] > 0) {
            return -1;
        }
        // 前一个区间的最后位置
        int b = 0;
        // 寻找第一个区间
        int res = 1;
        int t = 0;
        int i = 0;
        int j = 0;
        while (i < clips.length) {
            if (clips[i][0] <= b) {
                // 计算区间大小
                if (clips[i][1] - b > t) {
                    t = clips[i][1] - b;
                    j = i;
                }
                i++;
            } else {
                b = clips[j][1];
                t = 0;
                // 满足了条件可以直接返回了
                if (b >= T) {
                    break;
                }
                // 不存在满足目标的区间
                if (clips[i][0] > b) {
                    return -1;
                }
                // 寻找剩下的区间
                res++;
            }
        }
        b = clips[j][1];
        return b >= T ? res : -1;
    }
}
