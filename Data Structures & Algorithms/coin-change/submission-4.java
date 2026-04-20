class Solution {

    private int result = Integer.MAX_VALUE;

    public int coinChange(int[] coins, int amount) {

        if(amount == 0) return 0;

        Arrays.sort(coins); 
        int lastIdx = coins.length - 1;  

        for(int i = 0; i < coins.length / 2; i++)
        {
            int temp = coins[i];
            coins[i] = coins[lastIdx - i];
            coins[lastIdx - i] = temp;
        }

        findMinCoins(coins, amount, 0, 0, 0);

        return (result == Integer.MAX_VALUE)? -1 : result;      
    }

    public void findMinCoins(int[] coins, int amount, int currAmount, int iterations, int idx)
    {
        // deu certo!
        if(currAmount == amount)
        {
            result = Math.min(result, iterations);
            return;
        }

        // deu errado!
        if(currAmount > amount) return;

        for(int i = idx; i < coins.length; i++)
        {
            findMinCoins(coins, amount, currAmount + coins[i], iterations + 1, i);
            if(iterations + 1 >= result) break;
        }
    }
}



