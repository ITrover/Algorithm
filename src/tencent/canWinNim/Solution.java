package tencent.canWinNim;

/**
 * @author itrover
 * 292. Nim 游戏 https://leetcode-cn.com/problems/nim-game/
 * 推理
 */
class Solution {
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}
