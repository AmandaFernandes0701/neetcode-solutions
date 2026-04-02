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

    private int[] result = new int[1];

    public int kthSmallest(TreeNode root, int k) {

        int[] numK = new int[1];
        numK[0] = k;

        findKthMinNumber(root, numK);
        
        return result[0];
    }

    public void findKthMinNumber(TreeNode currNode, int[] valorFaltante)
    {
        if(currNode == null) return;

        findKthMinNumber(currNode.left, valorFaltante);

        valorFaltante[0]--;

        if(valorFaltante[0] == 0)
        {
            result[0] = currNode.val;
            return;
        }

        findKthMinNumber(currNode.right, valorFaltante);

        return;
    }
}




