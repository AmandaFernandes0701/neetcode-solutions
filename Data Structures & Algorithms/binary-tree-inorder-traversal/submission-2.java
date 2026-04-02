class Solution {

    // Método principal que o LeetCode vai chamar
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> listResult = new ArrayList<>();
        
        // Chamamos o método auxiliar
        fillInorderTraversalList(root, listResult);    

        return listResult;
    }

    // Método auxiliar declarado FORA do método principal, 
    // mas ainda DENTRO da classe Solution.
    // Dica: Geralmente usamos 'private' para métodos auxiliares.
    private void fillInorderTraversalList(TreeNode currNode, List<Integer> listResult) {
        if(currNode == null) return;

        fillInorderTraversalList(currNode.left, listResult);
        listResult.add(currNode.val); // Meio (Inorder)
        fillInorderTraversalList(currNode.right, listResult);
        
        // Note que mudei o retorno para 'void'.
        // Como 'listResult' é uma referência de objeto em Java, 
        // as modificações feitas nela (add) já refletem na lista original.
        // Não é necessário retornar a lista em cada chamada recursiva.
    }
}