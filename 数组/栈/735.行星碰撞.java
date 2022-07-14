package 数组.栈;
import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=735 lang=java
 *
 * [735] 行星碰撞
 */

// @lc code=start
class Solution {
    //栈，要具体考虑各种情况
    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> stack = new ArrayList();
        for (int a : asteroids) {
            if (stack.isEmpty()) {
                stack.add(a);
            } else {
                int lastNum = stack.get(stack.size() - 1);
                if (lastNum * a > 0) { // 同方向的
                    stack.add(a);
                } else if (lastNum < 0) { // 互相离开
                    stack.add(a);
                } else { // 互相接近
                    boolean addNew = true;
                    while (stack.size() > 0) {
                        lastNum = stack.get(stack.size() - 1);
                        if (lastNum * a > 0) {
                            addNew = true;
                            break;
                        } else if (lastNum > -a) {
                            addNew = false;
                            break;// 陨石太小,爆炸了，进入下一个陨石
                        } else if (lastNum == -a) {// 中陨石
                            stack.remove(stack.size() - 1);
                            addNew = false;
                            break;
                        } else {// 大陨石
                            stack.remove(stack.size() - 1);
                        }
                    }
                    if (addNew) {
                        stack.add(a);
                    }
                }
            }
        }
        int[] result = new int[stack.size()];
        for (int i = 0; i < stack.size(); i++) {
            result[i] = stack.get(i);
        }
        return result;
    }
}
// @lc code=end
