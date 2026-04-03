class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> resultList = new ArrayList<>();
        if (root == null) return resultList;

        bfsTraversal(root, resultList);
        return resultList;
    }

    public void bfsTraversal(TreeNode root, List<List<Integer>> resultList) {
        Queue<TreeNode> queueNodes = new LinkedList<>();
        queueNodes.add(root);

        while (!queueNodes.isEmpty()) {
            int size = queueNodes.size(); // Quantos nós existem no nível atual
            List<Integer> currentLevelList = new ArrayList<>(); // Criamos a sublista deste nível

            for (int i = 0; i < size; i++) {
                TreeNode currNode = queueNodes.poll(); // Remove o primeiro da fila
                currentLevelList.add(currNode.val); // Adiciona na sublista

                // Adiciona os filhos para o PRÓXIMO nível
                if (currNode.left != null) queueNodes.add(currNode.left);
                if (currNode.right != null) queueNodes.add(currNode.right);
            }

            // Após processar todos os nós do nível, adicionamos a sublista ao resultado
            resultList.add(currentLevelList);
        }
    }
}