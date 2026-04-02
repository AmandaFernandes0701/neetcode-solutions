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
    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> listResult = new ArrayList<>();

        return findListPreorderTraversal(root, listResult);
        
    }

    public List<Integer> findListPreorderTraversal(TreeNode currNode, List<Integer> currList)
    {
        if(currNode == null) return currList;

        currList.add(currNode.val);
        findListPreorderTraversal(currNode.left, currList);
        findListPreorderTraversal(currNode.right, currList);

        return currList;
    }

}