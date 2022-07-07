package 树.trie树;
/*
 * @lc app=leetcode.cn id=648 lang=java
 *
 * [648] 单词替换
 */

// @lc code=start
class TrieNode {
    public TrieNode[] child;
    public boolean isPrefix;

    public TrieNode() {
        isPrefix = false;
        child = new TrieNode[26];
    }
}
class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        StringBuilder sb = new StringBuilder();
        TrieNode root = new TrieNode();
        for (String dic : dictionary) {
            insert(root, dic);
        }
        for (String word : sentence.split(" ")) {
            sb.append(checkPrefix(root, word)).append(" ");
        }
        return sb.substring(0, sb.length() - 1);
    }

 private void insert(TrieNode node, String word) {
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            TrieNode[] childs = node.child;
            if (childs[c - 'a'] == null) {//对于每一个字符，如果没有子节点，就新建子节点
                childs[c - 'a'] = new TrieNode();
            }
            node = childs[c - 'a'];//进入下一个子节点
            if (i == chars.length - 1) {//如果关键词到头了， 说明当前是某个关键词，把isPrefix设置成true
                childs[c - 'a'].isPrefix = true;
            }
        }
    }

    private String checkPrefix(TrieNode node, String word) {
        StringBuilder preStr = new StringBuilder();
        for (char c : word.toCharArray()) {
            node = node.child[c - 'a'];//根节点没有任何字符信息，进来直接查找根节点的子节点
            if (node == null) {//如果没查到，说明没匹配
                return word;
            } else {//如果查到了，继续往下查找
                preStr.append(c);
                if (node.isPrefix) {//如果匹配到了，就返回匹配值。由于是匹配到了就返回，这样就会返回最短的匹配关键词
                    return preStr.toString();
                }
            }
        }
        return word;
    }
}
// @lc code=end

