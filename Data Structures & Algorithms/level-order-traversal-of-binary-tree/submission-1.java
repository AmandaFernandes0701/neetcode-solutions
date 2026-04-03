class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> resultList = new ArrayList<>();
        bfsTraversal(root, resultList);

        return resultList;
    }

    public void bfsTraversal(TreeNode root, List<List<Integer>> resultList)
    {
        if (root == null) return;

        Queue<TreeNode> queueNodes = new LinkedList<>();
        queueNodes.add(root);

        while(!queueNodes.isEmpty())
        {
            List<Integer> currLevelList = new ArrayList<>();

            for(TreeNode node : queueNodes)
                currLevelList.add(node.val);
            
            resultList.add(new ArrayList<>(currLevelList));
            Queue<TreeNode> newQueue = new LinkedList<>();

            while(!queueNodes.isEmpty())
            {
                TreeNode currNode = queueNodes.remove();

                if(currNode.left != null) newQueue.add(currNode.left);
                if(currNode.right != null) newQueue.add(currNode.right);
            }

            queueNodes = new LinkedList<>(newQueue);
            newQueue.clear();
        }
    }
}