package 字

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.print.DocFlavor.STRING;

符串;
/*
 * @lc app=leetcode.cn id=211 lang=java
 *
 * [211] 添加与搜索单词 - 数据结构设计
 */

// @lc code=start
class WordDictionary {

    public Set<String> dList;
    public Set<String> matchPattern;
    public Set<String> unMatchPattern;

    public WordDictionary() {
        this.dList = new HashSet<>();
        this.matchPattern = new HashSet<>();
        this.unMatchPattern = new HashSet<>();
    }
    
    public void addWord(String word) {
        dList.add(word);//新增的时候，要新增pattern
        for (String unPattern : unMatchPattern) {
            if (match(word, unPattern)) {
                //如果匹配到了之前不能匹配的，就说明这个pattern能匹配到了
                unMatchPattern.remove(unPattern);
            }
        }
    }
    
    public boolean search(String word) {
        //先查两个set有没有，再进行真正的查询
        if (matchPattern.contains(word)) {
            return true;
        }
        if (unMatchPattern.contains(word)) {
            return false;
        }
        boolean flag = false;
        for (String a : this.dList) {
            if (match(a, word)) {
                matchPattern.add(word);
                flag = true;
            } else {
                unMatchPattern.add(word);
            }
        }

        return flag;
    }

    public boolean match(String a, String pattern) {
        if (a.length() != pattern.length()) {
            return false;
        }
        if (a.equals(pattern)) {
            return true;
        }
        for (int i = 0; i < a.length(); i++) {
            if (pattern.charAt(i) == '.' || a.charAt(i) == pattern.charAt(i)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
    
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
// @lc code=end
