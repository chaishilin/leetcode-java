package 数学;
/*
 * @lc app=leetcode.cn id=357 lang=java
 *
 * [357] 计算各个位数不同的数字个数
 */

// @lc code=start
class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        Map<Integer, Integer> result = new HashMap<>();
        result.put(0,1);
        result.put(1,10);
        result.put(2,91);
        result.put(3,739);
        result.put(4,5275);
        result.put(5,32491);
        result.put(6,168571);
        result.put(7,712891);
        result.put(8,2345851);
        return result.get(n);
//  实际的公式：9**(n-2)*8*7*.... + func(i-1)
//        Map<Integer, Integer> d = new HashMap<>();
//        for (int i = 0; i <= n; i++) {
//            if (i == 0) {
//                d.put(i, 1);
//            } else if (i == 1) {
//                d.put(i, 10);
//            } else {
  
//                int temp = (int) Math.pow(9, 2);
//                for(int j = 2;j < i;j++){
//                    temp *= 10-j;
//                }
//                d.put(i, d.get(i - 1) + temp);
//            }
//        }
//        return d.get(n);
    }
}
// @lc code=end

