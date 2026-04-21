class Solution {
    public int coinChange(int[] coins, int amount) {
        // Criamos um array do tamanho do amount + 1 (pois vai do 0 até o amount)
        int[] dp = new int[amount + 1];
        
        // Preenchemos com um valor "infinito" (amount + 1 é o máximo possível + 1)
        // Não usamos Integer.MAX_VALUE para evitar overflow ao somar + 1 mais tarde
        Arrays.fill(dp, amount + 1);
        
        // Caso base: O troco para o valor 0 exige 0 moedas
        dp[0] = 0;

        // Vamos calcular a resposta para TODOS os valores, do 1 até o amount
        for (int currAmount = 1; currAmount <= amount; currAmount++) {
            
            // Para cada valor, testamos todas as moedas disponíveis
            for (int coin : coins) {
                // Se a moeda couber no valor que estamos calculando agora
                if (coin <= currAmount) {
                    // A mágica acontece aqui:
                    // O mínimo para currAmount é o melhor entre:
                    // 1. O que já temos salvo.
                    // 2. 1 moeda (a atual) + o mínimo de moedas do valor que SOBROU.
                    dp[currAmount] = Math.min(dp[currAmount], 1 + dp[currAmount - coin]);
                }
            }
        }

        // Se o valor final ainda for "infinito", é porque não achou solução
        return dp[amount] > amount ? -1 : dp[amount];
    }
}