package 树;
/*
 * @lc app=leetcode.cn id=558 lang=java
 *
 * [558] 四叉树交集
 */

import javax.lang.model.type.NullType;
import javax.swing.plaf.basic.BasicTreeUI.TreeCancelEditingAction;

import javafx.scene.Node;

// @lc code=start
/*
// Definition for a QuadTree node.

class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {
    }

    public Node(boolean _val, boolean _isLeaf, Node _topLeft, Node _topRight, Node _bottomLeft, Node _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
};
*/

class Solution {
    public Node intersect(Node quadTree1, Node quadTree2) {
        /*
        自下而上维护一棵树的过程
        */
        if (quadTree1 != null && quadTree1.isLeaf) { //如果quadTree1是叶子
            if (quadTree1.val) {//如果叶子的值是1
                return new Node(true, true, null, null, null, null);//则必然可以合并为val=1 的叶子，相当于是选了quadTree1
            }
            //否则就该节点就相当于是选了quadTree2
            return new Node(quadTree2.val, quadTree2.isLeaf, quadTree2.topLeft, quadTree2.topRight,
                    quadTree2.bottomLeft, quadTree2.bottomRight);
        }
        if (quadTree2 != null && quadTree2.isLeaf) {
            return intersect(quadTree2, quadTree1);
        }
        //都不是叶子的话
        Node topLeft = intersect(quadTree1.topLeft, quadTree2.topLeft);
        Node topRight = intersect(quadTree1.topRight, quadTree2.topRight);
        Node bottomLeft = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
        Node bottomRight = intersect(quadTree1.bottomRight, quadTree2.bottomRight);
        if (topLeft.val == topRight.val && topRight.val == bottomLeft.val && bottomLeft.val == bottomRight.val) {
            if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf) {
                return new Node(topLeft.val, true, null, null, null, null);//如果都是相同的值，并且都是叶子，那也能合并
            }
        }
        return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);//否则就不能合并

    }


}
// @lc code=end