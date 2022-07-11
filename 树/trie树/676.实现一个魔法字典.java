package 树.trie树;
/*
 * @lc app=leetcode.cn id=676 lang=java
 *
 * [676] 实现一个魔法字典
 */

// @lc code=start
class Trie {
    boolean isFinished;
    Trie[] child;

    public Trie() {
        isFinished = false;
        child = new Trie[26];
    }
}

class MagicDictionary {
    
    private Trie root;

    public MagicDictionary() {
        root = new Trie();
    }
    
    public void buildDict(String[] dictionary) {
        Arrays.stream(dictionary).forEach(word -> insert(root, word));
    }
    
    public boolean search(String searchWord) {
        return dfs(root, searchWord, false, 0);
    }

    private boolean dfs(Trie node, String word, boolean changed, int index) {
        if (index == word.length()) {
            return changed && node.isFinished;
        }
        int idx = word.charAt(index) - 'a';
        if (node.child[idx] != null) {
            if (dfs(node.child[idx], word, changed, index + 1)) {
                return true;
            }
        }
        if (!changed) {
            for (int i = 0; i < 26; i++) {
                Trie child = node.child[i];
                if (child != null && i != idx) {
                    if (dfs(child, word, true, index + 1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void insert(Trie node, String word) {
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (node.child[c - 'a'] == null) {
                node.child[c - 'a'] = new Trie();
            }
            node = node.child[c - 'a'];
            if (i == chars.length - 1) {
                node.isFinished = true;
            }
        }
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */
// @lc code=end

