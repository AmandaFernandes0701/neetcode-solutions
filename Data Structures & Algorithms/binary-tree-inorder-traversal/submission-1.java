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

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> listResult = new ArrayList<>();

        return fillInorderTraversalList(root, listResult);    
    }

    public List<Integer> fillInorderTraversalList(TreeNode currNode, List<Integer> listResult)
    {
        if(currNode == null) return listResult;

        fillInorderTraversalList(currNode.left, listResult);
        listResult.add(currNode.val);
        fillInorderTraversalList(currNode.right, listResult);

        return listResult;
    }
}



