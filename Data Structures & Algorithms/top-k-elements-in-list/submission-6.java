class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 1. Contar a frequência de cada número
        Map<Integer, Integer> countFrequency = new HashMap<>();
        for (int num : nums) {
            countFrequency.put(num, countFrequency.getOrDefault(num, 0) + 1);
        }

        // 2. Criar o array de baldes
        // O tamanho é nums.length + 1 porque a frequência máxima é o tamanho do array original
        List<Integer>[] buckets = new List[nums.length + 1];
        
        // OTIMIZAÇÃO: Não fazemos o 'for' para preencher com ArrayLists vazios aqui!

        // 3. Agrupar os números com base na frequência deles
        for (Map.Entry<Integer, Integer> entry : countFrequency.entrySet()) {
            int num = entry.getKey();
            int frequencia = entry.getValue();
            
            // Instanciação Preguiçosa: Só cria a lista no momento exato em que for precisar dela
            if (buckets[frequencia] == null) {
                buckets[frequencia] = new ArrayList<>();
            }
            
            buckets[frequencia].add(num);
        }

        // 4. Pegar os K elementos mais frequentes (de trás para frente)
        int[] arrayResult = new int[k];
        int j = 0; // Controle de índice do arrayResult

        for (int i = buckets.length - 1; i >= 0; i--) {
            // Só entra no balde se ele foi inicializado (ou seja, se tem números lá)
            if (buckets[i] != null) { 
                for (int num : buckets[i]) {
                    arrayResult[j] = num;
                    j++;
                    
                    // Se já pegamos a quantidade K necessária, encerra a função
                    if (j == k) {
                        return arrayResult;
                    }
                }
            }
        }
        
        return arrayResult;
    }
}