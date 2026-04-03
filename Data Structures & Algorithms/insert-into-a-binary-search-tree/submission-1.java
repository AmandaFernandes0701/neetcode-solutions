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
    public TreeNode insertIntoBST(TreeNode root, int val) {

        if(root == null)
            return new TreeNode(val);

        dfsSearchLocalInsertion(root, val);
        return root;    
    }

    public void dfsSearchLocalInsertion(TreeNode currNode, int val)
    {
        // se node é maior que val --> manda pra esquerda
        if(currNode.val > val)
        {
            if(currNode.left == null)
            {
                TreeNode node = new TreeNode(val);
                currNode.left = node;
                return;
            }
            else dfsSearchLocalInsertion(currNode.left, val);
        }

        // se node é menor que val --> manda pra direita
        if(currNode.val < val)
        {
            if(currNode.right == null)
            {
                TreeNode node = new TreeNode(val);
                currNode.right = node;
                return;
            }
            else dfsSearchLocalInsertion(currNode.right, val);
        }
        
    }
}









