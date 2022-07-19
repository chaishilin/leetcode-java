/*
 * @lc app=leetcode.cn id=731 lang=java
 *
 * [731] 我的日程安排表 II
 */

// @lc code=start
class MyCalendarTwo {

    private TreeMap<Integer,Integer> map;

    public MyCalendarTwo() {
        map = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        //差分! 就是第一个过来的时候加+1，看历史上有没有大于2
        int count = 0;
        map.put(start,map.getOrDefault(start,0)+1);
        map.put(end,map.getOrDefault(end,0)-1);
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            count += entry.getValue();
            if(count > 2){
                map.put(start,map.getOrDefault(start,0)-1);
                map.put(end,map.getOrDefault(end,0)+1);
                return false;
            }
        }
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */
// @lc code=end

