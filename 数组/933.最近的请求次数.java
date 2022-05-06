/*
 * @lc app=leetcode.cn id=933 lang=java
 *
 * [933] 最近的请求次数
 */

// @lc code=start
class RecentCounter {

    private int count;
    private List<Integer> pingList;
    private int lo;

    public RecentCounter() {
        this.count = 0;
        this.lo = 0;
        this.pingList = new ArrayList<>();
    }

    public int ping(int t) {
        pingList.add(t);
        while (pingList.get(lo) < t - 3000) {
            lo++;
        }
        return pingList.size() - lo;
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
// @lc code=end

