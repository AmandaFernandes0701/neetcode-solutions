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

    private int result = 0;
    private int valorFaltante = 0;

    public int kthSmallest(TreeNode root, int k) {

        valorFaltante = k;
        findKthMinNumber(root);  
        return result;
    }

    public void findKthMinNumber(TreeNode currNode)
    {
        if(currNode == null) return;

        findKthMinNumber(currNode.left);

        valorFaltante--;

        if(valorFaltante == 0)
        {
            result = currNode.val;
            return;
        }

        findKthMinNumber(currNode.right);
    }
}




