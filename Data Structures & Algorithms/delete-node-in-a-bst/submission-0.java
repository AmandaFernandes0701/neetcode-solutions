/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        // 1. Passo de Busca (A mesma lógica do seu searchNode)
        if (root == null) return null;

        if (key < root.val) {
            // Vai para a esquerda e o pai (root) atualiza seu ponteiro
            root.left = deleteNode(root.left, key);
        } 
        else if (key > root.val) {
            // Vai para a direita e o pai (root) atualiza seu ponteiro
            root.right = deleteNode(root.right, key);
        } 
        // 2. Encontramos o nó! (root.val == key)
        else {
            // CASO 1 E CASO 2: O nó é uma folha (0 filhos) OU tem apenas 1 filho.
            // Se a esquerda é nula, retornamos a direita (se a direita também for nula, ele retorna null, resolvendo o caso da folha!)
            if (root.left == null) {
                return root.right;
            } 
            else if (root.right == null) {
                return root.left;
            }

            // CASO 3: O nó tem 2 filhos.
            // Precisamos do "helper" para achar o sucessor (o menor valor da subárvore direita)
            TreeNode successor = findMin(root.right);
            
            // Copiamos o valor do sucessor para o nó atual
            root.val = successor.val;
            
            // Agora vamos na subárvore da direita e deletamos o sucessor original
            root.right = deleteNode(root.right, successor.val);
        }

        return root;
    }

    // Função Helper: Acha o menor valor de uma subárvore (indo tudo para a esquerda)
    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}