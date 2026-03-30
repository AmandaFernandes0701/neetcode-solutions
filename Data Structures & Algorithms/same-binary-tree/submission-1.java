class Solution {
    public boolean isSameTree(TreeNode currNodeP, TreeNode currNodeQ) {

        if(currNodeP == null && currNodeQ == null) return true;

        else if(currNodeP == null || currNodeQ == null || currNodeP.val != currNodeQ.val) return false;

        return isSameTree(currNodeP.right, currNodeQ.right) && isSameTree(currNodeP.left, currNodeQ.left);    
    }
}
