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
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> listResult = new ArrayList<>();

        if(root == null) return listResult;

        return bfs(root, listResult);
    }

    public List<Integer> bfs(TreeNode currNode, List<Integer> listResult)
    {
        Queue<TreeNode> currLevel = new LinkedList<>();
        currLevel.add(currNode);

        while(!currLevel.isEmpty())
        {
            int len = currLevel.size();
            
            for(int i = 0; i < len; i++)
            {
                TreeNode node = currLevel.remove();

                if(i == len - 1) listResult.add(node.val);

                if(node.left != null) currLevel.add(node.left);
                if(node.right != null) currLevel.add(node.right);
            }
        }
        return listResult;
    }
}
