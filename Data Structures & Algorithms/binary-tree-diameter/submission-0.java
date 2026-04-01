/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    public int maxVal = 0;

    public int diameterOfBinaryTree(TreeNode currNode) {

        maxDiameter(currNode);
        return maxVal;
    }

    public int maxDiameter(TreeNode currNode)
    {
        if(currNode == null) return 0;

        int maxRight = maxDiameter(currNode.right);
        int maxLeft = maxDiameter(currNode.left);

        maxVal = Math.max(maxVal, maxRight + maxLeft);

        return 1 + Math.max(maxRight,maxLeft);
    }
}








