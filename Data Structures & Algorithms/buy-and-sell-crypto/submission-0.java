class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        if (prices.length < 1) {return maxProfit;}
        int lowBuy = prices[0];
        for (int price: prices){
            lowBuy = Math.min(lowBuy, price);
            maxProfit = Math.max(maxProfit, price - lowBuy);
        } 

        return maxProfit;
    }
}
