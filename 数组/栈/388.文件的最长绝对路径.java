package 数组.栈;
/*
 * @lc app=leetcode.cn id=388 lang=java
 *
 * [388] 文件的最长绝对路径
 */

// @lc code=start
class Solution {
    public int lengthLongestPath(String input) {
        String[] dirList = input.split("\n");
        List<String> dirStack = new ArrayList<>();
        int maxCount = 0;
        int count = 0;//记录当前路径长度
        for (String dir : dirList) {
            int depthOfDir = getDepth(dir);
            String name = dir.substring(depthOfDir);
            while (depthOfDir < dirStack.size()) {
                //如果所在深度大于当前文件应在深度，说明应该弹出栈来，返回上一级
                String popName = dirStack.remove(dirStack.size() - 1);
                count -= popName.length();
                count -= 1;//文件名之间有一个反斜杠的长度也要去掉
            }
            //如果是平级文件，则继续入栈
            dirStack.add(name);
            count += name.length();
            count += 1;
            if (name.contains(".")) {
                //如果这个文件带扩展名了，说明是文件而不是目录，记录当前长度
                maxCount = Math.max(maxCount, count);
            }
        }
        return Math.max(maxCount - 1, 0);//-1是为了删去多加的反斜杠，0是防止没有文件的情况
    }

    //计算每个文件前面的制表符个数，也就是文件深度
    private int getDepth(String file) {
        int result = 0;
        for (int i = 0; i < file.length(); i += 1) {
            if (file.charAt(i) == '\t') {
                result += 1;
            } else {
                break;
            }
        }
        return result;
    }
}
// @lc code=end

