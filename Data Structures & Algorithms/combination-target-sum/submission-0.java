class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // A lista final que vai guardar APENAS as combinações corretas
        List<List<Integer>> resultList = new ArrayList<>();
        
        // Chamamos a função recursiva de Backtracking
        backtrack(resultList, new ArrayList<>(), candidates, target, 0);
        
        return resultList;
    }

    private void backtrack(List<List<Integer>> resultList, List<Integer> currentList, int[] candidates, int remain, int startIdx) {
        
        // Caso Base 1: A soma ultrapassou o target (remain ficou negativo)
        // O Java simplesmente encerra essa ramificação, poupando a CPU de continuar buscando à toa.
        if (remain < 0) {
            return; 
        }
        
        // Caso Base 2: Acertamos o alvo na mosca!
        if (remain == 0) {
            // LOW-LEVEL WARNING: Temos que criar um new ArrayList cópia aqui!
            // Se adicionarmos a 'currentList' direto, como ela é manipulada depois, 
            // a resposta final ficaria vazia ou cheia de números errados.
            resultList.add(new ArrayList<>(currentList));
            return;
        }

        // Loop de exploração (Branching)
        for (int i = startIdx; i < candidates.length; i++) {
            
            // 1. FAZ A ESCOLHA: Adiciona o número atual na lista temporária
            currentList.add(candidates[i]);
            
            // 2. EXPLORA (Recursão): Subtrai o número escolhido do target restante.
            // Note que passamos 'i' e não 'i + 1'. Isso porque o problema permite 
            // reutilizar o mesmo número várias vezes!
            backtrack(resultList, currentList, candidates, remain - candidates[i], i);
            
            // 3. DESFAZ A ESCOLHA (O famoso Backtrack):
            // Removemos o último número que testamos para tentar o próximo no loop 'for'
            currentList.remove(currentList.size() - 1);
        }
    }
}