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
    
    public boolean isValidBST(TreeNode root) {
        
        return checkBST(root, Integer.MIN_VALUE,  Integer.MAX_VALUE);
    }

    public boolean checkBST(TreeNode currNode, int minLimit, int maxLimit)
    {
        if(currNode == null) return true;

        boolean leftResult = checkBST(currNode.left, minLimit, currNode.val);

        if(currNode.val <= minLimit || currNode.val >= maxLimit) return false;

        boolean rightResult = checkBST(currNode.right, currNode.val, maxLimit);

        return leftResult && rightResult;

    }
}



