class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        // Ajuste 1: Usar ArrayList para instanciar a List
        List<List<Integer>> resultList = new ArrayList<>();
        printBFS(root, resultList);

        return resultList;
    }

    public void printBFS(TreeNode root, List<List<Integer>> resultList)
    {
        // Ajuste 3: Proteger o código caso a árvore venha vazia
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