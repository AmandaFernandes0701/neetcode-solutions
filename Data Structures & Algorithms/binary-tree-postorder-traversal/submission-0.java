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
    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> listResult = new ArrayList<>();

        return findListPostOrderTraversal(root, listResult);     
    }

    public List<Integer> findListPostOrderTraversal(TreeNode currNode, List<Integer> currList)
    {
        if(currNode == null) return currList;

        findListPostOrderTraversal(currNode.left, currList);
        findListPostOrderTraversal(currNode.right, currList);
        currList.add(currNode.val);

        return currList;
    }
}




