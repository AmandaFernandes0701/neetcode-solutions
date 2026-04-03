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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        
        dfsRemoveLeafNodes(root, target);

        if(root.left == null && root.right == null && root.val == target) return null;

        return root;
    }

    public void dfsRemoveLeafNodes(TreeNode currNode, int target)
    {
        if(currNode == null) return;

        dfsRemoveLeafNodes(currNode.left, target);
        dfsRemoveLeafNodes(currNode.right, target);

        // se nó da esquerda é folha E eh = target
        if(currNode.left != null)
        {
            boolean isLeftChildLeaf = currNode.left.left == null && currNode.left.right == null;

            if(isLeftChildLeaf && currNode.left.val == target)
            {
                currNode.left = null;
            }
        }

        // se nó da direita é folha E eh = target
        if(currNode.right != null)
        {
            boolean isRightChildLeaf = currNode.right.left == null && currNode.right.right == null;

            if(isRightChildLeaf && currNode.right.val == target)
            {
                currNode.right = null;
                return;
            }
        }
    }
}



