/*
 * @lc app=leetcode.cn id=433 lang=java
 *
 * [433] 最小基因变化
 */

// @lc code=start
class Solution {
    public int minMutation(String start, String end, String[] bank) {
        List<String> chooseAble = Arrays.asList(bank);
        int result = dsp(start, end, 0, chooseAble);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private static int dsp(String start, String end, int count, List<String> bank) {
        List<String> chooseAble = new ArrayList<>();
        List<String> oneStep = new ArrayList<>();
        for (String mid : bank) {
            int dis = calDis(start, mid);
            if (dis == 1) {
                if (mid.equals(end)) {
                    return count + 1;
                }else{
                    oneStep.add(mid);
                }
            } else if (dis > 1) {
                chooseAble.add(mid);//选择下一步能走的基因
            }
        }
        if (chooseAble.size() == 0) {//没有能走的，也没有能到达的，就说明步骤是无限远
            return Integer.MAX_VALUE;
        }
        int result = Integer.MAX_VALUE;
        for (String next : oneStep) {
            result = Math.min(result, dsp(next, end, count + 1, chooseAble));
        }
        return result;
    }

    private static int calDis(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                count += 1;
            }
        }
        return count;
    }
}
// @lc code=end

