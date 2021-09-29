/*
 * @lc app=leetcode.cn id=517 lang=java
 *
 * [517] 超级洗衣机
 */

// @lc code= start
class Solution {
    public int findMinMoves(int[] machines) {
        //看题解
        //贪心算法：
        int sumNUM = 0;
        for (int m : machines) {
            sumNUM += m;
        }
        int avg = sumNUM / machines.length;
        if (sumNUM % machines.length != 0) {
            return -1;
        }

        int sum = 0;
        int result = 0;
        for (int m : machines) {
            m -= avg;
            //每个洗衣机每次最多可以移走一件衣服，但是可以移入两件衣服（左右两边各移入一件）。
            //因此，m不需要取abs，因为移走的件数少，因此需要更多的移动次数
            sum += m;
            //sum统计的前i的组的需要移入移出数，第i+1及以后组成的组的移入移出数为-sum，
            //因为整体的移入移出数肯定是0，在machines内部才能做到平均
            result = Math.max(result, Math.max(Math.abs(sum), m));
        }
        return result;
        /*
        我们分两种情况(组间和组内)来考虑操作步数：
        1:A 与 B 两组之间的衣服，最多需要 \max_{i=0}^{n-1}|\textit{sum}[i]|max i=0 n−1∣sum[i]∣ 次衣服移动；
        2:组内的某一台洗衣机内的衣服数量过多，需要向左右两侧移出衣服，这最多需要 \max_{i=0}^{n-1}\textit{machines}[i]'max i=0 n−1 machines[i] ′
        次衣服移动。
        取两者的最大值即为答案

        作者：LeetCode-Solution
        链接：https://leetcode-cn.com/problems/super-washing-machines/solution/chao-ji-xi-yi-ji-by-leetcode-solution-yhej/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
        */
    }
}
// @lc code=end

