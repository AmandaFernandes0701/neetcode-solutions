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

    private int count = 0;

    public int goodNodes(TreeNode root) {

        countGoodNodes(root, Integer.MIN_VALUE);
        return count;
    }

    public void countGoodNodes(TreeNode currNode, int maxAncestor)
    {
        if(currNode == null) return;

        maxAncestor = Math.max(maxAncestor, currNode.val);

        if(currNode.val >= maxAncestor) count++;

        countGoodNodes(currNode.left, maxAncestor);
        countGoodNodes(currNode.right, maxAncestor);
    }
}










