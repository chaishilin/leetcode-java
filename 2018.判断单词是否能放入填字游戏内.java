import org.graalvm.compiler.hotspot.nodes.aot.ResolveDynamicConstantNode;

/*
 * @lc app=leetcode.cn id=2018 lang=java
 *
 * [2018] 判断单词是否能放入填字游戏内
 */

// @lc code=start
class Solution {
    public boolean placeWordInCrossword(char[][] board, String word) {
        boolean reuslt = false;
        //左右上下前后四层遍历

        for (int i = 0; i < board.length; i++) {
            reuslt = reuslt || findLine(board[i], word);
        }
        for (int i = 0; i < board.length; i++) {
            char[] newLine = new char[board[0].length];
            for (int j = 0; j < board[0].length; j++) {
                newLine[j] = board[i][board[0].length - 1 - j];
            }
            reuslt = reuslt || findLine(newLine, word);
        }

        char[] newColumnLine = new char[board.length];
        for (int i = 0; i < board[0].length; i++) {
            for (int j = 0; j < board.length; j++) {
                newColumnLine[j] = board[j][i];
            }
            reuslt = reuslt || findLine(newColumnLine, word);
        }
        for (int i = 0; i < board[0].length; i++) {
            for (int j = 0; j < board.length; j++) {
                newColumnLine[j] = board[board.length - 1 - j][i];
            }
            reuslt = reuslt || findLine(newColumnLine, word);
        }
        return reuslt;
    }

    public boolean findLine(char[] line, String word) {
        //查看每行是否匹配
        if (line.length < word.length()) {
            return false;
        }
        int index = 0;//记录当前匹配到的index
        int position = 0;
        for (int i = 0; i < line.length; i++) {
            if (line[i] == '#') {
                index = 0;//#表示不能从这个格子开始
            } else if (line[i] == ' ') {
                //如果可以任意填字
                index += 1;
            } else {
                //如果是其他字符
                if (line[i] == word.charAt(index)) {
                    index += 1;
                } else {
                    index = 0;//#表示不能从这个格子开始
                }
            }
            
            if (index == word.length()) {
                //再排查字符串前后是否有空格
                position = i;
                //对于字符串的前面
                if (position - word.length() == -1 || line[position - word.length()] == '#') {
                    //后面
                    if (position == line.length - 1 || line[position + 1] == '#') {
                        return true;
                    }
                }
                index = 0;
                continue;//如果这个匹配其实不满足条件，则清空index继续。
            }
            /*
            Your runtime beats 44.18 % of java submissions
            
            Your memory usage beats 42.8 % of java submissions (67.5 MB) */
        }
        return false;        
    }
}
// @lc code=end

