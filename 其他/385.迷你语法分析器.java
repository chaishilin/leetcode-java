package 其他;
/*
 * @lc app=leetcode.cn id=385 lang=java
 *
 * [385] 迷你语法分析器
 */

// @lc code=start
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public NestedInteger deserialize(String s) {
        NestedInteger result = new NestedInteger();
        if (s.contains("[")) {
            List<String> subList = removeBlock(s);
            for (String sub : subList) {
                NestedInteger num = deserialize(sub);
                if (num != null) {
                    result.add(num);//添加分出来的各个数字
                }
            }
        } else if (s.length() > 0) {//或者自己本身是个数字
            result.setInteger(Integer.parseInt(s));
        } else {
            result = null;
        }
        return result;
    }

    //就是栈的用法
    private List<String> removeBlock(String s) {
        s = s.substring(1, s.length() - 1);//每次都脱去一层括号，形成一堆列表
        List<String> result = new ArrayList<>();
        List<Character> blockStack = new ArrayList<>();
        StringBuilder num = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[') {
                blockStack.add(c);
                num.append(c);
            } else if (c == ']') {
                blockStack.remove(blockStack.size() - 1);
                num.append(c);
            } else if (c == ',') {//遇到分隔符时候，检查blockStack
                if (blockStack.size() == 0) {//如果自己不在一个列表里面
                    result.add(num.toString());//就认为这个是一个独立的数字
                    num = new StringBuilder();
                }else{
                    num.append(c);
                }
            } else {
                num.append(c);
            }
        }
        result.add(num.toString());//最后一个数字记录下
        return result;
    }
}
// @lc code=end

