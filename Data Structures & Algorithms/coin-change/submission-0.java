class Solution {
    public int coinChange(int[] coins, int amount) {
        int impossibleAmount = amount + 1;
        int []dp = new int[amount + 1];
        Arrays.fill(dp, impossibleAmount);
        dp[0] = 0;
        for(int denomination: coins){
            for(
                int currentAmount = 1; 
                currentAmount <= amount; 
                currentAmount++){
                    if(currentAmount - denomination >= 0){
                        dp[currentAmount] = 
                        Math.min(dp[currentAmount], dp[currentAmount - denomination] + 1);
                    }
            }
        }
        if(dp[amount] == impossibleAmount){
            return -1;
        }
        return dp[amount];
    }
}
