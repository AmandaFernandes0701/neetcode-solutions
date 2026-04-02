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
    public TreeNode invertTree(TreeNode root) {

        dfsInvert(root);
        return root;
    }

    public void dfsInvert(TreeNode currNode)
    {
        if(currNode == null) return;

        TreeNode tempNodeLeft = currNode.left;
        currNode.left = currNode.right;
        currNode.right = tempNodeLeft;

        dfsInvert(currNode.left);
        dfsInvert(currNode.right);

        return;
    }
}





