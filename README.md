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
| [205. 同构字符串](src/everyday/isIsomorphic) | 哈希表、双向映射 |  |
| [1128. 等价多米诺骨牌对的数量](src/everyday/numEquivDominoPairs) | Map/数组、计数 |  |
| [888. 公平的糖果棒交换](src/everyday/fairCandySwap) | 哈希表 |  |
| [447. 回旋镖的数量](src/leetcode/numberOfBoomerangs) | 哈希表 + 枚举 |  |
 |          递归          |                    |
|         [226. 翻转二叉树](src/leetcode/invertTree)         |          递归          |                    |
|       [98. 验证二叉搜索树](src/leetcode/isValidBST)        | 先序遍历/递归/层次遍历 |  |
|       [124. 二叉树中的最大路径和](src/tencent/maxPathSum)        | 后序遍历/递归 |  |
|       [剑指 Offer 26. 树的子结构](src/swordToOffer/isSubStructure)        | 递归、树的遍历、穷举 | 重点题 |
|       [128. 最长连续序列](src/leetcode/longestConsecutive) | 哈希表 + 枚举 |  |
| [496. 下一个更大元素 ](src/everyday/nextGreaterElement) | 哈希表 + 单调栈 |  |
| [2013. 检测正方形 ](src/everyday/DetectSquares) | 哈希表  |  |





### 树的遍历

|                            题目                            |         关键字         |                  |
| :--------------------------------------------------------: | :--------------------: | ---------------------- |
|   [129. 求根到叶子节点数字之和](src/everyday/sumNumbers)   |     先序遍历、递归     |          |
| [1325. 删除给定值的叶子节点](src/leetcode/removeLeafNodes)叉树的最近公共祖先](src/swordToOffer/lowestCommonAncestor)        | 递归 | 重点题 |
|       [230. 二叉搜索树中第K小的元素](src/tencent/kthSmallest)        |中序遍历 |  |
|       [剑指 Offer 68 - I. 二叉搜索树的最近公共祖先](src/swordToOffer/lowestCommonAncestor)        |迭代、递归、二叉搜索树的特性、后序遍历 |  |
|       [103. 二叉树的锯齿形层序遍历](src/everyday/zigzagLevelOrder)        |DFS、BFS、队列 | 重点题  |
|       [100. 相同的树](src/bytedance/isSameTree)        |递归 |  |
|       [173. 二叉搜索树迭代器](src/everyday/BSTIterator)        |中序遍历 |  |
|       [872. 叶子相似的树](src/everyday/leafSimilar)        |递归 |  |
|       [437. 路径总和 III](src/everyday/pathSum)        |dfs/前缀和 |  |




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
|        [746. 使用最小花费爬楼梯](src/everyday/minCostClimbingStairs)        |     动态规划   | 重点题 |
|        [198. 打家劫舍](src/leetcode/rob)        |     动态规划   |  |
|        [13. 打家劫舍 II](src/leetcode/rob/improve)        |     动态规划   | 重点题  |
|        [354. 俄罗斯套娃信封问题](src/everyday/maxEnvelopes)        |     动态规划、二分查找   | 重点题  |
|        [132. 分割回文串 II](src/everyday/minCut)        |     动态规划   | 重点题  |
|        [1137. 第 N 个泰波那契数](src/everyday/tribonacci)        |     动态规划   |   |
|        [516. 最长回文子序列](src/leetcode/longestCommonSubsequence/longestPalindromeSubseq)        |     动态规划   |   |
|        [63. 不同路径 II](src/tencent/uniquePaths/obstacles)        |     动态规划、回溯   |   |
|        [583. 两个字符串的删除操作](src/everyday/minDistance)        |     动态规划   |   |
|        [639. 解码方法 II](src/everyday/numDecodings)        |     回溯 dfs 记忆/动态规划   | 重点题  |
|        [1218. 最长定差子序列](src/everyday/longestSubsequence)        |     动态规划   | 重点题  |



### 模拟

|                      题目                       |       关键字        |        |
| :---------------------------------------------: | :-----------------: | ------ |
| [463. 岛屿的周长](src/everyday/islandPerimeter) | 模拟、暴力破解、BFS |        |
|       [57. 插入区间](src/everyday/insert)       |   模拟、分段求解    | 重点题 |
|       [1370. 上升下降字符串](src/everyday/sortString)       |   模拟、借助数组   |  |
|       [88. 合并两个有序数组](src/tencent/spiralOrder)       |   模拟、数组   |  |
|       [189. 旋转数组](src/everyday/rotate)       |   模拟、向前冒泡|  |
|       [1018. 可被 5 整除的二进制前缀](src/e veryday/prefixesDivBy5)       |   模拟，暴力求解|  |
|       [867. 转置矩阵](src/everyday/transpose)       |   模拟|  |
|       [482. 密钥格式化](src/everyday/licenseKeyFormatting)       |   模拟|  |





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
| [392. 判断子序列](src/leetcode/isSubsequence) | 双指针/String的indexOf方法 | |
| [435. 无重叠区间](src/everyday/eraseOverlapIntervals) | 双指针/按照末尾排序 | |
| [86. 分隔链表](src/everyday/partition) | 双指针 | |
| [978. 最长湍流子数组](src/everyday/maxTurbulenceSize) | 双指针/动态规划 | |
| [832. 翻转图像](src/everyday/flipAndInvertImage) | 双指针 | |
| [80. 删除有序数组中的重复项 II](src/everyday/removeDuplicates2) | 三指针 | |


### 字典树

|                    题目                    |    关键字     |        |
| :----------------------------------------: | :-----------: | ------ |
| [648. 单词替换](src/leetcode/replaceWords) | 字典树/hash表 | 重点题 |
| [211. 添加与搜索单词 - 数据结构设计](src/everyday/WordDictionary) | 字典树/hash表 |  |



### 回溯

|                  题目                   |    关键字     |        |
| :-------------------------------------: | :-----------: | ------ |
| [139. 单词拆分](src/everyday/wordBreak) | 回溯/动态规划 | 重点题 |
| [40. 组合总和 II](src/everyday/combinationSum/improve) | 回溯、剪枝 | 重点题 |
| [剑指 Offer 38. 字符串的排列](src/swordToOffer/permutation) | 回溯、dfs、剪枝 | 重点题 |
| [131. 分割回文串](src/everyday/partition_palindrome) | 回溯、动态规划预处理、记忆 |  |
| [90. 子集 II](src/everyday/subsetsWithDup) | 回溯 |  |
| [17. 电话号码的字母组合](src/everyday/letterCombinations) | 回溯 |  |
| [282. 给表达式添加运算符](src/everyday/addOperators) | 回溯 | 重点题 |
| [79. 单词搜索](src/leetcode/exist) | 回溯 |  |



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
| [89. 数组形式的整数加法](src/everyday/addToArrayForm) | /栈/链表/数组/题目条件 |  |
| [725. 分隔链表](src/everyday/splitListToParts) | 链表操作 |  |
| [430. 扁平化多级双向链表](src/everyday/flatten) | 链表操作、dfs |  |





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
| [371. 两整数之和](src/everyday/getSum) | 位运算 |      |
| [405. 数字转换为十六进制数](src/everyday/toHex) | 位运算 |      |
| [面试题 16.01. 交换数字](src/leetcode/swapNumbers) | 位运算 |      |



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
| [907. 子数组的最小值之和](src/bytedance/sumSubarrayMins) |   最小栈   |   重点题   |
| [448. 找到所有数组中消失的数字](src/everyday/findDisappearedNumbers) |   数组原地修改   |   重点题   |
| [1006. 笨阶乘](src/everyday/clumsy) |   暴力/栈/发现规律   |      |
| [453. 最小操作次数使数组元素相等](src/everyday/minMoves) |  技巧   |      |
| [229. 求众数 II](src/everyday/majorityElement) |  摩尔投票法/哈希   |      |



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
| [451. 根据字符出现频率排序](src/leetcode/frequencySort) |   哈希、桶排序、堆排序   |        |
| [1046. 最后一块石头的重量](src/everyday/lastStoneWeight) |   大顶堆   |        |
| [703. 数据流中的第 K 大元素](src/everyday/KthLargest) |   小顶堆   |   重点题     |
| [274. H 指数](src/everyday/hIndex) |   排序   |   重点题     |
| [1996. 游戏中弱角色的数量](src/everyday/numberOfWeakCharacters) |   排序   |   重点题     |


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
| [605. 种花问题](src/leetcode/canPlaceFlowers) | 贪心、判断条件考虑周全 |       |
| [665. 非递减数列 ](src/leetcode/checkPossibility) | 贪心、分情况讨论 | 重点题      |
| [135. 分发糖果](src/everyday/candy) | 贪心 | 重点题      |
| [674. 最长连续递增序列](src/everyday/findLengthOfLCIS) | 贪心 | 重点题      |
| [316. 去除重复字母](src/everyday/removeDuplicateLetters) | 贪心+单调栈 | 重点题      |
| [502. IPO](src/leetcode/findMaximizedCapital) | 堆、贪心算法 | 重点题      |
| [517. 超级洗衣机](src/everyday/findMinMoves) | 贪心算法 | 重点题      |
| [1414. 和为 K 的最少斐波那契数字数目](src/everyday/findMinFibonacciNumbers) | 贪心算法 | 重点题      |



### 数字

|                      题目                      |         关键字         |        |
| :--------------------------------------------: | :--------------------: | ------ |
|    [258. 各位相加](src/leetcode/addDigits)     |  递归、找规律、表达式  |        |
| [172. 阶乘后的零](src/leetcode/trailingZeroes) | 数学公式、技巧、找因子 | 重点题 |
| [231. 2的幂](src/tencent/isPowerOfTwo) | 余/二进制 | 重点题 |
| [1232. 缀点成线](src/everyday/checkStraightLine) | 斜率 |  |
| [166. 分数到小数](src/everyday/fractionToDecimal) | 长除法 | 重点题  |


### 二分查找

|                      题目                      |         关键字         |        |
| :--------------------------------------------: | :--------------------: | ------ |
|    [222. 完全二叉树的节点个数](src/everyday/countNodes)     |  二分查找、位运算、完全二叉树  |        |
|    [34. 在排序数组中查找元素的第一个和最后一个位置](src/leetcode/searchRange)     |  二分查找  |        |
|    [74. 搜索二维矩阵](src/everyday/searchMatrix)     |  二分查找  |        |
|    [1011. 在 D 天内送达包裹的能力](src/everyday/shipWithinDays)     |  二分查找  |   重点题     |
|    [1482. 制作 m 束花所需的最少天数](src/everyday/minDays)     |  二分查找  |   重点题     |
|    [162. 寻找峰值](src/everyday/findPeakElement)     |  二分查找  |        |
|    [1894. 找到需要补充粉笔的学生编号 ](src/leetcode/chalkReplacer)     |  二分查找+前缀和  |        |
|    [240. 搜索二维矩阵 II ](src/everyday/searchMatrix)     |  二分查找  |        |


### 数学推导

|                      题目                      |         关键字         |        |
| :--------------------------------------------: | :--------------------: | ------ |
|    [剑指 Offer 14- I. 剪绳子](src/swordToOffer/cuttingRope)     |  数学推导、贪心算法、循环求余  |  重点题     |
|    [剑指 Offer 16. 数值的整数次方](src/swordToOffer/myPow)     |  二分法、快速幂  |  重点题     |


### 滑动窗口

|                      题目                      |         关键字         |        |
| :--------------------------------------------: | :--------------------: | ------ |
|    [剑指 Offer 59 - I. 滑动窗口的最大值](src/swordToOffer/maxSlidingWindow)     |  双端队列、单调队列  |  重点题     |
|    [239. 滑动窗口最大值](src/everyday/maxSlidingWindow)     |  双端队列、单调队列  |  重点题     |
|    [DD-2020006. 简单游戏](src/swordToOffer/maxSlidingWindow/improve)     |  滑动窗口、贪心算法  |  重点题     |
|    [424. 替换后的最长重复字符](src/everyday/characterReplacement)     |  滑动窗口、双指针  |  重点题     |
|    [643. 子数组最大平均数 I](src/everyday/findMaxAverage)     |  滑动窗口  |       |
|    [1423. 可获得的最大点数](src/everyday/maxScore)     |  滑动窗口/前缀和  |       |
| [992. K 个不同整数的子数组](src/everyday/subarraysWithKDistinct) | 滑动窗口 | 重点题 |
| [567. 字符串的排列](src/everyday/checkInclusion) | 滑动窗口 |  |
| [1438. 绝对差不超过限制的最长连续子数组](src/everyday/longestSubarray) | 滑动窗口、有序集合、单调队列 |  |
| [1052. 爱生气的书店老板](src/everyday/maxSatisfied) | 滑动窗口 |  |
| [395. 至少有 K 个重复字符的最长子串](src/everyday/longestSubstring) | 滑动窗口、枚举/分治法 | 重点题  |


### 前缀和

|                      题目                      |         关键字         |        |
| :--------------------------------------------: | :--------------------: | ------ |
|    [560. 和为K的子数组](src/leetcode/subarraySum)     |  前缀和、HashMap  |  重点题     |
|    [724. 寻找数组的中心索引](src/everyday/pivotIndex)     |  前缀和  |       |

### 分情况讨论

|                      题目                      |         关键字         |        |
| :--------------------------------------------: | :--------------------: | ------ |
|    [面试题 01.05. 一次编辑](src/leetcode/oneEditAway)     | 分情况讨论  |       |
|    [468. 验证IP地址](src/bytedance/validIPAddress)     | 分情况讨论  |       |

### 图

|                      题目                      |         关键字         |        |
| :--------------------------------------------: | :--------------------: | ------ |
|    [547. 省份数量](src/leetcode/findCircleNum)     | 图的遍历  |       |

### 并查集

|                      题目                      |         关键字         |        |
| :--------------------------------------------: | :--------------------: | ------ |
|    [1202. 交换字符串中的元素](src/everyday/smallestStringWithSwaps)     | 并查集  |       |
|    [684. 冗余连接](src/everyday/findRedundantConnection)     | 并查集  |       |
|    [1319. 连通网络的操作次数](src/everyday/makeConnected)     | 并查集  |       |
|    [1579. 保证图可完全遍历](src/everyday/maxNumEdgesToRemove)     | 并查集  |       |

### BFS

|                      题目                      |         关键字         |        |
| :--------------------------------------------: | :--------------------: | ------ |
|    [1091. 二进制矩阵中的最短路径](src/leetcode/shortestPathBinaryMatrix)     | BFS  |   重点题    |
|    [279. 完全平方数](src/leetcode/numSquares)     | BFS  |   重点题    |
|    [2045. 到达目的地的第二短时间](src/everyday/secondMinimum)     | BFS  |   重点题    |

### 数据结构

|                      题目                      |         关键字         |        |
| :--------------------------------------------: | :--------------------: | ------ |
|    [232. 用栈实现队列](src/leetcode/myQueue)     | 栈  |       |
|    [503. 下一个更大元素 II](src/everyday/nextGreaterElements)     | 单调栈 循环数组  | 重点题       |
|    [1047. 删除字符串中的所有相邻重复项](src/everyday/removeDuplicates)     | 栈 |        |
|    [面试题 16.26. 计算器](src/everyday/calculate)     | 栈 |        |
|    [面试题 03.05. 栈排序](src/leetcode/SortedStack)     | 栈 |        |
|    [剑指 Offer II 025. 链表中的两数相加](src/swordToOffer/addTwoNumbers)     | 栈 |        |
|    [443. 压缩字符串](src/everyday/compress)     | 栈 |        |
|    [82. 删除排序链表中的重复元素 II](src/leetcode/deleteDuplicates)     | 链表 |        |
|    [414. 第三大的数](src/everyday/thirdMax)     | 有序集合 |        |
|    [剑指 Offer II 036. 后缀表达式](src/leetcode/evalRPN)     | 栈 |        |
|    [622. 设计循环队列](src/leetcode/MyCircularQueue)     | 队列 |        |
|    [034. 股票价格波动](src/leetcode/StockPrice)     | 数据结构组合 |        |
|    [739. 每日温度](src/leetcode/dailyTemperatures)     | 单调栈 |        |

### 数学

|                      题目                      |         关键字         |        |
| :--------------------------------------------: | :--------------------: | ------ |
|    [1486. 数组异或操作](src/everyday/xorOperation)     | 数学  |       |
|    [223. 矩形面积](src/everyday/computeArea)     | 数学  |       |
|    [29. 两数相除](src/everyday/divide))     | 倍增加、数学  |       |
