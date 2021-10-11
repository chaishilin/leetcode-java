import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import jdk.nashorn.api.tree.Tree;

/*
 * @lc app=leetcode.cn id=352 lang=java
 *
 * [352] 将数据流变为多个不相交区间
 */

// @lc code=start
class SummaryRanges {

    private TreeMap<Integer,Integer> intervals;

    public SummaryRanges() {
        intervals = new TreeMap<Integer, Integer>();
    }

    /*
    主要学习了treeMap的ceilingEntry和floorEntry用法，非常方便
    还学习了Map奇葩的遍历方式
    MapEntry这个数据结构
    */

    
    public void addNum(int val) {
        //五种情况，分别是
        /*
        1、该数字在原来某个区间中，不发生变化
        2、该数字在某个区间的左边，这个区间需要向左边扩展一格
        3、该数字在某个区间的右边，这个区间需要向右边扩展一格
        4、该数字在某个区间的左边和某个边界的右边，可以将两个边界连起来
        5、该数字不在任何区间附近，自成一个区间
        */
        //找到最近的两个区间，其中l0区间的left小于等于val，l1区间的left大于等于val
        Map.Entry<Integer,Integer> l1 = intervals.ceilingEntry(val+1);//celing是找到大于等于的
        Map.Entry<Integer,Integer> l0 = intervals.floorEntry(val);//floor是找到小于等于的
        if (l0 != null && l0.getKey() <= val && l0.getValue() >= val) {
            //情况一
            return;
        }else if(l0 != null && l1 != null && l0.getValue() + 1 == val && l1.getKey() - 1 == val) {
            //情况四
            intervals.put(l0.getKey(), l1.getValue());
            intervals.remove(l1.getKey());
            return;
        }else if (l0 != null && l0.getValue() + 1 == val) {
            //情况二
            intervals.put(l0.getKey(), val);
            return;
        } else if (l1 != null && l1.getKey() - 1 == val) {
            //情况三
            intervals.put(val, l1.getValue());
            intervals.remove(l1.getKey());
            return;
        }else{
            //情况五
            intervals.put(val, val);
        }
    }
    
    public int[][] getIntervals() {
        int[][] result = new int[intervals.size()][2];
        Iterator it = intervals.entrySet().iterator();
        int count = 0;
        while (it.hasNext()) {
            int[] temp = new int[2];
            Map.Entry<Integer,Integer> t =(Map.Entry<Integer,Integer>) it.next();
            temp[0] = t.getKey();
            temp[1] = t.getValue();
            result[count++] = temp;
        }
        return result;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * int[][] param_2 = obj.getIntervals();
 */
// @lc code=end

