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

    public boolean isBalancedBool = true;

    public boolean isBalanced(TreeNode root) {
        
        findHeight(root);
        return isBalancedBool;    
    }

    public int findHeight(TreeNode currNode)
    {
        if(currNode == null) return 0;

        int leftHeight = findHeight(currNode.left);
        int rightHeight = findHeight(currNode.right);

        int diff = Math.abs(leftHeight - rightHeight);

        if(diff > 1) isBalancedBool = false;

        return 1 + Math.max(leftHeight, rightHeight);
    }
}




