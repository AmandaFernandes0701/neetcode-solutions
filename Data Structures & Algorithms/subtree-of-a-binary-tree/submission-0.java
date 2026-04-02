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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        
        List<TreeNode> candidates = new ArrayList<TreeNode>();

        candidates = findAllNodesEqualsSubRoot(root, subRoot.val, candidates);

        boolean hasSubtree = false;

        // encontrar nó com msm valor do subroot
        for(TreeNode rootCandidate : candidates)
        {
            // chamar func is same tree?
            hasSubtree = isSameTree(rootCandidate, subRoot);
            if(hasSubtree) return true;
        }

        //retornal valGlobal
        return hasSubtree;

    }
    public boolean isSameTree(TreeNode root, TreeNode subRoot)
    {
        if(root == null && subRoot == null) return true;

        if(root == null || subRoot == null || root.val != subRoot.val) return false;

        return isSameTree(root.left, subRoot.left) && isSameTree(root.right, subRoot.right);
    }

    public List<TreeNode> findAllNodesEqualsSubRoot(TreeNode currRoot, int target, List<TreeNode> candidates)
    {
        if(currRoot == null) return candidates;

        if(currRoot.val == target)
            candidates.add(currRoot);
        
        findAllNodesEqualsSubRoot(currRoot.left, target, candidates);
        findAllNodesEqualsSubRoot(currRoot.right,target, candidates);

        return candidates;
    }
}













