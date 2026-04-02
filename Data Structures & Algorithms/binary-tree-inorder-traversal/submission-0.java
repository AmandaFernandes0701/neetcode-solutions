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

    private List<Integer> listResult = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {

        fillInorderTraversalList(root);
        return listResult;      
    }

    public void fillInorderTraversalList(TreeNode currNode)
    {
        if(currNode == null) return;

        fillInorderTraversalList(currNode.left);
        listResult.add(currNode.val);
        fillInorderTraversalList(currNode.right);
    }
}



