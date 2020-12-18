# Leetcode 算法题



### Hash相关

| 题目                                                         | 关键字                         |        |
| ------------------------------------------------------------ | ------------------------------ | ------ |
| [387. 字符串中的第一个唯一字符](src/leetcode/firstUniqChar)  | 哈希表                         |        |
| [381. O(1) 时间插入、删除和获取随机元素 - 允许重复](src/everyday/RandomizedCollection) | 哈希表、技巧、数据结构组合使用 | 重点题 |
| [42. 有效的字母异位词](src/everyday/isAnagram) | 哈希表、数组、排序 |  |
| [454. 四数相加 II](src/everyday/fourSumCount) | 哈希表 |  |
| [146. LRU缓存机制](src/tencent/LRUCache) | 哈希表、双向链表 | 重点题 |
| [290. 单词规律](src/everyday/wordPattern) | 哈希表、双向映射 | 重点题 |





### 树的遍历

|                            题目                            |         关键字         |                  |
| :--------------------------------------------------------: | :--------------------: | ---------------------- |
|   [129. 求根到叶子节点数字之和](src/everyday/sumNumbers)   |     先序遍历、递归     |          |
| [1325. 删除给定值的叶子节点](src/leetcode/removeLeafNodes) |          递归          |                    |
|         [226. 翻转二叉树](src/leetcode/invertTree)         |          递归          |                    |
|       [98. 验证二叉搜索树](src/leetcode/isValidBST)        | 先序遍历/递归/层次遍历 |  |
|       [124. 二叉树中的最大路径和](src/tencent/maxPathSum)        | 后序遍历/递归 |  |
|       [剑指 Offer 26. 树的子结构](src/swordToOffer/isSubStructure)        | 递归、树的遍历、穷举 | 重点题 |
|       [剑指 Offer 68 - II. 二叉树的最近公共祖先](src/swordToOffer/lowestCommonAncestor)        | 递归 | 重点题 |
|       [230. 二叉搜索树中第K小的元素](src/tencent/kthSmallest)        |中序遍历 |  |
|       [剑指 Offer 68 - I. 二叉搜索树的最近公共祖先](src/swordToOffer/lowestCommonAncestor)        |迭代、递归、二叉搜索树的特性、后序遍历 |  |






### 动态规划
|                             题目                             |            关键字            |        |
| :----------------------------------------------------------: | :--------------------------: | ------ |
| [1277. 统计全为 1 的正方形子矩阵](src/leetcode/countSquares) |           动态规划           |        |
|            [118. 杨辉三角](src/leetcode/generate)            |           动态规划           |        |
|       [300. 最长上升子序列](src/leetcode/lengthOfLIS)        | 动态规划、二分查找、贪心算法 | 重点题 |
| [1143. 最长公共子序列](src/leetcode/longestCommonSubsequence) |           动态规划           | 重点题 |
|        [416. 分割等和子集](src/everyday/canPartition)        |     动态规划/0-1背包问题     | 重点题 |
|        [LCP 19. 秋叶收藏集](src/everyday/minimumOperations)        |     动态规划   | 重点题 |
|        [514. 自由之路](src/everyday/findRotateSteps)        |     动态规划、dfs   | 重点题 |
|        [零钱兑换](src/everyday/coinChange)        |     动态规划、dfs   | 重点题 |
|        [309. 最佳买卖股票时机含冷冻期 ](src/swordToOffer/maxProfit/improve2)        |     动态规划、bfs   | 重点题 |
|        [剑指 Offer 49. 丑数](src/swordToOffer/uglyNumber)        |     动态规划   | 重点题 |



### 模拟

|                      题目                       |       关键字        |        |
| :---------------------------------------------: | :-----------------: | ------ |
| [463. 岛屿的周长](src/everyday/islandPerimeter) | 模拟、暴力破解、BFS |        |
|       [57. 插入区间](src/everyday/insert)       |   模拟、分段求解    | 重点题 |
|       [1370. 上升下降字符串](src/everyday/sortString)       |   模拟、借助数组   |  |
|       [88. 合并两个有序数组](src/tencent/spiralOrder)       |   模拟、数组   |  |





### 快慢指针

|                      题目                      |             关键字             |
| :--------------------------------------------: | :----------------------------: |
|      [202. 快乐数](src/leetcode/isHappy)       | 快慢指针/哈希表/出现循环的判断 |
| [876. 链表的中间结点](src/leetcode/middleNode) |            快慢指针            |



### 双指针

|                          题目                          |   关键字    |
| :----------------------------------------------------: | :---------: |
| [941. 有效的山脉数组](src/everyday/validMountainArray) | 双指针/模拟 |
| [328. 奇偶链表](src/everyday/oddEvenList) | 双指针、链表操作 | 重点题 |
| [283. 移动零](src/everyday/moveZeroes) | 双指针 | 重点题 |
| [922. 按奇偶排序数组 II](src/everyday/sortArrayByParityII) | 双指针 |  |
| [剑指 Offer 52. 两个链表的第一个公共节点](src/swordToOffer/getIntersectionNode) | 双指针、技巧 | |
| [524. 通过删除字母匹配到字典里最长单词](src/leetcode/findLongestWord) | 双指针 | |



### 字典树

|                    题目                    |    关键字     |        |
| :----------------------------------------: | :-----------: | ------ |
| [648. 单词替换](src/leetcode/replaceWords) | 字典树/hash表 | 重点题 |



### 回溯

|                  题目                   |    关键字     |        |
| :-------------------------------------: | :-----------: | ------ |
| [139. 单词拆分](src/everyday/wordBreak) | 回溯/动态规划 | 重点题 |
| [40. 组合总和 II](src/everyday/combinationSum/improve) | 回溯、剪枝 | 重点题 |
| [剑指 Offer 38. 字符串的排列](src/swordToOffer/permutation) | 回溯、dfs、剪枝 | 重点题 |



### 二叉搜索树

|                          题目                          | 关键字 |      |
| :----------------------------------------------------: | :----: | ---- |
| [450. 删除二叉搜索树中的节点](src/leetcode/deleteNode) |  递归  |      |



### 链表

|                   题目                   |         关键字         |        |
| :--------------------------------------: | :--------------------: | ------ |
| [146. LRU缓存机制](src/tencent/LRUCache) | 双向链表/LinkedHashMap | 重点题 |
| [147. 对链表进行插入排序](src/everyday/insertionSortList) | 链表、伪头 |  |
| [148. 排序链表](src/everyday/sortList) | 链表、递归、归并排序 |  |
| [237. 删除链表中的节点](src/tencent/deleteNode) | 链表操作 |  |
| [剑指 Offer 24. 反转链表](src/swordToOffer/reverseList) | 双指针/递归/栈 |  |





### 图

|                    题目                    |      关键字       |        |
| :----------------------------------------: | :---------------: | ------ |
| [127. 单词接龙](src/everyday/ladderLength) | BFS、队列、Hash表 | 重点题 |



### 位运算

|                             题目                             |               关键字               |      |
| :----------------------------------------------------------: | :--------------------------------: | ---- |
| [1356. 根据数字二进制下 1 的数目排序](src/everyday/sortByBits) | 位运算、改变排序规则、题目条件利用 |      |
| [剑指 Offer 56 - I. 数组中数字出现的次数](src/swordToOffer/singleNumbers) | 位运算、分组异或 |      |
| [389. 找不同](src/everyday/findTheDifference) | 异或/排序/计数/求和 |      |



### 技巧性

|                      题目                      |   关键字   |      |
| :--------------------------------------------: | :--------: | ---- |
|     [73. 矩阵置零](src/leetcode/setZeroes)     | 数组、技巧 |      |
| [31. 下一个排列](src/everyday/nextPermutation) |   找规律   |      |
| [406. 根据身高重建队列](src/everyday/reconstructQueue) |   思路、排序、插入   |      |
| [剑指 Offer 64. 求1+2+…+n](src/swordToOffer/sumNums) |   技巧性、&&短路的利用   |      |
| [剑指 Offer 66. 构建乘积数组](src/swordToOffer/constructArr) |   技巧性、规律   |      |
| [169. 多数元素](src/swordToOffer/majorityElement) |   摩尔投票法/哈希/快排思想   |      |
| [剑指 Offer 30. 包含min函数的栈](src/swordToOffer/minStack) |   使用辅助栈   |      |
| [43. 字符串相乘](src/tencent/multiply) |   字符串相乘   |   重点题   |



### 排序

|                       题目                        |          关键字          |        |
| :-----------------------------------------------: | :----------------------: | ------ |
|  [327. 区间和的个数](src/everyday/countRangeSum)  | 归并排序、动态规划、分治 | 重点题 |
| [973. 最接近原点的 K 个点](src/everyday/kClosest) |    快速排序/优先队列     |        |
| [1122. 数组的相对排序](src/everyday/relativeSortArray) |    修改排序规则/计数     |        |
| [1030. 距离顺序排列矩阵单元格](src/everyday/allCellsDistOrder) |    桶排序/排序/BFS/几何     |        |
| [164. 最大间距](src/everyday/maximumGap) |    桶排序/基数排序    |        |
| [剑指Offer45.把数组排成最小的数](src/swordToOffer/minNumber) |    修改排序规则    |  重点题      |
| [49. 字母异位词分组](src/everyday/groupAnagrams) |    排序/计数、哈希    |  重点题      |
| [75. 颜色分类](src/leetcode/sortColors) |   桶排序/双指针/技巧    |        |


### 贪心算法

|                             题目                             |       关键字       |      |
| :----------------------------------------------------------: | :----------------: | ---- |
| [122. 买卖股票的最佳时机 II](src/swordToOffer/maxProfit/improve) | 贪心算法、动态规划 |      |
| [402. 移掉K位数字](src/everyday/removeKdigits) | 贪心算法/单调栈（注意越界问题） |      |
| [134. 加油站 ](src/everyday/canCompleteCircuit) | 贪心算法、枚举 | 重点题      |
| [452. 用最少数量的箭引爆气球 ](src/everyday/findMinArrowShots) | 贪心算法、排序、区间合并 | 重点题      |
| [738. 单调递增的数字 ](src/everyday/monotoneIncreasingDigits) | 贪心算法、发现规律 | 重点题      |
| [714. 买卖股票的最佳时机含手续费](src/swordToOffer/maxProfit/improve4) | 贪心算法、动态规划 | 重点题      |
| [455. 分发饼干](src/leetcode/findContentChildren) | 排序 + 贪心算法 |       |



### 数字

|                      题目                      |         关键字         |        |
| :--------------------------------------------: | :--------------------: | ------ |
|    [258. 各位相加](src/leetcode/addDigits)     |  递归、找规律、表达式  |        |
| [172. 阶乘后的零](src/leetcode/trailingZeroes) | 数学公式、技巧、找因子 | 重点题 |
| [231. 2的幂](src/tencent/isPowerOfTwo) | 余/二进制 | 重点题 |


### 二分查找

|                      题目                      |         关键字         |        |
| :--------------------------------------------: | :--------------------: | ------ |
|    [222. 完全二叉树的节点个数](src/everyday/countNodes)     |  二分查找、位运算、完全二叉树  |        |
|    [34. 在排序数组中查找元素的第一个和最后一个位置](src/leetcode/searchRange)     |  二分查找  |        |


### 数学推导

|                      题目                      |         关键字         |        |
| :--------------------------------------------: | :--------------------: | ------ |
|    [剑指 Offer 14- I. 剪绳子](src/swordToOffer/cuttingRope)     |  数学推导、贪心算法、循环求余  |  重点题     |
|    [剑指 Offer 16. 数值的整数次方](src/swordToOffer/myPow)     |  二分法、快速幂  |  重点题     |


### 队列

|                      题目                      |         关键字         |        |
| :--------------------------------------------: | :--------------------: | ------ |
|    [剑指 Offer 59 - I. 滑动窗口的最大值](src/swordToOffer/maxSlidingWindow)     |  双端队列、单调队列  |  重点题     |


### 前缀和

|                      题目                      |         关键字         |        |
| :--------------------------------------------: | :--------------------: | ------ |
|    [560. 和为K的子数组](src/leetcode/subarraySum)     |  前缀和、HashMap  |  重点题     |
